package exercicio4

open class Eletrodomestico(protected val cor: String, protected val material: String) {
    fun seApresentar() {
        println("Tenho a cor $cor e o material $material")
    }
}

class Geladeira : Eletrodomestico(cor = "prata", "alumínio") {

}

fun main() {
    val geladeira = Geladeira()
    geladeira.seApresentar()
}