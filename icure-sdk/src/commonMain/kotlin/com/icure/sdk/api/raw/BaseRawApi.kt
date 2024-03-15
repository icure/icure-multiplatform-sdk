package com.icure.sdk.api.raw

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlin.time.Duration

abstract class BaseRawApi(
	additionalHeaders: Map<String, String>,
	requestTimeout : Duration?
) {

	protected val httpClient = HttpClient {
		install(ContentNegotiation) {
			json()
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
}