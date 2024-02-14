package com.icure.sdk.utils

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

expect val KtorEngine: HttpClientEngineFactory<HttpClientEngineConfig>