package demo2


import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {

    val job = launch {
        println("padre launch")

        launch {
            delay(500)
            println("primer launch")
        }

        launch {
            delay(1000)
            println("segundo launch")
        }

    }

    delay(2000)
    job.cancel()
    job.join()
    //job.cancelAndJoin()

    //stateJobs()
}


fun stateJobs() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm working $i ...")
            delay(500L)
        }
    }
    delay(1500L) // delay a bit
    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")

    delay(1500L)
    job.cancel() // cancels the job
    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")

    delay(1500L)
    job.join() // waits for job's completion
    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")
}


