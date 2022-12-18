// exercícios classes nested e inner
//class Outer {
//    val number0: Int = 1
//
//    class Nested {
//        private val number1: Int = 1
//
//        //        fun testeFuncao1() = number0 ------> ERRO -> não é possível acessar atributos da classe principal em classes aninhadas
//        fun testeFuncao1() = number1
//    }
//
//    inner class Inner {
//        private val number2: Int = 2
//
//        fun testeFuncao2() = number0
//    }
//}
//
//fun main(args: Array<String>) {
//    val testaNested = Outer.Nested().testeFuncao1()
////    val testaInner = Outer.Inner().  ------> ERRO -> não é possível acessar a classe de forma abstrata
//    val testaInner = Outer().Inner().testeFuncao2()
//    println(testaNested)
//    println(testaInner)
//
//}

//data class Empresa(val ListaFuncionarios: List<Funcionario>)
//
//data class Funcionario(val nome: String, val sobrenome: String, val cpf: String, val telefone: String, val cargo: Cargo)
//
//enum class Cargo(val salario: Double) {
//    VENDEDOR(salario = 2000.0),
//    GERENTE(salario = 6000.0),
//    DIRETOR(salario = 10000.0);
//}
//
//data class FormularioFuncionario(
//    val nome: String,
//    val sobrenome: String,
//    val cpf: String,
//    val telefone: String,
//    val cargo: Cargo
//)

//#######
//abstract class GeradorDeSenhas<T>(val quantidadeDigitos: Int) {
//    abstract fun gerarSenha(): T
//}
//
//class GeradorSenhaNumerica(quantidadeDigitos: Int): GeradorDeSenhas<Int>(quantidadeDigitos){
//    override fun gerarSenha(): Int {
//        var str = "123456789"
//        var password = ""
//        for (i in 1..quantidadeDigitos) {
//            password += str.random()
//        }
//        return password.toInt()
//    }
//}
//
//class GeradorSenhaAlfaNumerica (quantidadeDigitos: Int): GeradorDeSenhas<String>(quantidadeDigitos){
//    override fun gerarSenha(): String {
//        val caracteresPermitidos = ('A'..'Z') + ('a'..'z') + ('0'..'9') + ("*!?+-");
//        return (1..quantidadeDigitos)
//            .map { caracteresPermitidos.random() }
//            .joinToString("")
//    }
//}

//#############

abstract class Arquivo {
    abstract fun gerarArquivo()
}

open class ArquivoWord : Arquivo() {
    private fun gerarDocX() {
        println("DocX gerado.")
    }

    override fun gerarArquivo() {
        gerarDocX()
    }
}

class ArquivoPdf : Arquivo() {
    private fun gerarPdf() {
        println("Pdf gerado.")
    }

    override fun gerarArquivo() {
        gerarPdf()
    }
}

class GeradorDeArquivo {
    fun gerarArquivos(arquivos: List<Arquivo>) {
        arquivos.forEach {
            it.gerarArquivo()
        }
    }
}


fun main() {

//    val senhaNumerica = GeradorSenhaNumerica(8).gerarSenha()
//    println(senhaNumerica)
//
//    val senhaAlfaNumerica = GeradorSenhaAlfaNumerica(6).gerarSenha()
//    println(senhaAlfaNumerica)
}




