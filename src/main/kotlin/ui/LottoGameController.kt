package ui

import IO
import domain.LottoMoney
import domain.LottoTicket
import domain.LottoTicketCounts
import domain.RandomNumberGenerator

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

    private fun buyAutoTicket(): LottoTicket {
        return LottoTicket(numberGenerator.generateSixInts())
                .also { IO.printTicketNumbers(it) }
    }

}
