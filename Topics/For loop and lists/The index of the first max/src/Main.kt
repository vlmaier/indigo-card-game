fun main() {
    val n = readln().toInt()
    val numbers = List(n) { readln().toInt() }
    println(numbers.withIndex().maxByOrNull { it.value }?.index)
}