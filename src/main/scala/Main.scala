import cards.{Card, CardValue, Deck, Suit}
import player.Player

import scala.collection.mutable._

object Main extends App {
 var sthing = new Deck()
 println(sthing.cards)
 println(sthing.cards.length)
 val shuffled: Stack[Card] = sthing.shuffleCards
 println(shuffled)
// println(somepop(sthing.cards))
// println(sthing.cards.length)
// println(somepop(sthing.cards))
// println(sthing.cards.length)
// val actualPoppingFunc = somepop(sthing.cards)
// actualPoppingFunc()()
// println(sthing.cards.length)
// actualPoppingFunc()()
// println(sthing.cards.length)

 val p1 = new Player(1)
 p1.initialMove(shuffled)
 println(shuffled.length)
 println(p1.playerDeck.length)
 println(p1.score)
 p1.nextMove(shuffled)
 println(p1.score)
 p1.nextMove(shuffled)
 println(p1.score)
 p1.nextMove(shuffled)
 println(p1.score)


 def somepop(s: Stack[Card]): () => () => Card =  () => () => s.pop
}
