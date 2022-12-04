//get -> retornar o valor do atributo
//set -> inserir um valor para o atributo

class Ator(val nome: String, val sobrenome: String) {
    var ultimoFilme: String? = null
        get() {
            //se o valor do último filme for null, retorna Desconhecido
            return if (field == null) "Desconhecido" else field
        }
        set(value) {
            value?.apply {
                if (this.isEmpty())
                    println("Esse filme é inválido")
                else
                    field = value
            }
        }
}


fun main() {
    val theRock = Ator(nome = "Dwayne", sobrenome = "Johnson")

    //getNome()
    println("O último filme do ator ${theRock.nome} ${theRock.sobrenome} foi ${theRock.ultimoFilme}")

    theRock.ultimoFilme = ""

    println("O último filme do ator ${theRock.nome} ${theRock.sobrenome} foi ${theRock.ultimoFilme}")

    //set(value)
    theRock.ultimoFilme = "Adão Negro"

    println("O último filme do ator ${theRock.nome} ${theRock.sobrenome} foi ${theRock.ultimoFilme}")
}

