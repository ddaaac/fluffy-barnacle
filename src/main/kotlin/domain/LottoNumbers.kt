package domain

class LottoNumbers(numbers: Collection<Int>) {

    val numbers: Set<LottoNumber> = numbers.mapToLottoNumberSet()

    init {
        require(this.numbers.size == 6) { "중복된 번호가 존재하거나, 번호가 6개가 아닙니다" }
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    fun countSameNumbers(other: LottoNumbers): Int {
        return (numbers intersect other.numbers).size
    }
}

private fun Collection<Int>.mapToLottoNumberSet() = mapTo(HashSet()) { LottoNumber(it) }

class LottoTicket(numbers: Collection<Int>) {

    val numbers = LottoNumbers(numbers)

    fun contains(number: LottoNumber) = numbers.contains(number)

    fun countSameNumbers(other: LottoNumbers): Int = numbers.countSameNumbers(other)
}
