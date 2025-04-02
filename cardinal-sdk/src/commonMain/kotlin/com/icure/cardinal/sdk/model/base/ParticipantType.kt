package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ParticipantType() {
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
