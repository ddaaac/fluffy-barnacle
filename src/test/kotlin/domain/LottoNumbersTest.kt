package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : DescribeSpec({

    describe("생성") {
        context("유효하다면") {
            val numbers = intArrayOf(1, 2, 3, 4, 5, 6)
            it("생성된다") {
                LottoTicket(*numbers).numbers.map { it.value } shouldBe numbers.toList()
            }
        }

        context("중복되는 숫자가 있다면") {
            val numbers = intArrayOf(1, 2, 3, 4, 5, 5)
            it("생성되지 않는다") {
                shouldThrow<IllegalArgumentException> { LottoTicket(*numbers) }
            }
        }

        context("숫자가 6개가 아니라면") {
            listOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
            ).forEach {
                it("생성되지 않는다") {
                    shouldThrow<IllegalArgumentException> { LottoTicket(*it) }
                }
            }
        }
    }

    describe("포함") {
        val ticket = LottoTicket(1, 2, 3, 4, 5, 6)

        context("LottoNumber와 포함관계라면") {
            val number = LottoNumber(1)
            it("참") { ticket.contains(number) shouldBe true }
        }

        context("LottoNumber와 포함관계가 아니라면") {
            val number = LottoNumber(7)
            it("거짓") { ticket.contains(number) shouldBe false }
        }
    }

    describe("일치") {
        val ticket = LottoTicket(1, 2, 3, 4, 5, 6)

        context("다른 티켓과 일치하는 갯수를 구하면") {
            val other = LottoTicket(1, 2, 3, 4, 5, 6)
            it("구한다") { ticket.countSameNumbers(other) shouldBe 6 }
        }

        context("다른 티켓과 일치하는 갯수를 구하면") {
            val other = LottoTicket(4, 5, 7, 1, 8, 9)
            it("구한다") { ticket.countSameNumbers(other) shouldBe 3 }
        }

        context("다른 티켓과 일치하는 갯수를 구하면") {
            val other = LottoTicket(10, 11, 12, 13, 14, 15)
            it("구한다") { ticket.countSameNumbers(other) shouldBe 0 }
        }
    }
})