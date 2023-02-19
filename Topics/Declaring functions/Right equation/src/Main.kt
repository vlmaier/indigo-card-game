fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    println(isRightEquation(a, b, c))
}

fun isRightEquation(a: Int, b: Int, c: Int) = a * b == c