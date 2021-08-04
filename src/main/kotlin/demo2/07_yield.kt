package demo2


import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    runBlocking {
        launch { suspendTask1() }
        launch { suspendTask2() }
    }
}

suspend fun suspendTask1() {
    println("start suspendTask1")
    yield()
    println("finish suspendTask1")
}

suspend fun suspendTask2() {
    println("start suspendTask2")
    yield()
    println("finish suspendTask2")
}
