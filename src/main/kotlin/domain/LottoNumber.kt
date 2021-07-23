package domain

@JvmInline
value class LottoNumber(val value: Int) {

    init {
        require(value in 1..45) { " 로또 번호는 1이상 45이하 정수입니다" }
    }
}
