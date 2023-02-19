import kotlin.math.abs

fun main() {
    val a = readln().toInt()
    println(getLastDigit(a))
}

fun getLastDigit(number: Int) = abs(number) % 10

