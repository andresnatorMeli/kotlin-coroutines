import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlin.system.measureTimeMillis

sealed class AddMsg
class Add(val value: Long) : AddMsg() // one-way message to increment counter
class GetResult(val response: CompletableDeferred<Long>) : AddMsg()

fun CoroutineScope.sumActor() = actor<AddMsg> {
    var sum = 0L // actor state
    for (msg in channel) { // iterate over incoming messages
        when (msg) {
            is Add -> sum += msg.value
            is GetResult -> msg.response.complete(sum)
        }
    }
}

fun main() {
    runBlocking {
        val sum = sumActor()
        val threadNameSet = mutableSetOf<String>()
        val time = measureTimeMillis {
            (1..1_000L).map { i ->
                GlobalScope.launch {
                    threadNameSet.add(Thread.currentThread().name)
                    delay(1000)
                    sum.send(Add(i))
                }
            }.map {
                it.join()
            }
        }
        val response = CompletableDeferred<Long>()
        sum.send(GetResult(response))
        println("Calculated c: ${response.await()} in $time miliseconds, using ${threadNameSet.size} threads")
        sum.close()
    }
}
