package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class ParticipantType() {
	@SerialName("admitter")
	Admitter,

	@SerialName("attender")
	Attender,

	@SerialName("callback")
	CallbackContact,

	@SerialName("consultant")
	Consultant,

	@SerialName("discharger")
	Discharger,

	@SerialName("escort")
	Escort,

	@SerialName("referrer")
	Referrer,

	@SerialName("secondaryPerformer")
	SecondaryPerformer,

	@SerialName("primaryPerformer")
	PrimaryPerformer,

	@SerialName("participation")
	Participation,

	@SerialName("translator")
	Translator,

	@SerialName("emergency")
	Emergency,

	@SerialName("location")
	Location,
}
