import kotlin.math.abs

fun main() {
    val size = readln().toInt()
    val numbers = List(size) { readln().toInt() }
    val (p, m) = readln().split(" ").map { it.toInt() }
    val indicesOfP: List<Int> = numbers.indicesOf(p)
    val indicesOfM = numbers.indicesOf(m)
    val diffs = mutableListOf<Int>()
    for (indexOfP in indicesOfP) {
        for (indexOfM in indicesOfM) {
            diffs.add(abs(indexOfP - indexOfM))
        }
    }
    print(if (1 in diffs) "NO" else "YES")
}

fun <E> Iterable<E>.indicesOf(element: E) = mapIndexedNotNull { i, e -> i.takeIf { e == element } }