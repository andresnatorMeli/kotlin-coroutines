package demo2

// calculo suspendible
// seguiento de la corutinas


import kotlinx.coroutines.Runnable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {

    val timeThread = measureTimeMillis {

        repeat(1000) {
            Thread(Runnable {
                Thread.sleep(1)
                print(".")
            }).run()
        }
    }

    val timeCoroutine = measureTimeMillis {
        runBlocking {
            repeat(10_000) {
                launch {
                    delay(1)
                    print(".")
                }
            }
        }
    }

    println()
    println("tiempo transcurrido thread $timeThread")
    println("tiempo transcurrido coroutine $timeCoroutine")
}



