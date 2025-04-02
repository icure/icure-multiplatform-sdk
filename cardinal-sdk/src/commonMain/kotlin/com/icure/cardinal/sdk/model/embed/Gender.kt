package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Gender(
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
