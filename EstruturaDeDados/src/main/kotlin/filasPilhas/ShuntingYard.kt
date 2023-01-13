package filasPilhas

import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList

class Calculator {
    private val parseTokensRegex = "([()])|(\\d+(\\.\\d+)?)|([+*×÷/-])"

    private var expression: String = ""


    fun getResult(expression: String): Queue<String> {
        this.expression = expression
        val tokens = parseTokens(expression)
        return convertToPostFix(tokens)
    }

    private fun convertToPostFix(tokens: List<String>): Queue<String> {
        val stack = Stack<String>()
        val queue: Queue<String> = LinkedList()

        for (token in tokens) {
            when {
                isNumber(token) -> {
                    queue.add(token)
                }
                isOperation(token) -> {
                    if (stack.isNotEmpty()) {
                        val top = stack.peek()
                        if (hasLowPriority(token, top)) {
                            while (stack.isNotEmpty() && stack.peek() != "(") {
                                queue.add(stack.pop())
                            }
                        }
                    }
                    stack.push(token)

                }
                token == "(" -> {
                    stack.push(token)
                }
                token == ")" -> {
                    if (stack.isEmpty())
                        fail(token)
                    while (stack.peek() != "(") {
                        queue.add(stack.pop())
                        if (stack.isEmpty())
                            fail(token)
                    }
                    if (stack.peek() != "(") {
                        fail(token)
                    }
                    stack.pop()
                }
            }

        }

        while (stack.isNotEmpty()) {
            queue.add(stack.pop())
        }
        println(queue)
        return queue
    }

    private fun isNumber(token: String?): Boolean {
        if (token == null)
            return false
        return token.matches("(\\d+(\\.\\d+)?)".toRegex())
    }

    private fun isOperation(token: String?): Boolean {
        if (token == null)
            return false
        return token.matches("[+*/×÷-]".toRegex())
    }

    private fun hasLowPriority(token: String, top: String?): Boolean {
        if (top == null)
            return false
        val priority = listOf("*", "×", "/", "÷", "-", "+")
        return priority.indexOf(top) < priority.indexOf(token)
    }

    private fun fail(token: String) {
        throw MathExpressionException(" Brackets mismatch error at \'$token\'")
    }

    private fun parseTokens(expression: String): List<String> {
        val pattern = Pattern.compile(parseTokensRegex)
        val matcher = pattern.matcher(expression)
        val tokens = ArrayList<String>()

        while (matcher.find()) {
            tokens.add(matcher.group())
        }
        return tokens
    }

    class MathExpressionException(message: String?) : Exception(message)
}

fun main(){
    val calulator = Calculator()
    calulator.getResult("2+9")
    calulator.getResult("2+9-5/8")
    calulator.getResult("2+9-5/8*7")
}