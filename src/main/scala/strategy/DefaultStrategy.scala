package strategy

import cards.Card

import scala.collection.mutable._

class DefaultStrategy extends Strategy {

  def move(score: Integer, playerDeck : => Stack[Card], globalDeck : => Stack[Card], ): Unit = {
    score match{
      case score if(score < 17 ) => requestCard(globalDeck, playerDeck)
      case score if(score >= 17 && score < 21) => stay()
      case score if(score > 21) => forfeit()
    }
  }

  def requestCard(globalDeck: => Stack[Card], playerDeck: => Stack[Card]): Unit = {
    playerDeck.push(globalDeck.pop())
    println("Hit")
  }

  def stay(): Unit = {
    println("Stick")
  }

  def forfeit(): Unit = {

    println("Go bust")
  }
}
