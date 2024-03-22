package com.icure.sdk.model

import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensure
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalIcureApi
@Serializable
data class BulkShareOrUpdateMetadataParams(
	val requestsByEntityId: Map<String, EntityRequestInformationDto>
)

@InternalIcureApi
@Serializable
data class EntityRequestInformationDto(
	val requests: Map<String, EntityShareOrMetadataUpdateRequest>,
	/**
	 * Which delegations can be parents to any newly requested non-root delegations. Some may be ignored in order to
	 * simplify the delegation graph, or if the requested permission is root.
	 */
	val potentialParentDelegations: Set<SecureDelegationKeyString>
)

@InternalIcureApi
@Serializable
data class EntityShareOrMetadataUpdateRequest(
	val share: EntityShareRequest? = null,
	val update: EntitySharedMetadataUpdateRequest? = null,
) {
	init {
		ensure(share != null || update != null) { "Either share or update must be specified" }
		ensure(share == null || update == null) { "Only one of share or update must be specified" }
	}
}

/**
 * Holds parameters necessary to share an entity.
 */
@Serializable
data class EntityShareRequest(
	/**
	 * Id of the data owner which is sharing the entity (delegator), if it should be explicitly indicated or null if the
	 * delegator requires anonymous delegations. If not null this must match the logged data owner id.
	 */
	// We can easily infer the delegator id server-side, but the decision of whether to include it or not in the secure
	// delegation is done on client-side.
	val explicitDelegator: String? = null,
	/**
	 * Id of the data owner which will gain access to the entity (delegate), if it should be explicitly indicated or
	 * null if the delegate requires anonymous delegations.
	 */
	val explicitDelegate: String? = null,
	/**
	 * Values generated using the access control secret of the exchange data used for the encryption of the ids and keys
	 * to share. Once hashed they are used as secure delegation keys.
	 */
	val accessControlKeys: Set<AccessControlKeyHexString>,
	/**
	 * Encrypted secret ids to share with the delegate.
	 */
	val secretIds: Set<Base64String> = emptySet(),
	/**
	 * Encrypted encryption keys to share with the delegate.
	 */
	val encryptionKeys: Set<Base64String> = emptySet(),
	/**
	 * Encrypted owning entity ids to share with the delegate.
	 */
	val owningEntityIds: Set<Base64String> = emptySet(),
	/**
	 * Id of the exchange data used for the encryption of the ids and keys to share. Must be null at least one of
	 * delegator or delegate is not explicit.
	 */
	val exchangeDataId: String? = null,
	/**
	 * Must be non-empty if exactly one of delegator or delegate is explicit and the other is not, empty in all other
	 * cases.
	 */
	val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	/**
	 * Permissions for the delegate.
	 */
	val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite
) {
	@InternalIcureApi
	fun wrap() = EntityShareOrMetadataUpdateRequest(share = this)
}


/**
 * Strategy to use for the calculation of permissions for the new [SecureDelegation.permissions]
 */
@Serializable
enum class RequestedPermission {
	/**
	 * The new secure delegation will give maximum access to the delegate, depending on the rights of the delegator.
	 * This is currently equivalent to [FullRead], but with the introduction of fine-grained access control this
	 * would behave more similar to [FullWrite].
	 */
	@SerialName("MAX_READ")
	MaxRead,

	/**
	 * The new secure delegation will give full-read access to the delegate.
	 *
	 * With the introduction of fine-grained access control a user may have limited read access to an entity, and
	 * in such case the request would fail (similarly to [FullWrite]).
	 */
	@SerialName("FULL_READ")
	FullRead,

	/**
	 * The new secure delegation will give maximum access to the delegate, depending on the rights of the delegator.
	 * If the delegator has full-write access the delegate will also have full-write access else the delegate will
	 * have full-read access.
	 */
	@SerialName("MAX_WRITE")
	MaxWrite,

	/**
	 * The new secure delegation will give full-write access to the delegate. If the delegator does not have
	 * full-write access to the entity the request will fail.
	 */
	@SerialName("FULL_WRITE")
	FullWrite,

