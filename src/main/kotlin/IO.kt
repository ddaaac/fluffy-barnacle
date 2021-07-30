import domain.LottoStatistics
import domain.LottoTicket
import domain.LottoTicketCounts

private val NEW_LINE = System.lineSeparator()

object IO {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: throw RuntimeException()
    }

    fun inputManualTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해주세요.")
        return readLine()?.toInt() ?: throw RuntimeException()
    }

    fun inputLottoNumbers(): List<Int> {
        println("수동으로 구매할 번호를 입력해주세요.")
        return getLottoNumbers()
    }

    fun inputWinnerNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return getLottoNumbers()
    }

    private fun getLottoNumbers(): List<Int> {
        val numbers = readLine() ?: throw RuntimeException()
        return numbers.split(",")
                .map { it.trim().toInt() }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()?.toInt() ?: throw RuntimeException()
    }


    fun printTicketCounts(ticketCounts: LottoTicketCounts) {
        println("수동으로 ${ticketCounts.manualCount.value}장, 자동으로 ${ticketCounts.autoCount.value}장 구매했습니다.")
    }

    fun printTicketNumbers(lottoTicket: LottoTicket) {
        println(lottoTicket.numbers.numbers.joinToString(",") { it.value.toString() })
    }

    fun printWinningStatistics(lottoRankingCount: LottoStatistics) {
        println("당첨 통계")
        for ((key, value) in lottoRankingCount.countByRanking.entries) {
            println("${key.name}등 : ${value}번")
        }
        println("총 수익률은 ${lottoRankingCount.revenue}입니다.")
    }
}
