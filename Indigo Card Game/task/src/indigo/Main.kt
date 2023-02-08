package indigo

import kotlin.system.exitProcess

val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
val suits = listOf("♦", "♥", "♠", "♣")
var deck = ranks.cartesianProduct(suits)

fun main() {
    askForAction()
}

fun askForAction() {
    println("Choose an action (reset, shuffle, get, exit):")
    when(readln()) {
        "reset" -> {
            deck = ranks.cartesianProduct(suits)
            println("Card deck is reset.")
            askForAction()
        }
        "shuffle" -> {
            deck = deck.shuffled().toMutableList()
            println("Card deck is shuffled.")
            askForAction()
        }
        "get" -> {
            println("Number of cards:")
            val numberOfCards = readln().toIntOrNull()
            if (numberOfCards == null || numberOfCards < 1 || numberOfCards > 52) {
                println("Invalid number of cards.")
                askForAction()
            }
            if (numberOfCards!! > deck.size) {
                println("The remaining cards are insufficient to meet the request.")
                askForAction()
            }
            val cards = mutableListOf<String>()
            repeat(numberOfCards) {
                cards.add(deck.removeAt(0))
            }
            println(cards.joinToString(" "))
            askForAction()
        }
        "exit" -> {
            println("Bye")
            exitProcess(0)
        }
        else -> {
            println("Wrong action.")
            askForAction()
        }
    }

}

fun List<String>.cartesianProduct(second: List<String>): MutableList<String> {
    return this.flatMap { first ->
        second.map { second ->
            "$first$second"
        }
    }.toMutableList()
}