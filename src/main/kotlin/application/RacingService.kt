package application

import application.dto.request.CreateCarRequest
import application.dto.response.CarResponse
import application.exception.ClientException
import domain.Car
import domain.Judge
import persistence.CarRepository
import persistence.exception.DuplicateKeyException

class RacingService(
    private val carRepository: CarRepository,
    private val numberGenerator: NumberGenerator<Int>
) {

    fun createCars(createCarRequests: List<CreateCarRequest>) {
        createCarRequests.forEach { createCarRequest ->
            createCar(createCarRequest)
        }
    }

    private fun createCar(createCarRequest: CreateCarRequest) {
        val car = Car(createCarRequest.name)
        try {
            carRepository.insert(car)
        } catch (exception: DuplicateKeyException) {
            throw ClientException(exception.message)
        }
    }

    fun run(time: Int) {
        val cars = carRepository.findAll()
        repeat((0..time).count()) { runEach(cars) }
    }

    private fun runEach(cars: List<Car>) {
        cars.forEach { car ->
            val number = numberGenerator.generate(1, 10)
            car.move(number)
        }
    }

    fun findWinners(): List<CarResponse> {
        val cars = carRepository.findAll()
        val judge = Judge(cars)
        val winners = judge.findWinners()
        return winners.map { winner -> CarResponse(winner.name, winner.position) }
    }
}
