fun main() {
    val number = readln().toInt()
    println(round(number) ?: 0)
}

// do not change function below

fun round(number: Int): Int? {
    return if (number >= 1000) null else number
}