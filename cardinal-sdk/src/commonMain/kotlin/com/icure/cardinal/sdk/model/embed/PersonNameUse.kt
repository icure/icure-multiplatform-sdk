package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PersonNameUse() {
	@SerialName("usual")
	Usual,

	@SerialName("official")
	Official,

	@SerialName("temp")
	Temp,

	@SerialName("nickname")
	Nickname,

	@SerialName("anonymous")
	Anonymous,

	@SerialName("maiden")
	Maiden,

	@SerialName("old")
	Old,

	@SerialName("other")
	Other,
}
