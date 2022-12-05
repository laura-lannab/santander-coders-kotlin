package estoque

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

fun main() {
    controleEstoque()
}

fun controleEstoque() {
    val finalizar = 0
    println("\nBEM-VINDO AO CONTROLE DE ESTOQUE!")
    menuPrincipal()
}

val estoque = Estoque()

fun menuPrincipal() {
    println(menu)
    val opcao = readln().toInt()

    when (opcao) {
        1 -> estoque.adicionaProduto()
        2 -> estoque.editaProduto()
        3 -> estoque.exibeEstoque()
        4 -> estoque.exibeTodos()
        0 -> finalizar()
        else -> Unit
    }
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

