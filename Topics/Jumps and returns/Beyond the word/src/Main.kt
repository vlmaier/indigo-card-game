fun main() {
    val word = readln()
    var abc = ('a'..'z').toList().joinToString("")
    for (character in word) {
        abc = abc.replace(character.toString(), "")
    }
    println(abc)
}