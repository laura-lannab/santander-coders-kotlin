package carteira

fun main() {
    val laura = ClientePremium(
        "laura",
        "lanna",
        "34342442342",
        GeradorSenhaAlfaNumerica(8).gerarSenha(),
        Plano.Premium
    )

//    println(laura.carteiraDigital.senha)
//    println(laura.senha)
//    println(laura.carteiraDigital.guardar(100.0))
//    println(laura.carteiraDigital.investir(200.0))
//    println(laura.carteiraDigital.transferenciaPix(150.0))
//    println(laura.carteiraDigital.pagarBoleto(400.0))
//    println(laura.carteiraDigital.saldo)
//    println(laura.carteiraDigital.extrato)
//    println(laura.carteiraDigital.guardar(100.0))
//    println(laura.carteiraDigital.saldo)
//    println(laura.carteiraDigital.guardar(100.0))
//    println(laura.carteiraDigital.guardar(100.0))
//    println(laura.carteiraDigital.saldo)

    println(laura.carteiraFisica.senha)
    println(laura.senha)
    println(laura.carteiraFisica.saldo)
    println(laura.carteiraFisica.depositar(500.0))
    println(laura.carteiraFisica.saldo)
    println(laura.carteiraFisica.pagarBoleto(200.0))
    println(laura.carteiraFisica.sacar(100.0))
    println(laura.carteiraFisica.saldo)
}
