fun main() {
    val time = readln().toInt()
    val workTime = 9..18
    val lunchTime = 13..14
    print(time in workTime && time !in lunchTime)
}