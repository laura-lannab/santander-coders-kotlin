package aula_2

import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>) {
//    println("Digite o usuário:")
//    var user = readln()

    //condicional if else
//    if (user.length in 6..10) {
//        println("Usuário cadastrado com sucesso!")
//    } else if (user.length > 10) {
//        println("Usuário não pode ter mais de 10 caracteres!")
//    } else {
//        println("Usuário não cadastrado!")
//    }

    //condicional when
//    when {
//        user.length in 6..10 -> println("Usuário cadastrado com sucesso!")
//        user.length > 10 -> println("Usuário não pode ter mais de 10 caracteres!")
//        else -> println("Usuário não cadastrado!")
//    }

    //condicional while
//    while(user.isEmpty()){
//        println("Digite o usuário:")
//        user = readln()
//    }

    //condicional do while
//    do {
//        println("Digite o usuário:")
//        user = readln()
//    } while (user.isBlank() || user.isEmpty())

//    var i = 1
//    while (i < 10) {
//        println("while$i")
//        i++
//    }

//    do {
//        println("while$i")
//        i++
//    } while (i < 10)

//#################################################################################################
    println("Digite o número mínimo:")
    val min = readln().toInt()
    println("Digite o número máximo:")
    val max = readln().toInt()

    val random = Random.nextInt(min..max)

    do{
        println("Tente adivinhar o número gerado")
        val number = readln().toInt()

        when{
            number > random -> println("O número secreto é menor do que o escolhido")
            number < random -> println("O número secreto é maior do que o escolhido")
            else -> println("Você acertou!!")
        }
    }while (number != random)


}