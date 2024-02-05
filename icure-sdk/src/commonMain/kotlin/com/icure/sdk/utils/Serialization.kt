package com.icure.sdk.utils

import kotlinx.serialization.json.Json

object Serialization {
	val json = Json {
		encodeDefaults = false
		// TODO this is temporary, as long as I don't have the real models. Later we change
		println("Temporarily we are ignoring unknown keys")
		ignoreUnknownKeys = true
	}
	val lenientJson = Json {
		encodeDefaults = false
		ignoreUnknownKeys = true
	}
}