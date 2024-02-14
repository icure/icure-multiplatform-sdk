package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun platformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient
