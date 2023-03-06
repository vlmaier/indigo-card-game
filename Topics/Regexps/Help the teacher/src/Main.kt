fun main() {
    val report = readln()
    val pattern = "[0-9]\\swrong\\sanswers?".toRegex()
    print(pattern.matches(report))
}