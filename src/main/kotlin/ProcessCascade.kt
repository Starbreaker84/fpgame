tailrec fun BoardState.processCascade(
): BoardState {
    val matches = findMatches(this.board)

    if (matches.isEmpty()) {
        return this
    }

    return removeMatches(this, matches)
            .fillEmptySpaces()
            .processCascade()
}