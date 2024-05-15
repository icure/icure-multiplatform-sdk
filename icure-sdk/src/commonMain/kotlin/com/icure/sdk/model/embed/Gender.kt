package com.icure.sdk.model.embed

import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class Gender(
	public val code: String,
) {
	@SerialName("male")
	@DefaultValue("M")
	Male("M"),

	@SerialName("female")
	@DefaultValue("F")
	Female("F"),

	@SerialName("indeterminate")
	@DefaultValue("I")
	Indeterminate("I"),

	@SerialName("changed")
	@DefaultValue("C")
	Changed("C"),

	@SerialName("changedToMale")
	@DefaultValue("Y")
	ChangedToMale("Y"),

	@SerialName("changedToFemale")
	@DefaultValue("X")
	ChangedToFemale("X"),

	@SerialName("unknown")
	@DefaultValue("U")
	Unknown("U"),
}
