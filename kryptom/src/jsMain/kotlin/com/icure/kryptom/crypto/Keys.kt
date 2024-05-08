package com.icure.kryptom.crypto

/**
 * Key should ony be used with subtle crypto.
 * Algorithm can be used to check if the declared usage for a generated or imported key matches the requested usage.
 */
actual class PrivateRsaKey<out A : RsaAlgorithm>(
	internal val key: dynamic,
	actual val algorithm: A
) : RsaKey

/**
 * Key should ony be used with subtle crypto.
 * Algorithm can be used to check if the declared usage for a generated or imported key matches the requested usage.
 */
actual class PublicRsaKey<out A : RsaAlgorithm>(
	internal val key: dynamic,
	actual val algorithm: A
) : RsaKey

/**
 * This would actually be [CryptoKey](https://developer.mozilla.org/en-US/docs/Web/API/CryptoKey) but there is no easy
 * way of connecting to the external class in node. Since all use of the crypto key is done through the external
 * `SubtleCrypto` anyway there is no arm in just treating it as `Any`.
 */
actual class AesKey<out A : AesAlgorithm>(
	internal val cryptoKey: dynamic,
	actual val algorithm: A
)

/**
 * Key should ony be used with subtle crypto.
 * Algorithm can be used to check if the declared usage for a generated or imported key matches the requested usage.
 */
actual class HmacKey<out A : HmacAlgorithm>(
	internal val key: dynamic,
	actual val algorithm: A
)
