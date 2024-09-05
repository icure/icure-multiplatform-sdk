package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class HealthcarePartyHistoryStatus(
	public val status: HealthcarePartyStatus,
	public val specialisationCode: String,
	public val startDate: Long,
	public val active: Boolean,
) {
	// region HealthcarePartyHistoryStatus-HealthcarePartyHistoryStatus

	// endregion
}
