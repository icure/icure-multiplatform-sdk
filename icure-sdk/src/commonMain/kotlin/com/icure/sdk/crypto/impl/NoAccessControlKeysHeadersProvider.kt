package com.icure.sdk.crypto.impl

import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
object NoAccessControlKeysHeadersProvider : AccessControlKeysHeadersProvider {
	override suspend fun getAccessControlKeysHeadersFor(entityType: EntityWithDelegationTypeName): List<String> =
		emptyList()
}