package exercicios

import java.util.*

class exercicio3 {
}

data class Person(val name: String, val age: Int){

}

class Bank{
    private val queue = PriorityQueue<Person>()

    fun add(person: Person){
        queue.offer(person)
    }

    fun execute(){
        var current = queue.poll()
        while (current != null){
            println(current)
            current = queue.poll()
        }
    }
}

fun main(){
    val bank = Bank()
    bank.add(Person(name="Lalala", age= 30))
}

/*
* Definir classe de pessoa (nome e idade)
* Criar a estrutura de banco (fila, novas pessoas entram no banco, atende)
* Caso a pessoa tenha mais de 60 anos ela te prioridade na fila
* */