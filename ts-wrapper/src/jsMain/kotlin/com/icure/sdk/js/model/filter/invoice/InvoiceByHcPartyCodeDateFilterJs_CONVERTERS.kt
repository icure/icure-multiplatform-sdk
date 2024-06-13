package com.icure.sdk.js.model.filter.invoice

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.invoice.InvoiceByHcPartyCodeDateFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun invoiceByHcPartyCodeDateFilter_toJs(obj: InvoiceByHcPartyCodeDateFilter):
		InvoiceByHcPartyCodeDateFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val code = obj.code
	val startInvoiceDate = nullToUndefined(
		longToNumber(obj.startInvoiceDate)
	)
	val endInvoiceDate = nullToUndefined(
		longToNumber(obj.endInvoiceDate)
	)
	return InvoiceByHcPartyCodeDateFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"code:code," +
		"startInvoiceDate:startInvoiceDate," +
		"endInvoiceDate:endInvoiceDate" +
	"}"))
}

public fun invoiceByHcPartyCodeDateFilter_fromJs(obj: InvoiceByHcPartyCodeDateFilterJs):
		InvoiceByHcPartyCodeDateFilter {
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val code = obj.code
	val startInvoiceDate = numberToLong(obj.startInvoiceDate, "obj.startInvoiceDate")
	val endInvoiceDate = numberToLong(obj.endInvoiceDate, "obj.endInvoiceDate")
	return InvoiceByHcPartyCodeDateFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		code = code,
		startInvoiceDate = startInvoiceDate,
		endInvoiceDate = endInvoiceDate,
	)
}
