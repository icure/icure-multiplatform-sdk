package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.CardinalSdk.Companion.sharedHttpClient
import com.icure.cardinal.sdk.CardinalSdk.Companion.sharedHttpClientUsingLenientJson
import com.icure.cardinal.sdk.options.CommonSdkOptions
import com.icure.cardinal.sdk.utils.Serialization

internal fun CommonSdkOptions.configuredClientOrDefault() = this.httpClient ?: (if (this.lenientJson) sharedHttpClientUsingLenientJson else sharedHttpClient)

internal fun CommonSdkOptions.configuredJsonOrDefault() = this.httpClientJson ?: (if (this.lenientJson) Serialization.lenientJson else Serialization.json)
