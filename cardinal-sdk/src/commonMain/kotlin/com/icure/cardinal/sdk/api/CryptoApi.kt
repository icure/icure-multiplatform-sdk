package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.utils.DefaultValue


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

	/**
	 * Get the available keys for the current data and his parents (if using hierarchical data owners).
	 * The result is a map associating the current data owner or parent id to a map containing all the available keys
	 * for that data owner.
	 * The keys map associates the key fingerprint to the pkcs8 bytes of the private key.
	 * @param filterTrustedKeys if true (default) only keys fully trusted by this instance of the sdk will be returned.
	 * Otherwise, also unverified keys may be returned.
	 * @return the available keys
	 */
	suspend fun currentDataOwnerKeys(
		@DefaultValue("true")
		filterTrustedKeys: Boolean = true
	): Map<String, Map<KeypairFingerprintV1String, ByteArray>>
}

