package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByHcPartyTagCodeDateFilter")
@Serializable
data class ContactByHcPartyTagCodeDateFilter(
    override val desc: String? = null,
    public val healthcarePartyId: String? = null,
    public val tagType: String? = null,
    public val tagCode: String? = null,
    public val codeType: String? = null,
    public val codeCode: String? = null,
    public val startOfContactOpeningDate: Long? = null,
    public val endOfContactOpeningDate: Long? = null,
) : AbstractFilter<Contact> {
	// region ContactByHcPartyTagCodeDateFilter-ContactByHcPartyTagCodeDateFilter

	// endregion
}
