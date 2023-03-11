fun main() = when (readln()) {
    "red" -> 1
    "orange" -> 2
    "yellow" -> 3
    "green" -> 4
    "blue" -> 5
    "indigo" -> 6
    "violet" -> 7
    else -> 0
}.let(::println)