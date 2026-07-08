import kotlin.system.exitProcess

object Game {

    fun initializeGame(boardSize: Int = 8): BoardState {
        return BoardState.builder()
            .board(Board(boardSize))
            .score(0)
            .build()
            .fillEmptySpaces()
            .processCascade()
    }

    fun draw(board: Board) {
        print("  ")
        for (i in 0 until board.size) {
            print("$i ")
        }

        println()

        for (i in 0 until board.size) {
            print("$i ")

            for (j in 0 until board.size) {
                print("${board.cells[i][j].symbol} ")
            }

            println()
        }

        println()
    }

    fun cloneBoard(board: Board): Board {
        val newBoard = Board(board.size)

        for (row in 0 until board.size) {
            for (col in 0 until board.size) {
                newBoard.cells[row][col] = board.cells[row][col]
            }
        }

        return newBoard
    }

    fun applyMove(boardState: BoardState, move: Move): BoardState {
        val board = cloneBoard(boardState.board)

        val temporaryElement = board.cells[move.from.row][move.from.col]

        board.cells[move.from.row][move.from.col] = board.cells[move.to.row][move.to.col]

        board.cells[move.to.row][move.to.col] = temporaryElement

        return BoardState(board, boardState.score)
    }

    fun readMove(): Move {
        println(">")

        val input = readln()

        if (input == "q") {
            exitProcess(0)
        }

        val (y, x, y1, x1) = input.split(" ").map { it.toInt() }

        return Move(
            from = Position(x, y),
            to = Position(x1, y1)
        )
    }
}