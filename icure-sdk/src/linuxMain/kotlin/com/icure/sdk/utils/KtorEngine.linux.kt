package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.curl.Curl

actual fun newPlatformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient = HttpClient(Curl) {
	sharedConfig()
}

actual fun newPlatformWebsocketClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient = HttpClient(CIO) {
	sharedConfig()
}
