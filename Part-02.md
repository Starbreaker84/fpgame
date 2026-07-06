Реализация функции processCascade() с помощью хвостовой рекурсии на языке Kotlin:

``` Kotlin
tailrec fun processCascade(
    state: BoardState
): BoardState {
    val matches = findMatches(state.board)

    if (matches.isEmpty()) {
        return state
    }

    return processCascade(fillEmptySpaces(removeMatches(state, matches)))
}
```
