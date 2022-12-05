package exercicios

class Empresa(
    val id: Int,
    val nome: String,
    var email: String,
)

class Funcionario(
    val id: Int,
    var nome: String,
    val cpf: String,
    var email: String,
    var empresa: Empresa,
    var cargo: String,
    var salario: Double
) {

    fun redefinirCargo(novoCargo: String, novoSalario: Double) {
        this.cargo = novoCargo
        this.salario = novoSalario
        when (novoCargo) {
            "Diretor" -> this.salario = novoSalario * 3
            "Gerente" -> this.salario = novoSalario * 2
            "Farmacêutico" -> this.salario = novoSalario * 2
            "VendedorII" -> this.salario = novoSalario * 1.5
            "VendedorI" -> this.salario = novoSalario * 1.2
            else -> this.salario = novoSalario * 1.0
        }
    }

    override fun toString(): String {
        return """
            ID: $id
            Nome: $nome
            CPF: $cpf
            E-mail: $email
            Empresa: $empresa
            Cargo: $cargo
            Salário: $salario
        """.trimIndent()
    }

}

fun main() {

    val lojasRede = Empresa(
        id = 0,
        nome = "Lojas Rede",
        email = "lojasrede@email.com"
    )

    val araujo = Empresa(
        id = 0,
        nome = "Araujo",
        email = "araujo@email.com"
    )

    val ana = Funcionario(
        id = 0,
        nome = "Ana",
        cpf = "12356814725",
        email = "chopin@email.com",
        empresa = lojasRede,
        cargo = "Vendedor",
        salario = 1_200.0
    )
    val thomas = Funcionario(
        id = 1,
        nome = "Thomas",
        cpf = "12356814725",
        email = "thomas@email.com",
        empresa = lojasRede,
        cargo = "Gerente",
        salario = 5_000.0
    )
    val maria = Funcionario(
        id = 2,
        nome = "Maria",
        cpf = "12356814725",
        email = "maria@email.com",
        empresa = lojasRede,
        cargo = "Diretor",
        salario = 12_500.0
    )

    val tiago = Funcionario(
        id = 3,
        nome = "Tiago",
        cpf = "12356834345",
        email = "tiago@email.com",
        empresa = araujo,
        cargo = "Farmacêutico",
        salario = 6_000.0
    )

    ana.redefinirCargo("VendedorII", 2000.0)
    println(
        """
            Novo cargo de ${ana.nome}: ${ana.cargo}
            Novo salário de ${ana.nome}: ${ana.salario}
        """.trimIndent()
    )

    val faculdade: MutableList<Funcionario> = mutableListOf(tiago, ana, maria, thomas)

    faculdade.forEach { funcionario ->
        println(funcionario.toString())
    }

}