package com.icure.kryptom.crypto

import com.icure.kryptom.js.jsCrypto
import com.icure.kryptom.js.toArrayBuffer
import com.icure.kryptom.js.toByteArray
import kotlinx.coroutines.await

object JsDigestService : DigestService {
	override suspend fun sha256(data: ByteArray): ByteArray =
		jsCrypto.subtle.digest("SHA-256", data.toArrayBuffer()).await().toByteArray()
}