package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawSecureDelegationKeyMapApi
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.DelegationsDeAnonymization
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.SecureDelegationsDecryptor
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecureDelegationMembersDetails
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.SecureDelegationKeyMap
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.encodeAsAccessControlHeaders
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
class DelegationsDeAnonymizationImpl(
	private val secureDelegationsDecryptor: SecureDelegationsDecryptor,
	private val delegationKeyMapsApi: RawSecureDelegationKeyMapApi,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider,
	private val entity: EntityEncryptionService,
	private val dataOwnerApi: DataOwnerApi,
	private val crypto: CryptoService,
) : DelegationsDeAnonymization {
	companion object {
		private val log = getLogger("DelegationsDeAnonymization")

		private val delegationKeyMapFieldsToEncrypt =
			JsonEncryptionService.parseEncryptedFields(setOf("delegate", "delegator"), "SecureDelegationKeyMap.")
	}

	override suspend fun createOrUpdateDeAnonymizationInfo(
		entity: EntityWithTypeInfo<*>,
		shareWithDataOwners: Set<String>
	) {
		val delegationDetails = secureDelegationsDecryptor.getDelegationMemberDetails(entity)
		val delegationsForDeanonInfoSharing = delegationDetails.filter { (_, delegation) ->
			// Drop fully explicit ones: they don't need de-anonymization info
			!delegation.fullyExplicit
		}
		//    // A subset of delegations for which deanon info is relevant AND for which we can also create new info if there is existing that we can share.
		val delegationsForNewDeanonInfoCreation = delegationsForDeanonInfoSharing.filter { (_, delegation) ->
			// Drop those for which we don't have the full information needed for the creation of new data.
			delegation.delegate != null && delegation.delegator != null && delegation.accessControlSecret != null
		}
		val existingDelegationsMap = getDecryptedSecureDelegationKeyMaps(
			delegationsForDeanonInfoSharing.map { it.key.s }.toSet(),
			entity.type
		)
		existingDelegationsMap.forEach { delMapToShare ->
			ensureDelegationKeyMapSharedWith(entity.type, delMapToShare, shareWithDataOwners)
		}
		val existingDelegationsMapKeys = existingDelegationsMap.mapTo(mutableSetOf()) { it.delegationKey }
		delegationsForNewDeanonInfoCreation.filter { (k, _) -> k.s !in existingDelegationsMapKeys }.forEach { (k, v) ->
			createSecureDelegationKeyMap(entity.type, k.s, v, shareWithDataOwners)
		}
	}

	override suspend fun getDataOwnersWithAccessTo(entityWithType: EntityWithTypeInfo<*>): EntityAccessInformation =
		getDataOwnersWithAccessToSecureDelegations(entityWithType).merge(
			EntityAccessInformation(
				permissionsByDataOwnerId = entityWithType.entity.delegations.keys.associateWith { AccessLevel.Write },
				hasUnknownAnonymousDataOwners = false
			)
		)

	private suspend fun getDataOwnersWithAccessToSecureDelegations(entityWithType: EntityWithTypeInfo<*>): EntityAccessInformation {
		val secureDelegationDetails = secureDelegationsDecryptor.getDelegationMemberDetails(entityWithType)
		val secureDelegationWithUnknownMembers =
			secureDelegationDetails.entries.mapNotNull { (canonicalKey, delegation) ->
				if (delegation.delegate == null || delegation.delegator == null)
					canonicalKey to delegation
				else
					null
			}.toMap()
		val secureDelegationKeyMapsByDelegationKey = getDecryptedSecureDelegationKeyMaps(
			secureDelegationWithUnknownMembers.keys.mapTo(mutableSetOf()) { it.s },
			entityWithType.type
		).associateBy { it.delegationKey }
		val permissionsByDataOwnerId = EntityAccessInformation.buildPermissionsMap(
			secureDelegationDetails.values.flatMap { d ->
				listOfNotNull(
					d.delegate?.let { it to d.accessLevel },
					d.delegator?.let { it to d.accessLevel }
				)
			} + secureDelegationWithUnknownMembers.flatMap { (k, v) ->
				val keyMap = secureDelegationKeyMapsByDelegationKey[k.s]
				listOfNotNull(
					keyMap?.delegate?.let { it to v.accessLevel },
					keyMap?.delegator?.let { it to v.accessLevel }
				)
			}
		)
		val hasUnknownAnonymousDataOwners = secureDelegationWithUnknownMembers.keys.any { k ->
			secureDelegationKeyMapsByDelegationKey[k.s]?.takeIf {
				it.delegator != null && it.delegate != null
			} == null
		}
		return EntityAccessInformation(permissionsByDataOwnerId, hasUnknownAnonymousDataOwners)
	}

	private suspend fun getDecryptedSecureDelegationKeyMaps(
		delegationIds: Set<String>,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<DecryptedSecureDelegationKeyMap> =
		if (delegationIds.isNotEmpty()) {
			delegationKeyMapsApi.findByDelegationKeys(
				ListOfIds(delegationIds.toList()),
				accessControlKeysHeadersProvider.getAccessControlKeysHeadersFor(entityType)
			).successBody().mapNotNull { encryptedMap ->
				entity.tryDecryptEntity(
					EntityWithTypeInfo(encryptedMap, entityType),
					EncryptedSecureDelegationKeyMap.serializer()
				) {
					Serialization.json.decodeFromJsonElement<DecryptedSecureDelegationKeyMap>(it)
				}
			}
		} else emptyList()

	// Important: to avoid potentially leaking links between entities of different types the key map calculates the secure delegation keys using the
	// same entity type as the delegation key for which they are mapping information.
	private suspend fun ensureDelegationKeyMapSharedWith(
		entityType: EntityWithEncryptionMetadataTypeName,
		keyMap: SecureDelegationKeyMap,
		delegates: Set<String>
	) {
		ensure(keyMap.delegator != null && keyMap.delegate != null) { "Key map is missing delegator or delegate info." }
		val keyMapWithType = EntityWithTypeInfo(keyMap, entityType)
		val dataOwnersWithAccessToMapThroughDelegation =
			secureDelegationsDecryptor.getDelegationMemberDetails(keyMapWithType)
				.flatMap { (_, v) -> listOfNotNull(v.delegate, v.delegator) }
		// Delegator and delegate got access to the entity when it was first created: no need to share with them ever.
		val dataOwnersWithAccessToMap =
			setOfNotNull(keyMap.delegate, keyMap.delegator, *dataOwnersWithAccessToMapThroughDelegation.toTypedArray())
		val dataOwnersNeedingShare = delegates.filter { it !in dataOwnersWithAccessToMap }
		if (dataOwnersNeedingShare.isNotEmpty()) {
			entity.simpleShareOrUpdateEncryptedEntityMetadata(
				keyMapWithType,
				dataOwnersNeedingShare.associateWith {
					SimpleDelegateShareOptionsImpl(
						shareSecretIds = SecretIdShareOptions.UseExactly(emptySet(), false),
						shareEncryptionKey = ShareMetadataBehaviour.Required,
						shareOwningEntityIds = ShareMetadataBehaviour.Never,
						requestedPermissions = RequestedPermission.FullRead
					)
				},
				true,
				{ id ->
					EntityWithTypeInfo(
						getDecryptedSecureDelegationKeyMaps(setOf(keyMap.delegationKey), entityType).first { it.id == id },
						entityType
					)
				},
				{
					delegationKeyMapsApi.bulkShare(
						it,
						accessControlKeysHeadersProvider.getAccessControlKeysHeadersFor(entityType)
					).successBody()
				}
			).updatedEntityOrThrow()
		}
	}

	// Important: to avoid potentially leaking links between entities of different types the key map calculates the secure delegation keys using the
	// same entity type as the delegation key for which they are mapping information.
	private suspend fun createSecureDelegationKeyMap(
		entityType: EntityWithEncryptionMetadataTypeName,
		delegationKey: String,
		delegationMembersDetails: SecureDelegationMembersDetails,
		delegates: Set<String>
	) {
		ensure(
			delegationMembersDetails.delegate != null
				&& delegationMembersDetails.delegator != null
				&& delegationMembersDetails.accessControlSecret != null
		) {
			"Delegation members details are missing delegate, delegator or access control secret info."
		}
		val selfDoId = dataOwnerApi.getCurrentDataOwnerId()
		val initialDelegates = setOf(delegationMembersDetails.delegate, delegationMembersDetails.delegator, *delegates.toTypedArray())
			.filter { it != selfDoId }
		val initialMapInfo = entity.entityWithInitializedEncryptedMetadata(
			entity = EntityWithTypeInfo(
				DecryptedSecureDelegationKeyMap(
					id = crypto.strongRandom.randomUUID(),
					delegate  =delegationMembersDetails.delegate,
					delegator = delegationMembersDetails.delegator,
					delegationKey = delegationKey
				),
				entityType,
			),
			owningEntityId = null,
			owningEntitySecretId = null,
			initializeEncryptionKey = true,
			autoDelegations = initialDelegates.associateWith { AccessLevel.Read }
		)
		val encryptedKeyMap = entity.encryptEntity(
			EntityWithTypeInfo(
				initialMapInfo.updatedEntity,
				entityType,
			),
			DecryptedSecureDelegationKeyMap.serializer(),
			delegationKeyMapFieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedSecureDelegationKeyMap>(it) }
		delegationKeyMapsApi.createSecureDelegationKeyMap(
			encryptedKeyMap,
			listOf(delegationMembersDetails.accessControlSecret.toAccessControlKeyStringFor(entityType, crypto)).encodeAsAccessControlHeaders().map { it.s }
		).successBody()
	}
}
