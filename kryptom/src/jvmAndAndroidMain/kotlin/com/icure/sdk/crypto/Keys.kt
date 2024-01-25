package com.icure.sdk.crypto

import java.security.PublicKey
import java.security.interfaces.RSAPrivateCrtKey
import javax.crypto.SecretKey

// We can't use interface typealias for expect class nor the opposite, so the best solution is to create a class which
// through delegation implements the required interfaces.

/**
 * Represents a private rsa key.
 */
actual class PrivateRsaKey<A : RsaAlgorithm>(
    internal val key: RSAPrivateCrtKey,
    internal val algorithm: A
) : RSAPrivateCrtKey by key

/**
 * Represents a public rsa key.
 */
actual class PublicRsaKey<A : RsaAlgorithm>(
    internal val key: PublicKey,
    internal val algorithm: A
) : PublicKey by key

/**
 * Represents an AesKey.
 */
actual class AesKey(internal val key: SecretKey) : SecretKey by key

/**
 * Represents an Hmac key.
 */
actual class HmacKey<A : HmacAlgorithm>(
    internal val key: SecretKey,
    internal val algorithm: A
) : SecretKey by key