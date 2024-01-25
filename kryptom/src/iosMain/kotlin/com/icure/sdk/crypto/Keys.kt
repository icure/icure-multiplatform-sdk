package com.icure.sdk.crypto

/**
 * Represents an rsa private key, as a pkcs1-encoded key.
 * The appropriate type for keys is actually SecKeyRef, however that needs to be released through CFRelease.
 * By representing the key as a normal kotlin byte array we can garbage-collect it. This requires to convert the key on
 * each use but the overhead is actually very small.
 * The measured overhead is of ~10 ms over a total of ~1400 ms necessary to perform encryption and decryption of 500
 * arrays of 100 bytes each.
 */
actual class PrivateRsaKey<A : RsaAlgorithm>(internal val rawKey: ByteArray, internal val algorithm: A)

/**
 * Represents an rsa public key, as a pkcs1-encoded key.
 * The appropriate type for keys is actually SecKeyRef, however that needs to be released through CFRelease.
 * By representing the key as a normal kotlin byte array we can garbage-collect it. This requires to convert the key on
 * each use but the overhead is actually very small.
 * The measured overhead is of ~10 ms over a total of ~1400 ms necessary to perform encryption and decryption of 500
 * arrays of 100 bytes each.
 */
actual class PublicRsaKey<A : RsaAlgorithm>(internal val rawKey: ByteArray, internal val algorithm: A)

/**
 * Represents an aes key.
 * On CommonCrypto there is no specific class to represent an AesKey, any form of byte array is fine.
 */
actual typealias AesKey = ByteArray

actual class HmacKey<A : HmacAlgorithm>(internal val rawKey: ByteArray, internal val algorithm: A)