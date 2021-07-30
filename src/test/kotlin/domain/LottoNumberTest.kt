package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec

class LottoNumberTest : ExpectSpec({

    context("1~45 사이라면") {
        (1..45).forEach {
            expect("생성된다") {
                LottoNumber(it)
            }
        }
    }

    context("1~45 바깥 범위라면") {
        listOf(0, 46).forEach {
            expect("생성에 실패한다") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumber(it)
                }
            }
        }
    }
})
