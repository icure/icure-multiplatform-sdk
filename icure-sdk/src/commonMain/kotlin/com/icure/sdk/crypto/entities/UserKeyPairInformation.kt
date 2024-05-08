package com.icure.sdk.crypto.entities

import com.icure.sdk.crypto.entities.DataOwnerKeyInfo
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class UserKeyPairInformation(
	/**
	 * Id and keys of the current data owner.
	 */
	val self: DataOwnerKeyInfo,
	/**
	 * Id and keys of the current data owner parents, starting from the topmost ancestor (at index 0) to the direct parent
	 * of the current data owner (at the last index, may be the same as the topmost ancestor).
	 */
	val parents: List<DataOwnerKeyInfo>
)