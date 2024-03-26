package com.icure.sdk.crypto.impl

import com.icure.sdk.crypto.SecurityMetadataDecryptor
import com.icure.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flattenConcat
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalCoroutinesApi::class)
@InternalIcureApi
class SecurityMetadataDecryptorChain(
	private val decryptors: List<SecurityMetadataDecryptor>
): SecurityMetadataDecryptor {
	override fun decryptEncryptionKeysOf(
		typedEntity: HasEncryptionMetadata,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<HexString>> =
		decryptors.asFlow().map { it.decryptEncryptionKeysOf(typedEntity, dataOwnersHierarchySubset) }.flattenConcat()

	override fun decryptSecretIdsOf(
		typedEntity: HasEncryptionMetadata,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<String>> =
		decryptors.asFlow().map { it.decryptSecretIdsOf(typedEntity, dataOwnersHierarchySubset) }.flattenConcat()

	override fun decryptOwningEntityIdsOf(
		typedEntity: HasEncryptionMetadata,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<String>> =
		decryptors.asFlow().map { it.decryptOwningEntityIdsOf(typedEntity, dataOwnersHierarchySubset) }.flattenConcat()

	override suspend fun getEntityAccessLevel(
		typedEntity: HasEncryptionMetadata,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? =
		decryptors.fold<SecurityMetadataDecryptor, AccessLevel?>(null) { acc, currDecryptor ->
			if (acc != AccessLevel.Write) {
				currDecryptor.getEntityAccessLevel(typedEntity, dataOwnersHierarchySubset) ?: acc
			} else acc
		}

	override fun hasAnyEncryptionKeys(entity: HasEncryptionMetadata): Boolean =
		decryptors.any { it.hasAnyEncryptionKeys(entity) }
}