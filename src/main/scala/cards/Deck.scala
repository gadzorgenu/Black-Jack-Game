package cards

import scala.collection.mutable._
import scala.util.Random

class Deck(var cards: Stack[Card]) {

  def this() {
    this(Stack())
    generateCards()
  }

  /** Primes an instantiated Deck with all the cards needed. */
  private def generateCards(): Unit =
    for (suit <- Suit.values)
      for (value <- CardValue.CARD_VALUES)
        cards.push(Card(suit, value))

  /**
   * Shuffles a stack of cards from the deck.
   * @return A stack of cards
   * */
  def shuffleCards() : Stack[Card] = Random.shuffle(cards)

}
