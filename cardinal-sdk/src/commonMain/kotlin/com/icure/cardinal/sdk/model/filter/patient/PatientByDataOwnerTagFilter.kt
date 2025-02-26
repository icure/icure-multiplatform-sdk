package com.icure.cardinal.sdk.model.filter.patient

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByDataOwnerTagFilter")
@Serializable
data class PatientByDataOwnerTagFilter(
	public val desc: String? = null,
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
) {
	// region PatientByDataOwnerTagFilter-PatientByDataOwnerTagFilter
	// endregion
}
