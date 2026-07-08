enum class MatchDirection {
    HORIZONTAL,
    VERTICAL,
}

data class Match(
    val direction: MatchDirection,
    val row: Int,
    val column: Int,
    val length: Int
)