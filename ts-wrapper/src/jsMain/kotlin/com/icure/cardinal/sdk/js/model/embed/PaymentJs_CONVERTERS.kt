// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.Payment
import com.icure.cardinal.sdk.model.embed.PaymentType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun payment_toJs(obj: Payment): PaymentJs {
	val paymentDate = longToNumber(obj.paymentDate)
	val paymentType = nullToUndefined(
		obj.paymentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val paid = nullToUndefined(
		obj.paid
	)
	return PaymentJs(js("{" +
		"paymentDate:paymentDate," +
		"paymentType:paymentType," +
		"paid:paid" +
	"}"))
}

public fun payment_fromJs(obj: PaymentJs): Payment {
	val paymentDate = numberToLong(obj.paymentDate, "obj.paymentDate")
	val paymentType = obj.paymentType?.let { nonNull1 ->
		PaymentType.valueOf(nonNull1)
	}
	val paid = undefinedToNull(obj.paid)
	return Payment(
		paymentDate = paymentDate,
		paymentType = paymentType,
		paid = paid,
	)
}
