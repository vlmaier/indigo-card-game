fun main() {
    val firstMoment = List(3) { readln().toInt() }
    val secondMoment = List(3) { readln().toInt() }
    val diffInSeconds = (secondMoment[0] - firstMoment[0]) * 3600 +
            (secondMoment[1] - firstMoment[1]) * 60 +
            (secondMoment[2] - firstMoment[2])
    println(diffInSeconds)
}