package domain

class LottoStatistics(tickets: List<LottoTicket>, winnerNumbers: WinnerNumbers) {

    val rankingToCount: Map<LottoRanking, Int> = getRankingToCount(tickets, winnerNumbers)
    private val ticketCount = tickets.size

    val revenue: Double
        get() {
            val spent: LottoMoney = LottoTicketCount(ticketCount).price
            val reward: Long = getTotalReward(rankingToCount)
            return reward.toDouble() / spent
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
