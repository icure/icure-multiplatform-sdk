package com.icure.sdk.api

import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.DataOwnerWithType


interface DataOwnerApi {
	/**
	 * Get the current data owner in full, regardless of its type. This method returns the full entity, including also
	 * information that is outside the scope of the [com.icure.sdk.model.base.CryptoActor] interface.
	 * Fails if the current user is not a data owner.
	 * @return the data owner associated to the current user.
	 */
	suspend fun getCurrentDataOwner(): DataOwnerWithType

	/**
	 * Get a stub of the current data owner. The stub contains only the information from the CryptoActor interface +
	 * id and rev.
	 * Fails if the current user is not a data owner.
	 * @return the crypto actor stub of the data owner associated to the current user.
	 */
	suspend fun getCurrentDataOwnerStub(): CryptoActorStubWithType

	/**
	 * If the logged user is a data owner get the current data owner id. This information is cached without expiration,
	 * and will only be updated in case of forced refresh.
	 * Fails if the current user is not a data owner.
	 * @return the current data owner id
	 */
	suspend fun getCurrentDataOwnerId(): String

	/**
	 * If the logged user is a data owner get its parent hierarchy. This information is cached without expiration, and
	 * will only be updated in case of forced refresh.
	 * The resulting list starts with the topmost parent (the only ancestor without a parent) and ends with the data
	 * owner itself.
	 * Fails if the current user is not a data owner.
	 * @return a list containing the ids of the current data owner hierarchy, ending with the current data owner id.
	 */
	suspend fun getCurrentDataOwnerHierarchyIds(): List<String>

	/**
	 * Get a data owner regardless of its actual type. The logged user must have the permission to access the data
	 * owner. For example, if [ownerId] turns out to be associated to a patient, and it is not shared with the current
	 * user this method will fail.
	 * If are interested only in the [com.icure.sdk.model.base.CryptoActor] information of the data owner and its
	 * [com.icure.sdk.model.DataOwnerType] you should use the [getCryptoActorStub] method instead.
	 * @param ownerId the id of a data owner (patient, hcp or device)
	 * @return the full data owner associated to the provided id.
	 */
	suspend fun getDataOwner(ownerId: String): DataOwnerWithType

	/**
	 * Get a data owner regardless of its actual type. Does not require any special permission.
	 * @param ownerId the id of a data owner (patient, hcp or device)
	 * @return the full data owner associated to the provided id.
	 */
	suspend fun getCryptoActorStub(ownerId: String): CryptoActorStubWithType

	/**
	 * Get the hierarchy for the current data owner starting from the specified parent.
	 * Fails if the current user is not a data owner.
	 * @param parentId the id of a member of the current data owner hierarchy.
	 * @return an array starting at the topmost parent and ending at the provided parent id.
	 * @throws IllegalArgumentException If the provided id is not part of the hierarchy
	 */
	suspend fun getCurrentDataOwnerHierarchyIdsFrom(parentId: String): List<String>

	/**
	 * If the logged user is a data owner get the current data owner and all of his parents. The returned list starts
	 * from the topmost ancestor of the current data owner and ends with the current data owner.
	 * Fails if the current user is not a data owner.
	 * @return a list containing the current data owner hierarchy, ending with the current data owner.
	 */
	suspend fun getCurrentDataOwnerHierarchy(): List<DataOwnerWithType>

	/**
	 * Modifies the crypto actor information of a data owner. The information that can be modified depend on the
	 * permissions of the current user, by default only information that refer to the current user can be changed.
	 * @param cryptoActorStubWithTypeDto the stub with updated information
	 * @return the updated stub, with updated revision
	 */
	suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): CryptoActorStubWithType

	/**
	 * If the logged user is a data owner get the type of the current data owner. This information is cached.
	 * @return the type of the current data owner
	 */
	suspend fun getCurrentDataOwnerType(): DataOwnerType

	/**
	 * Clears the cache of current data owner id and parent hierarchy ids. The hierarchy of a data owner should not
	 * normally change over time, so this method should be rarely needed. The cache will be repopulated lazily.
	 */
	fun clearCurrentDataOwnerIdsCache()
}

