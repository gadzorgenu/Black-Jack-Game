package player

import cards.Card
import strategy.DefaultStrategy

import scala.collection.mutable._

class Player(val id: Integer, val strategy: DefaultStrategy = new DefaultStrategy()) {

    var playerDeck: Stack[Card] = new Stack()

    def initialMove(globalDeck: Stack[Card]): Unit = { playerDeck.push(globalDeck.pop); playerDeck.push(globalDeck.pop) }

    def nextMove(globalDeck: Stack[Card] ): Unit = strategy.move(score, playerDeck, globalDeck)

    def score() : Int =  if(!playerDeck.isEmpty) playerDeck.map(_.value._2).sum else 0
}
