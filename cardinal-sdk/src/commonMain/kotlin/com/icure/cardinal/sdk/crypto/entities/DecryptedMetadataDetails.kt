package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi

/**
 * Contains decrypted metadata and the data owners part of the current data owner hierarchy which have access to it.
 */
@InternalIcureApi
data class DecryptedMetadataDetails<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val value: T,
	/**
	 * The ids data owners know to have access to [value]. Never includes the group id.
	 */
	val dataOwnersWithAccess: Set<String>
)