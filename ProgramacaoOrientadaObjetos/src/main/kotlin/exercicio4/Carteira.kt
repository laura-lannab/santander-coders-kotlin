package exercicio4

class Carteira {

    private var saldo: Double = 0.0

    private val listaDeChaves: MutableList<String> = mutableListOf()

    fun criarChavePix(): String {
        val caracteresPermitidos = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..30)
            .map { caracteresPermitidos.random() }
            .joinToString("")
    }

    fun depositar(valor: Double) {
        saldo += valor
    }

    fun sacar(valor: Double) {
        if (valor > saldo) {
            println("Valor em saldo menor que o valor a ser sacado. (Saldo = $saldo)")
            return
        }
        saldo -= valor
    }

    fun buscaSaldo(): Double {
        return saldo
    }
}

class Cliente(val nome: String, val sobrenome: String){
    private var senha: String = ""
//    val carteira: Carteira = mutableListOf<Carteira>()
}

fun main(){
    println(Carteira().criarChavePix())
}