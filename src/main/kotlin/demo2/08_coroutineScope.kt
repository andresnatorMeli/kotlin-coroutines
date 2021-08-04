package demo2

import kotlinx.coroutines.*


fun main() {
    //val globalContext = CoroutineScope(GlobalScope.coroutineContext)


    runBlocking {

        launch {
            delay(1)
            println(Thread.currentThread().name)
        }

        launch(Dispatchers.Unconfined) {
            delay(50)
            println(Thread.currentThread().name)
        }

        launch(Dispatchers.Default) {
            delay(100)
            println(Thread.currentThread().name)
        }

        launch(Dispatchers.IO) {
            delay(150)
            println(Thread.currentThread().name)
        }

        launch(newSingleThreadContext("myThread")) {
            delay(200)
            println(Thread.currentThread().name)
        }

        launch(newFixedThreadPoolContext(2, "mythreads")) {
            delay(250)
            println(Thread.currentThread().name)
        }

    }

}







