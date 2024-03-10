package persistence

import domain.Car
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import persistence.exception.DuplicateKeyException
import kotlin.test.assertContains

class CarRepositoryTest {

    private lateinit var carRepository: CarRepository

    @BeforeEach
    fun init() {
        carRepository = CarRepository()
    }

    @Test
    fun `차를 저장한다`() {
        //given
        val car = Car("name")

        //when
        carRepository.insert(car)

        //then
        val cars = carRepository.findAll()
        assertContains(cars, car)
    }

    @Test
    fun `차 저장 시 이름이 중복되었을 경우 예외가 발생한다`() {
        //given
        val name = "duplicateName"
        val car1 = Car(name)
        carRepository.insert(car1)

        //when
        //then
        assertThrows<DuplicateKeyException> {
            val car2 = Car(name)
            carRepository.insert(car2)
        }
    }
}
