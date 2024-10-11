@file:JsQualifier("crypto.RecoveryDataKey")
package com.icure.cardinal.sdk.js.crypto.entities

@JsName("fromBase32")
external fun RecoveryDataKeyJs_fromBase32(base32: String): RecoveryDataKeyJs

@JsName("fromRawBytes")
external fun RecoveryDataKeyJs_fromRawBytes(rawBytes: ByteArray): RecoveryDataKeyJs

@JsName("fromHexString")
external fun RecoveryDataKeyJs_fromHexString(hexString: String): RecoveryDataKeyJs