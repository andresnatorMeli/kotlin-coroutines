package demo2

import kotlinx.coroutines.*
import javax.xml.bind.JAXBElement
import kotlin.coroutines.coroutineContext


fun main() {

    val globalContext = CoroutineScope(GlobalScope.coroutineContext)

    globalContext.launch {
        delay(1000L)
        println("globalContext")
    }

    Thread.sleep(2000)
    println(globalContext.isActive) // apesar que terminó su tarea sigue activo porque hace parte del hilo principal



    val unconfined = CoroutineScope(newSingleThreadContext("hilo"))

    unconfined.launch {
        delay(1000L)
        println("globalContext")
    }
    Thread.sleep(2000)
    println(unconfined.isActive) // apesar que terminó su tarea sigue activo porque hace parte del hilo principal

}







