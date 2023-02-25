fun main() = when (readln().toInt()) {
    in 1..10 -> false
    else -> true
}.let(::println)