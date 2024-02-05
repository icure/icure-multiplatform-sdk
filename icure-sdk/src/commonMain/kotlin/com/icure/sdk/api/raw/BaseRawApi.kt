package com.icure.sdk.api.raw

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

class BaseRawApi {

	protected val httpClient = HttpClient {
		install(ContentNegotiation) {
			json()
		}
	}
}