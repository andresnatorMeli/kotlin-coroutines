import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.lang.Thread.sleep
import kotlin.system.measureTimeMillis

fun main() {
    val mutex = Mutex()
    var c = 0L
    val threadNameSet = mutableSetOf<String>()
    val time = measureTimeMillis {
        runBlocking {
            (1..1_000L).map { i ->
                GlobalScope.launch {
                    threadNameSet.add(Thread.currentThread().name)
                    delay(1000)
                    mutex.withLock {
                        c += i
                    }
                }
            }.map {
                it.join()
            }
        }
    }
    println("Calculated c: $c in $time miliseconds, using ${threadNameSet.size} threads")
}