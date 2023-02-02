package indigo

fun main() {
    val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val suits = listOf("♦", "♥", "♠", "♣")
    val deck = listOf(
        "K♣",
        "Q♣",
        "J♣",
        "10♣",
        "9♣",
        "8♣",
        "7♣",
        "6♣",
        "5♣",
        "4♣",
        "3♣",
        "2♣",
        "A♣",
        "K♦",
        "Q♦",
        "J♦",
        "10♦",
        "9♦",
        "8♦",
        "7♦",
        "6♦",
        "5♦",
        "4♦",
        "3♦",
        "2♦",
        "A♦",
        "K♥",
        "Q♥",
        "J♥",
        "10♥",
        "9♥",
        "8♥",
        "7♥",
        "6♥",
        "5♥",
        "4♥",
        "3♥",
        "2♥",
        "A♥",
        "K♠",
        "Q♠",
        "J♠",
        "10♠",
        "9♠",
        "8♠",
        "7♠",
        "6♠",
        "5♠",
        "4♠",
        "3♠",
        "2♠",
        "A♠"
    )
    println(ranks.joinToString(" "))
    println(suits.joinToString(" "))
    println(deck.joinToString(" "))
}