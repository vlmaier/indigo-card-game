
fun main() {
    val n = readln().toInt()
    val requiredNumber = kotlin.math.ceil(kotlin.math.sqrt(2 * n.toDouble()) + 1 / 2).toInt()
    var output = ""
    for (i in 1..requiredNumber) {
        output += "$i ".repeat(i)
    }
    val numbers = output.split(' ').toList()
    println(numbers.take(n).joinToString(" "))
}