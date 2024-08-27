package com.icure.sdk.api.raw

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.auth.AuthenticationProcessCaptchaType
import com.icure.sdk.auth.AuthenticationProcessTelecomType
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

class RawMessageGatewayApi(
	private val client: HttpClient
) {
	@OptIn(InternalIcureApi::class)
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
		val requestId = defaultCryptoService.strongRandom.randomUUID()
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
