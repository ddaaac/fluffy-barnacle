package domain

import kotlin.random.Random

class RandomNumberGenerator {

    private val random = Random

    fun generateSixInts() = VALID_LOTTO_NUMBER_RANGE.shuffled(random).take(6)
}
