package lista_exercicios

fun main(args: Array<String>) {
    //    Faça um programa que leia 10 valores digitados pelo usuário e no final, escreva o maior e o menor valor lido.

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (i in 1..10) {
        println("Digite um valor:")
        val value: Int = readln().toInt()
        max = max.coerceAtLeast(value)
        min = min.coerceAtMost(value)
    }
    println("O valor máximo é: $max, e o valor mínimo é: $min")
}