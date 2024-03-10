import application.RacingService
import application.RandomIntNumberGenerator
import persistence.CarRepository
import presentation.RacingController
import view.InputView
import view.OutputView

fun main() {
    val racingService = RacingService(CarRepository(), RandomIntNumberGenerator())
    val racingController = RacingController(racingService, InputView(), OutputView())
    racingController.start()
}
