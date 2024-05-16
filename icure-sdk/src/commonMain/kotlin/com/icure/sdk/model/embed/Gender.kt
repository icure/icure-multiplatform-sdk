package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class Gender(
	public val code: String,
) {
	@SerialName("male")
	Male("M"),

	@SerialName("female")
	Female("F"),

	@SerialName("indeterminate")
	Indeterminate("I"),

	@SerialName("changed")
	Changed("C"),

	@SerialName("changedToMale")
	ChangedToMale("Y"),

	@SerialName("changedToFemale")
	ChangedToFemale("X"),

	@SerialName("unknown")
	Unknown("U"),
}
