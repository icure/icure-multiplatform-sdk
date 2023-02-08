package com.icure.sdk.crypto

// TODO
actual class PrivateRsaKey<A : RsaAlgorithm>(
    internal val key: dynamic,
    internal val algorithm: A
)

// TODO
actual class PublicRsaKey<A : RsaAlgorithm>(
    internal val key: dynamic,
    internal val algorithm: A
)

/**
 * This would actually be [CryptoKey](https://developer.mozilla.org/en-US/docs/Web/API/CryptoKey) but there is no easy
 * way of connecting to the external class in node. Since all use of the crypto key is done through the external
 * `SubtleCrypto` anyway there is no arm in just treating it as `Any`.
 */
actual typealias AesKey = Any
