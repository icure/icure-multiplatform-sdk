package com.icure.sdk.crypto.entities

import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi

/**
 * A container for the exchange keys of a data owner.
 */
@InternalIcureApi
data class DataOwnerExchangeKeys(
	/**
	 * The id of a data owner
	 */
	val dataOwnerId: String,
	/**
	 * Exchange keys where [dataOwnerId] is the delegator and the map key is a delegate.
	 */
	val exchangeKeysByDataOwnerTo: Map<String, List<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>,
	/**
	 * Exchange keys where [dataOwnerId] is the delegate and the map key is a delegator.
	 */
	val exchangeKeysToDataOwnerFrom: Map<String, List<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
)