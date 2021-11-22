package strategy

import cards.Card

import scala.collection.mutable._
import player._

trait Strategy {
  def move(score: Integer, playerDeck : => Stack[Card], globalDeck : => Stack[Card], id: Int, players: Map[Int, Player])

  def requestCard(globalDeck: => Stack[Card], playerDeck: => Stack[Card], playerid: Int, players: Map[Int, Player]): Unit = {
    print(s"${players(playerid)} \t==>\t Hit")
    playerDeck.push(globalDeck.pop())
    println(s" \t\t==>\t\t${players(playerid)}")
  }

  def stay(playerid: Int, players: Map[Int, Player]): Unit = {
    println(s"${players(playerid)} \t==>\t Stick \t\t==>\t\t${players(playerid)}")
  }

  def forfeit(playerid: Int, players: Map[Int, Player]): Unit = {
    println(s"${players(playerid)} \t==>\t Go bust \t==>\t\tN/A")
    players -= playerid
  }
}

object Strategy {
  def produce(strategy_type: String) : DefaultStrategy = strategy_type.toLowerCase match {
    case "default" => new DefaultStrategy
    case _ => { println("Strategy not known. Defaulting to DefaultStrategy... Done."); new DefaultStrategy }
  }
}
