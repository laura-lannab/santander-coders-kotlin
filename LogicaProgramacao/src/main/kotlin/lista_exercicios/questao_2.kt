package lista_exercicios

fun main(args: Array<String>) {
//    Escreva um algoritmo que receba um número e imprima a tabuada dele (de 1 a 10)
//
//    Ex:
//
//    Digite um número: 9
//
//    Tabuada do 9
//    1 x 9 = 9
//    2 x 9 = 18
//    3 x 9 = 27
//    4 x 9 = 36
//    5 x 9 = 45
//    6 x 9 = 54
//    7 x 9 = 63
//    8 x 9 = 72
//    9 x 9 = 81
//    10 x 9 = 90


    println("Informe um número:")
    val number: Int = readln().toInt()
    println("Tabuada do $number")
    for (i in 1..10) {
        val result: Int = i * number
        println("$i x $number = $result")
    }
}