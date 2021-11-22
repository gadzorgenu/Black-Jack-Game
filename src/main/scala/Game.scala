import scala.collection.mutable._

import player._
import cards._

class Game(val players:Map[Int,Player]) {
  
  val winningCriteria: List[Map[Int, Player] => (Boolean, Map[Int, Player], String)] = 
    List(blackjackCheck, allStickCheck, lonePlayerCheck)

  def startgame() = {

    var gameEnded: Boolean = false

    val cards: Stack[Card] = (new Deck()).shuffleCards()

    players.foreach( (p: (Int, Player)) => p._2.initialMove(cards) )

    var statusPayload: (Boolean, Map[Int, Player], String) = checkForPossibleWinner(players)

    gameEnded = statusPayload._1

    while(!gameEnded) {
      players.foreach( _._2.nextMove(cards, players) )

      statusPayload = checkForPossibleWinner(players)
      gameEnded = statusPayload._1
    }

    println
    println(s"${statusPayload._2.toSeq(0)._2} wins the round by ${statusPayload._3}")
  }

  def checkForPossibleWinner(players: Map[Int, Player]) : (Boolean, Map[Int, Player], String) = {
    for(i <- 0 until winningCriteria.length) {
      val verdict: (Boolean, Map[Int, Player], String) = winningCriteria(i)(players)
      if(verdict._1) return verdict
    }

    println

    return (false, Map((-1, new Player())), "")
  }

  def blackjackCheck() : (Map[Int, Player]) => (Boolean, Map[Int, Player], String) = (players: Map[Int, Player])=> {
    val winner = players.filter(p => p._2.score == 21)
    (winner.size > 0, winner, "Black Jack")
  }

  def lonePlayerCheck() : (Map[Int, Player]) => (Boolean, Map[Int, Player], String) = (players: Map[Int, Player])=> {
    (players.size == 1, players, "Last Man Standing")
  }

  def allStickCheck() : (Map[Int, Player]) => (Boolean, Map[Int, Player], String) = (players: Map[Int, Player])=> {
    val stickers: Map[Int, Player] = players.filter(p => (p._2.score >= 17 && p._2.score < 21))
    var playerhold: Map[Int, Player] = Map((-1, new Player()))

    if(stickers.isEmpty || stickers.size == 1) (false, playerhold, "Highest Stick")
    else {
      val stickersInOrder = stickers.toSeq.sortWith( (a: (Int, Player), b: (Int, Player)) => a._2.score > b._2.score)
      playerhold = Map(stickersInOrder(0))
      (players.size == stickersInOrder.length, playerhold, "Highest Stick")
    }
  }
}
