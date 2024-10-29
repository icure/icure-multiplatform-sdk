package com.icure.cardinal.sdk.dart.options

import kotlinx.serialization.Serializable

@Serializable
sealed interface DartStorageOptions {
	@Serializable
	data object Default : DartStorageOptions
}