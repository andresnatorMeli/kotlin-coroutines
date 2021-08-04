package demo2


import kotlinx.coroutines.*

/*
Conviene manejar try catch cuando queremos que las coroutine hijas se ejecuten sin importar si alguna falla, en cambio con el except ion
handler al existir una excepción en corrutinas hijas se realiza la cancelación de todo el scope al que pertenece una coroutine
 */
fun main() = runBlocking {

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Excepcion cachada ..")
    }

    val coroutineScope = CoroutineScope(Dispatchers.Unconfined + exceptionHandler)
    //sval coroutineScope = CoroutineScope(SupervisorJob() + exceptionHandler) // con el supervisor job se evita que sea canceladas las demas ejecuciones que comparten el scope

    val job1 = coroutineScope.launch {
        println("Job1 Started.")
        delay(100L)
        throw RuntimeException("Boom!")
    }


    val job2 = coroutineScope.launch {
        println("Job2 Started.")
        delay(200L)
        println("Job2 Finished.")
    }

    Thread.sleep(2000L)

    println("Job1 isCancelled:${job1.isCancelled}")
    println("Job2 isCancelled:${job2.isCancelled}")
}



