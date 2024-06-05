package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.Payment
import com.icure.sdk.model.embed.PaymentType

public fun payment_toJs(obj: Payment): PaymentJs {
	val paymentDate = longToNumber(obj.paymentDate)
	val paymentType = obj.paymentType?.let { nonNull1 ->
		obj.paymentType?.name
	}
	val paid = obj.paid
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
	val paid = obj.paid
	return Payment(
		paymentDate = paymentDate,
		paymentType = paymentType,
		paid = paid,
	)
}
