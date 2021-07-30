package domain

const val MONEY_PER_TICKET = 1000

@JvmInline
value class LottoMoney(val value: Int) {

    init {
        require(value >= 0) { "금액은 0 이상입니다" }
        require(value % MONEY_PER_TICKET == 0) { "1000원 단위의 금액만 허용합니다" }
    }
}

operator fun LottoMoney.minus(other: LottoMoney): LottoMoney {
    return LottoMoney(value - other.value)
}

operator fun LottoMoney.div(other: Int): Int {
    return value / other
}

operator fun Double.div(other: LottoMoney): Double {
    return this / other.value
}
