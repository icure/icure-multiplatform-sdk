package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyTagCodeFilter")
@Serializable
data class HealthElementByHcPartyTagCodeFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val codeType: String? = null,
	public val codeCode: String? = null,
	public val tagType: String? = null,
	public val tagCode: String? = null,
	public val status: Int? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyTagCodeFilter-HealthElementByHcPartyTagCodeFilter

	// endregion
}
