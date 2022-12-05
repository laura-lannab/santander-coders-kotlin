package epadoca

class Estoque {
    val paes: List<Produto> = listOf(
        Produto("Pão Francês", 0.60),
        Produto("Pão de Leite", 0.40),
        Produto("Pão de Milho", 0.50),
    )

    val salgados: List<Produto> = listOf(
        Produto("Coxinha", 5.00),
        Produto("Esfiha", 6.00),
        Produto("Pão de Queijo", 3.00),
    )

    val doces: List<Produto> = listOf(
        Produto("Carolina", 1.50),
        Produto("Pudim", 4.00),
        Produto("Brigadeiro", 2.00),
    )
}