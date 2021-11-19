import cards.{Card, CardValue, Deck, Suit}

import scala.collection.mutable._

object Main extends App {
 val sthing = new Deck()
 println(sthing.cards.length)
 println(sthing.shuffleCards)
}
