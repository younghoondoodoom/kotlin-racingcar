package domain

import domain.exception.DomainException

private const val MIN_MOVEMENT_THRESHOLD = 3
private const val MIN_NAME_LENGTH = 1
private const val MAX_NAME_LENGTH = 5

class Car(val name: String, var position: Int = 0) {

    init {
        if (name.length < MIN_NAME_LENGTH || name.length > MAX_NAME_LENGTH) {
            throw DomainException("자동차 이름은 " + MIN_NAME_LENGTH + " ~ " + MAX_NAME_LENGTH + "자까지 가능")
        }
    }

    fun move(number: Int) {
        if (number > MIN_MOVEMENT_THRESHOLD) {
            position++
        }
    }

    fun isPositionEqual(car: Car): Boolean {
        return this.position == car.position
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
