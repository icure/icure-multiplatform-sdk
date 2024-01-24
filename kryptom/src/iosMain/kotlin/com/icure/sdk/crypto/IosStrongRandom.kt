package com.icure.sdk.crypto

import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Security.SecRandomCopyBytes
import platform.Security.errSecSuccess
import platform.Security.kSecRandomDefault

object IosStrongRandom : StrongRandom {
    override fun randomBytes(length: Int): ByteArray {
        val bytes = ByteArray(length)
        val returnCode = bytes.usePinned {
            SecRandomCopyBytes(kSecRandomDefault, length.toULong(), it.addressOf(0))
        }
        check(returnCode == errSecSuccess) { "Random bytes generation failed with code $returnCode" }
        return bytes
    }

    // Not sure if UUID is cryptographically strong in iOS: not specified in the documentation.
    // Use default implementation based on randomBytes.
}
