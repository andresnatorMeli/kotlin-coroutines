package demo2


import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking  { // this: CoroutineScope

   // val timeUnconfined = dispatcherTest(Dispatchers.Unconfined) // información disponible aleatroia o que requiere muy pocos recursos
    //val timeMain = dispatcherTest(Dispatchers.Main) // se  utiliza para interfaz generalmente en android
    val timeDefault = dispatcherTest(Dispatchers.Default) // Operaciones complejas que requieren largos tiempos de ejecucion y recursos
    //val timeIO = dispatcherTest(Dispatchers.IO) // tareas de recoger información, api call, service, o un llamado a base de datos

    //warning
   // val myThread = dispatcherTest(newSingleThreadContext("myThread"))
    //val myThreads = dispatcherTest(newFixedThreadPoolContext(2, "mythreads"))

    println()
    //println("timeUnconfined $timeUnconfined")
    //println("timeMain $timeMain")
    println("timeDefault $timeDefault")
    //println("timeIO $timeIO")
   // println("myThread $myThread")
    //println("myThreads $myThreads")
}


suspend fun dispatcherTest(dispatcher: CoroutineDispatcher) = measureTimeMillis {
    runBlocking(dispatcher) {
        repeat(10) {
            launch {
                delay(1)
                //print(".")
                println(Thread.currentThread().name)
            }
        }
    }
}





