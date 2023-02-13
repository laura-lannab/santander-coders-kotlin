package exercicioFormulario

fun validaEmail(input: String) {
    val patternNumbersEmail = Regex("""^[a-z0-9.]+@[a-z0-9]+\.[a-z]+(\.[a-z]+)?$""")

    return if(input.matches(patternNumbersEmail)){
        println("Email válido!")
    } else{
        println("Email inválido!")
    }
}