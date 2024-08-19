package persistence

import domain.Car
import persistence.exception.DuplicateKeyException

class CarRepositoryImpl : CarRepository {

    private val cars: MutableSet<Car> = HashSet()

    override fun insert(car: Car) {
        val beforeSize = this.cars.size
        this.cars.add(car)
        if (beforeSize == cars.size) {
            throw DuplicateKeyException("자동차 이름이 중복되었습니다.")
        }
    }

    override fun findAll(): List<Car> {
        return this.cars.toList()
    }
}
