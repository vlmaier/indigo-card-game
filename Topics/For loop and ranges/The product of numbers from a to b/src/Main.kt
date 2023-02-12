fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    println(calculateProductExcluding(a, b))
}

fun calculateProductExcluding(from: Int, to: Int): Long {
    var product = 1L
    for (i in from until to) {
        product *= i
    }
    return product
}