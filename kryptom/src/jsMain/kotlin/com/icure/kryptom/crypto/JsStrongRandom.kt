package com.icure.kryptom.crypto

import com.icure.kryptom.js.jsCrypto

object JsStrongRandom : StrongRandom {
    override fun randomBytes(length: Int): ByteArray =
        jsCrypto.getRandomValues(ByteArray(length))

    // Js crypto is Cryptographically secure according to documentation
    // https://developer.mozilla.org/en-US/docs/Web/API/Crypto/randomUUID
    override fun randomUUID(): String =
        jsCrypto.randomUUID()
}
