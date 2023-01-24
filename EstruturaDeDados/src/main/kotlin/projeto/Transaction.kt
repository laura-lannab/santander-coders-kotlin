package projeto

enum class TransactionType{
    DRAW,
    DEPOSIT;

    companion object {
        fun getTransactionTypeByString(name: String) :TransactionType {
            return when(name){
                "SAQUE" -> DRAW
                else -> DEPOSIT
            }

        }
    }
}

data class Transaction(val account: Account, val date: String, val transactionValue: Double, val transactionType: TransactionType) {
}