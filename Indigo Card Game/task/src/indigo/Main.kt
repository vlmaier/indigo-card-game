package indigo

private const val TABLE_SIZE = 4
private const val HAND_SIZE = 6

fun main() {
    Indigo().play()
}

class Indigo {
    private val deck = Deck()
    private val table = Table()
    private val human = Human()
    private val computer = Computer()
    private lateinit var onTurn: Player

    fun play() {
        println("Indigo Card Game")
        onTurn = askWhoGoesFirst()
        init()
        while (deck.isNotEmpty() || human.hand.isNotEmpty() || computer.hand.isNotEmpty()) {
            if (onTurn is Human) {
                table.showCards()
                human.showHand()
                val card = askForCardToPlay() ?: break
                table.putCard(human.playCard(card))
            } else {
                table.showCards()
                table.putCard(computer.playCard(0))
            }
            onTurn = nextTurn()
            dealHand(human)
            dealHand(computer)
        }
        if (deck.isEmpty()) {
            table.showCards()
        }
        println("Game Over")
    }

    private fun askWhoGoesFirst(): Player {
        println("Play first?")
        return when (readln()) {
            "yes" -> human
            "no" -> computer
            else -> askWhoGoesFirst()
        }
    }

    private fun init() {
        human.getHand(deck.dealHand())
        computer.getHand(deck.dealHand())
        table.putCards(deck.dealTable())
    }

    private fun askForCardToPlay(): Int? {
        val handSize = human.hand.size
        println("Choose a card to play (1-$handSize):")
        val input = readln()
        if (input == "exit") {
            return null
        }
        val number = input.toIntOrNull()
        if (number == null || number !in 1..handSize) {
            return askForCardToPlay()
        }
        return number - 1
    }

    private fun dealHand(player: Player) {
        if (player.hand.isEmpty()) {
            player.getHand(deck.dealHand())
        }
    }

    private fun nextTurn(): Player {
        return if (onTurn is Human) computer else human
    }
}

class Deck {
    private val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    private val suits = listOf("♦", "♥", "♠", "♣")
    private var cards = ranks.cartesianProduct(suits)

    init {
        shuffle()
    }

    fun isEmpty(): Boolean {
        return this.cards.isEmpty()
    }

    fun isNotEmpty(): Boolean {
        return this.cards.isNotEmpty()
    }

    fun dealHand(): List<Card> {
        return deal(HAND_SIZE)
    }

    fun dealTable(): List<Card> {
        return deal(TABLE_SIZE)
    }

    private fun deal(amount: Int): List<Card> {
        val cards = mutableListOf<Card>()
        if (this.cards.isEmpty()) {
            return cards
        }
        repeat(amount) {
            cards.add(this.cards.removeAt(0))
        }
        return cards
    }

    private fun shuffle() {
        this.cards = this.cards.shuffled().toMutableList()
    }
}

data class Card(val rank: String, val suit: String) {
    override fun toString(): String {
        return "$rank$suit"
    }
}

class Table {

    private val cards = mutableListOf<Card>()

    fun showCards() {
        println("${this.cards.size} cards on the table, and the top card is ${this.cards.last()}")
        println()
    }

    fun putCards(cards: List<Card>) {
        this.cards.addAll(cards)
        println("Initial cards on the table: ${this.cards.joinToString(" ")}")
    }

    fun putCard(card: Card) {
        this.cards.add(card)
    }
}

open class Player {

    var hand = mutableListOf<Card>()

    open fun getHand(cards: List<Card>) {
        this.hand = cards.toMutableList()
    }

    open fun showHand() {
        var message = "Cards in hand: "
        this.hand.forEachIndexed { index, card ->
            message += "${index + 1})$card "
        }
        println(message.trimEnd())
    }

    open fun playCard(index: Int): Card {
        return this.hand.removeAt(index)
    }
}

class Human : Player()

class Computer : Player() {

    override fun playCard(index: Int): Card {
        val card = super.playCard(index)
        println("Computer plays $card")
        return card
    }
}
fun List<String>.cartesianProduct(second: List<String>): MutableList<Card> {
    return this.flatMap { first ->
        second.map { second ->
            Card(first, second)
        }
    }.toMutableList()
}
