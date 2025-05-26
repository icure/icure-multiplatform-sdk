package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class UserAndHealthcareParty(
	public val user: User,
	public val healthcareParty: HealthcareParty,
	internal val dtoSerialName: String,
) {
	// region UserAndHealthcareParty-UserAndHealthcareParty

	// endregion
}
