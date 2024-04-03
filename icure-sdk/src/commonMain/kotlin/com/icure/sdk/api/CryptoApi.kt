package com.icure.sdk.api

import com.icure.sdk.crypto.BaseExchangeKeysManager
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.ShamirKeysManager
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi

/**
 * Gives access to cryptographic operations that should be managed by the user, such as the creation of recovery data for keys.
 */
@OptIn(InternalIcureApi::class)
class CryptoApi(
	val shamirKeysManager: ShamirKeysManager,
	private val exchangeDataManager: ExchangeDataManager,
	private val exchangeKeysManager: BaseExchangeKeysManager,
	private val userKeysManager: UserEncryptionKeysManager
) {
	// TODO temporary, should be part of an extended maintenance task api
	suspend fun giveAccessBackTo(
		dataOwnerId: String,
		key: SpkiHexString
	) {
		exchangeDataManager.giveAccessBackTo(dataOwnerId, key)
		exchangeKeysManager.giveAccessBackTo(dataOwnerId, key, userKeysManager.getDecryptionKeys())
	}
}
