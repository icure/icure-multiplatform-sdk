package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.winhttp.WinHttp

actual fun newPlatformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient = HttpClient(WinHttp) {
	sharedConfig()
}

