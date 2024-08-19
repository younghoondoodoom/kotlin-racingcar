package view

import application.dto.response.CarResponse

class OutputView {

    fun outputWinners(carResponses: List<CarResponse>) {
        println("최종 우승 자동차")
        for (carResponse in carResponses) {
            println("자동차 이름: " + carResponse.name)
            println(carResponse.name + "의 최종 위치:" + carResponse.location)
            println()
        }
    }
}
