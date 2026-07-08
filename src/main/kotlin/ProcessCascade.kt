tailrec fun BoardState.processCascade(
): BoardState {
    val matches = findMatches(this.board)

    if (matches.isEmpty()) {
        return this
    }

    return this
            .removeMatches(matches)
            .fillEmptySpaces()
            .processCascade()
}