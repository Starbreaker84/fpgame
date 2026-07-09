fun <T> T.pipeline(
    vararg steps: (T) -> T
): T = steps.fold(this) { current, step -> step(current) }

fun <T> step(
    f: (T) -> T
): (T) -> T = f