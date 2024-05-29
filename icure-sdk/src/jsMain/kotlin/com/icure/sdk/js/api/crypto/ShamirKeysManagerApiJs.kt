// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.crypto

import com.icure.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.sdk.js.model.base.CryptoActorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ShamirKeysManagerApi")
public external interface ShamirKeysManagerApiJs {
	public fun getExistingSplitsInfo(dataOwner: CryptoActorJs): dynamic

	public fun updateSelfSplits(keySplitsToUpdate: dynamic, keySplitsToDelete: Array<String>):
			Promise<CryptoActorStubWithTypeJs>
}
