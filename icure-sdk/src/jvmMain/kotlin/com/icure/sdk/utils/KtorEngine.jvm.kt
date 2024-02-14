package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.java.Java

actual fun platformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient = HttpClient(Java) {
	sharedConfig()
	engine {
		protocolVersion = java.net.http.HttpClient.Version.HTTP_2
	}
}