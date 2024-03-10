package view

import application.dto.request.CreateCarRequest
import java.util.function.Predicate

private const val CAR_NAME_COMMENT = "자동차 이름을 입력해주세요(','로 구분)"

private const val DIVIDER = ","

class InputView {

    fun inputCarNames(): List<CreateCarRequest> {
        println(CAR_NAME_COMMENT)
        val carNames = inputStringWithRetry { input -> input.trim().isNotEmpty() }
        return carNames.split(DIVIDER)
            .map { carName -> CreateCarRequest(carName.trim()) }
    }

    fun inputRaceTime(): Int {
        println("경주 횟수를 입력해주세요.")
        return inputIntWithRetry(
            { input -> input.trim().isNotEmpty() },
            { result -> result > 0 })
    }
}

private fun inputStringWithRetry(predicate: Predicate<String>): String {
    return inputWithRetry(predicate)
}

private fun inputIntWithRetry(inputPredicate: Predicate<String>, resultPredicate: Predicate<Int>): Int {
    val result = inputWithRetry(inputPredicate).toInt()
    if (!resultPredicate.test(result)) {
        println("다시 입력해주세요")
        return inputIntWithRetry(inputPredicate, resultPredicate)
    }
    return result
}

private fun inputWithRetry(predicate: Predicate<String>): String {
    val input = readln()
    if (!predicate.test(input)) {
        println("다시 입력해주세요")
        return inputWithRetry(predicate)
    }
    return input
}
