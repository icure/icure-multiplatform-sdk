package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun newPlatformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient

/*TODO
 * On kotlin native for linux we don't have a single engine that can handle both HTTP2 and websockets.
 * Currently we are using 2 different clients, but if https://youtrack.jetbrains.com/issue/KTOR-5199/Support-WebSockets-in-Curl-engine
 * is implemented we can go back to one client only.
 */
expect fun newPlatformWebsocketClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient

/*TODO
 * Currently there is no support for curl on linuxArm64, but it should be fixed soon
 * https://youtrack.jetbrains.com/issue/KTOR-6173/Support-ktor-client-curl-for-linuxArm64
 */
