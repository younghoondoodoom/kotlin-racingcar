package persistence

import domain.Car

interface CarRepository {

    fun insert(car: Car)

    fun findAll(): List<Car>
}
