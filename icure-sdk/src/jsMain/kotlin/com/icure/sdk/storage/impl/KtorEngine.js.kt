package com.icure.sdk.utils

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.js.Js

actual val KtorEngine: HttpClientEngineFactory<HttpClientEngineConfig> = Js
