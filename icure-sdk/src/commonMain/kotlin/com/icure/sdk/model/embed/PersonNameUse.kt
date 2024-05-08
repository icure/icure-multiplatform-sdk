package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PersonNameUse() {
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
