package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class DataOwnerKeyInfo(
	val dataOwnerId: String,
	val keys: List<CachedKeypairDetails>
)