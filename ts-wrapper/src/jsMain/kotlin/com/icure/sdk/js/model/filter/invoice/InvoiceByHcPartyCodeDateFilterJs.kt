// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.invoice

import com.icure.sdk.js.model.InvoiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("InvoiceByHcPartyCodeDateFilter")
public external class InvoiceByHcPartyCodeDateFilterJs(
	partial: dynamic,
) : AbstractFilterJs<InvoiceJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val code: String

	public val startInvoiceDate: Double?

	public val endInvoiceDate: Double?

	override val ktClass: String
}
