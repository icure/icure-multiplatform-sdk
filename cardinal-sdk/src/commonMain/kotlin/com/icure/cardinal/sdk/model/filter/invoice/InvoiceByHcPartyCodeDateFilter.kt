package com.icure.cardinal.sdk.model.filter.invoice

import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("InvoiceByHcPartyCodeDateFilter")
@Serializable
data class InvoiceByHcPartyCodeDateFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val code: String,
	public val startInvoiceDate: Long? = null,
	public val endInvoiceDate: Long? = null,
) : AbstractFilter<Invoice> {
	// region InvoiceByHcPartyCodeDateFilter-InvoiceByHcPartyCodeDateFilter

	// endregion
}
