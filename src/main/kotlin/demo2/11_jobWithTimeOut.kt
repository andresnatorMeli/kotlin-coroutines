package demo2


import kotlinx.coroutines.*

fun main() {

    val scope = CoroutineScope(Dispatchers.Unconfined)
    val job = scope.launch {
        withTimeout(500) {
            delay(1000)
        }
    }

    val job2 = scope.launch {
    }


    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted}, scope: ${scope.isActive} ")
    println("isActive: ${job2.isActive}, isCancelled: ${job2.isCancelled}, isCompleted: ${job2.isCompleted}, scope: ${scope.isActive} ")
    Thread.sleep(2000)
    println("isActive: ${job.isActive}, isCancelled: ${job.isCancelled}, isCompleted: ${job.isCompleted}, scope: ${scope.isActive} ")
    println("isActive: ${job2.isActive}, isCancelled: ${job2.isCancelled}, isCompleted: ${job2.isCompleted}, scope: ${scope.isActive} ")

}


