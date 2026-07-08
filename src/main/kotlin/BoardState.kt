data class BoardState(
    val board: Board,
    val score: Int
) {
    companion object {
        fun builder(): BoardStep = Builder()
    }

    interface BoardStep {
        fun board(board: Board): ScoreStep
    }

    interface ScoreStep {
        fun score(score: Int): BuildStep
    }

    interface BuildStep {
        fun build(): BoardState
    }

    private class Builder: BoardStep, ScoreStep, BuildStep {
        private lateinit var board: Board
        private var score: Int? = null

        override fun board(board: Board): ScoreStep = apply {
            this.board = board
        }

        override fun score(score: Int): BuildStep = apply {
            this.score = score
        }

        override fun build(): BoardState {
            return BoardState(
                board = board,
                score = requireNotNull(this.score) { "score is required" }
            )
        }
    }
}
