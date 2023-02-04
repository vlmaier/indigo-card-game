import java.util.Collections

fun main() {
    val size = readln().toInt()
    val numbers = MutableList(size) { readln().toInt() }
    Collections.rotate(numbers, 1)
    println(numbers.joinToString(" "))
}