fun main() {
    val size = readln().toInt()
    val numbers = mutableListOf<Int>()
    repeat(size) {
        numbers.add(readln().toInt())
    }
    var previous = 0
    var currentSequence = mutableListOf<Int>()
    val allSequences = mutableListOf<List<Int>>()
    var i = 0
    do {
        val current = numbers[i]
        i++
        if (previous <= current) {
            currentSequence.add(current)
        } else {
            allSequences.add(currentSequence)
            currentSequence = mutableListOf()
            i--
        }
        previous = current
    } while (i < numbers.size)
    allSequences.add(currentSequence)
    val max = allSequences.maxOfOrNull { it.size }
    println(max)
}
