fun main(args: Array<String>) {
    println("Digite seu nome:") // Imprime a mensagem fornecida
    var name: String = readln() // Lê uma linha de entrada do fluxo de entrada padrão e a retorna
    println("Digite seu sobrenome:")
    var surname: String = readln()

    println(name.plus(surname)) // Imprime na tela a variável name + a variável surname (o método .plus() faz a
        // mesma operação que o +)

    println("Digite sua idade:")
    var age: Int? = readln().toIntOrNull() ?: 30  // a Interrogação faz com que o tipo não seja obrigatório,
        // e o ?:(if else operator), faz com que se o valor for nulo ele sempre terá o valor de 30

    println("Seja bem vindo(a), $name. Você tem $age anos.")

    val number = 2147483647 // valor máximo do tipo int
    val number1 = 2147483648 // valor mínimo do tipo long

    val balance = 432.43

    println("Digite a nota 1:")
    var nota1 = readln().toInt()
    println("Digite a nota 2:")
    var nota2 = readln().toInt()
    println("Digite a nota 3:")
    var nota3 = readln().toInt()
    println("Digite a nota 4:")
    var nota4 = readln().toInt()
    println("Digite a nota 5:")
    var nota5 = readln().toInt()

    var media = (nota1 + nota2 + nota3 + nota4 + nota5) / 5

    println("A média das notas é: $media")

    val soma = 1.plus(1)
    val subtracao = 1.minus(1)
    val divisao = 10.div(2)
    val multplicacao = 10.times(3)
    val mod = 10 % 3


}