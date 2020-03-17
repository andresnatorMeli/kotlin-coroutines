import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val routinesList = List(200000) {
        launch {
            delay(500L)
            print(".")
        }
    }
    routinesList.forEach { it.join() }
}