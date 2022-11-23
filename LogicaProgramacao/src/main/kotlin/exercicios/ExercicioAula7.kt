package exercicios

fun main(args: Array<String>) {
    var divisores = mutableListOf<Int?>()
    var dividendos = mutableListOf<Int?>()

    repeat(3) {
        println("Digite o ${it.inc()} dividendo")
        dividendos.add(readln().toIntOrNull())
        println("Digite o ${it.inc()} divisores")
        divisores.add(readln().toIntOrNull())
    }

    for (i in dividendos.indices) {
        var dividido = dividendos[i]
        var divisor = divisores[i]
        println("O resultador da divisão entre $dividido e $divisor é: ${dividido!! / divisor!!}")
    }


}