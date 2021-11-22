package player

import cards.Card
import strategy._

import scala.collection.mutable._


class Player {
    import Player._

    private var _id: Int = _ct
    private var _strategy: Strategy = new DefaultStrategy()

    def id: Int = _id

    def strategy: Strategy = _strategy

    def this(player_strategy: Strategy = new DefaultStrategy) = {
        this
        _strategy = player_strategy
        _ct += 1
    }

    var playerDeck: Stack[Card] = new Stack()

    def initialMove(globalDeck: Stack[Card]): Unit = { playerDeck.push(globalDeck.pop); playerDeck.push(globalDeck.pop) }

    def nextMove(globalDeck: Stack[Card], players: Map[Int, Player]): Unit = _strategy.move(score, playerDeck, globalDeck, id, players)

    def score() : Int =  if(!playerDeck.isEmpty) playerDeck.map(_.value._2).sum else 0

    override def toString(): String = s"Player{id: $id, score: $score}"
}


object Player {
    private var _ct = 1

    def apply(strategy: Strategy) : Unit = new Player(strategy)

    def producePlayers(quantity: Int, strategies: List[String]) : Map[Int, Player] = {
        var players: Map[Int, Player] = Map()

        for(i <- 0 until quantity) {
            val player: Player = new Player(Strategy.produce(strategies(i)))
            players.addOne((player.id, player))
        }

        players
    }
}