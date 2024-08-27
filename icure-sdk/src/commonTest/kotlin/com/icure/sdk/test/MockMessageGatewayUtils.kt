package com.icure.sdk.test

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.requireSuccess
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.encodeURLPathPart
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

object MockMessageGatewayUtils {
	@Serializable
	data class EmailBody(
		val from: String,
		val subject: String,
		val html: String
	)

	@Serializable
	data class SMSBody(
		val message: String
	)

	@OptIn(InternalIcureApi::class)
	suspend fun getLatestEmailTo(email: String) =
		IcureSdk.sharedHttpClient.get(
			"$mockMessageGatewayUrl/$mockSpecId/lastEmail/${email.encodeURLPathPart()}"
		).wrap<EmailBody>().successBody()

	@OptIn(InternalIcureApi::class)
	suspend fun getLatestSmsTo(mobilePhone: String) =
		IcureSdk.sharedHttpClient.get(
			"$mockMessageGatewayUrl/$mockSpecId/lastSMS/${mobilePhone.encodeURLPathPart()}"
		).wrap<SMSBody>().successBody()

	suspend fun createTestProcess(
		groupId: String,
		hcpId: String,
		userType: UserType
	): String {
		val processId = defaultCryptoService.strongRandom.randomUUID()
		IcureSdk.sharedHttpClient.post("$mockMessageGatewayUrl/$mockSpecId/customProcess/${processId}") {
			contentType(ContentType.Application.Json)
			setBody(JsonObject(mapOf(
				"hcpId" to JsonPrimitive(hcpId),
				"userType" to JsonPrimitive(userType.serialName),
				"groupId" to JsonPrimitive(groupId),
			)))
		}.requireSuccess()
		return processId
	}

	enum class UserType(
		val serialName: String
	) {
		Patient("PATIENT"),
		Hcp("HCP"),
		Organization("ORGANIZATION"),
		Practitioner("PRACTITIONER"),
	}
}

