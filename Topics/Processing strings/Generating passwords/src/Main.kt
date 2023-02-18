fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val a = input[0]
    val b = input[1]
    val c = input[2]
    val n = input[3]
    println(randomString(a, b, c, n))
}

fun randomString(a: Int, b: Int, c: Int, n: Int): String {
    val uppercase = ('A'..'Z').toList()
    val lowercase = ('a'..'z').toList()
    val digits = ('0'..'9').toList()
    val all = uppercase + lowercase + digits
    val randomUppercase = List(a) { uppercase.random() }.joinToString("")
    val randomLowercase = List(b) { lowercase.random() }.joinToString("")
    val randomDigits = List(c) { digits.random() }.joinToString("")
    val randomPadding = List(kotlin.math.abs(a + b + c - n)) { all.random() }.joinToString("")
    val password = "$randomUppercase$randomLowercase$randomDigits$randomPadding".toCharArray()

    do {
        password.shuffle()
    } while ("(.)\\1".toRegex().find(String(password)) != null)
    return String(password)
}