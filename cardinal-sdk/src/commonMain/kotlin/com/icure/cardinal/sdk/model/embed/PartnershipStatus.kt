package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PartnershipStatus() {
	@SerialName("active")
	Active,

	@SerialName("complicated")
	Complicated,

	@SerialName("past")
	Past,
}
