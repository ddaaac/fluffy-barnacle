package domain

class WinnerNumbers(numbers: Collection<Int>, bonusNumber: Int) {

    val numbers = LottoNumbers(numbers)
    val bonusNumber = LottoNumber(bonusNumber)

    init {
        require(!this.numbers.contains(this.bonusNumber)) { "당첨번호와 보너스번호는 중복되면 안됩니다" }
    }
}
