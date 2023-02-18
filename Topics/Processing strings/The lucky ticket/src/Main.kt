fun main() {
    val ticket = readln()
    val numbers = ticket
        .map { it.toString().toInt() }
        .withIndex()
        .groupBy { it.index < ticket.length / 2 }
        .map { it -> it.value.map { it.value } }
    println(if (numbers[0].sum() == numbers[1].sum()) "Lucky" else "Regular")
}