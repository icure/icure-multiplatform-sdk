// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CryptoApi")
public external interface CryptoApiJs {
	public val shamirKeysManager: ShamirKeysManagerApiJs

	public fun forceReload(): Promise<Unit>
}
