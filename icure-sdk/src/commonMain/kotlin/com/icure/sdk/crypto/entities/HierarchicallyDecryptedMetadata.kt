package com.icure.sdk.crypto.entities

import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class HierarchicallyDecryptedMetadata<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val extracted: List<T>,
	/**
	 * The ids of a data owner part
	 */
	val ownerId: String
)