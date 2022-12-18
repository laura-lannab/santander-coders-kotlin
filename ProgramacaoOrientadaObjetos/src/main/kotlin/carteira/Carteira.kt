package carteira

import java.text.NumberFormat
import java.util.*

fun currencyFormatter(number: Double): String {
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))
    return currencyInstance.format(number)
}

internal abstract class Carteira(
    val senha: String,
    val tipo: Plano,
    var saldo: Double,
    var extrato: String
) {
    abstract fun pagarBoleto(valor: Double)
}

internal open class CarteiraFisica(senha: String, tipo: Plano, saldo: Double, extrato: String) :
    Carteira(senha, tipo, saldo, extrato) {
    fun depositar(valor: Double) {
        this.saldo += valor
        println("Foi depositado o valor de ${currencyFormatter(valor)}")
    }

    fun sacar(valor: Double) {
        this.saldo -= valor
        println("Foi sacado o valor de ${currencyFormatter(valor)}")
    }

    override fun pagarBoleto(valor: Double) {
        this.saldo -= valor
        this.extrato = """ 
            Boleto pago no valor de ${currencyFormatter(valor)}
            Saldo atual: ${this.saldo}
        """.trimIndent()
    }

}

internal open class CarteiraDigital(senha: String, tipo: Plano, saldo: Double, extrato: String) :
    Carteira(senha, tipo, saldo, extrato) {


    fun transferenciaPix(valor: Double) {
        println("Foi transferido o valor de ${currencyFormatter(valor)}")
    }

    fun investir(valor: Double) {
        this.saldo += valor
        println("Foi investido o valor de ${currencyFormatter(valor)}")
    }

    fun guardar(valor: Double) {
        this.saldo += valor
        println("Foi guardado o valor de ${currencyFormatter(valor)}")
    }

    override fun pagarBoleto(valor: Double) {
        this.saldo -= valor
        this.extrato = """ 
            Boleto pago no valor de ${currencyFormatter(valor)}
            Saldo atual: ${this.saldo}
        """.trimIndent()
    }

}