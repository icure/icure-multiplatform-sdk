package com.icure.sdk.crypto

import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi

/**
 * @internal this class is intended for internal use only and may be changed without notice.
 * This class helps to create confidential medical data in systems where multiple hcps share data with each other using parent hcps: while normally
 * the hcps would share all data with other hcps part of the same "family" (e.g. an hospital) there are situations where the medical data is
 * confidential and should only be known by the doctor which created the data. In these situations it is also important that the secret foreign key
 * used in the confidential data is not known by other members of the hcp family, otherwise they may be able to draw some links between the medical
 * data and the patient.
 */
@InternalIcureApi
interface ConfidentialEntities {
	/**
	 * Ensures that the current data owner has access to a confidential secret id for the provided entity: this is an id that is known to the data owner
	 * but is not known by any of his parents. If there is currently no confidential secret id for this entity the method returns a copy of the entity
	 * with a new confidential secret id for the current data owner (the entity in the database won't be updated), else this method returns undefined.
	 * New confidential secret ids will have an appropriate tag, but existing confidential secret ids may not necessarily have it.
	 * @param entity an entity which needs to have a confidential secret id for the current data owner
	 * @param entityType the type of the entity
	 * @param doRequestBulkShareOrUpdate perform the request to share or update an entity encrypted metadata on the cloud API (and save to DB).
	 * @return undefined if the entity already had a confidential secret id for the current user, or the updated AND SAVED entity with the new
	 * confidential secret id.
	 */
	suspend fun <T : Encryptable> initialiseConfidentialSecretId(
		entity: T,
		entityType: EntityWithDelegationTypeName,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<T>>
	): T?

	/**
	 * Get an existing confidential secret id of the provided entity for the provided data owner (current data owner by default). A confidential secret
	 * id is a secret id known by the data owner but not known by any of his parents: note however that children will know confidential secret ids.
	 * @param entity an entity for which you want to retrieve the confidential secret id.
	 * @param dataOwnerId (current data owner by default) a data owner for which you want to get a confidential secret id.
	 * @return the confidential secret id or undefined if there is no confidential secret id for the provided data owner.
	 */
	suspend fun getConfidentialSecretId(entity: Encryptable, dataOwnerId: String? = null): String?

	/**
	 * Get all existing confidential secret ids of the provided entity for the provided data owner (current data owner by default). A confidential secret
	 * id is a secret id known by the data owner but not known by any of his parents: note however that children will know confidential secret ids.
	 * @param entity an entity for which you want to retrieve the confidential secret id.
	 * @param dataOwnerId (current data owner by default) a data owner for which you want to get a confidential secret id.
	 * @return the confidential secret ids for the data owner (may be empty).
	 */
	suspend fun getConfidentialSecretIds(entity: Encryptable, dataOwnerId: String? = null): List<String>

	/**
	 * Gets a secret id known by the topmost parent of the current data owner hierarchy. If there is multiple secret ids shared with the topmost parent
	 * there is no guarantee on which one will be chosen.
	 * @param entity an entity.
	 * @return a secret id known by the topmost parent of the current data owner hierarchy, or undefined if there is no secret id currently available
	 * for the topmost parent.
	 */
	suspend fun getAnySecretIdSharedWithParents(entity: Encryptable): String?

	/**
	 * Gets all secret ids known by the topmost parent of the current data owner hierarchy (or all secret ids known by the current data owner if he is
	 * not part of any data owner hierarchy).
	 * @param entity an entity.
	 * @return all secret ids known by the topmost parent of the current data owner hierarchy, may be empty.
	 */
	suspend fun getSecretIdsSharedWithParents(entity: Encryptable): List<String>
}