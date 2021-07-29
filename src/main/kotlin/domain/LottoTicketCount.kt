package domain

class LottoTicketCount(val value: Int) {

    init {
        require(value >= 0) { "티켓 갯수는 0 이상의 정수입니다" }
    }

    companion object {
        fun from(money: LottoMoney) = LottoTicketCount(money.ticketCount)
    }

    val price: LottoMoney = MONEY_PER_TICKET * value

    private var remain: Int = value

    fun isTicketRemain(): Boolean {
        return remain > 0
    }

    fun useTicket() {
        require(isTicketRemain()) { "티켓을 모두 사용했습니다" }

        remain--
    }
}
