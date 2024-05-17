package com.icure.kryptom.crypto.external

import kotlin.js.Promise

@JsExport
external interface XDigestService {
	fun sha256(data: ByteArray): Promise<ByteArray>
}