package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PersonNameUse() {
	@SerialName("usual")
	Usual("usual"),

	@SerialName("official")
	Official("official"),

	@SerialName("temp")
	Temp("temp"),

	@SerialName("nickname")
	Nickname("nickname"),

	@SerialName("anonymous")
	Anonymous("anonymous"),

	@SerialName("maiden")
	Maiden("maiden"),

	@SerialName("old")
	Old("old"),

	@SerialName("other")
	Other("other"),
	;

	public val dtoSerialName: String
}
