package com.icure.sdk

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.UnionFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.newPlatformHttpClient
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.*
import io.ktor.http.content.TextContent
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Contextual
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.encodeToJsonElement

class SetBodyTest: StringSpec({

	"Should be able to serialize filter" {
		val filterSpecific: AbstractFilter<HealthcareParty> = HealthcarePartyByIdsFilter(setOf("whatever"))
		val filterGeneric: AbstractFilter<out Identifiable<String>> = filterSpecific
		val filterJson = JsonObject(mapOf(
			"\$type" to JsonPrimitive("HealthcarePartyByIdsFilter"),
			"ids" to JsonArray(listOf(JsonPrimitive("whatever"))),
		))
		val unionFilterSpecific: UnionFilter<HealthcareParty> = UnionFilter(filters = listOf(filterSpecific))
		val unionFilterGeneric: UnionFilter<out Identifiable<String>> = unionFilterSpecific
		val unionFilterJson = JsonObject(mapOf(
			"\$type" to JsonPrimitive("UnionFilter"),
			"filters" to JsonArray(listOf(filterJson)),
		))
		val unionFilterNoTypeJson = JsonObject(mapOf(
			"filters" to JsonArray(listOf(filterJson)),
		))
		val filterChainUnionSpecific = FilterChain(unionFilterSpecific)
		val filterChainUnionGeneric = FilterChain(unionFilterGeneric)
		val filterChainUnionJson = JsonObject(mapOf(
			"filter" to unionFilterJson,
		))
		val filterChainByIdsJson = JsonObject(mapOf(
			"filter" to filterJson,
		))
		Serialization.json.encodeToJsonElement(FilterChain(unionFilterSpecific)) shouldBe filterChainUnionJson
		Serialization.json.encodeToJsonElement(FilterChain(unionFilterGeneric)) shouldBe filterChainUnionJson
		Serialization.json.encodeToJsonElement(FilterChain(filterSpecific)) shouldBe filterChainByIdsJson
		Serialization.json.encodeToJsonElement(FilterChain(filterGeneric)) shouldBe filterChainByIdsJson
		Serialization.json.encodeToJsonElement(unionFilterSpecific) shouldBe unionFilterNoTypeJson
		Serialization.json.encodeToJsonElement(unionFilterGeneric) shouldBe unionFilterNoTypeJson
		// Currently there is a bug with `encodeToJsonElement` https://github.com/Kotlin/kotlinx.serialization/issues/2535
		Serialization.json.encodeToString<@Contextual AbstractFilter<HealthcareParty>>(filterSpecific) shouldBe filterJson.toString()
		Serialization.json.encodeToString<@Contextual AbstractFilter<out Identifiable<String>>>(filterGeneric) shouldBe filterJson.toString()
	}

})
