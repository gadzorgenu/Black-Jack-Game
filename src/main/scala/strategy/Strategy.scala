package strategy

import cards.Card

import scala.collection.mutable._

trait Strategy {
  def move(score: Integer, playerDeck : => Stack[Card], globalDeck : => Stack[Card])

  def requestCard(globalDeck: => Stack[Card], playerDeck: => Stack[Card])

  def stay()

  def forfeit()
}
