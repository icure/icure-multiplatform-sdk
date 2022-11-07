package com.icure.sdk.crypto

import com.icure.sdk.js.jsCrypto

actual val strongRandom = object : StrongRandom {
    override fun randomBytes(length: Int): ByteArray =
        jsCrypto.getRandomValues(ByteArray(length))

    // Js crypto is Cryptographically secure according to documentation
    // https://developer.mozilla.org/en-US/docs/Web/API/Crypto/randomUUID
    override fun randomUUID(): String =
        jsCrypto.randomUUID()
}
