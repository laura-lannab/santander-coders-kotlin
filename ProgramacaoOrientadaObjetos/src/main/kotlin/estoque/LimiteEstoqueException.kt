package estoque

class LimiteEstoqueException : Exception() {
    override fun getLocalizedMessage(): String {
        return "Quantidade inválida! Quantidade mínima: 0; Quantidade máxima: 999"
    }
}