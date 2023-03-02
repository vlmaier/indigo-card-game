
fun main() {
    val coordinates = List(3) { readln().split(' ') }
    val xValues = coordinates.map { it.first().toInt() }
    val yValues = coordinates.map { it.last().toInt() }
    val values = (1..5).toList()
    val xDiff = values - xValues.toSet()
    val yDiff = values - yValues.toSet()
    println(xDiff.joinToString(" "))
    println(yDiff.joinToString(" "))
}