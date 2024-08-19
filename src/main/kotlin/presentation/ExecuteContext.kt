package presentation

import java.util.function.Supplier

fun <T> workWithRetry(executeStrategy: Supplier<T?>): T {
    var result: T? = null
    while (result == null) {
        result = catchException(executeStrategy, result)
    }
    return result
}

private fun <T> catchException(executeStrategy: Supplier<T>, result: T): T {
    try {
        return executeStrategy.get()
    } catch (exception: Exception) {
        println(exception.message)
    }
    return result
}
