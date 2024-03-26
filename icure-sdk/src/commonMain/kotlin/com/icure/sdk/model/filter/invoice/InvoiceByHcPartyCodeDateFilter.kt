package com.icure.sdk.model.filter.invoice

import com.icure.sdk.model.Invoice
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("InvoiceByHcPartyCodeDateFilter")
@Serializable
public data class InvoiceByHcPartyCodeDateFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val code: String,
  public val startInvoiceDate: Long? = null,
  public val endInvoiceDate: Long? = null,
) : AbstractFilter<Invoice>
