package com.icure.sdk.js

import com.icure.sdk.crypto.AesKey
import io.ktor.util.PlatformUtils
import org.khronos.webgl.ArrayBuffer
import kotlin.js.Json
import kotlin.js.Promise

// Implementation from ktor
// https://github.com/ktorio/ktor/blob/8efb61fcc2/ktor-utils/js/src/io/ktor/util/CryptoJs.kt#L47
internal val jsCrypto: Crypto by lazy {
    if (PlatformUtils.IS_NODE) {
        js("eval('require')('crypto').webcrypto")
    } else {
        js("(window ? (window.crypto ? window.crypto : window.msCrypto) : self.crypto)")
    }
}

internal external class Crypto {
    val subtle: SubtleCrypto

    fun getRandomValues(array: ByteArray): ByteArray

    fun randomUUID(): String
}

internal external class SubtleCrypto {
    // https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/generateKey#syntax
    fun generateKey(algorithm: Json, extractable: Boolean, keyUsages: Array<String>): Promise<dynamic>

    // https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/exportKey
    fun exportKey(format: String, key: dynamic): Promise<ArrayBuffer>

    // https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/importKey
    fun importKey(
        format: String,
        keyData: ArrayBuffer,
        algorithm: Json,
        extractable: Boolean,
        keyUsages: Array<String>
    ): Promise<dynamic>

    // https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/encrypt
    fun encrypt(algorithm: Json, key: dynamic, data: ArrayBuffer): Promise<ArrayBuffer>

    // https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/decrypt
    fun decrypt(algorithm: Json, key: dynamic, data: ArrayBuffer): Promise<ArrayBuffer>
}
