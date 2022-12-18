package carteira

internal abstract class Cliente(
    val nome: String,
    val sobrenome: String,
    val cpf: String,
    var senha: String,
    var plano: Plano
)

internal class ClienteNormal(nome: String, sobrenome: String, cpf: String, senha: String, plano: Plano) :
    Cliente(nome, sobrenome, cpf, senha, plano) {
    val carteiraFisica = CarteiraFisica(
        senha = this.senha,
        tipo = Plano.Normal,
        saldo = 0.0,
        extrato = ""
    )
}

internal class ClienteDigital(nome: String, sobrenome: String, cpf: String, senha: String, plano: Plano) :
    Cliente(nome, sobrenome, cpf, senha, plano) {
    val carteiraDigital = CarteiraDigital(
        senha = this.senha,
        tipo = Plano.Digital,
        saldo = 0.0,
        extrato = ""
    )
}

internal class ClientePremium(nome: String, sobrenome: String, cpf: String, senha: String, plano: Plano) :
    Cliente(nome, sobrenome, cpf, senha, plano) {

    val carteiraFisica = CarteiraFisica(
        senha = this.senha,
        tipo = Plano.Premium,
        saldo = 0.0,
        extrato = ""
    )
    val carteiraDigital = CarteiraDigital(
        senha = this.senha,
        tipo = Plano.Premium,
        saldo = 0.0,
        extrato = ""
    )

}
