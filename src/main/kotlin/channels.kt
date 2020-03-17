import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val channel = Channel<String?>()
        val producer = GlobalScope.launch {
            while (true) {
                val line = readLine()
                println("readline in thread ${Thread.currentThread().name}")
                if (line == "salir"){
                    channel.close()
                    break
                }
                channel.send(line)
            }
        }
        val consumer = GlobalScope.launch {
            while (!channel.isClosedForReceive) {
                val line = try {
                    channel.receive()
                } catch (ce: ClosedReceiveChannelException) {
                    "Channel closed! chau"
                }
                println("printing in thread ${Thread.currentThread().name}")
                println(line)
            }
        }
        producer.join()
        consumer.join()
    }
}
