enum class Element(
    val symbol: Char
) {
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E'),
    F('F'),
    EMPTY('0');

    companion object {
        private val playable = entries.filter { it != EMPTY }

        fun random(): Element = playable.random()
    }
}