import application.RacingService
import application.RandomIntNumberGenerator
import persistence.CarRepositoryImpl
import presentation.RacingController
import view.InputView
import view.OutputView

fun main() {
    val racingService = RacingService(CarRepositoryImpl(), RandomIntNumberGenerator())
    val racingController = RacingController(racingService, InputView(), OutputView())
    racingController.start()
}
