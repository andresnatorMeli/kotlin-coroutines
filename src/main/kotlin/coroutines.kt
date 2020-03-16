import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    println("Hola")
    val threadPool = newFixedThreadPoolContext(2, "mythreads")
    val elapsedTime = measureTimeMillis {
        runBlocking(threadPool) {
            val job1 = async {
                println("Start 1 at ${Thread.currentThread().name}")
                delay(2000)
                println("waiting 1 at ${Thread.currentThread().name}")
                delay(2000)
                println("End 1 at ${Thread.currentThread().name}")
            }
            println("Job1 Creado")
            val job2 = async {
                println("Start 2 at ${Thread.currentThread().name}")
                delay(2000)
                println("waiting 2 at ${Thread.currentThread().name}")
                delay(2000)
                println("End 2 at ${Thread.currentThread().name}")
            }
            println("Job2 Creado")
            delay(1000)
            println("Esperando corrutinas")
            job1.await()
            job2.await()
            println("Done")
        }
    }
    threadPool.close()
    println("Elapsed time: $elapsedTime")
}