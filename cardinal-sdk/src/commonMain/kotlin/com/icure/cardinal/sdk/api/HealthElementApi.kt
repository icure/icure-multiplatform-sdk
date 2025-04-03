package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface HealthElementBasicFlavourlessApi  {
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteHealthElementUnsafe(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteHealthElementsUnsafe(entityIds: List<String>): List<DocIdentifier>
	
	/**
	 * Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 * @param entityId id of the healthElement.
	 * @param rev the latest known rev of the healthElement to delete
	 * @return the id and revision of the deleted healthElement.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteHealthElementById(entityId: String, rev: String?): DocIdentifier

	/**
	 * Deletes many healthElements. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the healthElements to delete.
	 * @return the id and revision of the deleted healthElements. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteHealthElementsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Permanently deletes a healthElement.
	 * @param id id of the healthElement to purge
	 * @param rev latest revision of the healthElement
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeHealthElementById(id: String, rev: String)

	/**
	 * Deletes a healthElement. If you don't have write access to the healthElement the method will fail.
	 * @param healthElement the healthElement to delete
	 * @return the id and revision of the deleted healthElement.
	 * @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	suspend fun deleteHealthElement(healthElement: HealthElement): DocIdentifier =
		deleteHealthElementById(healthElement.id, requireNotNull(healthElement.rev) { "Can't delete an healthElement that has no rev" })

	/**
	 * Deletes many healthElements. Ignores healthElement for which you don't have write access or that don't match the latest revision.
	 * @param healthElements the healthElements to delete
	 * @return the id and revision of the deleted healthElements. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteHealthElements(healthElements: List<HealthElement>): List<DocIdentifier> =
		deleteHealthElementsByIds(healthElements.map { healthElement ->
			IdWithMandatoryRev(healthElement.id, requireNotNull(healthElement.rev) { "Can't delete an healthElement that has no rev" })
		})

	/**
	 * Permanently deletes a healthElement.
	 * @param healthElement the healthElement to purge.
	 * @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	suspend fun purgeHealthElement(healthElement: HealthElement) {
		purgeHealthElementById(healthElement.id, requireNotNull(healthElement.rev) { "Can't delete an healthElement that has no rev" })
	}
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface HealthElementBasicFlavouredApi<E : HealthElement> {
	/**
	 * Restores a healthElement that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteHealthElementById(id: String, rev: String): E
	
	/**
	 * Restores a healthElement that was marked as deleted.
	 * @param healthElement the healthElement to undelete
	 * @return the restored healthElement.
	 * @throws RevisionConflictException if the provided healthElement doesn't match the latest known revision
	 */
	suspend fun undeleteHealthElement(healthElement: HealthElement): E =
		undeleteHealthElementById(healthElement.id, requireNotNull(healthElement.rev) { "Can't delete an healthElement that has no rev" })

	/**
	 * Modifies a health element. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a health element with update content
	 * @return the health element updated with the provided content and a new revision.
	 */
	suspend fun modifyHealthElement(entity: E): E

	/**
	 * Modifies multiple health elements. Ignores all health elements for which you don't have write access.
	 * Flavoured method.
	 * @param entities health elements with update content
	 * @return the updated health elements with a new revision.
	 */
	suspend fun modifyHealthElements(entities: List<E>): List<E>

	/**
	 * Get a health element by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a health element, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a health element id.
	 * @return the health element with id [entityId].
	 */
	suspend fun getHealthElement(
		entityId: String,
		@DefaultValue("null")
		groupId: String? = null
	): E

	/**
	 * Get multiple health elements by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a health element, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of health elements ids
	 * @return all health elements that you can access with one of the provided ids.
	 */
	suspend fun getHealthElements(entityIds: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface HealthElementFlavouredApi<E : HealthElement> : HealthElementBasicFlavouredApi<E> {
	/**
	 * Share a health element with another data owner. The health element must already exist in the database for this method to
	 * succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the health element
	 * @param healthElement the health element to share with [delegateId]
	 * @param options specifies how the health element will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the health element. Refer
	 * to the documentation of [HealthElementShareOptions] for more information.
	 * @return the updated health element if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		healthElement: E,
		@DefaultValue("null")
		options: HealthElementShareOptions? = null
	): E

	/**
	 * Share a health element with multiple data owners. The health element must already exist in the database for this method to
	 * succeed. If you want to share the health element before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param healthElement the health element to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated health element.
	 */
	suspend fun shareWithMany(
		healthElement: E,
		delegates: Map<String, HealthElementShareOptions>
	): E

	suspend fun shareInGroup(
		healthElement: E,
		entityGroupId: String?,
		delegates: @JsMapAsObjectArray(flattenKey = true, flattenValue = true) Map<EntityReferenceInGroup, HealthElementShareOptions>
	): E

	@Deprecated("Use filter instead")
	suspend fun findHealthElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBy(
		filter: FilterOptions<HealthElement>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBySorted(
		filter: SortableFilterOptions<HealthElement>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface HealthElementApi : HealthElementBasicFlavourlessApi, HealthElementFlavouredApi<DecryptedHealthElement>, Subscribable<HealthElement, EncryptedHealthElement, FilterOptions<HealthElement>> {
	/**
	 * Create a new health element. The provided health element must have the encryption metadata initialized.
	 * @param entity a health element with initialized encryption metadata
	 * @return the created health element with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createHealthElement(
		entity: DecryptedHealthElement,
		@DefaultValue("null")
		groupId: String? = null
	): DecryptedHealthElement

	/**
	 * Create multiple health elements. All the provided health elements must have the encryption metadata initialized, otherwise
	 * this method fails without doing anything.
	 * @param entities health elements with initialized encryption metadata
	 * @return the created health elements with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any health element in the input was not initialized.
	 */
	suspend fun createHealthElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement>

	/**
	 * Creates a new health element with initialized encryption metadata
	 * @param base a health element with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the health element.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new health element
	 * @return a health element with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
	): DecryptedHealthElement

	/**
	 * Equivalent to [withEncryptionMetadata] but initializes the encryption metadata for storage in a group that
	 * can be different from the current user's group, or with delegates in an external group.
	 */
	suspend fun withEncryptionMetadataForGroup(
		entityGroupId: String?,
		base: DecryptedHealthElement?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: @JsMapAsObjectArray(flattenKey = true, valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
	): DecryptedHealthElement

	/**
	 * Attempts to extract the encryption keys of a health element. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param healthElement a health element
	 * @return the encryption keys extracted from the provided health element.
	 */
	suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString>

	/**
	 * Specifies if the current user has write access to a health element.
	 * @param healthElement a health element
	 * @return if the current user has write access to the provided health element
	 */
	suspend fun hasWriteAccess(healthElement: HealthElement): Boolean

	/**
	 * Attempts to extract the patient id linked to a health element.
	 * Note: health elements usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param healthElement a health element
	 * @return the id of the patient linked to the health element, or empty if the current user can't access any patient id
	 * of the health element.
	 */
	suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a health element.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided health element. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the health element the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any HealthElement,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a health element E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any health element that you have shared with P, H will be able to know that the health element was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a health element that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a health element
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>)

	/**
	 * Decrypts a health element, throwing an exception if it is not possible.
	 * @param healthElement a health element
	 * @return the decrypted health element
	 * @throws EntityEncryptionException if the health element could not be decrypted
	 */
	suspend fun decrypt(healthElement: EncryptedHealthElement, groupId: String? = null): DecryptedHealthElement

	/**
	 * Tries to decrypt a health element, returns the input if it is not possible.
	 * @param healthElement an encrypted health element
	 * @return the decrypted health element if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(healthElement: EncryptedHealthElement, groupId: String? = null): HealthElement

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: HealthElementFlavouredApi<EncryptedHealthElement>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: HealthElementFlavouredApi<HealthElement>

	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBy(filter: FilterOptions<HealthElement>): List<String>

	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): List<String>
}

interface HealthElementBasicApi : HealthElementBasicFlavourlessApi, HealthElementBasicFlavouredApi<EncryptedHealthElement>, Subscribable<HealthElement, EncryptedHealthElement, BaseFilterOptions<HealthElement>> {
	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): List<String>

	/**
	 * Get the ids of all health elements matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): List<String>

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterHealthElementsBySorted] instead.
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBy(
		filter: BaseFilterOptions<HealthElement>
	): PaginatedListIterator<EncryptedHealthElement>

	/**
	 * Get an iterator that iterates through all health elements matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterHealthElementsBy].
	 *
	 * @param filter a health element filter
	 * @return an iterator that iterates over all health elements matching the provided filter.
	 */
	suspend fun filterHealthElementsBySorted(
		filter: BaseSortableFilterOptions<HealthElement>
	): PaginatedListIterator<EncryptedHealthElement>
}
