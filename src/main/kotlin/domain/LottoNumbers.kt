package domain

abstract class LottoNumbers(val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == 6) { "중복된 번호가 존재하거나, 번호가 6개가 아닙니다" }
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    fun countSameNumbers(other: LottoNumbers): Int {
        return (numbers intersect other.numbers).size
    }
}

class LottoTicket(vararg numbers: Int) : LottoNumbers(numbers.mapToLottoNumberSet())

private fun IntArray.mapToLottoNumberSet() = mapTo(HashSet()) { LottoNumber(it) }
