package exercicios

data class Node1<T>(
    var value: T,
    var next: Node1<T>?
)
private data class LinkedList<T>(
    var head: Node1<T>? = null
) {
    fun add(value: T) {
        val newNode = Node1(value = value, null)
        if (head == null) {
            head = newNode
            return
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }
    fun show() {
        var current = head
        if (current == null) {
            println("Lista vazia")
            return
        }
        while(current != null) {
            println(current.value)
            current = current.next
        }
    }
    fun isEmpty(): Boolean {
        return head == null
    }

    //feita pelo grupo
    fun remove(value: T){
        var previous = head
        var current = head?.next
        if (previous == null) {
            return
        }else if(previous.value == value){ // Se o elemento for o primeiro da lista
            head = current
        }
        while(current != null) { // Se o elemento não for o primeiro da lista
            previous = previous?.next
            current = current?.next
            if(current?.value == value)
                previous?.next = current?.next
        }
    }

    //feita pelo professor
    fun remove2(value: T): Boolean {
        if (head?.value == value) {
            head = head?.next
            return true
        }

        var current = head?.next
        var previous = head

        while (current != null && current.value != value) {
            previous = current
            current = current.next
        }

        if (current!= null) {
            previous?.next = current.next
            return true
        }

        return false
    }
}
fun main() {
    val list = LinkedList<String>()
    println(list.isEmpty())
    list.add("primeiro valor")
    list.show()
    list.add("segundo valor")
    list.show()
}