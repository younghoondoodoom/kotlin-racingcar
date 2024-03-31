package domain

import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class JudgeTest {

    @Test
    fun `차 목록 중 승리차를 뽑는다`() {
        //given
        val maxPosition = 10
        val winner = Car("win", maxPosition)
        val cars = ArrayList<Car>()
        (1 until maxPosition).mapTo(cars) { Car("car$it", it) }
        cars.add(winner)

        val judge = Judge(cars)

        //when
        val winners = judge.findWinners()

        //then
        assertEquals(winners.size, 1)
        assertEquals(winners.get(0), winner)
    }

    @Test
    fun `차 목록 중 승리차 목록을 뽑는다`() {
        //given
        val maxPosition = 10
        val winner1 = Car("win1", maxPosition)
        val winner2 = Car("win2", maxPosition)
        val cars = ArrayList<Car>()
        (1 until maxPosition).mapTo(cars) { Car("car$it", it) }
        cars.add(winner1)
        cars.add(winner2)

        val judge = Judge(cars)

        //when
        val winners = judge.findWinners()

        //then
        assertEquals(winners.size, 2)
        assertContains(winners, winner1)
        assertContains(winners, winner2)
    }
}
