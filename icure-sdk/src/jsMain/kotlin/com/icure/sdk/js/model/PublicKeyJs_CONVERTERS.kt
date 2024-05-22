package com.icure.sdk.js.model

import com.icure.sdk.model.PublicKey

public fun publicKey_toJs(obj: PublicKey): PublicKeyJs {
	val hcPartyId = obj.hcPartyId
	val hexString = obj.hexString
	return PublicKeyJs(js("{" +
		"hcPartyId:hcPartyId," +
		"hexString:hexString" +
	"}"))
}

public fun publicKey_fromJs(obj: PublicKeyJs): PublicKey {
	val hcPartyId = obj.hcPartyId
	val hexString = obj.hexString
	return PublicKey(
		hcPartyId = hcPartyId,
		hexString = hexString,
	)
}
