package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class LottoMoneyTest : BehaviorSpec({
    given("돈") {
        `when`("1000원 단위") {
            then("생성") {
                LottoMoney(1000)
            }
        }

        `when`("1000원 단위가 아님") {
            val invalidMoneys = listOf(1001, 1010, 1100, 1111)
            invalidMoneys.forEach {
                then("실패") {
                    shouldThrow<IllegalArgumentException> { LottoMoney(it) }
                }
            }
        }
    }
})
