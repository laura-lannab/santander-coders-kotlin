package epadoca

import java.text.NumberFormat
import java.util.*

private const val LINHA = ".........."

val estoque = Estoque()

val categorias = """
    Digite a opção desejada no Menu:
    1..................Pães
    2..............Salgados
    3.................Doces
    4.....cupom de desconto
    0......Finalizar compra
""".trimIndent()

fun getMenuProduto(listaProduto: List<Produto>): String {
    var menu = ""
    listaProduto.forEachIndexed { index, produto ->
        menu += "${index + 1} - ${produto.nome}...........${formataNumero(produto.preco)}\n"
    }
    menu += "0 - Voltar"
    return menu
}

val itensComanda: MutableList<String> = mutableListOf<String>()
const val linhaComanda = "===========================================================\n"
const val tituloComanda = "====================Comanda E-padoca=======================\n" +
        "===========================================================\n" +
        "item.......Produto..........Qtd.......Valor...........Total\n" +
        "==========================================================="
const val finalComanda = "=====================VOLTE SEMPRE ^-^======================"

var total = 0.0

const val cincoPadoca = 0.05
const val dezPadoca = 0.1
const val descontoCinco = 5
var cupomPorcentagemAplicada = 0.0
var cupomSubtracaoAplicada = 0

fun main() {
    do {
        var finalizarCompra = "S"
        ePadoca()

        if (itensComanda.isEmpty()) {
            println("Deseja mesmo finalizar a compra? (S/N)")
            finalizarCompra = readln().uppercase()
        } else {
            println(tituloComanda)
            itensComanda.forEach { item -> // funcao
                println(item)
            }
            total -= cupomSubtracaoAplicada
            total -= total * cupomPorcentagemAplicada
            total = maxOf(total, 0.0)

            println(
                linhaComanda + "Total ===========================================> ${
                    formataNumero(total)
                }\n" + finalComanda
            )
        }
    } while (finalizarCompra != "S")
}

fun ePadoca() {
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categorias)

        val categoria = Categoria.pegarPorValor(readln().toInt())

        when (categoria) {
            Categoria.PAES -> selecionaProduto(menuSelecionado = getMenuProduto(estoque.paes), produtos = estoque.paes)
            Categoria.SALGADOS -> selecionaProduto(menuSelecionado = getMenuProduto(estoque.salgados), produtos = estoque.salgados)
            Categoria.DOCES -> selecionaProduto(menuSelecionado = getMenuProduto(estoque.doces), produtos = estoque.doces)
            Categoria.DESCONTO -> {
                println("Digite o seu cupom:")
                val cupom = readln().uppercase()
                aplicaDesconto(cupom)
            }

            Categoria.ERRO -> println("Valor inválido")
            else -> Unit
        }
    } while (categoria != Categoria.FINALIZAR)
}

fun selecionaProduto(
    menuSelecionado: String, produtos: List<Produto>
) {
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt()

        for ((i, produto) in produtos.withIndex()) {
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }

    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(produto: Produto) {
    println("Digite a quantidade:")
    val quantidade = readln().toInt()
    val totalItem = quantidade * produto.preco
    val item =
        itemComanda(produto = produto.nome, quantidade = quantidade, valorUnitario = produto.preco, total = totalItem)
    itensComanda.add(item)
    total += totalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double,
): String = "${itensComanda.size.inc()}$LINHA$produto$LINHA$quantidade$LINHA${
    formataNumero(valorUnitario)
}$LINHA${formataNumero(total)}"

fun aplicaDesconto(cupom: String) {
    if (cupomPorcentagemAplicada + cupomSubtracaoAplicada > 0) {
        println("Um cupom já aplicado na compra")
    } else {
        when (cupom) {
            "5PADOCA" -> {
                cupomPorcentagemAplicada = cincoPadoca
            }

            "10PADOCA" -> {
                cupomPorcentagemAplicada = dezPadoca
            }

            "5OFF" -> {
                cupomSubtracaoAplicada = descontoCinco
            }

            else -> {
                println("Cupom inválido, deseja aplicar um cupom novamente?")
            }
        }
    }
}

fun formataNumero(number: Double): String {
    val ptBr = Locale("pt", "BR")
    return NumberFormat.getCurrencyInstance(ptBr).format(number)
}