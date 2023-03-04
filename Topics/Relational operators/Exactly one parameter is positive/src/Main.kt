private const val SIZE = 3

fun main() {
    val numbers = List(SIZE) { readln().toInt() }
    println(numbers.filter { it > 0 }.size == 1)
}