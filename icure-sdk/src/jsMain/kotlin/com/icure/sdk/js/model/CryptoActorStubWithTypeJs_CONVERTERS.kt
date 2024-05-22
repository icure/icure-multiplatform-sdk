package com.icure.sdk.js.model

import com.icure.sdk.model.CryptoActorStubWithType

public fun cryptoActorStubWithType_toJs(obj: CryptoActorStubWithType): CryptoActorStubWithTypeJs {
	val type = dataOwnerType_toJs(obj.type)
	val stub = cryptoActorStub_toJs(obj.stub)
	return CryptoActorStubWithTypeJs(js("{" +
		"type:type," +
		"stub:stub" +
	"}"))
}

public fun cryptoActorStubWithType_fromJs(obj: CryptoActorStubWithTypeJs): CryptoActorStubWithType {
	val type = dataOwnerType_fromJs(obj.type)
	val stub = cryptoActorStub_fromJs(obj.stub)
	return CryptoActorStubWithType(
		type = type,
		stub = stub,
	)
}
