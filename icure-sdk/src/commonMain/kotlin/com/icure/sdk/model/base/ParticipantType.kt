package com.icure.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class ParticipantType() {
	@SerialName("Admitter")
	Admitter,

	@SerialName("Attender")
	Attender,

	@SerialName("CallbackContact")
	CallbackContact,

	@SerialName("Consultant")
	Consultant,

	@SerialName("Discharger")
	Discharger,

	@SerialName("Escort")
	Escort,

	@SerialName("Referrer")
	Referrer,

	@SerialName("SecondaryPerformer")
	SecondaryPerformer,

	@SerialName("PrimaryPerformer")
	PrimaryPerformer,

	@SerialName("Participation")
	Participation,

	@SerialName("Translator")
	Translator,

	@SerialName("Emergency")
	Emergency,

	@SerialName("Location")
	Location,
}
