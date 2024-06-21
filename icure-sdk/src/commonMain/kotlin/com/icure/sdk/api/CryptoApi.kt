package com.icure.sdk.api

import com.icure.sdk.api.crypto.ShamirKeysManagerApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.utils.InternalIcureApi


/**
 * Gives access to cryptographic operations that should be managed by the user, such as the creation of recovery data for keys.
 */
interface CryptoApi {
	val shamirKeysManager: ShamirKeysManagerApi

	/**
	 * Clears the cache of the api and reloads the user keys and exchange keys.
	 * In some cases this method could allow users to retrieve and decrypt data that was shared with them after the api
	 * instantiation or last reload.
	 */
	suspend fun forceReload()
}

@InternalIcureApi
internal class CryptoApiImpl(
	override val shamirKeysManager: ShamirKeysManagerApi,
	internal val internal: InternalCryptoServices
) : CryptoApi {
	override suspend fun forceReload() {
		internal.forceReload()
	}
}