	/**
	 * Request to create a root delegation on the entity. Usually new entities are created with a root delegation
	 * for the creator data owner and no other data owners will be able to obtain root permissions, but there are
	 * some situations where other data owners can create root delegations on existing entities:
	 * - If a data owner has a legacy delegation on an entity he can create a root delegation. This is necessary in
	 * cases where the data owner wants to share an entity with another data owner using the new delegation format
	 * but does not have a delegation in the new format yet (the data owner creates a new root delegation self->self
	 * and then creates a delegation self->other).
	 * - A patient data owner is always allowed to create a root delegation for himself
	 *
	 * A root delegation gives full write permissions to the data owners which can access it (usually a root
	 * delegation should be accessible only for one data owner, it should be a delegation a->a) and does not depend
	 * on any other delegation: this means that no data owners except for the data owners with the root permission
	 * can revoke it.
	 */
	@SerialName("ROOT")
	@InternalIcureApi
	Root
}

/**
 * Parameters for the update of shared metadata. Currently only changes to secret ids, encryption keys and owning entity
 * ids are allowed. In the future we are going to allow also changes to the permissions of users with access to the
 * shared metadata.
 */
@Serializable
data class EntitySharedMetadataUpdateRequest(
	/**
	 * Access control hash of the metadata to update.
	 */
	val metadataAccessControlHash: SecureDelegationKeyString,
	/**
	 * Updates for secret ids: the key is an encrypted secret id and the value is if an entry with that encrypted secret
	 * id should be created or deleted.
	 */
	val secretIds: Map<Base64String, EntryUpdateTypeDto> = emptyMap(),
	/**
	 * Updates for encryption keys: a key in the map is an encrypted encryption key and the value is if an entry with
	 * that encrypted encryption key should be created or deleted.
	 */
	val encryptionKeys: Map<Base64String, EntryUpdateTypeDto> = emptyMap(),
	/**
	 * Updates for owning entity ids: the key is the encrypted id of an owning entity and the value is if an entry with
	 * that encrypted owning entity id should be created or deleted.
	 */
	val owningEntityIds: Map<Base64String, EntryUpdateTypeDto> = emptyMap(),
) {
	/**
	 * Specifies if an entry should be created anew or deleted
	 */
	@Serializable
	enum class EntryUpdateTypeDto {
		@SerialName("CREATE")
		Create,
		@SerialName("DELETE")
		Delete
	}

	@InternalIcureApi
	fun wrap() = EntityShareOrMetadataUpdateRequest(update = this)
}

/**
 * Represents a reason why a share requests failed or was rejected.
 */
@Serializable
data class RejectedShareOrMetadataUpdateRequest(
	/**
	 * Code of the error, mimics an http status code (400 general user error, 409 conflict, ...).
	 */
	val code: Int,
	/**
	 * If true a new share request with the same content may succeed so the user is encouraged to retry. This could
	 * happen if the entity to share changed while verifying the validity of the request (correctness, permissions,
	 * ...), and if the entity did not change in ways incompatible with the request re-performing the request in
	 * the same way may succeed.
	 */
	val shouldRetry: Boolean = false,
	/**
	 * Human-friendly message explaining the reason of the failure.
	 */
	val reason: String
)

/**
 * Result of a bulk share operation.
 */
@Serializable
data class MinimalEntityBulkShareResult(
	/**
	 * Id of the entity for which the update was requested.
	 */
	val entityId: String,
	/**
	 * Last known revision of the entity before any update, non-null only if an entity matching the requests could be
	 * found. This can help to understand if an error is caused by an outdated version of the entity on the client-side.
	 */
	val entityRev: String? = null,
	/**
	 * If a `bulkShare` method fails to apply any of the share requests for an entity this map associates the id of the
	 * original failed request to the reason of failure.
	 */
	val rejectedRequests: Map<String, RejectedShareOrMetadataUpdateRequest> = emptyMap()
)

/**
 * Result of a bulk share operation.
 */
@Serializable
data class EntityBulkShareResult<T : Encryptable>(
	/**
	 * The updated entity. Non-null if at least one of the requests succeeded.
	 */
	val updatedEntity: T? = null,
	/**
	 * Id of the entity for which the update was requested.
	 */
	val entityId: String,
	/**
	 * Last known revision of the entity before any update, non-null only if an entity matching the requests could be
	 * found. This can help to understand if an error is caused by an outdated version of the entity on the client-side.
	 */
	val entityRev: String? = null,
	/**
	 * If a `bulkShare` method fails to apply any of the share requests for an entity this map associates the id of the
	 * original failed request to the reason of failure.
	 */
	val rejectedRequests: Map<String, RejectedShareOrMetadataUpdateRequest> = emptyMap()
)
