import kotlin.math.max
import kotlin.math.min

const val NUM_SIZE = 3

fun main() {
    val (n1, n2, n3) = List(NUM_SIZE) { readln().toInt() }
    print(n1 in min(n2, n3)..max(n2, n3))
}
