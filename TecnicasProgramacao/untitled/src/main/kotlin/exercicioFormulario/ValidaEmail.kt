package exercicioFormulario

fun validaEmail(input: String) {
    val regexEmail = Regex("""^[a-z0-9.]+@[a-z0-9]+\.[a-z]+(\.[a-z]+)?$""")

    return if(input.matches(regexEmail)){
        println("Email válido!")
    } else{
        println("Email inválido!")
    }
}