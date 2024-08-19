package presentation

import application.RacingService
import view.InputView
import view.OutputView

class RacingController(
    private val racingService: RacingService,
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun start() {
        createCars()
        race()
        printWinners()
    }

    private fun createCars() {
        workWithRetry {
            val createCarRequests = inputView.inputCarNames()
            racingService.createCars(createCarRequests)
        }
    }

    private fun race() {
        workWithRetry {
            val raceTime = inputView.inputRaceTime()
            racingService.run(raceTime)
        }
    }

    private fun printWinners() {
        workWithRetry {
            val winners = racingService.findWinners()
            outputView.outputWinners(winners)
        }
    }
}
