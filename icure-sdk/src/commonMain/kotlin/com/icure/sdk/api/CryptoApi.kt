package com.icure.sdk.api

import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.ShamirKeysManager
import com.icure.sdk.utils.InternalIcureApi

/**
 * Gives access to cryptographic operations that should be managed by the user, such as the creation of recovery data for keys.
 */
@OptIn(InternalIcureApi::class)
class CryptoApi(
	val shamirKeysManager: ShamirKeysManager,
	private val internalCryptoApi: InternalCryptoServices
) {
	/**
	 * Clears the cache of the api and reloads the user keys and exchange keys.
	 * In some cases this method could allow users to retrieve and decrypt data that was shared with them after the api
	 * instantiation or last reload.
	 */
	suspend fun forceReload() {
		internalCryptoApi.forceReload()
	}
}
