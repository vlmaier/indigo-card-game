fun main() {
    val input = readln()
    val size = input.length
    if (size % 2 == 0) {
        println(input.substring(0, size / 2 - 1) + input.substring(size / 2 + 1, size))
    } else {
        println(input.substring(0, size / 2) + input.substring(size / 2 + 1, size))
    }
}