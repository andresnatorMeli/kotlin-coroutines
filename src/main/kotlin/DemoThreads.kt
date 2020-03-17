import kotlin.concurrent.thread

fun main() {
    val routinesList = List(200000) {
        thread {
            Thread.sleep(500L)
            print(".")
        }
    }
    routinesList.forEach { it.join() }
}