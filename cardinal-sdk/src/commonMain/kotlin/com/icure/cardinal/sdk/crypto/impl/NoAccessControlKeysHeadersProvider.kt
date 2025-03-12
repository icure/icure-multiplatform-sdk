package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.utils.InternalIcureApi

@InternalIcureApi
object NoAccessControlKeysHeadersProvider : AccessControlKeysHeadersProvider {
	override suspend fun getAccessControlKeysHeadersFor(
		groupId: String?,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<String> =
		emptyList()
}