package domain

import domain.exception.DomainException
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals


class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `차 이름의 길이는 1~5자이다`(number: Int) {
        //given
        val stringBuilder = StringBuilder()
        for (count: Int in 1..number) {
            stringBuilder.append("x")
        }

        //when
        //then
        assertDoesNotThrow { Car(stringBuilder.toString()) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 6, 7, 8, 9, 10])
    fun `차 이름의 길이는 1미만, 5초과일 경우 예외가 발생한다`(number: Int) {
        //given
        val stringBuilder = StringBuilder()
        for (count: Int in 1..number) {
            stringBuilder.append("x")
        }

        //when
        //then
        assertThrows<DomainException> { Car(toString()) }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9, 10])
    fun `숫자가 3초과일 경우 1 전진한다`(number: Int) {
        //given
        val car = Car("test")
        val initPosition = car.position

        //when
        car.move(number)

        //then
        assertEquals(initPosition + 1, car.position)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9, 10])
    fun `값이 3초과이면 전진한다`(number: Int) {
        //given
        val initPosition = 0
        val car = Car("name", initPosition)

        //when
        car.move(number)

        //then
        assertEquals(car.position, initPosition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `값이 3이하이면 움직이지 않는다`(number: Int) {
        //given
        val initPosition = 0
        val car = Car("name", initPosition)

        //when
        car.move(number)

        //then
        assertEquals(car.position, initPosition)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `차가 움직일때 값이 3이하이면 움직이지 않는다`(number: Int) {
        //given
        val position = 0
        val car = Car("name", position)

        //when
        car.move(number)

        //then
        assertEquals(car.position, position)
    }


}
