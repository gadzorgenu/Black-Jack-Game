package cards

import scala.collection.mutable._
import scala.util.Random

class Deck(var cards: Stack[Card]) {

  def this() {
    this(Stack())
    generateCards()
  }


  private def generateCards(): Unit =
    for (suit <- Suit.values)
      for (value <- CardValue.CARD_VALUES)
        cards.push(Card(suit, value))

  def shuffleCards() : Stack[Card] = Random.shuffle(cards)

}
