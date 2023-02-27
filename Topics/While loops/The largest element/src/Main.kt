fun main() {
    var max = Int.MIN_VALUE
    while (true) {
        val number = readln().toInt()
        if (number == 0) {
            break
        }
        if (number > max) {
            max = number
        }
    }
    println(max)
}