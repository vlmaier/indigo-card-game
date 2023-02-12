fun main() {
    val (a, b, n) = List(3) { readln().toInt() }
    val range = a..b
    var counter = 0
    for (number in range) {
        if (number % n == 0) {
            counter++
        }
    }
    print(counter)
}