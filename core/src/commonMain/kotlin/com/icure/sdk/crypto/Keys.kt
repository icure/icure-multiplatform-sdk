package com.icure.sdk.crypto

/**
 * Represents a private rsa key.
 */
expect class PrivateRsaKey

/**
 * Represents a public rsa key.
 */
expect class PublicRsaKey

/**
 * Represents an rsa key pair.
 * @param private a private rsa key.
 * @param public the public rsa key corresponding to the private key.
 */
data class RsaKeypair(val private: PrivateRsaKey, val public: PublicRsaKey)

/**
 * Represents an aes key.
 */
expect class AesKey
