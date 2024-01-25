package com.icure.sdk.crypto

import com.icure.sdk.js.jsCrypto
import com.icure.sdk.js.toArrayBuffer
import com.icure.sdk.js.toByteArray
import kotlinx.coroutines.await

object JsDigestService : DigestService {
    override suspend fun sha256(data: ByteArray): ByteArray =
        jsCrypto.subtle.digest("SHA-256", data.toArrayBuffer()).await().toByteArray()
}