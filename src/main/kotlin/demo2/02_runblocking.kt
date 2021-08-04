package demo2


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    GlobalScope.launch {
        println("GlobalScope.launch Start")
        delay(1000L)
        println("GlobalScope.launch Finish")
    }
    //Thread.sleep(2000)


    /*
       // trabaja como si fueran funciones no suspendibles
       runBlocking {
           launch {
               println("runBlocking Start")
               delay(1000L)
               println("runBlocking Finish")
           }
       }

       */


}


