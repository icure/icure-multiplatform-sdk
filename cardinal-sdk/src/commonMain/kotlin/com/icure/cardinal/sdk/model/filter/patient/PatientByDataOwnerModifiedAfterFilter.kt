package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByDataOwnerModifiedAfterFilter")
@Serializable
data class PatientByDataOwnerModifiedAfterFilter(
	public val dataOwnerId: String,
	public val startDate: Long?,
	public val endDate: Long?,
	public val descending: Boolean?,
	override val desc: String?,
) : AbstractFilter<Patient> {
	// region PatientByDataOwnerModifiedAfterFilter-PatientByDataOwnerModifiedAfterFilter

	// endregion
}
