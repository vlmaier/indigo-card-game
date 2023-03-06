fun main() {
    val answer = readln()
    val pattern = "I can'?t? do my homework on time!".toRegex()
    println(answer.matches(pattern))
}