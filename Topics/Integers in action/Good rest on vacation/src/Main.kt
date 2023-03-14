fun main() {
    val durationInDays = readln().toInt()
    val totalFoodCostPerDay = readln().toInt()
    val oneWayFlightCost = readln().toInt()
    val hotelPerNightCost = readln().toInt()
    val total = durationInDays * totalFoodCostPerDay + 2 * oneWayFlightCost + (durationInDays - 1) * hotelPerNightCost
    println(total)
}