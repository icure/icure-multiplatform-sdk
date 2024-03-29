package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PersonalStatus() {
	@SerialName("single")
	Single,

	@SerialName("in_couple")
	InCouple,

	@SerialName("married")
	Married,

	@SerialName("separated")
	Separated,

	@SerialName("divorced")
	Divorced,

	@SerialName("divorcing")
	Divorcing,

	@SerialName("widowed")
	Widowed,

	@SerialName("widower")
	Widower,

	@SerialName("complicated")
	Complicated,

	@SerialName("unknown")
	Unknown,

	@SerialName("contract")
	Contract,

	@SerialName("other")
	Other,

	@SerialName("annulled")
	Annulled,

	@SerialName("polygamous")
	Polygamous,
}
