package application

import kotlin.random.Random

class RandomIntNumberGenerator : NumberGenerator<Int> {

    override fun generate(from: Int, util: Int): Int {
        return Random.nextInt(from, util)
    }
}
