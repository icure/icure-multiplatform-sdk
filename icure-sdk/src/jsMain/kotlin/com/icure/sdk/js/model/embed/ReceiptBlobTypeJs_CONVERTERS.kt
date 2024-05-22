package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.ReceiptBlobType
import kotlin.String

public fun receiptBlobType_toJs(obj: ReceiptBlobType): String = obj.name

public fun receiptBlobType_fromJs(obj: String): ReceiptBlobType = when (obj) {
	"Xades" -> ReceiptBlobType.Xades
	"KmehrRequest" -> ReceiptBlobType.KmehrRequest
	"KmehrResponse" -> ReceiptBlobType.KmehrResponse
	"SoapRequest" -> ReceiptBlobType.SoapRequest
	"SoapResponse" -> ReceiptBlobType.SoapResponse
	"SoapConversation" -> ReceiptBlobType.SoapConversation
	"Tack" -> ReceiptBlobType.Tack
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.ReceiptBlobType: $obj""")
}
