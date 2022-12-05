package exercicios

import java.text.NumberFormat
import java.util.*

private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val DESCONTO = 4
private const val FINALIZAR = 0

private const val LINHA = ".........."

const val valorPaoFrances = 0.60
const val valorPaoDeLeite = 0.40
const val valorPaoDeMilho = 0.50

const val produtoPaoFrances = "Pão Francês"
const val produtoPaoDeLeite = "Pão de Leite"
const val produtoPaoDeMilho = "Pão de Milho"

const val valorCoxinha = 5.00
const val valorEsfiha = 6.00
const val valorPaoDeQueijo = 3.00

const val produtoCoxinha = "Coxinha"
const val produtoEsfiha = "Esfiha"
const val produtoPaoDeQueijo = "Pão de Queijo"

const val valorCarolina = 1.50
const val valorPudim = 4.00
const val valorBrigadeiro = 2.00

const val produtoCarolina = "Carolina"
const val produtoPudim = "Pudim"
const val produtoBrigadeiro = "Brigadeiro"

val paes: List<Pair<String, Double>> = listOf(
    Pair(produtoPaoFrances, valorPaoFrances), // index 0
    Pair(produtoPaoDeLeite, valorPaoDeLeite), // index 1
    Pair(produtoPaoDeMilho, valorPaoDeMilho), // index 2
)

val salgados: List<Pair<String, Double>> = listOf(
    Pair(produtoCoxinha, valorCoxinha), // index 0
    Pair(produtoEsfiha, valorEsfiha), // index 1
    Pair(produtoPaoDeQueijo, valorPaoDeQueijo), // index 2
)

val doces: List<Pair<String, Double>> = listOf(
    Pair(produtoCarolina, valorCarolina), // index 0
    Pair(produtoPudim, valorPudim), // index 1
    Pair(produtoBrigadeiro, valorBrigadeiro), // index 2
)


val categorias = """
    Digite a opção desejada no Menu:
    1..................Pães
    2..............Salgados
    3.................Doces
    4.....cupom de desconto
    0......Finalizar compra
""".trimIndent()

val menuPaes = """
        1 - $produtoPaoFrances...........${formataNumero(valorPaoFrances)}
        2 - $produtoPaoDeLeite..........${formataNumero(valorPaoDeLeite)}
        3 - $produtoPaoDeMilho..........${formataNumero(valorPaoDeMilho)}
        0 - Voltar
    """.trimIndent()

val menuSalgados = """
        1 - $produtoCoxinha...........${formataNumero(valorCoxinha)}
        2 - $produtoEsfiha..........${formataNumero(valorEsfiha)}
        3 - $produtoPaoDeQueijo..........${formataNumero(valorPaoDeQueijo)}
        0 - Voltar
    """.trimIndent()

val menuDoces = """
        1 - $produtoCarolina...........${formataNumero(valorCarolina)}
        2 - $produtoPudim..........${formataNumero(valorPudim)}
        3 - $produtoBrigadeiro..........${formataNumero(valorBrigadeiro)}
        0 - Voltar
    """.trimIndent()


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

        val categoria = readln().toInt()

        when (categoria) {
            PAES -> selecionaProduto(menuSelecionado = menuPaes, produtos = paes)
            SALGADOS -> selecionaProduto(menuSelecionado = menuSalgados, produtos = salgados)
            DOCES -> selecionaProduto(menuSelecionado = menuDoces, produtos = doces)
            DESCONTO -> {
                println("Digite o seu cupom:")
                val cupom = readln().uppercase()
                aplicaDesconto(cupom)
            }

            else -> Unit
        }
    } while (categoria != FINALIZAR)
}

fun selecionaProduto(
    menuSelecionado: String, produtos: List<Pair<String, Double>>
) {
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt() // valor atual -> 1 (corresponde ao pao frances)

        for ((i, produto) in produtos.withIndex()) {
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }

    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(produto: Pair<String, Double>) {
    println("Digite a quantidade:")
    val quantidade = readln().toInt()
    val totalItem = quantidade * produto.second
    val item =
        itemComanda(produto = produto.first, quantidade = quantidade, valorUnitario = produto.second, total = totalItem)
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
}${LINHA}${formataNumero(total)}"

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

fun formataNumero(number: Double) {
    val ptBr = Locale("pt", "BR")
    NumberFormat.getCurrencyInstance(ptBr).format(number)
}