package domain

class LottoTicketCounts private constructor(
        val manualCount: LottoTicketCount,
        val autoCount: LottoTicketCount,
) {
    fun useManualTicket() {
        manualCount.useTicket()
    }

    fun useAutoTicket() {
        autoCount.useTicket()
    }

    val isManualRemain: Boolean
        get() = manualCount.isTicketRemain()

    val isAutoRemain: Boolean
        get() = autoCount.isTicketRemain()

    companion object {
        fun from(money: LottoMoney, manualCount: Int): LottoTicketCounts {
            val manualTicketCount = LottoTicketCount(manualCount)
            val autoTicketCount = LottoTicketCount.from(money - manualTicketCount.price)
            return LottoTicketCounts(manualTicketCount, autoTicketCount)
        }
    }
}
