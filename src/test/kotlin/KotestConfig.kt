import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.config.configuration
import io.kotest.core.test.DuplicateTestNameMode

class KotestConfig: AbstractProjectConfig() {

    init {
        configuration.duplicateTestNameMode = DuplicateTestNameMode.Silent
    }
}
