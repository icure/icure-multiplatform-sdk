package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.auth.minAuthClassForLevel
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.AuthService
import com.icure.cardinal.sdk.auth.services.setAuthorizationWith
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.RequestStatusException
import io.ktor.client.HttpClient
import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.http.headers
import kotlinx.serialization.json.Json
import kotlin.time.Duration

@InternalIcureApi
abstract class BaseRawApi(
	internal val httpClient: HttpClient,
	private val additionalHeaders: Map<String, String>,
	private val requestTimeout : Duration?,
	private val json: Json
) {
	init {
		require (additionalHeaders.keys.none { it.lowercase() == "content-type" }) {
			"You are not allowed to specify Content-Type header: it is automatically set on each request as needed."
		}
	}

	companion object {
		internal const val ACCESS_CONTROL_KEYS_HEADER = "Icure-Access-Control-Keys"
	}

	protected open suspend fun getAccessControlKeysHeaderValues(): List<String>? = null

	private suspend fun HttpRequestBuilder.addAccessControlKeys() {
		getAccessControlKeysHeaderValues()?.forEach {
			header(ACCESS_CONTROL_KEYS_HEADER, it)
		}
	}

	protected suspend fun get(authProvider: AuthProvider? = null, block: suspend HttpRequestBuilder.() -> Unit) = requestAndRetryOnUnauthorized(HttpMethod.Get, authProvider?.getAuthService(), null, block)

	protected suspend fun post(authProvider: AuthProvider? = null, block: suspend HttpRequestBuilder.() -> Unit) = requestAndRetryOnUnauthorized(HttpMethod.Post, authProvider?.getAuthService(), null, block)

	protected suspend fun put(authProvider: AuthProvider? = null, block: suspend HttpRequestBuilder.() -> Unit) = requestAndRetryOnUnauthorized(HttpMethod.Put, authProvider?.getAuthService(), null, block)

	protected suspend fun delete(authProvider: AuthProvider? = null, block: suspend HttpRequestBuilder.() -> Unit) = requestAndRetryOnUnauthorized(HttpMethod.Delete, authProvider?.getAuthService(), null, block)

	private suspend fun requestAndRetryOnUnauthorized(method: HttpMethod, authService: AuthService?, authenticationClass: AuthenticationClass?, block: suspend HttpRequestBuilder.() -> Unit): HttpResponse {
		val response = request(method, authService, authenticationClass, block)
		return if (authService != null && response.status == HttpStatusCode.Unauthorized) {
			val requiredAuthClass = response.headers["Icure-Minimum-Required-Auth-Level"]?.let { minAuthClassForLevel(it.toInt()) }
			authService.invalidateCurrentAuthentication(
				RequestStatusException(response.call.request.method, response.call.request.url.toString(), response.status.value),
				requiredAuthClass
			)
			return requestAndRetryOnUnauthorized(
				method = method,
				authService = authService,
				authenticationClass = requiredAuthClass,
				block = block
			)
		} else {
			response
		}
	}

	private suspend fun request(method: HttpMethod, authService: AuthService?, authenticationClass: AuthenticationClass?, block: suspend HttpRequestBuilder.() -> Unit) =
		httpClient.request {
			this.method = method
			headers {
				additionalHeaders.forEach { (header, headerValue) ->
					set(header, headerValue)
				}
			}
			requestTimeout?.also {
				timeout {
					requestTimeoutMillis = it.inWholeMilliseconds
				}
			}
			authService?.also {
				setAuthorizationWith(it, authenticationClass)
			}
			block()
			addAccessControlKeys()
		}

	protected fun <T> HttpRequestBuilder.setBodyWithSerializer(serializer: kotlinx.serialization.KSerializer<T>, body: T) = this.setBody(
		TextContent(
			json.encodeToString(serializer, body),
			ContentType.Application.Json
		)
	)
}
