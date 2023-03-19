fun <T> getStringsOnly(list: List<T>): List<String> {
    val result = mutableListOf<String>()
    for (item in list) {
        if (item is String) {
            result.add(item)
        }
    }
    return result
}