fun main() = println(if (isPalindrome(readln())) "yes" else "no")

fun isPalindrome(input: String): Boolean {
    var candidate = input
    if (input.length % 2 != 0) {
        // remove middle character for odd length strings
        candidate = input.replace(input[input.length / 2].toString(), "")
    }
    val halfIndex = candidate.length / 2
    val firstHalf = candidate.substring(0, halfIndex)
    val secondHalf = candidate.substring(halfIndex, candidate.length)
    return firstHalf == secondHalf.reversed()
}