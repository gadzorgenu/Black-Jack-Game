package strategy

import scala.collection.mutable._

import cards._
import player._


class DefaultStrategy extends Strategy {

  def move(score: Integer, playerDeck : => Stack[Card], globalDeck : => Stack[Card], id: Int, players: Map[Int, Player]): Unit = {
    score match{
      case score if(score < 17) => requestCard(globalDeck, playerDeck, id, players)
      case score if(score >= 17 && score < 21) => stay(id, players)
      case score if(score > 21) => forfeit(id, players)
    }
  }

}

object DefaultStrategy {
  def apply = new DefaultStrategy()
}
