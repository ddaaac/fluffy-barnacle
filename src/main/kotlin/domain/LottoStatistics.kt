package domain

class LottoStatistics(tickets: List<LottoTicket>, winnerNumbers: WinnerNumbers) {

    val rankingToCount: Map<LottoRanking, Int> = getRankingToCount(tickets, winnerNumbers)

    val revenue: Double
        get() {
            val ticketsPrice: LottoMoney = LottoTicketCount(rankingToCount.entries.size).price
            val reward: Long = getTotalReward(rankingToCount)
            return reward.toDouble() / ticketsPrice.value
        }
}

private fun getRankingToCount(tickets: List<LottoTicket>, winnerNumbers: WinnerNumbers): Map<LottoRanking, Int> {
    return tickets.mapNotNull { it.findRankingBy(winnerNumbers) }
            .groupingBy { it }
            .eachCount()
}

private fun LottoTicket.findRankingBy(winnerNumbers: WinnerNumbers): LottoRanking? =
        LottoRanking.from(winnerNumbers.countSameNumber(this), winnerNumbers.containsBonus(this))

private fun getTotalReward(rankingToCount: Map<LottoRanking, Int>) =
        rankingToCount.map { (ranking, count) -> ranking.reward * count }.sum()
