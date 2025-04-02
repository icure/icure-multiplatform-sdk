package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DeactivationReason() {
	@SerialName("deceased")
	Deceased,

	@SerialName("moved")
	Moved,

	@SerialName("other_doctor")
	OtherDoctor,

	@SerialName("retired")
	Retired,

	@SerialName("no_contact")
	NoContact,

	@SerialName("unknown")
	Unknown,

	@SerialName("none")
	None,
}
