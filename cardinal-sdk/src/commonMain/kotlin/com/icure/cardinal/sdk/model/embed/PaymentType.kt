package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PaymentType() {
	@SerialName("cash")
	Cash,

	@SerialName("wired")
	Wired,

	@SerialName("insurance")
	Insurance,

	@SerialName("creditcard")
	Creditcard,

	@SerialName("debitcard")
	Debitcard,

	@SerialName("paypal")
	Paypal,

	@SerialName("bitcoin")
	Bitcoin,

	@SerialName("other")
	Other,
}
