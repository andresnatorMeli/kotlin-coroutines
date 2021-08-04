package demo2


import kotlinx.coroutines.*

fun main() = runBlocking {
    val getWorldFromApi = async {
        getWorldFromApi()
    }
    println("Hello ${getWorldFromApi.await()}")
}

suspend fun getWorldFromApi(): String {
    return withContext(Dispatchers.IO) {
        delay(2000L)
        "World!"
    }

}
