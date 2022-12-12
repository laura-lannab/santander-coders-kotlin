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

data class Empresa(val ListaFuncionarios: List<Funcionario>)

data class Funcionario(val nome: String, val sobrenome: String, val cpf: String, val telefone: String, val cargo: Cargo)

enum class Cargo(val salario: Double) {
    VENDEDOR(salario = 2000.0),
    GERENTE(salario = 6000.0),
    DIRETOR(salario = 10000.0);
}

data class FormularioFuncionario(
    val nome: String,
    val sobrenome: String,
    val cpf: String,
    val telefone: String,
    val cargo: Cargo
)





