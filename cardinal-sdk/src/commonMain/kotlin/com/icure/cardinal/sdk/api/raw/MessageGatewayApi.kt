package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.Captcha
import com.icure.cardinal.sdk.auth.Captcha.*
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.keberus.Challenge
import com.icure.keberus.resolveChallenge
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.encodeToJsonElement

@InternalIcureApi
class RawMessageGatewayApi(
	private val client: HttpClient,
	private val cryptoService: CryptoService
) {

	private suspend fun askChallenge(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
	): Challenge {
		return client.get("${messageGatewayUrl}/${externalServicesSpecId}/challenge").body()
	}

	suspend fun startProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		captcha: Captcha,
		firstName: String?,
		lastName: String?,
		userTelecom: String,
		userTelecomType: AuthenticationProcessTelecomType
	): String {
		val kerberusSolution = when (captcha) {
			is Kerberus -> {
				when(captcha) {
					is Kerberus.Computed -> captcha.solution
					is Kerberus.Delegated -> {
						val challenge = askChallenge(messageGatewayUrl, externalServicesSpecId)
						resolveChallenge(challenge, externalServicesSpecId, cryptoService, captcha.onProgress ?: {})
					}
				}
			}
			else -> null
		}

		val requestBodyJson = JsonObject(mapOf(
			"firstName" to JsonPrimitive(firstName ?: ""),
			"lastName" to JsonPrimitive(lastName ?: ""),
			when (captcha) {
				is Recaptcha -> "g-recaptcha-response" to JsonPrimitive(captcha.solution)
				is FriendlyCaptcha -> "friendly-captcha-response" to JsonPrimitive(captcha.solution)
				is Kerberus -> "kerberus-response" to Serialization.json.encodeToJsonElement(kerberusSolution)
			},
			"email" to JsonPrimitive(if (userTelecomType == AuthenticationProcessTelecomType.Email) userTelecom else ""),
			"mobilePhone" to JsonPrimitive(if (userTelecomType == AuthenticationProcessTelecomType.MobilePhone) userTelecom else ""),
		))
		val requestId = cryptoService.strongRandom.randomUUID()
		client.post("${messageGatewayUrl}/${externalServicesSpecId}/process/${processId}/${requestId}") {
			contentType(ContentType.Application.Json)
			setBody(requestBodyJson)
		}.wrap<String>().successBody()
		return requestId
	}

	suspend fun completeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		requestId: String,
		validationCode: String
	) {
		client.get("${messageGatewayUrl}/${externalServicesSpecId}/process/validate/${requestId}-${validationCode}").requireSuccess()
	}
}
