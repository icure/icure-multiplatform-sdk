package com.icure.sdk.model.filter.message

import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.model.Message

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByHcPartyTransportGuidFilter")
@Serializable
data class MessageByHcPartyTransportGuidFilter(
	public val healthcarePartyId: String,
	public val transportGuid: String,
	override val desc: String? = null,
) : AbstractFilter<O> {
	// region MessageByHcPartyTransportGuidFilter-MessageByHcPartyTransportGuidFilter

	// endregion
}
