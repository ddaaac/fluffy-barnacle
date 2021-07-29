package domain

private const val MONEY_PER_TICKET_VALUE = 1000
val MONEY_PER_TICKET: LottoMoney = LottoMoney(MONEY_PER_TICKET_VALUE)

@JvmInline
value class LottoMoney(val value: Int) {

    init {
        println()
        require(value >= 0) { "금액은 0 이상입니다" }
        require(value % MONEY_PER_TICKET_VALUE == 0) { "1000원 단위의 금액만 허용합니다" }
    }

    val ticketCount: Int get() = value / MONEY_PER_TICKET_VALUE
}

operator fun LottoMoney.times(value: Int): LottoMoney {
    return LottoMoney(this.value * value)
}

operator fun LottoMoney.minus(other: LottoMoney): LottoMoney {
    return LottoMoney(value - other.value)
}
