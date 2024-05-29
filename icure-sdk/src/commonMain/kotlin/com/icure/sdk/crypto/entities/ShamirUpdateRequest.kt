package com.icure.sdk.crypto.entities

/**
 * Information on how to update the splits for a specific key.
 */
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