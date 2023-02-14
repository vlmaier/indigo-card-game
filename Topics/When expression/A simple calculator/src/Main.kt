fun main() {
    val input = readln().split(' ')
    val firstNumber = input[0].toLong()
    val secondNumber = input[2].toLong()
    val operator = input[1]
    println(
        when (operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" ->
                if (secondNumber == 0L) {
                    "Division by 0!"
                } else {
                    firstNumber / secondNumber
                }

            else -> "Unknown operator"
        }
    )
}