package com.icure.cardinal.sdk.js.utils

import com.icure.cardinal.sdk.js.model.CryptoActorStubJs
import com.icure.cardinal.sdk.js.model.base.CryptoActorJs
import com.icure.cardinal.sdk.js.model.cryptoActorStub_fromJs
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki

@JsExport
fun allPublicKeysOf(cryptoActor: CryptoActorJs) =
	cryptoActorStub_fromJs(CryptoActorStubJs(cryptoActor)).publicKeysSpki.map { it.s }.toTypedArray()
