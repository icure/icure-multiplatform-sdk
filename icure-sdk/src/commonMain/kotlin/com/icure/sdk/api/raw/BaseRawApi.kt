package com.icure.sdk.api.raw

import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.platformHttpClient
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlin.time.Duration

abstract class BaseRawApi(
	additionalHeaders: Map<String, String>,
	requestTimeout : Duration?
) {

	companion object {
		private const val ACCESS_CONTROL_KEYS_HEADER = "Icure-Access-Control-Keys"
	}

	protected open suspend fun getAccessControlKeysHeaderValues(): List<String>? = null

	protected val httpClient = platformHttpClient {
		install(ContentNegotiation) {
			json(json = Serialization.json)
		}
		requestTimeout?.also {
			install(HttpTimeout) {
				requestTimeoutMillis = requestTimeout.inWholeMilliseconds
			}
		}

		headers {
			additionalHeaders.filterKeys {
				it.lowercase() != "content-type"
			}.forEach { (header, headerValue) ->
				set(header, headerValue)
			}
		}
	}

	private suspend fun HttpRequestBuilder.addAccessControlKeys() {
		getAccessControlKeysHeaderValues()?.forEach {
			header(ACCESS_CONTROL_KEYS_HEADER, it)
		}
	}

	protected suspend fun get(block: suspend HttpRequestBuilder.() -> Unit) = httpClient.get {
		block()
		addAccessControlKeys()
	}

	protected suspend fun post(block: suspend HttpRequestBuilder.() -> Unit) = httpClient.post {
		block()
		addAccessControlKeys()
	}

	protected suspend fun put(block: suspend HttpRequestBuilder.() -> Unit) = httpClient.put {
		block()
		addAccessControlKeys()
	}

	protected suspend fun delete(block: suspend HttpRequestBuilder.() -> Unit) = httpClient.delete {
		block()
		addAccessControlKeys()
	}
}
