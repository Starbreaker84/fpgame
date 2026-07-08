private const val CHAIN_LENGTH = 3

fun Board.findMatches(): List<Match> {
    val matches = mutableListOf<Match>()

    // Горизонтальные комбинации
    for (row in 0 until this.size) {
        var startColumn = 0

        for (column in 1 until this.size) {
            // Пропускаем пустые ячейки в начале строки
            if (this.cells[row][startColumn] == Element.EMPTY) {
                startColumn = column
                continue
            }

            // Если текущая ячека пустая, обрываем текущую последовательность
            if (this.cells[row][column] == Element.EMPTY) {
                matches.addIfValid(row, startColumn, column - startColumn, MatchDirection.HORIZONTAL)
                startColumn = column + 1
                continue
            }

            // Проверяем совпадение символов для непустых ячеек
            if (this.cells[row][column] != this.cells[row][startColumn]) {
                matches.addIfValid(row, startColumn, column - startColumn, MatchDirection.HORIZONTAL)
                startColumn = column
            } else {
                if (column == this.size - 1) {
                    matches.addIfValid(row, startColumn, column - startColumn + 1, MatchDirection.HORIZONTAL)
                }
            }
        }
    }

    // Вертикальные комбинации
    for (column in 0 until this.size) {
        var startRow = 0

        for (row in 1 until this.size) {
            // Пропускаем пустые ячейки в начале столбца
            if (this.cells[startRow][column] == Element.EMPTY) {
                startRow = row
                continue
            }

            // Если текущая ячека пустая, обрываем текущую последовательность
            if (this.cells[row][column] == Element.EMPTY) {
                matches.addIfValid(startRow, column, row - startRow, MatchDirection.VERTICAL)
                startRow = row + 1
                continue
            }

            // Проверяем совпадение символов для непустых ячеек
            if (this.cells[row][column] != this.cells[startRow][column]) {
                matches.addIfValid(startRow, column, row - startRow, MatchDirection.VERTICAL)
                startRow = row
            } else {
                if (column == this.size - 1) {
                    matches.addIfValid(startRow, column, row - startRow + 1, MatchDirection.VERTICAL)
                }
            }
        }
    }

    return matches
}

private fun MutableList<Match>.addIfValid(
    row: Int,
    column: Int,
    length: Int,
    direction: MatchDirection
) {
    if (length >= CHAIN_LENGTH) {
        add(Match(direction, row, column, length))
    }
}