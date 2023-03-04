fun main() {
    val butterCups = readln().toInt()
    val isWeekend = readln().toBoolean()
    val regularRange = 10..20
    val weekendRange = 15..25
    println(
        when {
            butterCups in regularRange && !isWeekend -> true
            butterCups in weekendRange && isWeekend -> true
            else -> false
        }
    )
}