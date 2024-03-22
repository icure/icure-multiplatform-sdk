package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin

actual fun platformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient = HttpClient(Darwin) {
	sharedConfig()
}