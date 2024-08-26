// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.crypto.entities.ShamirUpdateRequestJs
import com.icure.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.sdk.js.model.base.CryptoActorJs
import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ShamirKeysManagerApi")
public external interface ShamirKeysManagerApiJs {
	public fun getExistingSplitsInfo(dataOwner: CryptoActorJs): Record<String, Array<String>>

	public fun updateSelfSplits(keySplitsToUpdate: Record<String, ShamirUpdateRequestJs>,
			keySplitsToDelete: Array<String>): Promise<CryptoActorStubWithTypeJs>
}
