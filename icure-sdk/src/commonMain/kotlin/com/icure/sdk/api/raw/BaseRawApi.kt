package com.icure.sdk.api.raw

import io.ktor.client.HttpClient
import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.headers
import kotlin.time.Duration

abstract class BaseRawApi(
	internal val httpClient: HttpClient,
	private val additionalHeaders: Map<String, String>,
	private val requestTimeout : Duration?
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

	protected suspend fun get(block: suspend HttpRequestBuilder.() -> Unit) = request(HttpMethod.Get, block)

	protected suspend fun post(block: suspend HttpRequestBuilder.() -> Unit) = request(HttpMethod.Post, block)

	protected suspend fun put(block: suspend HttpRequestBuilder.() -> Unit) = request(HttpMethod.Put, block)

	protected suspend fun delete(block: suspend HttpRequestBuilder.() -> Unit) = request(HttpMethod.Delete, block)

	private suspend fun request(method: HttpMethod, block: suspend HttpRequestBuilder.() -> Unit) =
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
			block()
			addAccessControlKeys()
		}
}
