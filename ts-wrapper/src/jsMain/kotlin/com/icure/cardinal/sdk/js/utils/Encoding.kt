package com.icure.cardinal.sdk.js.utils

import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString

@JsExport
fun base32Encode(bytes: ByteArray): String =
	com.icure.kryptom.utils.base32Encode(bytes)

@JsExport
fun base32Decode(base32String: String): ByteArray =
	com.icure.kryptom.utils.base32Decode(base32String)

@JsExport
fun hexEncode(bytes: ByteArray): String =
	bytes.toHexString()

@JsExport
fun hexDecode(hexString: String): ByteArray =
	hexToByteArray(hexString)

@JsExport
fun base64Encode(bytes: ByteArray): String =
	com.icure.kryptom.utils.base64Encode(bytes)

@JsExport
fun base64Decode(base64String: String): ByteArray =
	com.icure.kryptom.utils.base64Decode(base64String)
