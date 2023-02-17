fun main() = readln().let { input ->
    when {
        input.isEmpty() -> input
        input.first() == 'i' -> input.drop(1).toInt() + 1
        input.first() == 's' -> input.drop(1).reversed()
        else -> input
    }.let(::println)
}
