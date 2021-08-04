package demo2


import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch(GlobalScope.coroutineContext, CoroutineStart.LAZY) {
        repeat(1000) { i ->
            println("job: I'm working $i ...")
            delay(500L)

            if (i == 3) {
                throw Exception("Boom!")
            }
        }
    }

    try {
        println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")
        job.start()
        job.join()
        delay(2000L)
    } catch (e: Exception) {
        println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")
    }

}


