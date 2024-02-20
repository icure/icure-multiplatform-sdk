package com.icure.sdk.crypto.entities

import com.icure.sdk.utils.InternalIcureApi

/**
 * Contains decrypted metadata and the data owners which have access to it.
 */
@InternalIcureApi
data class DecryptedMetadataDetails<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val value: T,
	/**
	 * The ids of data owners know to have access to [value]
	 */
	val dataOwnersWithAccess: List<String>
)