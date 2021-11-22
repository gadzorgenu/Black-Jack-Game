import cards.{Card, CardValue, Deck, Suit}
import player.Player

import scala.collection.mutable._
import strategy.DefaultStrategy

object Main extends App {
 
 (new Game(Player.producePlayers(6, List("default", "default", "something else", "something else", "something else", "something else")))).startgame()

}
