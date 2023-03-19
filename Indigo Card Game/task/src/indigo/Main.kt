package indigo

private const val TABLE_SIZE = 4
private const val HAND_SIZE = 6
private const val MOST_CARDS_SCORE = 3

fun main() {
    Indigo().play()
}

class Indigo {
    private val deck = Deck()
    private val table = Table()
    private val human = Human()
    private val computer = Computer()

    fun play() {
        println("Indigo Card Game")
        val whoGoesFirst = askWhoGoesFirst()
        table.setWhoPlayedFirst(whoGoesFirst)
        var onTurn = whoGoesFirst
        init()
        var playerExit = false
        while (deck.isNotEmpty() || human.hand.isNotEmpty() || computer.hand.isNotEmpty()) {
            if (onTurn is Human) {
                table.showCards()
                human.showHand()
                val card = askForCardToPlay()
                if (card == null) {
                    playerExit = true
                    break
                }
                table.putCard(human.playCard(card), human)
            } else {
                table.showCards()
                table.putCard(computer.playCard(0), computer)
            }
            onTurn = if (onTurn is Human) computer else human
            dealHand(human)
            dealHand(computer)
        }
        if (!playerExit) {
            table.showCards()
            table.addLeftCards()
            table.showScoreBoard(isFinal = true)
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

    fun matchesRankOrSuit(card: Card): Boolean {
        return this.rank == card.rank || this.suit == card.suit
    }
}

class Table {
    private var cards = mutableListOf<Card>()
    private val humanCardsWon = mutableListOf<Card>()
    private val computerCardsWon = mutableListOf<Card>()
    private lateinit var whoPlayedFirst: Player
    private lateinit var lastWinner: Player

    fun setWhoPlayedFirst(player: Player) {
        this.whoPlayedFirst = player
    }

    fun showCards() {
        println()
        if (this.cards.isEmpty()) {
            println("No cards on the table")
        } else {
            println("${this.cards.size} cards on the table, and the top card is ${this.cards.last()}")
        }
    }

    fun putCards(cards: List<Card>) {
        this.cards.addAll(cards)
        println("Initial cards on the table: ${this.cards.joinToString(" ")}")
    }

    fun putCard(card: Card, player: Player) {
        val lastCardOnTable = this.cards.lastOrNull()
        this.cards.add(card)
        if (lastCardOnTable != null && lastCardOnTable.matchesRankOrSuit(card)) {
            lastWinner = player
            addWonCardsToPlayer(this.cards, player)
            this.cards = mutableListOf()
            showScoreBoard()
        }
    }

    fun showScoreBoard(isFinal: Boolean = false) {
        var humanScore = calculateScore(humanCardsWon)
        var computerScore = calculateScore(computerCardsWon)
        if (isFinal) {
            if (humanCardsWon.size == computerCardsWon.size) {
                if (whoPlayedFirst is Human) {
                    humanScore += MOST_CARDS_SCORE
                } else {
                    computerScore += MOST_CARDS_SCORE
                }
            } else {
                humanScore += if (humanCardsWon.size > computerCardsWon.size) MOST_CARDS_SCORE else 0
                computerScore += if (computerCardsWon.size > humanCardsWon.size) MOST_CARDS_SCORE else 0
            }
        }
        println("Score: Player $humanScore - Computer $computerScore")
        println("Cards: Player ${humanCardsWon.size} - Computer ${computerCardsWon.size}")
    }

    private fun calculateScore(cards: List<Card>): Int {
        val ranksWithPoints = arrayOf("A", "K", "Q", "J", "10")
        return cards.stream().filter { card -> card.rank in ranksWithPoints }.count().toInt()
    }

    fun addLeftCards() {
        if (humanCardsWon.isEmpty() && computerCardsWon.isEmpty()) {
            addWonCardsToPlayer(this.cards, whoPlayedFirst, print = false)
        } else {
            addWonCardsToPlayer(this.cards, lastWinner, print = false)
        }
        this.cards = mutableListOf()
    }

    private fun addWonCardsToPlayer(cards: List<Card>, player: Player, print: Boolean = true) {
        val isHumanPlayer = player is Human
        if (isHumanPlayer) {
            humanCardsWon.addAll(cards)
        } else {
            computerCardsWon.addAll(cards)
        }
        if (print) {
            println("${if (isHumanPlayer) "Player" else "Computer"} wins cards")
        }
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
