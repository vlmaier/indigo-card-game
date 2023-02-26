fun main() = println(countTriples(List(readln().toInt()) { readln().toInt() }))

fun countTriples(numbers: List<Int>): Int {
    var countTriples = 0
    var i = 0
    while (i < numbers.size) {
        if (i + 2 >= numbers.size) {
            break
        }
        val first = numbers[i]
        val second = numbers[i + 1]
        val third = numbers[i + 2]
        if (first == second - 1 && second == third - 1) {
            countTriples++
        }
        i++
    }
    return countTriples
}