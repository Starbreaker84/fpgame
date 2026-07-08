private const val SCORE_MULTIPLIER = 10

fun BoardState.removeMatches(
    matches: List<Match>
): BoardState {
    if (matches.isEmpty()) return this

    // Шаг 1: Помечаем ячейки для удаления
    val markedCells = markCellsForRemoval(this.board, matches)

    // Шаг 2: Применяем гравитацию
    val gravityAppliedCells = applyGravity(markedCells, this.board.size)

    // Шаг 3: Подсчитываем очки
    val removedCount = matches.sumOf { it.length }
    val newScore = this.score + calculateScore(removedCount)

    // Возращаем НОВОЕ состояние
    return BoardState(
        Board(gravityAppliedCells),
        newScore
    )
}

private fun markCellsForRemoval(
    board: Board,
    matches: List<Match>
): Array<Array<Element>> {
    val newCells = board.cells.clone()

    for (match in matches) {
        for (i in 0 until match.length) {
            val row = if (match.direction == MatchDirection.HORIZONTAL) match.row else match.row + i
            val column = if (match.direction == MatchDirection.HORIZONTAL) match.column + i else match.column

            newCells[row][column] = Element.EMPTY
        }
    }

    return newCells
}

private fun applyGravity(
    cells: Array<Array<Element>>,
    size: Int
): Array<Array<Element>> {
    val newCells = Array(size) { Array(size) { Element.EMPTY } }

    for (column in 0 until size) {
        var newRow = size - 1
        for (row in size -1 downTo 0) {
            if (cells[row][column] != Element.EMPTY) {
                newCells[newRow][column] = cells[row][column]
                newRow--
            }
        }
    }

    return newCells
}

private fun calculateScore(removedCount: Int): Int {
    return removedCount * SCORE_MULTIPLIER
}



