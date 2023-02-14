fun main() {
    val input = List(3) { readln() }
    println(
        when (input[1]) {
            "equals" -> input[0] == input[2]
            "plus" -> "${input[0]}${input[2]}"
            "endsWith" -> input[0].endsWith(input[2])
            else -> "Unknown operation"
        }
    )
}