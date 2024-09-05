// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun cryptoActorStubWithType_toJs(obj: CryptoActorStubWithType): CryptoActorStubWithTypeJs {
	val type = obj.type.name
	val stub = cryptoActorStub_toJs(obj.stub)
	return CryptoActorStubWithTypeJs(js("{" +
		"type:type," +
		"stub:stub" +
	"}"))
}

public fun cryptoActorStubWithType_fromJs(obj: CryptoActorStubWithTypeJs): CryptoActorStubWithType {
	val type = DataOwnerType.valueOf(obj.type)
	val stub = cryptoActorStub_fromJs(obj.stub)
	return CryptoActorStubWithType(
		type = type,
		stub = stub,
	)
}
