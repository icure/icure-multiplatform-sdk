package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.auth.AuthenticationProcessCaptchaType
import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@InternalIcureApi
class RawMessageGatewayApi(
	private val client: HttpClient,
	private val cryptoService: CryptoService
) {

	suspend fun startProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		captchaType: AuthenticationProcessCaptchaType,
		captchaKey: String,
		firstName: String?,
		lastName: String?,
		userTelecom: String,
		userTelecomType: AuthenticationProcessTelecomType
	): String {
		val requestBodyJson = JsonObject(mapOf(
			"firstName" to JsonPrimitive(firstName ?: ""),
			"lastName" to JsonPrimitive(lastName ?: ""),
			when (captchaType) {
				AuthenticationProcessCaptchaType.Recaptcha -> "g-recaptcha-response"
				AuthenticationProcessCaptchaType.FriendlyCaptcha -> "friendly-captcha-response"
			} to JsonPrimitive(captchaKey),
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
