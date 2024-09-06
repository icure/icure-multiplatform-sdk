package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByDataOwnerFromAddressFilter")
@Serializable
data class MessageByDataOwnerFromAddressFilter(
	public val dataOwnerId: String,
	public val fromAddress: String,
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerFromAddressFilter-MessageByDataOwnerFromAddressFilter

	// endregion
}