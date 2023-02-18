fun main() {
    val input = readln()
    if (input.isEmpty()) {
        println()
    }
    var previous: Char = input[0]
    var result = ""
    var counter = 0
    var i = 0
    while (i < input.length) {
        if (input[i] == previous) {
            counter++
        } else {
            result += "$previous$counter"
            counter = 1
        }
        previous = input[i]
        i++
    }
    result += "$previous$counter"
    println(result)
}