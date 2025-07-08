package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.api.impl.AnonymousSdkImpl
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousApiImpl
import com.icure.cardinal.sdk.options.AnonymousSdkOptions
import com.icure.cardinal.sdk.options.configuredClientOrDefault
import com.icure.cardinal.sdk.options.configuredJsonOrDefault
import com.icure.utils.InternalIcureApi

interface CardinalAnonymousSdk : AnonymousApis {

	companion object {
		@OptIn(InternalIcureApi::class)
		fun initialize(
			baseUrl: String,
			options: AnonymousSdkOptions = AnonymousSdkOptions(),
		): CardinalAnonymousSdk {
			val rawApiConfig = RawApiConfig(
				httpClient = options.configuredClientOrDefault(),
				json = options.configuredJsonOrDefault(),
				requestTimeout = options.requestTimeout,
				additionalHeaders = emptyMap(),
				retryConfiguration = options.requestRetryConfiguration
			)
			return AnonymousSdkImpl(
				rawAnonymousApi = RawAnonymousApiImpl(
					apiUrl = baseUrl,
					rawApiConfig = rawApiConfig
				)
			)
		}
	}

}
