// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CryptoApi")
public external interface CryptoApiJs {
	public val shamirKeysManager: ShamirKeysManagerApiJs

	public fun forceReload(): Promise<Unit>

	public fun currentDataOwnerKeys(options: dynamic):
			Promise<Record<String, Record<String, ByteArray>>>
}
