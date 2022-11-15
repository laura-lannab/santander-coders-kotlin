package exercicios

fun main(args: Array<String>) {
//    readValues()
//    multiplicationTable()
//    reversedList()
//    calculatePercentage()
    primes()
}

fun readValues() {
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

fun multiplicationTable() {
    println("Informe um número:")
    val number: Int = readln().toInt()
    println("Tabuada do $number")
    for (i in 1..10) {
        val result: Int = i * number
        println("$i x $number = $result")
    }
}

fun reversedList() {
    val listOfNumber: MutableList<Int> = mutableListOf()

    for (i in 1..15) {
        println("Informe um número:")
        val number: Int = readln().toInt()
        listOfNumber.add(number)
    }

    println(listOfNumber.asReversed())
}

fun calculatePercentage() {
    println("Informe o número de eleitores:")
    val voters: Int = readln().toInt()
    var candidateA: Int = 0
    var candidateB: Int = 0
    var candidateC: Int = 0

    for (i in 1..voters) {
        println("Vote A, para o candidato A; vote B, para o Candidato B; e vote C, para o Candidato C!")
        when (readln().uppercase()) {
            "A" -> candidateA++
            "B" -> candidateB++
            "C" -> candidateC++
            else -> println("Voto inválido!")
        }
    }
    val totalCount: Double = (candidateA + candidateB + candidateC).toDouble()
    val percentageA: Double = (candidateA.toDouble() / totalCount) * 100
    val percentageB: Double = (candidateB.toDouble() / totalCount) * 100
    val percentageC: Double = (candidateC.toDouble() / totalCount) * 100

    println("Candidato A - $candidateA votos ($percentageA)")
    println("Candidato B - $candidateB votos ($percentageB)")
    println("Candidato C - $candidateC votos ($percentageC)")
}

fun primes(){
    //    Enunciado
//    Faça um programa que gera uma lista dos números primos existentes entre 1 e um número inteiro informado pelo usuário.
    println("Informe um número:")
    val number: Int = readln().toInt()

    val primeList = mutableListOf<Int>()
    for (i in 2..number) {
        if ((2 until i).none{ i % it == 0 })
            primeList.add(i)
    }

    println(primeList)
}