package domain

class LottoStatistics(tickets: List<LottoTicket>, winnerNumbers: WinnerNumbers) {

    val countByRanking: Map<LottoRanking, Int> = countRankingFrom(tickets, winnerNumbers)
    private val ticketCount = tickets.size

    val revenue: Double
        get() {
            val spent: LottoMoney = LottoTicketCount(ticketCount).price
            val reward: Long = getTotalReward(countByRanking)
            return reward.toDouble() / spent
        }
}

private fun countRankingFrom(tickets: List<LottoTicket>, winnerNumbers: WinnerNumbers): Map<LottoRanking, Int> {
    return tickets.mapNotNull { it.findRankingBy(winnerNumbers) }
            .groupingBy { it }
            .eachCount()
}

private fun LottoTicket.findRankingBy(winnerNumbers: WinnerNumbers): LottoRanking? =
        LottoRanking.from(winnerNumbers.countSameNumber(this), winnerNumbers.containsBonus(this))

private fun getTotalReward(rankingToCount: Map<LottoRanking, Int>) =
        rankingToCount.map { (ranking, count) -> ranking.reward * count }.sum()
