package com.icure.sdk.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun newPlatformHttpClient(
	sharedConfig: HttpClientConfig<*>.() -> Unit
): HttpClient

/*TODO
 * Currently there is no support for curl on linuxArm64, but it should be fixed soon
 * https://youtrack.jetbrains.com/issue/KTOR-6173/Support-ktor-client-curl-for-linuxArm64
 */
