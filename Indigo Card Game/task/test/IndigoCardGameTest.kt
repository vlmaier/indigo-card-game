import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram

class CardGameTest : StageTest<Any>() {

    @DynamicTest
    fun printRanksSuitsCardsTest(): CheckResult {
        val main = TestedProgram()
        val outputString = main.start().trim()
        val lines = outputString.split('\n').map { it.trim() }.filter { it != "" }

        var ranksPrinted = -1
        var suitsPrinted = -1
        var cardsPrinted = -1
        for ((index, line) in lines.withIndex()) {
            if (isRanks(line)) ranksPrinted = index
            if (isSuits(line)) suitsPrinted = index
            if (isCards(line)) cardsPrinted = index
        }

        if (ranksPrinted == -1) return CheckResult(false, "Line with ranks isn't correct.")
        if (suitsPrinted == -1) return CheckResult(false, "Line with suits isn't correct.")
        if (cardsPrinted == -1) return CheckResult(false, "Line with all cards isn't correct.")

        return CheckResult.correct()
    }

}

fun isRanks(string: String): Boolean {
    val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val outRanks = string.split(' ').map { it.trim() }.filter { it != "" }
    return ( outRanks.containsAll(ranks) && ranks.size == outRanks.size )
}

fun isSuits(string: String): Boolean {
    val ranks = listOf("♦", "♥", "♠", "♣")
    val outRanks = string.split(' ').map { it.trim() }.filter { it != "" }
    return ( outRanks.containsAll(ranks) && ranks.size == outRanks.size )
}

fun isCards(string: String): Boolean {
    val ranks = listOf("A♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠",
        "A♥", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥",
        "A♦", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦",
        "A♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣")
    val outRanks = string.split(' ').map { it.trim() }.filter { it != "" }
    return ( outRanks.containsAll(ranks) && ranks.size == outRanks.size )
}


