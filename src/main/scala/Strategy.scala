trait Strategy {
     def move(score: Integer)
     def requestCard(globaldeck : => List[Card])
     def stay()
     def forfeit()
}
