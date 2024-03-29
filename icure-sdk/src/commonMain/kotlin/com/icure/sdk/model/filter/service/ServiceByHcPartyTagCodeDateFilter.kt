package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyTagCodeDateFilter")
@Serializable
data class ServiceByHcPartyTagCodeDateFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val patientSecretForeignKey: String? = null,
	public val tagType: String? = null,
	public val tagCode: String? = null,
	public val codeType: String? = null,
	public val codeCode: String? = null,
	public val startValueDate: Long? = null,
	public val endValueDate: Long? = null,
	public val descending: Boolean,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyTagCodeDateFilter-ServiceByHcPartyTagCodeDateFilter

	// endregion
}
