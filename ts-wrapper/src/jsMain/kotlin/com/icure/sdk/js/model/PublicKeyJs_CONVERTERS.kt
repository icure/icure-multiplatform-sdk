package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.PublicKey
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun publicKey_toJs(obj: PublicKey): PublicKeyJs {
	val hcPartyId = nullToUndefined(
		obj.hcPartyId
	)
	val hexString = nullToUndefined(
		obj.hexString
	)
	return PublicKeyJs(js("{" +
		"hcPartyId:hcPartyId," +
		"hexString:hexString" +
	"}"))
}

public fun publicKey_fromJs(obj: PublicKeyJs): PublicKey {
	val hcPartyId = undefinedToNull(obj.hcPartyId)
	val hexString = undefinedToNull(obj.hexString)
	return PublicKey(
		hcPartyId = hcPartyId,
		hexString = hexString,
	)
}
