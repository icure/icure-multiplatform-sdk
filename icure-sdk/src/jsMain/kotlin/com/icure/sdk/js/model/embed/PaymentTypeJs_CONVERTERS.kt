package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.PaymentType
import kotlin.String

public fun paymentType_toJs(obj: PaymentType): String = obj.name

public fun paymentType_fromJs(obj: String): PaymentType = when (obj) {
	"Cash" -> PaymentType.Cash
	"Wired" -> PaymentType.Wired
	"Insurance" -> PaymentType.Insurance
	"Creditcard" -> PaymentType.Creditcard
	"Debitcard" -> PaymentType.Debitcard
	"Paypal" -> PaymentType.Paypal
	"Bitcoin" -> PaymentType.Bitcoin
	"Other" -> PaymentType.Other
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.PaymentType: $obj""")
}
