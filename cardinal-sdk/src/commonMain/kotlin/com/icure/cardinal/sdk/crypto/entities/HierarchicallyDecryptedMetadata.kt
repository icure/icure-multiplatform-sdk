package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class HierarchicallyDecryptedMetadata<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val extracted: Set<T>,
	/**
	 * The ids of a data owner part
	 */
	val ownerId: String
)