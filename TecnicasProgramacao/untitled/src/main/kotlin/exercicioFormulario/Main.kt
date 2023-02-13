package exercicioFormulario

fun main() {
    println("Informe um CPF ou CNPJ:")
    val inputCpfOuCnpj = readln()
    validaCpfCnpj(inputCpfOuCnpj)

    println("Informe um e-mail:")
    val inputEmail = readln()
    validaEmail(inputEmail)

    println("Informe um número de celular com DDD:")
    val inputCelular = readln()
    validaCelular(inputCelular)
}