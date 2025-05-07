package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class HierarchicallyDecryptedMetadata<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val extracted: Set<T>,
	/**
	 * The ids of a data owner part. Plain id, not a reference, regardless of group of the source entity.
	 */
	val ownerId: String
)