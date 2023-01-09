import java.util.*

class ExpressionValidator() {
    val stack = Stack<Char>()


    // apenas validar parenteses
    // utilizando pilha
    fun isValid(expression: String): Boolean {
        for (c in expression) {
            if (c == '(') stack.push(c)
            else if (c == ')') {
                if (stack.isEmpty()) return false

                stack.pop()

            }
        }
        return stack.isEmpty()

    }
}

fun main() {
    val expressionValidator = ExpressionValidator()

    println( expressionValidator.isValid("((1 + 2))"))
}