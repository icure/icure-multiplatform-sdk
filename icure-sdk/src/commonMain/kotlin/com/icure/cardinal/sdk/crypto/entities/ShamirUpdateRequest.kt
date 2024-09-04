package com.icure.cardinal.sdk.crypto.entities

import kotlinx.serialization.Serializable

/**
 * Information on how to update the splits for a specific key.
 */
@Serializable
data class ShamirUpdateRequest(
	/**
	 * The ids of the data owners which will hold a copy of the key part.
	 */
	val notariesIds: Set<String>,
	/**
	 * The minimum number of shares required to reconstruct the key.
	 */
	val minShares: Int
)