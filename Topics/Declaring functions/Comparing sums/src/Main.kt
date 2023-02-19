fun isGreater(number1: Int, number2: Int, number3: Int, number4: Int): Boolean {
    return number1 + number2 > number3 + number4
}

fun main() {
    val number1 = readln().toInt()
    val number2 = readln().toInt()
    val number3 = readln().toInt()
    val number4 = readln().toInt()

    println(isGreater(number1, number2, number3, number4))
}