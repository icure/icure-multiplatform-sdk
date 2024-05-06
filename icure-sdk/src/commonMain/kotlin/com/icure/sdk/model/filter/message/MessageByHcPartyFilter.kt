package com.icure.sdk.model.filter.message

import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.model.Message

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByHcPartyFilter")
@Serializable
data class MessageByHcPartyFilter(
	override val hcpId: String,
	override val desc: String? = null,
) : AbstractFilter<O>, Filter.ByHcpartyFilter<O> {
	// region MessageByHcPartyFilter-MessageByHcPartyFilter

	// endregion
}
