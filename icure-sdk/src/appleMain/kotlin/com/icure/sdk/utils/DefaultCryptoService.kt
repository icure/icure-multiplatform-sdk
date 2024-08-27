package com.icure.sdk.utils

import com.icure.kryptom.crypto.RsaAlgorithm

/**
 * This is a default crypto service that is used by the SDK.
 * The sole purpose of this variable is to make the Kotlin Multiplatform to generate the correct code for the XcFramework.
 */
val defaultCryptoService = com.icure.kryptom.crypto.defaultCryptoService

val rsaEncryptionAlgorithmOaepWithSha1 = RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
val rsaEncryptionAlgorithmOaepWithSha256 = RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
