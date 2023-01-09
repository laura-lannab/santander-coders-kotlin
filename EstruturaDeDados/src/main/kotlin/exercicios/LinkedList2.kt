package exercicios

// Representa o nó, com valor(inicial, e com tipo generico), e próximo valor(que pode ser nulo)
data class Node2<T>(
    var value: T,
    var next: Node2<T>?
)

class LinkedList2<T>(var head: Node2<T>? = null) {
    fun add(value: T) {}
    fun show() {}
    fun isEmpty() {}
    fun remove(value: T) {}
    fun ordenate() {}
}