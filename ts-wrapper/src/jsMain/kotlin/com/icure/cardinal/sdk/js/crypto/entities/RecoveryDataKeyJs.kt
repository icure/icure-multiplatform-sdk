@file:JsQualifier("crypto")
package com.icure.cardinal.sdk.js.crypto.entities

@JsName("RecoveryDataKey")
external class RecoveryDataKeyJs {
	fun asHexString(): String
	fun asRawBytes(): ByteArray
	fun asBase32(): String
}

