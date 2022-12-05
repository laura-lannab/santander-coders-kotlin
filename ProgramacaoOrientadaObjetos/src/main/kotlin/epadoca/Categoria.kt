package epadoca

enum class Categoria(val valor: Int) {
    PAES(1),
    SALGADOS(2),
    DOCES(3),
    DESCONTO(4),
    FINALIZAR(0),
    ERRO(-1);

    companion object {
        fun pegarPorValor(valor: Int): Categoria {
            return when (valor) {
                PAES.valor -> PAES
                SALGADOS.valor -> SALGADOS
                DOCES.valor -> DOCES
                DESCONTO.valor -> DESCONTO
                FINALIZAR.valor -> FINALIZAR
                else -> ERRO
            }
        }
    }
}