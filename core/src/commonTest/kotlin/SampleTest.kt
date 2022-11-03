import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

@Serializable
data class Example(val a: String, val b: Double)

class SampleTest : StringSpec({
    "Ktor get should work".config(enabled = false) {
        HttpClient().get("https://echo.zuplo.io/").also { println(it) }.status shouldBe HttpStatusCode.OK
    }

    "Ktor post should work".config(enabled = false) {
        val example = Example("banana", 1.234)
        HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }.post("https://echo.zuplo.io/") {
            contentType(ContentType.Application.Json)
            setBody(example)
        }.apply {
            status shouldBe HttpStatusCode.OK
            contentType() shouldBe ContentType.Application.Json
            Json.decodeFromJsonElement<Example>(body<JsonElement>().jsonObject.getValue("body")) shouldBe example
        }
    }
})