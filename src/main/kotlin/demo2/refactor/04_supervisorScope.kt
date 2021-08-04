package demo2


import kotlinx.coroutines.*

fun main() {

    val scopeFail = CoroutineScope(Job())


    scopeFail.launch {
        launch {
            println("Child 1")
        }
        launch {
            throw Exception("Plop!")
            //println("Child 2")
        }
        launch {
            println("Child 3")
        }

    }

/*
    val scope = CoroutineScope(Job())
    scope.launch {
        supervisorScope {
            launch {
                println("Child 1")
            }
            launch {
                throw Exception("Plop!")
                //println("Child 2")
            }
            launch {
                println("Child 3")
            }
        }
    }

 */


    Thread.sleep(1000L)
}


