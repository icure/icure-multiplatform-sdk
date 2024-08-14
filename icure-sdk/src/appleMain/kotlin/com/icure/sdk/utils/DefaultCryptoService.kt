package com.icure.sdk.utils

/**
 * This is a default crypto service that is used by the SDK.
 * The sole purpose of this variable is to make the Kotlin Multiplatform to generate the correct code for the XcFramework.
 */
val defaultCryptoService = com.icure.kryptom.crypto.defaultCryptoService
