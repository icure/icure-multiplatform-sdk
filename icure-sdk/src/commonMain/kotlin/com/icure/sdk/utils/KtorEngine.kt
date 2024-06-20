package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun newPlatformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient

/*TODO
 * On kotlin native for linux we don't have a single engine that can handle both HTTP2 and websockets. We can use two
 * different clients, or we can wait for https://youtrack.jetbrains.com/issue/KTOR-5199/Support-WebSockets-in-Curl-engine.
 * Also, currently there is no support for curl on linuxArm64, but it should be fixed soon
 * https://youtrack.jetbrains.com/issue/KTOR-6173/Support-ktor-client-curl-for-linuxArm64
 */
