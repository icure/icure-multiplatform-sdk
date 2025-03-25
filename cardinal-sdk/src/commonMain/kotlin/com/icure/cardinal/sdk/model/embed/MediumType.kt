package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MediumType() {
	@SerialName("cdrom")
	Cdrom,

	@SerialName("eattest")
	Eattest,

	@SerialName("efact")
	Efact,

	@SerialName("email")
	Email,

	@SerialName("mediprima")
	Mediprima,

	@SerialName("paper")
	Paper,

	@SerialName("stat")
	Stat,
}
