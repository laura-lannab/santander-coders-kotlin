package exercicio3

sealed class Comodo(val tamanho: Double){
    data class Sala(val tamanhoSala: Double): Comodo(tamanhoSala)
    data class Quarto(val tamanhoQuarto: Double): Comodo(tamanhoQuarto)
    data class Banheiro(val tamanhoBanheiro: Double, val temChuveiro: Boolean): Comodo(tamanhoBanheiro)
}

class Casa(val comprimento: Double, val largura: Double, val listaDeComodos: MutableList<Comodo> = mutableListOf(), val piscina: Piscina? = null) {
    private fun adicionaComodo(comodo: Comodo){
        listaDeComodos.add(comodo)
    }

    fun adicionaQuarto(tamanho: Double){
        adicionaComodo(Comodo.Quarto(tamanho))
    }
    fun adicionaSala(tamanho: Double){
        adicionaComodo(Comodo.Sala(tamanho))
    }
    fun adicionaBanheiro(tamanho: Double, temChuveiro: Boolean){
        adicionaComodo(Comodo.Banheiro(tamanho, temChuveiro))
    }
}

class Piscina(val comprimento: Double, val largura: Double, val altura: Double)

fun main(){

}




