package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.sdk.crypto.ExchangeKeysManager
import com.icure.sdk.crypto.SecurityMetadataDecryptor
import com.icure.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.getLogger
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
		typedEntity.encryptionKeys,
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
		typedEntity.delegations,
	) { decrypted -> decrypted.takeIf { it.isNotBlank() } }

	override fun decryptOwningEntityIdsOf(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<String>> = extractFromDelegations(
		dataOwnersHierarchySubset,
		typedEntity.cryptedForeignKeys,
	) { decrypted -> decrypted.takeIf { it.isNotBlank() } }

	override suspend fun getEntityAccessLevel(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? =
		if (dataOwnersHierarchySubset.any { typedEntity.delegations.containsKey(it) }) {
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

	private suspend fun <T : Any> tryDecryptDelegation(
		delegation: Delegation,
		tryImportDecrypted: suspend (String) -> T?
	): DecryptedMetadataDetails<T>? {
		if (delegation.key == null) {
			log.w { "Can't decrypt delegation due to missing content" }
			return null
		}
		if (delegation.owner == null || delegation.delegatedTo == null) {
			log.w { "Can't decrypt delegation due to missing delegator and/or delegate id" }
			return null
		}
		val exchangeKeys = exchangeKeysManager.getDecryptionExchangeKeysFor(
			delegatorId = delegation.owner,
			delegateId = delegation.delegatedTo,
		)
		return exchangeKeys.firstNotNullOfOrNull {
			kotlin.runCatching {
				cryptoService.aes.decrypt(delegation.key.decodedBytes(), it)
					// Legacy delegation contain the string entityId:content, and entityId was supposed to be a checksum to ensure the decryption was successful
					// Unfortunately since different entities may be merged into one and all the secret ids need to be preserved this is not possible anymore
					.decodeToString().split(":").takeIf { it.size == 2 }?.last()
					?.let { tryImportDecrypted(it) }
					?.let { DecryptedMetadataDetails(it, setOf(delegation.owner, delegation.delegatedTo)) }
			}.getOrNull()
		}
	}
}
