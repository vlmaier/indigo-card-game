fun main() {
    val input = readln().split(" ")
    var max = input[0]
    for (str in input) {
        if (str.length > max.length) {
            max = str
        }
    }
    println(max)
}