fun main() {  
    val beyondTheWall = readln().split(", ").map { it }.toMutableList()
    val backToTheWall = readln().split(", ").map { it }.toMutableList()
    val diff = beyondTheWall.minus(backToTheWall)
    println(diff.isEmpty())
}