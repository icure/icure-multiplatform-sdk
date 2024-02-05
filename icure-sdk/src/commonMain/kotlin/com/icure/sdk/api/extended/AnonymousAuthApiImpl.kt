/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
	"ArrayInDataClass",
	"EnumEntryName",
	"RemoveRedundantQualifierName",
	"UnusedImport"
)

package com.icure.sdk.api.extended

import com.icure.sdk.api.raw.ApiClient
import com.icure.sdk.auth.Jwt
import com.icure.sdk.auth.ThirdPartyProvider
import io.ktor.client.call.body
import kotlinx.serialization.Serializable
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod

open class AnonymousAuthApiImpl(
	baseUrl: String,
) : ApiClient(baseUrl, null), AnonymousAuthApi {
	@Serializable
	data class LoginCredentials(
		val username: String,
		val password: String
	)

	@Serializable
	data class JwtResponse(
		val token: String? = null,
		val refreshToken: String? = null,
		val successful: Boolean
	)

	override suspend fun login(username: String, password: String): Jwt {
		val localVariableBody = LoginCredentials(username, password)

		val localVariableQuery = mutableMapOf<String, List<String>>()
		val localVariableHeaders = mutableMapOf<String, String>()

		val localVariableConfig = RequestConfig<Any?>(
			RequestMethod.POST,
			"/rest/v2/auth/login",
			query = localVariableQuery,
			headers = localVariableHeaders,
			requiresAuthentication = false,
		)

		val response: JwtResponse = jsonRequest(
			localVariableConfig,
			localVariableBody,
		).body()

		if (!response.successful) throw IllegalArgumentException("Invalid credentials?")
		check(response.token != null && response.refreshToken != null) { "Token is null" }
		return Jwt(response.token, response.refreshToken)
	}

	override suspend fun loginWithThirdPartyToken(thirdPartyProvider: ThirdPartyProvider, token: String): Jwt {
		TODO("This is not really raw api...")
	}

	override suspend fun refresh(refreshJwt: String): Jwt {
		val localVariableBody =
			io.ktor.client.utils.EmptyContent

		val localVariableQuery = mutableMapOf<String, List<String>>()
		val localVariableHeaders = mutableMapOf<String, String>()
		localVariableHeaders["Refresh-Token"] = "Bearer $refreshJwt"

		val localVariableConfig = RequestConfig<kotlin.Any?>(
			RequestMethod.POST,
			"/rest/v2/auth/refresh",
			query = localVariableQuery,
			headers = localVariableHeaders,
			requiresAuthentication = false,
		)

		val response: JwtResponse = request(
			localVariableConfig,
			localVariableBody,
		).body()

		if (!response.successful) throw IllegalArgumentException("Invalid credentials?")
		check(response.token != null && response.refreshToken != null) { "Token is null" }
		return Jwt(response.token, response.refreshToken)
	}
}
