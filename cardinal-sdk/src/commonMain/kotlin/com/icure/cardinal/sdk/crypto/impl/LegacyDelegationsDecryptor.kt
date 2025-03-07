package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.cardinal.sdk.crypto.ExchangeKeysManager
import com.icure.cardinal.sdk.crypto.SecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.getLogger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@InternalIcureApi
class LegacyDelegationsDecryptor(
	private val cryptoService: CryptoService,
	private val exchangeKeysManager: ExchangeKeysManager
) : SecurityMetadataDecryptor {
	companion object {
		private val log = getLogger("LegacyDelegationsDecryptor")
	}

	override fun decryptEncryptionKeysOf(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<HexString>> = extractFromDelegations(
		dataOwnersHierarchySubset,
		typedEntity.entity.encryptionKeys,
	) {
		val fixedKey = it.replace("-", "")
		kotlin.runCatching {
			cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, hexToByteArray(fixedKey))
		}.getOrNull()?.let {
			// Fixed key can be imported properly -> decryption is likely valid
			HexString(fixedKey)
		}
	}

	override fun decryptSecretIdsOf(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<String>> = extractFromDelegations(
		dataOwnersHierarchySubset,
		typedEntity.entity.delegations,
	) { decrypted -> decrypted.takeIf { it.isNotBlank() } }

	override fun decryptOwningEntityIdsOf(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<String>> = extractFromDelegations(
		dataOwnersHierarchySubset,
		typedEntity.entity.cryptedForeignKeys,
	) { decrypted -> decrypted.takeIf { it.isNotBlank() } }

	override suspend fun getEntityAccessLevel(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? =
		if (dataOwnersHierarchySubset.any { typedEntity.entity.delegations.containsKey(it) }) {
			AccessLevel.Write
		} else {
			null
		}

	override fun hasAnyEncryptionKeys(entity: HasEncryptionMetadata): Boolean =
		entity.encryptionKeys.values.any { it.isNotEmpty() }

	private fun <T : Any> extractFromDelegations(
		dataOwnersHierarchySubset: Set<String>,
		delegationsLike: Map<String, Set<Delegation>>,
		tryImportDecrypted: suspend (String) -> T?
	): Flow<DecryptedMetadataDetails<T>> {
		ensure(dataOwnersHierarchySubset.isNotEmpty()) { "`dataOwnersHierarchySubset` should not be empty" }
		val delegationsWithOwner = delegationsLike.flatMap { (delegateId, delegations) ->
			populateDelegatedTo(
				delegateId,
				if (delegateId in dataOwnersHierarchySubset) {
					delegations
				} else {
					delegations.filter { d -> d.owner in dataOwnersHierarchySubset }
				}
			)
		}
		return flow {
			delegationsWithOwner.forEach { delegation ->
				tryDecryptDelegation(delegation, tryImportDecrypted)?.also { emit(it) }
			}
		}
	}

	// Ensure that the delegations are properly formatted
	private fun populateDelegatedTo(delegateId: String, delegations: Collection<Delegation>): Set<Delegation> =
		delegations.mapTo(mutableSetOf()) { it.copy(delegatedTo = delegateId) }


}
