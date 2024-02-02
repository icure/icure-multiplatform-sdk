package com.icure.sdk.utils

import kotlinx.serialization.json.Json

object Serialization {
	val json = Json {
		encodeDefaults = false
		ignoreUnknownKeys = false
	}
}