import Game.applyMove
import Game.draw
import Game.readMove

fun main() {
    var boardState = Game.initializeGame()
    while (true) {
        draw(boardState.board)
        val move = readMove()
        boardState = applyMove(boardState, move)
    }
}