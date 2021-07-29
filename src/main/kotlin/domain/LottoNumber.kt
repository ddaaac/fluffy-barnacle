package domain

val VALID_LOTTO_NUMBER_RANGE = 1..45

@JvmInline
value class LottoNumber(val value: Int) {

    init {
        require(value in VALID_LOTTO_NUMBER_RANGE) { " 로또 번호는 1이상 45이하 정수입니다" }
    }
}
