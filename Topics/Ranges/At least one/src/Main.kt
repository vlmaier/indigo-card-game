fun main() {
    val input = List(5) { readln().toInt() }
    val firstRange = input[0]..input[1]
    val secondRange = input[2]..input[3]
    print(input[4] in firstRange || input[4] in secondRange)
}