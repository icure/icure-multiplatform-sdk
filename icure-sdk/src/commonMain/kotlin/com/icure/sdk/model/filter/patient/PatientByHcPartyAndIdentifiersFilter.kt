package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndIdentifiersFilter")
@Serializable
data class PatientByHcPartyAndIdentifiersFilter(
	public val healthcarePartyId: String? = null,
	@DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	override val desc: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndIdentifiersFilter-PatientByHcPartyAndIdentifiersFilter

	// endregion
}
