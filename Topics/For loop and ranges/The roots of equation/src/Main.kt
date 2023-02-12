import kotlin.math.pow

fun main() {
    val (a, b, c, d) = List(4) { readln().toInt() }
    for (i in 0..1000) {
        val x = i.toDouble()
        val equation = a * x.pow(3) + b * x.pow(2) + c * x + d
        if (equation == 0.0) {
            println(i)
        }
    }
}