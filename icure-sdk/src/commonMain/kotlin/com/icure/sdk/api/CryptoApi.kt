package com.icure.sdk.api

import com.icure.sdk.crypto.ShamirKeysManager

/**
 * Gives access to cryptographic operations that should be managed by the user, such as the creation of recovery data for keys.
 */
class CryptoApi(
	val shamirKeysManager: ShamirKeysManager
) {
}
