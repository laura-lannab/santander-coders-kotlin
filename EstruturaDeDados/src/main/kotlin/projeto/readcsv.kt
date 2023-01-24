package projeto

import java.io.File

fun readCsv(fileName: String): List<Transaction> {
    val reader = File(fileName).bufferedReader()
    val header = reader.readLine() // caso queira evitar o header descomentar
    val csvList = reader.lineSequence()
        .filter { it.isNotBlank() }
        .map {
            it.split(',', ignoreCase = false)
        }.toList()

    val accountList = mutableListOf<Transaction>()

    csvList.forEach { list ->
        var agency: Int = 0
        var accountNumber: Int = 0
        var bank: String = ""
        var userName: String = ""
        var operation: String = ""
        var date: String = ""
        var value: Double = 0.0

        list.forEachIndexed { index, item ->
            when (index) {
                0 -> agency = item.toInt()
                1 -> accountNumber = item.toInt()
                2 -> bank = item
                3 -> userName = item
                4 -> operation = item
                5 -> date = item
                6 -> value = item.toDouble()
            }
        }
        val account = Account(agency, accountNumber, bank, userName, value)
        val transaction = Transaction(account, date, value, operation)
        TODO(
            "terminar a instanciação e fazer as operações de ordenação e eliminar duplicidades"
        )
    }
}

fun main() {
    println(readCsv("E:\\Aulas Kotlin\\santander-coders-kotlin\\EstruturaDeDados\\src\\main\\kotlin\\projeto\\operacoes.csv"))
}