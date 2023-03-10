private const val FIZZ = 3
private const val BUZZ = 5

fun main() {
    for (i in readln().toInt()..readln().toInt()) {
        when {
            i % FIZZ == 0 && i % BUZZ == 0 -> "FizzBuzz"
            i % FIZZ == 0 -> "Fizz"
            i % BUZZ == 0 -> "Buzz"
            else -> i
        }.let(::println)
    }
}
