package exercicio5

open class Personagem(val dano: Int, val defesa: Int)

class Guerreiro : Personagem(10, 5)
class Mago : Personagem(8, 7)

abstract class Mouse {
    abstract fun cliqueEsquerdo()
    abstract fun cliqueDireito()
}

interface Teclado {
    fun pressionarTecla(tecla: Char)
    val teclasDisponiveis: List<Char>
}

class Controle(val mouse: Mouse, val teclado: Teclado)

fun main() {
    val guerreiro = Guerreiro()
    val mago = Mago()

    val controleGuerreiro = Controle(mouse = object : Mouse() {
        override fun cliqueEsquerdo() {
            TODO("Not yet implemented")
        }

        override fun cliqueDireito() {
            TODO("Not yet implemented")
        }
    }, teclado = object :Teclado{
        override fun pressionarTecla(tecla: Char) {
            TODO("Not yet implemented")
        }

        override val teclasDisponiveis: List<Char>
            get() = TODO("Not yet implemented")
    })
}

