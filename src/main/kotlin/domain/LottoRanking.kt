package domain

private val DONT_CARE = null

enum class LottoRanking(
        private val count: Int,
        private val bonus: Boolean?,
        val reward: Long,
) {
    RANK_1(6, DONT_CARE, 2_000_000_000L),
    RANK_2(5, true, 100_000_000L),
    RANK_3(5, false, 1_000_000L),
    RANK_4(4, DONT_CARE, 100_000L),
    RANK_5(3, DONT_CARE, 1_000L),
    ;

    companion object {

        fun from(count: Int, bonus: Boolean): LottoRanking? {
            return values().firstOrNull {
                (it.count == count) && match(it.bonus, bonus)
            }
        }

        private fun match(rankingBonus: Boolean?, bonus: Boolean): Boolean {
            return if (rankingBonus == DONT_CARE) {
                true
            } else {
                rankingBonus == bonus
            }
        }
    }
}
