package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class SuspensionReason() {
	@SerialName("notInsured")
	NotInsured,

	@SerialName("noReasonGiven")
	NoReasonGiven,

	@SerialName("isHospitalized")
	IsHospitalized,

	@SerialName("outsideOfCountry")
	OutsideOfCountry,

	@SerialName("changeOfMutuality")
	ChangeOfMutuality,
}