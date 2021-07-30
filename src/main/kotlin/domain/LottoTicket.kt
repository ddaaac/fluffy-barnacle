package domain

class LottoTicket(numbers: Collection<Int>) {

    val numbers = LottoNumbers(numbers)

    fun contains(number: LottoNumber) = numbers.contains(number)

    fun countSameNumbers(other: LottoNumbers): Int = numbers.countSameNumbers(other)
}
