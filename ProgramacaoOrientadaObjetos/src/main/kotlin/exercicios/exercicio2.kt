package exercicios

class Animal(val tipo: String, val raca: String, val idade: Int, var cor: String) {


    override fun toString(): String {
        return """
            $tipo, $raca, cor $cor de idade $idade anos
        """.trimIndent()
    }
}

class Carro(
    var modelo: String,
    var cor: String,
    var ano: Int
) {

    override fun toString(): String {
        return """
            $modelo, ano $ano, cor $cor
        """.trimIndent()
    }
}


class Pessoa(val nome: String, val idade: Int, var altura: Double, var pet: Animal, var carro: Carro) {


    override fun toString(): String {
        return """
            $nome, idade $idade, altura $altura, dirige um ${carro.toString()}, e possui um animal de estimação ${pet.toString()}
        """.trimIndent()
    }
}


fun main() {
    val cachorro1 = Animal(
        tipo = "Cachorro",
        raca = "Golden",
        idade = 4,
        cor = "Dourado"
    )

    val carro1 = Carro(
        modelo = "gol",
        cor = "cinza",
        ano = 2020
    )

    val pessoa1 = Pessoa(
        nome = "Laura",
        idade = 32,
        altura = 1.57,
        pet = cachorro1,
        carro = carro1
    )

    println(pessoa1.toString())

}
