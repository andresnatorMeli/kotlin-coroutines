package demo2


import kotlinx.coroutines.*


fun main() = runBlocking {

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Excepcion cachada ..")
    }

    val coroutineScope = CoroutineScope(Dispatchers.Default + exceptionHandler)
    //val coroutineScope = CoroutineScope(SupervisorJob() + exceptionHandler)

    val job1 = coroutineScope.launch {
        delay(500L)
        throw RuntimeException("job Boom!")
    }

    val job2 = coroutineScope.launch {
        delay(1000L)
        println("Job2 executed")
    }


    delay(1500L)

    println("Job1 isActive: ${job1.isActive}, isCancelled: ${job1.isCancelled}, isCompleted: ${job1.isCompleted} ")
    println("Job2 isActive: ${job2.isActive}, isCancelled: ${job2.isCancelled}, isCompleted: ${job2.isCompleted} ")
}



