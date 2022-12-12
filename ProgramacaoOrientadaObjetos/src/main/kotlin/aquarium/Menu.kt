import aquarium.Aquarium
import aquarium.Fish

val menuOptions = """
    ################################
    ### Digite a opção desejada: ###
    1.............Adicionar um peixe
    2............Alimentar os peixes
    3...............Limpar o aquário
    0...............Fechar o sistema
    ################################
""".trimIndent()

fun createFish(): Fish {
    println("Digite o nome do peixe:")
    val name = readln()
    println("Digite a cor do peixe:")
    val color = readln()
    println("Digite o tamanho do peixe (P, M ou G):")
    var size = readln().uppercase()
    while (size != "P" && size != "M" && size != "G"){
        println("Tamanho inválido. Digite um tamanho válido (P, M ou G):")
        size = readln().uppercase()
    }
    return Fish(name, color, size)
}

fun menu() {
    val aquarium = Aquarium()
    do {
        println(menuOptions)
        val input = readln().toInt()
        when (input) {
            1 -> aquarium.addFish(createFish())
            2 -> aquarium.feed()
            3 -> aquarium.clean()
            else -> Unit
        }
    } while (input != 0)
}

fun main() {
    println("\n Seja bem-vindo ao seu aquário! \n".uppercase())
    menu()
}