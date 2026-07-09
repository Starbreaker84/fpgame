tailrec fun BoardState.processCascade(
): BoardState {
    val matches = this.board.findMatches()
    return if (matches.isEmpty())
                this
           else
               this.pipeline(
                   step{ bs -> bs.removeMatches(matches) },
                   step{ bs -> bs.fillEmptySpaces() },
               ).processCascade()
}