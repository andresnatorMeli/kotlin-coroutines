package demo2


import kotlinx.coroutines.*

fun main() {

    val scopeFail = CoroutineScope(Dispatchers.Unconfined)

    scopeFail.launch {
        //supervisorScope {

            launch {
                delay(200)
                println("Child 1")
            }

            launch {
                delay(400)
                throw Exception("Plop!")
            }

            launch {
                delay(600)
                println("Child 3")
            }

        //}
    }

    Thread.sleep(1000)

}


