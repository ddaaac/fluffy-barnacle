package domain

class WinnerNumbers(numbers: Collection<Int>, bonusNumber: Int) {

    private val numbers = LottoNumbers(numbers)
    private val bonusNumber = LottoNumber(bonusNumber)

    init {
        require(!this.numbers.contains(this.bonusNumber)) { "당첨번호와 보너스번호는 중복되면 안됩니다" }
    }

    fun countSameNumber(ticket: LottoTicket): Int {
        return ticket.countSameNumbers(numbers)
    }

    fun containsBonus(ticket: LottoTicket): Boolean {
        return ticket.contains(bonusNumber)
    }
}
