package exercicioFormulario

fun validaCelular(input: String) {
    val regexCelular = Regex("""^\([0-9]{2}\)\s9[1-9][0-9]{3}\-[0-9]{4}$""")

    return if(input.matches(regexCelular)){
        println("Celular válido!")
    } else{
        println("Celular inválido!")
    }
}
