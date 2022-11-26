package exercicios.desafio2

val menu = """
    
    #################################
    Digite a opção desejada no Menu:
    1..................Adicionar item
    2.....................Editar item
    3.........Exibir itens em estoque
    4...........Exibir todos os itens
    0...............Finalizar sistema
    #################################
    
""".trimIndent()

class Item(var id: Int, var nome: String, var quantidade: Int)

val estoque: MutableList<Item> = mutableListOf<Item>()

fun main() {
    controleEstoque()
}

fun controleEstoque() {
    val finalizar = 0
    println("\nBEM-VINDO AO CONTROLE DE ESTOQUE!")
    menuPrincipal()

}

fun menuPrincipal() {
    println(menu)
    val opcao = readln().toInt()

    when (opcao) {
        1 -> adicionaProduto()
        2 -> editaProduto()
        3 -> exibeEstoque()
        4 -> exibeTodos()
        0 -> finalizar()
        else -> Unit
    }
}

fun adicionaProduto() {
    println("Digite o nome do produto:")
    val nome = readln()

    try {
        println("Digite a quantidade:")
        val quantidade = readln().toInt()
        validaQuantidade(quantidade)
        estoque.add(Item(estoque.size, nome, quantidade))
        println("Produto adicionado com sucesso!")
    } catch (e: LimiteEstoqueException) {
        println(e.localizedMessage)
        menuPrincipal()
    } catch (e: Exception) {
        println("Valor inválido")
        menuPrincipal()
    }
    menuPrincipal()
}

fun editaProduto() {
    if (estoque.isEmpty()) {
        println("Não há produtos no estoque para editar!")
    } else {
        println("Informe o ID do produto que deseja editar:")
        val id = readln().toInt()
        if (id > estoque.size) {
            println("ID não encontrado")
        } else {
            val idProduto = id - 1
            println("Informe novo nome para o produto")
            val novoNome = readln()
            estoque[idProduto].nome = novoNome
            println("Informe nova quantidade para o produto")
            val novaQuantidade = readln().toInt()
            estoque[idProduto].quantidade = novaQuantidade
            println(
                """
                    
                #####################################
                Edição feita com sucesso!
                
                Novo nome: ${estoque[idProduto].nome}
                Nova quantidade: ${estoque[idProduto].quantidade}
                #####################################
                
            """.trimIndent()
            )
        }
    }
    menuPrincipal()
}

fun exibeEstoque() {
    println("Lista dos produtos em estoque:")
    if (estoque.size != 0) {
        estoque.forEach {
            println(
            """
                
            Nome: ${it.nome} Quantidade: ${it.quantidade}
            
        """.trimIndent()
            )
        }
    } else {
        println("Não há produtos a serem exibidos")
    }
    menuPrincipal()
}

fun exibeTodos() {
    println("Lista de todos os produtos:")
    if (estoque.size != 0) {
        estoque.forEach {
            println(
                """
                    
            ID:#${"%04d".format(it.id)} Nome: ${it.nome} Quantidade: ${it.quantidade}
            
        """.trimIndent()
            )
        }
    } else {
        println("Não há produtos a serem exibidos")
    }
    menuPrincipal()
}

fun finalizar() {
    println("Deseja mesmo sair do sistema? (S/N)")
    when (readln().uppercase()) {
        "S" -> return
        "N" -> menuPrincipal()
    }
}

fun validaQuantidade(qtd: Int) {
    if (qtd > 999 || qtd < 0) {
        throw LimiteEstoqueException()
    }
}

class LimiteEstoqueException : Exception() {
    override fun getLocalizedMessage(): String {
        return "Quantidade inválida! Quantidade mínima: 0; Quantidade máxima: 999"
    }

}