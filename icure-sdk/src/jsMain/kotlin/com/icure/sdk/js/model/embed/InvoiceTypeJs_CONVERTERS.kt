package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.InvoiceType
import kotlin.String

public fun invoiceType_toJs(obj: InvoiceType): String = obj.name

public fun invoiceType_fromJs(obj: String): InvoiceType = when (obj) {
	"Patient" -> InvoiceType.Patient
	"Mutualfund" -> InvoiceType.Mutualfund
	"Payingagency" -> InvoiceType.Payingagency
	"Insurance" -> InvoiceType.Insurance
	"Efact" -> InvoiceType.Efact
	"Other" -> InvoiceType.Other
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.InvoiceType: $obj""")
}
