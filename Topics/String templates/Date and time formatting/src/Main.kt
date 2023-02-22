fun main() {
    val (hours, minutes, seconds) = readln().split(' ')
    val (day, month, year) = readln().split(' ')
    println("$hours:$minutes:$seconds $day/$month/$year")
}