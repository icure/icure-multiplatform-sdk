package banana

import io.kotest.core.spec.style.StringSpec
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromDynamic
import kotlinx.serialization.json.encodeToDynamic

class Example : StringSpec({
	"Encode to/from dynamic behaviour" {
		val obj = JsonObject(mapOf("a" to JsonArray(listOf(JsonPrimitive(1.23), JsonPrimitive(false))), "b" to JsonPrimitive("c"), "c" to JsonNull))
		println(JSON.stringify(Json.encodeToDynamic<JsonElement>(obj)))
		val obj2 = Json.decodeFromDynamic<JsonElement>(Json.encodeToDynamic<JsonElement>(obj))

	}
})