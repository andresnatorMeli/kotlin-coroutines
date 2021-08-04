package demo2


import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1500L) // delay a bit
    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")
    delay(1500L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    delay(1500L)
    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")
    job.join() // waits for job's completion
    delay(1500L)
    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted} ")
    println("main: Now I can quit.")
}


