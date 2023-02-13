package exercicioFormulario

fun validaCpfCnpj(input: String) {
    val regexCpfCnpj =
        Regex("""([0-9]{2}\.[0-9]{3}\.[0-9]{3}\/[0-9]{4}-[0-9]{2})|([0-9]{3}\.[0-9]{3}\.[0-9]{3}-[0-9]{2})""")

    return if (input.matches(regexCpfCnpj)) {
        println("CPF ou CNPJ válido!")
    } else {
        println("CPF ou CNPJ inválido!")
    }
}