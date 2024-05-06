package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import com.icure.sdk.model.Contact

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByHcPartyPatientTagCodeDateFilter")
@Serializable
data class ContactByHcPartyPatientTagCodeDateFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val patientSecretForeignKey: String? = null,
	public val patientSecretForeignKeys: List<String>? = null,
	public val tagType: String? = null,
	public val tagCode: String? = null,
	public val codeType: String? = null,
	public val codeCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
) : AbstractFilter<O> {
	// region ContactByHcPartyPatientTagCodeDateFilter-ContactByHcPartyPatientTagCodeDateFilter

	// endregion
}
