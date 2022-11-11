package exercicios

fun main(args: Array<String>) {
//    1 - Faça um programa que receba a idade de uma pessoa em anos e imprima essa idade em meses, dias, horas e minutos.
//    (obs: não será preciso levar em conta anos bissextos, podendo usar 365 dias por ano)
//
//    Exemplo:
//
//    Digite sua idade:
//    -> 1
//    Sua idade equivale a :
//    12 meses
//    365 dias
//    8760 horas
//    525600 minutos

//    convertAge()

    // ###########################################################################################################

//    2 - Faça um programa que receba o ano de nascimento de uma pessoa, o ano atual e calcule e imprima:>
//
//    - A idade dessa pessoa.
//    - A idade convertida em semanas.
//
//    (obs: vamos usar o valor aproximado de 52 semanas por ano para o calculo)
//
//
//    Exemplo:
//
//    Qual seu ano de nascimento?
//    -> 1953
//    Em qual ano estamos?
//    -> 2022
//
//    Você tem 69 anos, você já viveu aproximadamente 3588 semanas.

//    convertBirthDate()

    // ###########################################################################################################
//    3 - Faça um programa que receba a idade de um nadador e imprima a sua categoria seguindo as regras:
//
//    CATEGORIA   	IDADE
//
//    Infantil A 	5 — 7 anos
//    Infantil B	8 — 10 anos
//    Juvenil A		11 — 13 anos
//    Juvenil B		14 — 17 anos
//    Sênior		maiores de 18 anos

//    categoryByAge()

    // ###########################################################################################################

//    4 - Faça um programa que peça uma nota, entre zero e dez.
//    Mostre uma mensagem caso o valor seja inválido e continue pedindo até que o usuário informe um valor válido.
//    askGrade()

    // ###########################################################################################################

//    5 - Faça um programa que leia um nome de usuário e a sua senha e não aceite a senha igual ao nome do usuário,
//    mostrando urna mensagem de erro e voltando a pedir as informações.
    isUserInPassword()
}

fun convertAge() {
    println("Digite sua idade:")
    val age: Int = readln().toInt()

    val minutes: Int = (MINUTES_MULTIPLIER * age)
    val hours: Int = (HOURS_MULTIPLIER * age)
    val days: Int = (DAYS_MULTIPLIER * age)
    val months: Int = (MONTHS_MULTIPLIER * age)

    println("Sua idade equivale a : $months meses $days dias $hours horas $minutes minutos")
}

private const val MINUTES_MULTIPLIER = 525600
private const val HOURS_MULTIPLIER = 8760
private const val DAYS_MULTIPLIER = 365
private const val MONTHS_MULTIPLIER = 12

fun convertBirthDate() {
    println("Qual seu ano de nascimento?")
    val birthDate: Int = readln().toInt()
    println("Em qual ano estamos?")
    val currentYear: Int = readln().toInt()

    val age: Int = currentYear - birthDate
    val ageInWeeks: Int = age * WEEKS_MULTIPLIER

    println("Você tem $age anos, você já viveu aproximadamente $ageInWeeks semanas.")
}

private const val WEEKS_MULTIPLIER = 52

fun categoryByAge() {
    println("Digite sua idade:")

    when (readln().toInt()) {
        in 0..4 -> println("Você precisa ter mais de 5 anos")
        in 5..7 -> println("Você pertence a categoria Infantil A")
        in 8..10 -> println("Você pertence a categoria Infantil B")
        in 11..13 -> println("Você pertence a categoria Juvenil A")
        in 14..17 -> println("Você pertence a categoria Juvenil B")
        else -> println("Você pertence a categoria Senior")
    }
}

fun askGrade() {
    println("Informe uma nota, entre 0 e 10:")
    var grade: Int = readln().toInt()

    do {
        println("Digite um valor válido, entre 0 e 10!")
        grade = readln().toInt()

    } while (grade <= 0 || grade >= 10)
}

fun isUserInPassword() {
    println("Informe seu nome:")
    var name: String = readln().lowercase()
    println("Informe uma senha:")
    var password: String = readln().lowercase()

    var check: Boolean = name == password

    while (check) {
        println("Nome não pode ser igual a senha")
        println("Informe seu nome novamente:")
        name = readln().lowercase()
        println("Informe uma senha novamente:")
        password = readln().lowercase()
        check = name == password
    }
}