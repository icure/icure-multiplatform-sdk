package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Confidentiality() {
	@SerialName("freeaccess")
	Freeaccess,

	@SerialName("personal")
	Personal,

	@SerialName("secret")
	Secret,
}
