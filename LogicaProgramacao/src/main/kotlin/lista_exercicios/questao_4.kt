package lista_exercicios

fun main(args: Array<String>) {

//    Numa eleição existem três candidatos. Faça um programa que peça o número total de eleitores.
//    Peça para cada eleitor votar e ao final mostrar o número de votos de cada candidato e qual a porcentagem de votos de cada um.
//
//    Candidato A - 300 votos (30%)
//    Candidato B - 200 votos (20%)
//    Candidato C - 500 votos (50%)


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