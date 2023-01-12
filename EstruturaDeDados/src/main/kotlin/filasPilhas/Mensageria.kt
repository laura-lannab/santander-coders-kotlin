package filasPilhas

import java.util.*
import kotlin.random.Random

data class Message(
    val text: String,
    val recipient: String
)

class MessageBroker {
    private val messageSender = Random(1000)
    private val queue: Queue<Message> = LinkedList<Message>()

    fun processFirstMessage() {

        val message = queue.peek()
        message?.let {
            var count = 0
            while (!send(message)) {
                count++
                if (count == 3) {
                    break
                }
            }
            queue.poll()
            if (count < 3) {
                println("Mensagem enviada com sucesso: ${message.text}")
            } else {
                println("Erro ao enviar mensagem: ${message.text}")
            }
        }
    }

    private fun send(message: Message): Boolean {
        return messageSender.nextBoolean()
    }

    fun addMessage(message: Message) {
        queue.add(message)
    }
}

fun main() {
    val message = MessageBroker()
    message.addMessage(Message("teste1", "lalala1"))
    message.addMessage(Message("teste2", "lalala2"))
    message.processFirstMessage()
    message.processFirstMessage()

}