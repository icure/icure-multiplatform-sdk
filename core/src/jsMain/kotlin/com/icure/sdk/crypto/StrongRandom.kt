package com.icure.sdk.crypto

import io.ktor.util.PlatformUtils

// Implementation from ktor
// https://github.com/ktorio/ktor/blob/8efb61fcc2/ktor-utils/js/src/io/ktor/util/CryptoJs.kt#L47
private val jsCrypto: Crypto by lazy {
    if (PlatformUtils.IS_NODE) {
        js("eval('require')('crypto').webcrypto")
    } else {
        js("(window ? (window.crypto ? window.crypto : window.msCrypto) : self.crypto)")
    }
}

private external class Crypto {
    val subtle: SubtleCrypto

    fun getRandomValues(array: ByteArray): ByteArray

    fun randomUUID(): String
}

private external class SubtleCrypto {
    // TODO
}

actual val strongRandom = object : StrongRandom {
    override fun randomBytes(length: Int): ByteArray =
        jsCrypto.getRandomValues(ByteArray(length))

    // Js crypto is Cryptographically secure according to documentation
    // https://developer.mozilla.org/en-US/docs/Web/API/Crypto/randomUUID
    override fun randomUUID(): String =
        jsCrypto.randomUUID()
}
