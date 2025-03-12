package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi

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
	 * The reference strings of data owners know to have access to [value]
	 */
	val dataOwnersWithAccess: Set<String>
)