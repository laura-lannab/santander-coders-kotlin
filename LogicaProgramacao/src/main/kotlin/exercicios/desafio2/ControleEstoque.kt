package exercicios.desafio2

val menu = """
    Digite a opção desejada no Menu:
    1..................Adicionar item
    2.....................Editar item
    3.........Exibir itens em estoque
    4...........Exibir todos os itens
    0...............Finalizar sistema
""".trimIndent()

val estoque: MutableList<Item> = mutableListOf<Item>()

class Item(val id: Int, val nome: String, val quantidade: Int)

fun main() {
    controleEstoque()
}

fun adicionaProduto() {
    println("Digite o nome do produto:")
    var nome = readln()
    println("Digite a quantidade:")
    var qtd = readln().toInt()

    if (qtd > 999) throw LimiteEstoqueMaxException()
    if (qtd < 0) throw LimiteEstoqueMinException()

    estoque.add(Item(estoque.size, nome, qtd))

    println("Produto adicionado com sucesso!")
}

fun editaProduto() {
    if (estoque.isEmpty()) {
        println("Não há produtos no estoque para editar!")
    } else {
        println("Menu Editar")
        // TODO função exibir produtos aqui

        println("Informe o ID do produto que deseja editar:")
        val id = readln().toInt()
        if (id > estoque.size) {
            println("ID não encontrado")
        } else {

        }
    }
}

fun controleEstoque() {
    println("Bem-vindo ao controle de estoque!")
    do {
        println(menu)

        val categoria = readln().toInt()

        when (categoria) {
            1 -> {
                adicionaProduto()
            }

            2 -> {
                "editar"
            }

            3 -> {
                "listar validos"
            }

            4 -> {
                "listar todos"
            }

            else -> Unit
        }
    } while (categoria != 0)
}


class LimiteEstoqueMaxException : Exception() {
    override fun getLocalizedMessage(): String {
        return "Erro: Quantidade maior que 999. (Quantidade Máxima = 999)"
    }
}

class LimiteEstoqueMinException : Exception() {
    override fun getLocalizedMessage(): String {
        return "Erro: Quantidade menor que 0. (Quantidade Mínima = 0)"
    }
}