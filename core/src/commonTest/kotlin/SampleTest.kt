import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SampleTest : StringSpec({
    "($platform) Should make lowercase" {
        "A".lowercase() shouldBe "a"
    }
})