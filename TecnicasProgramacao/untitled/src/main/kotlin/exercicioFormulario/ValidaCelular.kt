package exercicioFormulario

fun validaCelular(input: String) {
    val patternNumbersPhone = Regex("""^\([0-9]{2}\)\s9[1-9][0-9]{3}\-[0-9]{4}$""")

    return if(input.matches(patternNumbersPhone)){
        println("Celular válido!")
    } else{
        println("Celular inválido!")
    }
}
