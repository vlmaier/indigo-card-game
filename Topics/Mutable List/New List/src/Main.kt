fun solution(numbers: List<Int>, number: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    list.addAll(numbers)
    list.add(number)
    return list
}