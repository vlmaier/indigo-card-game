fun main() {
    val string = readln()
    val delimiter = "u"
    println("${string.substringBeforeLast(delimiter)}$delimiter${string.substringAfterLast(delimiter).uppercase()}")
}