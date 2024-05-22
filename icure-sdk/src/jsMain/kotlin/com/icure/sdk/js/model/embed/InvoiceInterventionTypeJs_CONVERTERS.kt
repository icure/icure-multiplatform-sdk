package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.InvoiceInterventionType
import kotlin.String

public fun invoiceInterventionType_toJs(obj: InvoiceInterventionType): String = obj.name

public fun invoiceInterventionType_fromJs(obj: String): InvoiceInterventionType = when (obj) {
	"Total" -> InvoiceInterventionType.Total
	"Userfees" -> InvoiceInterventionType.Userfees
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.InvoiceInterventionType: $obj""")
}
