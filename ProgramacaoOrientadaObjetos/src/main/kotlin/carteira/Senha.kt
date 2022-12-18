package carteira

internal abstract class GeradorDeSenhas<T>(val quantidadeDigitos: Int) {
    abstract fun gerarSenha(): T
}

internal class GeradorSenhaNumerica(quantidadeDigitos: Int): GeradorDeSenhas<Int>(quantidadeDigitos){
    override fun gerarSenha(): Int {
        var str = "123456789"
        var password = ""
        for (i in 1..quantidadeDigitos) {
            password += str.random()
        }
        return password.toInt()
    }
}

internal class GeradorSenhaAlfaNumerica (quantidadeDigitos: Int): GeradorDeSenhas<String>(quantidadeDigitos){
    override fun gerarSenha(): String {
        val caracteresPermitidos = ('A'..'Z') + ('a'..'z') + ('0'..'9') + ("*!?+-");
        return (1..quantidadeDigitos)
            .map { caracteresPermitidos.random() }
            .joinToString("")
    }
}