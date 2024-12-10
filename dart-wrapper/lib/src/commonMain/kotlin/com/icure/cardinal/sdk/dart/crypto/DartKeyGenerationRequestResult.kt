package com.icure.cardinal.sdk.dart.crypto

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable

@Serializable
sealed interface DartKeyGenerationRequestResult {
	@Serializable
	data object Allow : DartKeyGenerationRequestResult
	@Serializable
	data object Deny : DartKeyGenerationRequestResult
	@Serializable
	data class Use(val key: Base64String) : DartKeyGenerationRequestResult
}