package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByDataOwnerFormIdsFilter")
@Serializable
data class ContactByDataOwnerFormIdsFilter(
	public val dataOwnerId: String,
	public val formIds: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Contact> {
	// region ContactByDataOwnerFormIdsFilter-ContactByDataOwnerFormIdsFilter
	// endregion
}
