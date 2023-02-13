package exercicios

fun main() {
//    val patternNumbers = Regex("3[0-9]*")
//    val numberTest = "5000"
//    println("NumberTest: ${numberTest.matches(patternNumbers)}")

//    val patternLetters = Regex("")
//    val lettersTest = "5000"
//    println("LettersTest: ${lettersTest.matches(patternLetters)}")

    ////////////////////////////////////////////////////////////////////////

    //exercício1

//    val patternNumbersCPF = Regex("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")
//    val cpfTest = "123.321.456-98"
//    println("cpfTest: ${cpfTest.matches(patternNumbersCPF)}")
//
//    val patternNumbersCNPJ = Regex("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")
//    val cnpjTest = "12.345.456/7896-98"
//    println("cnpjTest: ${cnpjTest.matches(patternNumbersCNPJ)}")
//
//    val patternNumbers = Regex("""([0-9]{2}\.?[0-9]{3}\.?[0-9]{3}\/?[0-9]{4}-?[0-9]{2})|([0-9]{3}\.?[0-9]{3}\.?[0-9]{3}-?[0-9]{2})""")
//    val test1 = "111.222.333-44"
//    val test2 = "11.222.333/0001-44"
//
//    println("test1: ${test1.matches(patternNumbers)}")
//    println("test2: ${test2.matches(patternNumbers)}")

    ////////////////////////////////////////////////////////////////////////


    //exercício2

//    val patternNumbers = Regex("""R\$\s[0-9]\,[0-9][0-9]""")
//    val test = "R$ 7,50"
//    println("test: ${test.matches(patternNumbers)}")


    ///////////////////////////////////////////////////////////////////////

    //exercicio3

//    val patternNumbers = Regex("""^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.com$""")
    val patternNumbers = Regex("""^[a-z0-9.]+@[a-z0-9]+\.[a-z]+(\.[a-z]+)?$""")
    val test1 = "email@provedor.com"
    val test2 = "email@provedor.com.br"
    println("test1: ${test1.matches(patternNumbers)}")
    println("test2: ${test2.matches(patternNumbers)}")


    ///////////////////////////////////////////////////////////////////////

    //exercicio4

//    val patternNumbers = Regex("""^\([0-9]{2}\)\s9[1-9][0-9]{3}\-[0-9]{4}$""")
//    val test = "(31) 92222-3333"
//    println("test: ${test.matches(patternNumbers)}")


    //https://souforce.cloud/regra-de-validacao-para-cpf-e-cnpj-no-salesforce/#:~:text=Seu%20n%C3%BAmero%20%C3%A9%20composto%20por,n%C3%BAmero%20do%20CPF%20%C3%A9%20v%C3%A1lido

}