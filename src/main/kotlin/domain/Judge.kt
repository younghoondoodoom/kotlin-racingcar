package domain

class Judge(val cars: List<Car>) {

    fun findWinners(): List<Car> {
        val maxPositionCar = cars.maxWith { o1, o2 -> o1.position.compareTo(o2.position) }
        return cars.filter { car -> car.isPositionEqual(maxPositionCar) }
    }
}
