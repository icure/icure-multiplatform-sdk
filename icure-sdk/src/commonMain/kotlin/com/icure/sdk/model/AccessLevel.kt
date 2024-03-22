package com.icure.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AccessLevel {
	@SerialName("READ")
	Read,

	@SerialName("WRITE")
	Write
}