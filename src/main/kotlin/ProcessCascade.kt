tailrec fun BoardState.processCascade(
): BoardState {
    val matches = this.board.findMatches()
    return if (matches.isEmpty())
                this
           else
                this.removeMatches(matches)
                    .fillEmptySpaces()
                    .processCascade()
}