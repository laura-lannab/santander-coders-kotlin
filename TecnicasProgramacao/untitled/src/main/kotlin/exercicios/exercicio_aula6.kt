package exercicios

fun main() {

    val patternNumbersCpfCnpj = Regex("""([0-9]{2}\.?[0-9]{3}\.?[0-9]{3}\/?[0-9]{4}-?[0-9]{2})|([0-9]{3}\.?[0-9]{3}\.?[0-9]{3}-?[0-9]{2})""")
    val cpf = "111.222.333-44"
    val cnpj = "11.222.333/0001-44"
    println("CPF: ${cpf.matches(patternNumbersCpfCnpj)}")
    println("CNPJ: ${cnpj.matches(patternNumbersCpfCnpj)}")

    val patternNumbersEmail = Regex("""^[a-z0-9.]+@[a-z0-9]+\.[a-z]+(\.[a-z]+)?$""")
    val email1 = "email@provedor.com"
    val email2 = "email@provedor.com.br"
    println("Email.com: ${email1.matches(patternNumbersEmail)}")
    println("Email.com.br: ${email2.matches(patternNumbersEmail)}")

    val patternNumbersPhone = Regex("""^\([0-9]{2}\)\s9[1-9][0-9]{3}\-[0-9]{4}$""")
    val phone = "(31) 92222-3333"
    println("Phone: ${phone.matches(patternNumbersPhone)}")
}
