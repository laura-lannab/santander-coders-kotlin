package exercicioFormulario

fun validaCpfCnpj(input: String) {
    val patternNumbersCpfCnpj =
        Regex("""([0-9]{2}\.[0-9]{3}\.[0-9]{3}\/[0-9]{4}-[0-9]{2})|([0-9]{3}\.[0-9]{3}\.[0-9]{3}-[0-9]{2})""")

    return if(input.matches(patternNumbersCpfCnpj)){
        println("CPF ou CNPJ válido!")
    } else{
        println("CPF ou CNPJ inválido!")
    }
}