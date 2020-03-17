import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis


fun main() {
    val threadNameSet = mutableSetOf<String>()
    val time = measureTimeMillis {
        val c = runBlocking {
            (1..1_000L).map { i ->
                GlobalScope.async {
                    threadNameSet.add(Thread.currentThread().name)
                    delay(1000)
                    i
                }
            }.map {
                it.await()
            }.sum()
        }
        print("Calculated c: $c ")
    }
    println("in $time miliseconds, using ${threadNameSet.size} threads")
}
