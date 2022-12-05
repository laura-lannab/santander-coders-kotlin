package estoque

class Estoque {

    private val listaItems: MutableList<Item> = mutableListOf()

    fun adicionaProduto() {
        println("Digite o nome do produto:")
        val nome = readln()

        try {
            println("Digite a quantidade:")
            val quantidade = readln().toInt()
            validaQuantidade(quantidade)
            listaItems.add(Item(listaItems.size, nome, quantidade))
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
        if (listaItems.isEmpty()) {
            println("Não há produtos no estoque para editar!")
        } else {
            println("Informe o ID do produto que deseja editar:")
            val id = readln().toInt()
            if (id > listaItems.size) {
                println("ID não encontrado")
            } else {
                val idProduto = id - 1
                println("Informe novo nome para o produto")
                val novoNome = readln()
                listaItems[idProduto].nome = novoNome
                println("Informe nova quantidade para o produto")
                val novaQuantidade = readln().toInt()
                listaItems[idProduto].quantidade = novaQuantidade
                println(
                    """
                    
                #####################################
                Edição feita com sucesso!
                
                Novo nome: ${listaItems[idProduto].nome}
                Nova quantidade: ${listaItems[idProduto].quantidade}
                #####################################
                
            """.trimIndent()
                )
            }
        }
        menuPrincipal()
    }

    fun exibeEstoque() {
        println("Lista dos produtos em estoque:")
        if (listaItems.size != 0) {
            listaItems.forEach {
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
        if (listaItems.size != 0) {
            listaItems.forEach {
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

}