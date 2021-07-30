package ui

import IO
import domain.*

class LottoGameController(private val numberGenerator: RandomNumberGenerator) {

    fun buyTickets(): List<LottoTicket> {
        val ticketCounts = LottoTicketCounts.from(LottoMoney(IO.inputMoney()), IO.inputManualTicketCount())
        IO.printTicketCounts(ticketCounts)

        val tickets = mutableListOf<LottoTicket>()
        while (ticketCounts.isManualRemain) {
            tickets.add(LottoTicket(IO.inputLottoNumbers()))
            ticketCounts.useManualTicket()
        }
        while (ticketCounts.isAutoRemain) {
            tickets.add(buyAutoTicket())
            ticketCounts.useAutoTicket()
        }
        return tickets
    }

    fun getWinnerNumbers(): WinnerNumbers {
        return WinnerNumbers(IO.inputWinnerNumbers(), IO.inputBonusNumber())
    }

    fun getStatistics(tickets: List<LottoTicket>, winnerNumbers: WinnerNumbers) {
        IO.printWinningStatistics(LottoStatistics(tickets, winnerNumbers))
    }

    private fun buyAutoTicket(): LottoTicket {
        return LottoTicket(numberGenerator.generateSixInts())
                .also { IO.printTicketNumbers(it) }
    }

}
