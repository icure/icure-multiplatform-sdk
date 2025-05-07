package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class OwningEntityDetails(
	val groupId: String?,
	val id: String,
	val secretIds: Set<String>
)
