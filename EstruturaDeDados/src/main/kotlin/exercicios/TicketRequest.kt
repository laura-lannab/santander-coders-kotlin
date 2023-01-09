package exercicios

import java.util.*

//class Radio {
//    private val queue: Queue<String> = LinkedList()
//    private var currentSong: String? = null
//
//    fun addNewSong(song: String) {
//        queue.offer(song)
//    }
//
//    suspend fun play() {
//        while(queue.isNotEmpty()) {
//            currentSong = queue.poll()
//            println("Musica: " + currentSong)
//            println("Proxima musica: " + getNextSong())
//            delay(1000)
//        }
//    }
//
//    fun getNextSong(): String? {
//        return queue.peek()
//    }
//}
//
//fun main(): Unit = runBlocking {
//    val radio = Radio()
//    radio.addNewSong("Primeira musica")
//    launch {
//        radio.play()
//    }
//
//    launch {
//        radio.addNewSong("Segunda música")
//        radio.addNewSong("Terceira música")
//        radio.addNewSong("Quarta música")
//        radio.addNewSong("Quinta música")
//        delay(500)
//        radio.addNewSong("Sexta música")
//    }
//}

data class TicketRequest(
    val name: String,
    val waitingTime: Int
)

class TicketManager {
    private val queue: Queue<TicketRequest> = LinkedList()

    fun add(ticket: TicketRequest) {
        queue.offer(ticket)
        println(queue)
    }

    fun execute() {
        var current = queue.poll()
        while (current != null) {
            if (current.waitingTime < 10) {
                println("Resolvendo:" + current.name)
            } else {
                println("Cancelado:" + current.name)
            }
            current = queue.poll()
        }
        println(queue)
    }

    fun remove() {

    }
}

fun main() {
    val ticketManager = TicketManager()

    ticketManager.add(ticket = TicketRequest(name = "Ticket 1", waitingTime = 2))
    ticketManager.add(ticket = TicketRequest(name = "Ticket 2", waitingTime = 5))
    ticketManager.add(ticket = TicketRequest(name = "Ticket 3", waitingTime = 10))
    ticketManager.execute()


}

