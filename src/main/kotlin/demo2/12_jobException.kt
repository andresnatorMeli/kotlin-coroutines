package demo2


import kotlinx.coroutines.*

fun main() = runBlocking {

    val job1 = launch(GlobalScope.coroutineContext, CoroutineStart.LAZY) {
        delay(500L)
        throw RuntimeException("job Boom!")
    }

    val job2 = launch(GlobalScope.coroutineContext) {
        delay(1000L)
        println("Job2 executed")
    }

    try {
        println("Job1 isActive: ${job1.isActive}, isCancelled: ${job1.isCancelled}, isCompleted: ${job1.isCompleted} ")
        println("Job2 isActive: ${job2.isActive}, isCancelled: ${job2.isCancelled}, isCompleted: ${job2.isCompleted} ")
        job1.start()
        job1.join()
        delay(2000L)
    } catch (e: Exception) {
        println("Job1 isActive: ${job1.isActive}, isCancelled: ${job1.isCancelled}, isCompleted: ${job1.isCompleted} ")
        println("Job2 isActive: ${job2.isActive}, isCancelled: ${job2.isCancelled}, isCompleted: ${job2.isCompleted} ")
        throw e
    }

}


