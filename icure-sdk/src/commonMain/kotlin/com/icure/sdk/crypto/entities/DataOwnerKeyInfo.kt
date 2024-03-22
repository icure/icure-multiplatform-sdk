package com.icure.sdk.crypto.entities

import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class DataOwnerKeyInfo(
	val dataOwnerId: String,
	val keys: List<CachedKeypairDetails>
)