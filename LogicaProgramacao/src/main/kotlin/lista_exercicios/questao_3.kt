package lista_exercicios

fun main(args: Array<String>) {
//    Faça um algoritmo para ler 15 números e armazenar em uma lista.
//
//    Após a leitura total dos 15 números, o algoritmo deve escrever esses 15 números lidos na ordem inversa
//    da qual foi declarado.


    val listOfNumber: MutableList<Int> = mutableListOf()

    for (i in 1..15) {
        println("Informe um número:")
        val number: Int = readln().toInt()
        listOfNumber.add(number)
    }

    println(listOfNumber.asReversed())
}