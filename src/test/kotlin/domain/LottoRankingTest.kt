package domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

private data class RankingProps(
    val count: Int,
    val bonus: Boolean,
    val expected: LottoRanking?,
)

class LottoRankingTest : FunSpec({
    test("일치하는 번호의 갯수와 보너스 여부가 주어지면, 랭킹을 구한다.") {
        listOf(
            RankingProps(6, true, LottoRanking.RANK_1),
            RankingProps(6, false, LottoRanking.RANK_1),
            RankingProps(5, true, LottoRanking.RANK_2),
            RankingProps(5, false, LottoRanking.RANK_3),
            RankingProps(4, true, LottoRanking.RANK_4),
            RankingProps(4, false, LottoRanking.RANK_4),
            RankingProps(3, true, LottoRanking.RANK_5),
            RankingProps(3, false, LottoRanking.RANK_5),
            RankingProps(2, true, null),
            RankingProps(2, false, null),
            RankingProps(1, true, null),
            RankingProps(1, false, null),
            RankingProps(0, true, null),
            RankingProps(0, false, null),
        ).forEachWith {
            LottoRanking.from(count, bonus) shouldBe expected
        }
    }
})

private fun <T> Iterable<T>.forEachWith(action: T.() -> Unit) = forEach(action)

