fun main() = println(readln().toCharArray().toMutableList().stream().filter { c -> c.isDigit() }.findFirst().get())