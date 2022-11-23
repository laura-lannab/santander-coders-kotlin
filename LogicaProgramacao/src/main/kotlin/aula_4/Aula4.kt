package aula_4

fun main(args: Array<String>) {

}

fun funcaoSemRetorno(): Unit {
    print("Minha primeira função no Kotlin")
}

fun mostraSaldo(nome: String, dia: Boolean, saldo: Double): String {
    val diaOuNoite = if (dia) "Bom dia," else "Boa noite,"
    return "$diaOuNoite $nome\n seu saldo é de R$$saldo"
}

fun log(usuario: String, acao: () -> Unit) {
    println("Usuário: $usuario")
    acao.invoke()
}