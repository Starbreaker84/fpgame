data class Board(
    val cells: Array<Array<Element>>
) {
    val size: Int get() = cells.size

    constructor(size: Int) : this(
        cells = Array(size) {
            Array(size) { Element.EMPTY }
        }
    )
}
