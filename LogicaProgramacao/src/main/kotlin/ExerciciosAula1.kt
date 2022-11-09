import kotlin.math.pow

fun main(args: Array<String>)  {
    //Exercício 1

/*  Faça um algoritimo que receba o comprimento do lado de um quadrado e calcule sua área e seu perímetro.

    Exemplo:

    Digite o lado do do quadrado:
    12
    A area do quadrado e de 144 e seu perimetro de 48    */


    println("Digite o lado do quadrado:")
    var lado = readln().toDouble()

    var area = lado.pow(2)
    var perimetro = lado * 4

    println("A área do quadrado é de $area e seu perímetro de $perimetro")

    // #############################################
    // Exercício 2

/*  Faça um algoritimo que leia a base e a altura de um triangulo e calcule a sua area.
    F => base*altura/2   */


//    println("Digite a base do triângulo:")
//    var base = readln().toDouble()
//    println("Digite a altura do triângulo:")
//    var altura = readln().toDouble()
//
//    var area = (base * altura) / 2
//    println("A area do triângulo é $area")

    // #############################################
    // Exercício 3

 /*   3 - Gerador de usuarios. Crie um programa que receba o nome, sobrenome e ano de nascimento do usuário, e a partir disso gere um nick com as duas primeiras letras do nome, seu sobrenome
    ao contrario e os ultimos dois digitos de seu ano de nascimento tudo minusculo.

    Exemplo:

    - Maria
    - Medeiros
    - 1984

    nick gerado: masoriedem84  */

//    println("Digite seu nome:")
//    var name: String = readln().substring(0, 2).lowercase()
//    println("Digite seu sobrenome:")
//    var surname: String = readln().reversed().lowercase()
//    println("Digite sua data de nascimento:")
//    var birthday: Int = readln().toInt()
//    var birthdayString: String = birthday.toString().substring(2,4)
//
//    println(name + surname + birthdayString)
}