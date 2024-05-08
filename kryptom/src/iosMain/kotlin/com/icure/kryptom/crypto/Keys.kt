package com.icure.kryptom.crypto

/**
 * Represents an rsa private key, as a pkcs1-encoded key.
 * The appropriate type for keys is actually SecKeyRef, however that needs to be released through CFRelease.
 * By representing the key as a normal kotlin byte array we can garbage-collect it. This requires to convert the key on
 * each use but the overhead is actually very small.
 * The measured overhead is of ~10 ms over a total of ~1400 ms necessary to perform encryption and decryption of 500
 * arrays of 100 bytes each.
 */
actual class PrivateRsaKey<out A : RsaAlgorithm>(val rawKey: ByteArray, actual val algorithm: A): RsaKey

/**
 * Represents an rsa public key, as a pkcs1-encoded key.
 * The appropriate type for keys is actually SecKeyRef, however that needs to be released through CFRelease.
 * By representing the key as a normal kotlin byte array we can garbage-collect it. This requires to convert the key on
 * each use but the overhead is actually very small.
 * The measured overhead is of ~10 ms over a total of ~1400 ms necessary to perform encryption and decryption of 500
 * arrays of 100 bytes each.
 */
actual class PublicRsaKey<out A : RsaAlgorithm>(val rawKey: ByteArray, actual val algorithm: A): RsaKey

/**
 * Represents an aes key.
 * On CommonCrypto there is no specific class to represent an AesKey, any form of byte array is fine.
 */
actual class AesKey<out A : AesAlgorithm>(
	val rawKey: ByteArray,
	actual val algorithm: A
)

actual class HmacKey<out A : HmacAlgorithm>(val rawKey: ByteArray, actual val algorithm: A)

/**
 * Methods to help with weird typing issues from swift.
 */
fun <A : RsaAlgorithm> PrivateRsaKey<A>.dropTypeInfo(): PrivateRsaKey<*> = this
fun <A : RsaAlgorithm> PublicRsaKey<A>.dropTypeInfo(): PublicRsaKey<*> = this
fun <A : HmacAlgorithm> HmacKey<A>.dropTypeInfo(): HmacKey<*> = this
fun <A : AesAlgorithm> AesKey<A>.dropTypeInfo(): AesKey<*> = this
