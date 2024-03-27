package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByHcPartyIdentifiersFilter")
@Serializable
data class ContactByHcPartyIdentifiersFilter(
    public val healthcarePartyId: String? = null,
    override val desc: String? = null,
    public val identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<Contact> {
	// region ContactByHcPartyIdentifiersFilter-ContactByHcPartyIdentifiersFilter

	// endregion
}
