package indigo

import kotlin.system.exitProcess

private const val DECK_SIZE = 52
private const val TABLE_SIZE = 4
private const val HAND_SIZE = 6

val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
val suits = listOf("♦", "♥", "♠", "♣")
var deck = ranks.cartesianProduct(suits)
var table = mutableListOf<String>()
var playerHand = mutableListOf<String>()
var computerHand = mutableListOf<String>()

enum class Starter {
    PLAYER, COMPUTER
}

fun main() {
    printTitle()
    var onTurn = askWhoGoesFirst()
    initGame()
    while (deck.isNotEmpty() || playerHand.isNotEmpty() || computerHand.isNotEmpty()) {
        if (Starter.PLAYER == onTurn) {
            printTable()
            printPlayerHand()
            val cardToPlay = askForCardToPlay() ?: break
            playPlayerCard(cardToPlay)
        } else {
            printTable()
            playComputerCard()
        }
        onTurn = swapPlayer(onTurn)
        dealCards()
    }
    if (deck.isEmpty()) {
        printTable()
    }
    printGameOver()
}

private fun printTitle() {
    println("Indigo Card Game")
}

private fun printGameOver() {
    println("Game Over")
}

private fun askWhoGoesFirst(): Starter {
    println("Play first?")
    return when (readln()) {
        "yes" -> Starter.PLAYER
        "no" -> Starter.COMPUTER
        else -> askWhoGoesFirst()
    }
}

private fun initGame() {
    shuffleDeck()
    table = getCards(TABLE_SIZE)
    playerHand = getCards(HAND_SIZE)
    computerHand = getCards(HAND_SIZE)
    println("Initial cards on the table: ${table.joinToString(" ")}")
}

private fun printTable() {
    println("${table.size} cards on the table, and the top card is ${table.last()}")
    println()
}

private fun printPlayerHand() {
    var message = "Cards in hand: "
    playerHand.forEachIndexed { index, card ->
        message += "${index + 1})$card "
    }
    println(message.trimEnd())
}

private fun askForCardToPlay(): Int? {
    println("Choose a card to play (1-${playerHand.size}):")
    val input = readln()
    if (input == "exit") {
        return null
    }
    val number = input.toIntOrNull()
    if (number == null || number !in 1..playerHand.size) {
        return askForCardToPlay()
    }
    return number
}

private fun playPlayerCard(number: Int) {
    val card = playerHand.removeAt(number - 1)
    table.add(card)
}

private fun playComputerCard() {
    // val card = computerHand.removeAt((0..5).random())
    val card = computerHand.removeAt(0)
    table.add(card)
    println("Computer plays $card")
}

private fun swapPlayer(onTurn: Starter): Starter {
    return if (onTurn == Starter.PLAYER) Starter.COMPUTER else Starter.PLAYER
}

private fun dealCards() {
    if (playerHand.isEmpty()) {
        playerHand = getCards(HAND_SIZE)
    }
    if (computerHand.isEmpty()) {
        computerHand = getCards(HAND_SIZE)
    }
}

private fun askForAction() {
    println("Choose an action (reset, shuffle, get, exit):")
    when (readln()) {
        "reset" -> {
            resetDeck()
            println("Card deck is reset.")
            askForAction()
        }

        "shuffle" -> {
            shuffleDeck()
            println("Card deck is shuffled.")
            askForAction()
        }

        "get" -> {
            println("Number of cards:")
            val amount = readln().toIntOrNull()
            if (amount == null || amount < 1 || amount > DECK_SIZE) {
                println("Invalid number of cards.")
                askForAction()
            }
            if (amount!! > deck.size) {
                println("The remaining cards are insufficient to meet the request.")
                askForAction()
            }
            val cards = getCards(amount)
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

private fun resetDeck() {
    deck = ranks.cartesianProduct(suits)
}

private fun shuffleDeck() {
    deck = deck.shuffled().toMutableList()
}

private fun getCards(amount: Int): MutableList<String> {
    val cards = mutableListOf<String>()
    if (deck.isEmpty()) {
        return cards
    }
    repeat(amount) {
        cards.add(deck.removeAt(0))
    }
    return cards
}

private fun List<String>.cartesianProduct(second: List<String>): MutableList<String> {
    return this.flatMap { first ->
        second.map { second ->
            "$first$second"
        }
    }.toMutableList()
}