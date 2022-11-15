package lista_exercicios

fun main(args: Array<String>) {

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

