package com.icure.kryptom.crypto

import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.SecretKey

// We can't use interface typealias for expect class nor the opposite, so the best solution is to create a class which
// through delegation implements the required interfaces.

/**
 * Represents a private rsa key.
 */
actual class PrivateRsaKey<out A : RsaAlgorithm>(
	internal val key: PrivateKey,
	actual val algorithm: A
) : RsaKey

/**
 * Represents a public rsa key.
 */
actual class PublicRsaKey<out A : RsaAlgorithm>(
	internal val key: PublicKey,
	actual val algorithm: A
) : RsaKey

/**
 * Represents an AesKey.
 */
actual class AesKey<out A : AesAlgorithm>(
	internal val key: SecretKey,
	actual val algorithm: A
)

/**
 * Represents an Hmac key.
 */
actual class HmacKey<out A : HmacAlgorithm>(
	internal val key: SecretKey,
	actual val algorithm: A
)
