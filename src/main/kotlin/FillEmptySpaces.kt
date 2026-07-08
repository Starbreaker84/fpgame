fun BoardState.fillEmptySpaces(): BoardState {
    val newCells = this.board.cells.clone()

    for (row in 0 until this.board.size) {
        for (col in 0 until this.board.size) {
            if (newCells[row][col] == Element.EMPTY) {
                newCells[row][col] = Element.random()
            }
        }
    }

    return BoardState(
        Board(newCells),
        this.score
    )
}