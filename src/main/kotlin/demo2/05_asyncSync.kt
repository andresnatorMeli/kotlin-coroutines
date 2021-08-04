package demo2


import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    testSync()
    testAsync()
    Thread.sleep(4000L)
}

private fun testSync() {
    val globalScope = CoroutineScope(GlobalScope.coroutineContext)

    globalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            val response1 = getInfoHeavyFromApi(1)
            val response2 = getInfoHeavyFromApi(2)

            println(response1)
            println(response2)
        }
        println("tiempo transcurrido testSync $time")
    }
}


private fun testAsync() {
    val globalScope = CoroutineScope(GlobalScope.coroutineContext)

    globalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            val response1 = async { getInfoHeavyFromApi(1) }
            val response2 = async { getInfoHeavyFromApi(2) }

            println(response1)
            println(response2)
            println(response2.await())
        }
        println("tiempo transcurrido  testAsync $time")
    }
}


suspend fun getInfoHeavyFromApi(num: Int): String {
    delay(500L)
    return "response from internet $num"
}


