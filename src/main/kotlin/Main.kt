import domain.RandomNumberGenerator
import ui.LottoGameController

class AppContext(
        val numberGenerator: RandomNumberGenerator = RandomNumberGenerator(),
        val gameController: LottoGameController = LottoGameController(numberGenerator),
)


fun main() {
    val ctx = AppContext()
    val gameController = ctx.gameController

    val tickets = gameController.buyTickets()
    val winnerNumbers = gameController.getWinnerNumbers()
    gameController.getStatistics(tickets, winnerNumbers)
}
