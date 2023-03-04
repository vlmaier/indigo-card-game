fun main() = when (readln().toInt()) {
    0 -> "do not move"
    1 -> "move up"
    2 -> "move down"
    3 -> "move left"
    4 -> "move right"
    else -> "error!"
}.let(::println)