package com.icure.sdk.api.flavoured

import com.icure.sdk.api.RecoveryApi
import com.icure.sdk.api.raw.RawCalendarItemApi
import com.icure.sdk.api.raw.RawClassificationApi
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.api.raw.RawFormApi
import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.RawInvoiceApi
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.crypto.entities.DelegateShareOptions
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.extensions.publicKeysSpki
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.Subscribable
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.ensureNonNull
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface PatientBasicFlavourlessApi : Subscribable<Patient, EncryptedPatient> {
	/**
	 * Get the ids of all health elements matching the provided filter.
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchPatientsBy(filter: AbstractFilter<Patient>): List<String>

	/**
	 * Deletes a patient. If you don't have write access to the patient the method will fail.
	 * @param entityId id of the patient.
	 * @return the id and revision of the deleted patient.
	 */
	suspend fun deletePatient(entityId: String): DocIdentifier

	/**
	 * Deletes many patients. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the patients.
	 * @return the id and revision of the deleted patients. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deletePatients(entityIds: List<String>): List<DocIdentifier>

	/**
	 * Restores patients that were marked as deleted (but not purged). This method won't restore any content if before
	 * deletion you had destroyed the content.
	 * @param patientIds the ids of patients to restore
	 * @return the undeleted patient ids and revisions
	 */
	suspend fun undeletePatients(patientIds: List<String>): List<DocIdentifier>

	/**
	 * Get all data owners with access to the provided patient, attempting to identify any unknown anonymous data owners
	 * using delegations de-anonymization metadata.
	 * @param patient a patient
	 * @return information on users with access to the provided patient
	 */
	suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation

	@Deprecated("This method gives inaccurate results outside of the simples scenarios, use match instead")
	suspend fun countOfPatients(hcPartyId: String): Int
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface PatientBasicFlavouredApi<E : Patient> {
	/**
	 * Modifies a patient. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a patient with update content
	 * @return the patient updated with the provided content and a new revision.
	 */
	suspend fun modifyPatient(entity: E): E

	/**
	 * Get a patient by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a patient, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a patient id.
	 * @return the patient with id [entityId].
	 */
	suspend fun getPatient(entityId: String): E


	/**
	 * Get the patient with the provided id and follows the chain of patient merges indicated by the
	 * [Patient.mergeToPatientId] field until a patient that was not merged into another patient is reached, then that
	 * patient is returned.
	 * You can optionally limit the maximum depth of merges this method will go through by providing a [maxMergeDepth]
	 * parameter. This parameter limits the amount of links that will be resolved: if by the time the [maxMergeDepth] is
	 * reached the end of the merge chain is not yet reached this method will throw an exception.
	 * @param patientId the id of a patient
	 * @param maxMergeDepth a number greater than 0 or null if you don't want to limit the merge depth
	 * @return the patient at the end of the merge chain
	 * @throws IllegalArgumentException if maxMergeLevel is less than 1, or if the max merge level has been reached but
	 * the end of the merge chain was not yet reached.
	 */
	suspend fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Int? = null): E

	/**
	 * @param filter a patient filter
	 * @return an iterator that iterates over all patients matching the provided filter.
	 */
	suspend fun filterPatientsBy(filter: AbstractFilter<Patient>): PaginatedListIterator<E>

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsByNameBirthSsinAuto(
		@DefaultValue("null")
		healthcarePartyId: String? = null,
		filterValue: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		@DefaultValue("\"name\"")
		sortField: String = "name",
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listOfMergesAfter(date: Long): List<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsModifiedAfter(
		date: Long,
		@DefaultValue("null")
		startKey: Long? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun listPatientsByHcParty(
		hcPartyId: String,
		@DefaultValue("\"name\"")
		sortField: String = "name",
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsByHealthcareParty(
		@DefaultValue("null")
		hcPartyId: String? = null,
		@DefaultValue("\"name\"")
		sortField: String = "name",
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("com.icure.sdk.model.couchdb.SortDirection.Asc")
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<String>

	@Deprecated("This method has undefined behaviour in case multiple patients have the same external id. You should use the corresponding filter instead.")
	suspend fun getPatientByExternalId(externalId: String): E

	@Deprecated("Will be replaced by filter")
	suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		@DefaultValue("null")
		dateOfBirth: Int? = null,
	): List<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findDeletedPatients(
		startDate: Long,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		desc: Boolean? = null,
		@DefaultValue("null")
		startKey: Long? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listDeletedPatientsByName(
		@DefaultValue("null")
		firstName: String? = null,
		@DefaultValue("null")
		lastName: String? = null,
	): List<E>

	/**
	 * Get multiple patients by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a patient, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param patientIds a list of patients ids
	 * @return all patients that you can access with one of the provided ids.
	 */
	suspend fun getPatients(patientIds: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		@DefaultValue("null")
		system: String? = null,
	): E

	/**
	 * Modifies multiple patients. Ignores all patients for which you don't have write access.
	 * Flavoured method.
	 * @param patientDtos patients with update content
	 * @return the updated patients with a new revision.
	 */
	suspend fun modifyPatients(patientDtos: List<EncryptedPatient>): List<IdWithRev>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("List methods are deprecated", ReplaceWith("filterPatientsBy()"))
	suspend fun findDuplicatesByName(
		hcPartyId: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	/**
	 * Merge two patients into one. This method performs the following operations:
	 * - The `from` patient will be soft-deleted, and it will point to the `into` patient. Only the `deletionDate` and `mergeToPatientId` fields of the
	 *   patient will be changed (automatically by this method). Note that the value of [from] is only used to verify that the client is aware of
	 *   the last version of the `from` patient: any changes to its content and/or metadata compared to what is actually stored in the database will be
	 *   ignored.
	 * - The metadata of the `into` patient will be automatically updated to contain also the metadata of the `from` patient and to keep track of the
	 *   merge:
	 *   - the `mergedIds` will be updated to contain the `from` patient id
	 *   - all secret ids of the `from` patient will be added to the `into` patient
	 *   - all data owners (including anonymous data owners) with access to the `from` patient will have the same access to the merged `into` patient
	 *     (unless they already had greater access to the `into` patient, in which case they keep the greater access)
	 * - The content of the `into` patient will be updated to match the content (name, address, note, ...) of the provided [mergedInto] parameter.
	 *   Note that since the metadata is automatically updated by this method you must not change the metadata of the `mergedInto` patient
	 *   (`delegations`, mergedInto`, ...): if there is any change between the metadata of the provided `mergedInto` patient and the stored patient this
	 *   method will fail.
	 *
	 * In case the revisions of [from] and/or [mergedInto] does not match the latest revisions for these patients in the database this
	 * method will fail without soft-deleting the `from` patient and without updating the `into` patient with the merged content and metadata. You will
	 * have to retrieve the updated versions of both patients before retrying the merge.
	 *
	 * Finally, note that this method only merges existing data, and does not perform any automatic sharing of the data. The secret ids and encryption
	 * keys will not be shared with users that had access only to one of the entity, you will have to use a share method after the merge
	 * if you want to do so.
	 * For example consider hcps A, B with access to P' and hcps A, C with access to P'', and we merge P'' into P'. After the merge:
	 * - A has access to all secret ids of the merged patient and to the encryption key of the merged patient
	 * - B has access to the encryption key of the merged patient (since it is the same as in P'), but only to the secret id which was originally from
	 *   the unmerged P'
	 * - C has no access to the encryption key of the merged patient, and has access only to the secret id which was originally from the unmerged P''
	 *
	 * Note that the user performing this operation must have write access to both patients.
	 *
	 * @param from the original, unmodified `from` patient. Its content will be unchanged and its metadata will be automatically updated by this method
	 * to reflect the merge.
	 * @param mergedInto the `into` patient with updated content result of the merge with the `from` patient, as specified by your application logic.
	 * The metadata of the `mergedInto` patient must not differ from the metadata of the stored version of the patient, since it will be automatically
	 * updated by the method.
	 * @return the updated `into` patient.
	 */
	suspend fun mergePatients(from: Patient, mergedInto: E): E
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface PatientFlavouredApi<E : Patient> : PatientBasicFlavouredApi<E> {
	/**
	 * Share a patient with another data owner. The patient must already exist in the database for this method to
	 * succeed. If you want to share the patient before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param delegateId the owner that will gain access to the patient
	 * @param patient the patient to share with [delegateId]
	 * @param options specifies how the patient will be shared. Refer to the documentation of [PatientShareOptions] for more information.
	 * @return the updated patient if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		patient: E,
		options: PatientShareOptions
	): SimpleShareResult<E>

	/**
	 * Share a patient with multiple data owners. The patient must already exist in the database for this method to
	 * succeed. If you want to share the patient before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param patient the patient to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated patient if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		patient: E,
		delegates: Map<String, PatientShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a patient with multiple data owners. The patient must already exist in the database for this method to
	 * succeed. If you want to share the patient before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param patient the patient to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated patient.
	 */
	suspend fun shareWithMany(
		patient: E,
		delegates: Map<String, PatientShareOptions>
	): E

	/**
	 * Initializes a new "confidential" secret id for the provided patient if there is none, and saves it. Returns the
	 * updated patient if a new secret id was initialised, or the input if there was already a confidential secret id
	 * available.
	 *
	 * A "confidential" secret id is a secret id that was not shared with any of the current data owner parents, at
	 * least to the extent of the knowledge of the current data owner. If the current data owner is missing access to
	 * some of the keys of his parents a secret id that is not confidential may be mistakenly identified as confidential.
	 * The confidential secret id may be shared in a second moment with a parent data owner, making it not confidential
	 * anymore. It may also be possible to share the secret id with another non-parent data owner, in which case the
	 * secret id will still be considered as confidential.
	 *
	 * Confidential secret ids only make sense in environments where a hierarchical data owner structure is used. In
	 * other environments all secret ids are confidential by nature.
	 *
	 * @param patient a patient
	 * @return the input if there is already a secret id available for the patient, or the updated patient otherwise.
	 */
	suspend fun initialiseConfidentialSecretId(patient: E): E
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface PatientApi : PatientBasicFlavourlessApi, PatientFlavouredApi<DecryptedPatient> {
	/**
	 * Get all the secret ids that the current data owner can access from the provided patient.
	 * @param patient a patient
	 * @return the secret ids of the provided patient
	 */
	suspend fun getSecretIdsOf(patient: Patient): Set<String>

	/**
	 * Attempts to extract the encryption keys of a patient. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param patient a patient
	 * @return the encryption keys extracted from the provided patient.
	 */
	suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString>

	/**
	 * Create a new patient. The provided patient must have the encryption metadata initialised.
	 * @param patient a patient with initialised encryption metadata
	 * @return the created patient with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createPatient(patient: DecryptedPatient): DecryptedPatient

	/**
	 * Creates a new patient with initialised encryption metadata
	 * @param base a patient with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @return a patient with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedPatient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap()
	): DecryptedPatient
	/**
	 * Specifies if the current user has write access to a patient.
	 * @param patient a patient
	 * @return if the current user has write access to the provided patient
	 */
	suspend fun hasWriteAccess(patient: Patient): Boolean

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a patient.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided patient. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the patient the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Patient,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a patient E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any patient that you have shared with P, H will be able to know that the patient was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a patient that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a patient
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Set<String>)

	/**
	 * Decrypts a patient, throwing an exception if it is not possible.
	 * @param patient a patient
	 * @return the decrypted patient
	 * @throws EntityEncryptionException if the patient could not be decrypted
	 */
	suspend fun decrypt(patient: EncryptedPatient): DecryptedPatient

	/**
	 * Tries to decrypt a patient, returns the input if it is not possible.
	 * @param patient an encrypted patient
	 * @return the decrypted patient if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(patient: EncryptedPatient): Patient

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: PatientFlavouredApi<EncryptedPatient>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: PatientFlavouredApi<Patient>
	suspend fun createPatients(patientDtos: List<DecryptedPatient>): List<IdWithRev>

	/**
	 * Share a patient and all data associated to that patient that the current user can access with other data owners.
	 * @param patientId the id of the patient id to share
	 * @param delegatesWithShareType the data owners which will gain access to the patient data, and the type of data
	 * they should actually get access to.
	 * @return details on the result of the operation
	 */
	suspend fun shareAllDataOfPatient(
		patientId: String,
		delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>
	): ShareAllPatientDataOptions.Result

	@Deprecated("This method combines the getPatientId of a child document (contact, health element, ...) with the getPatientResolvingMerges method. Use the methods individually instead.")
	suspend fun getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfo<*>): String

	/**
	 * Get all confidential secret ids of a patient
	 *
	 * A "confidential" secret id is a secret id that was not shared with any of the current data owner parents, at
	 * least to the extent of the knowledge of the current data owner. If the current data owner is missing access to
	 * some of the keys of his parents a secret id that is not confidential may be mistakenly identified as confidential.
	 * The confidential secret id may be shared in a second moment with a parent data owner, making it not confidential
	 * anymore. It may also be possible to share the secret id with another non-parent data owner, in which case the
	 * secret id will still be considered as confidential.
	 *
	 * Confidential secret ids only make sense in environments where a hierarchical data owner structure is used. In
	 * other environments all secret ids are confidential by nature.
	 *
	 * @param patient a patient
	 * @return the confidential secret ids of the patient
	 */
	suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String>

	/**
	 * Initializes the exchange data towards a newly invited patient. This allows the doctor to share data with the
	 * patient even if the patient has not yet initialized a keypair for himself.
	 *
	 * This method should be used only if the patient has not yet initialized a keypair for himself. If the patient has
	 * already initialized a keypair this method does nothing and returns false. In this case the exchange data will be
	 * automatically created the first time you share data with the patient, and your implementation of the crypto
	 * strategies will be used to validate the public keys of the patient.
	 *
	 * Once exchange data is initialized you can use the [RecoveryApi.createExchangeDataRecoveryInfo] to
	 * generate a key that the patient will be able to use on his first login to immediately gain access to the exchange
	 * data (through the [RecoveryApi.recoverExchangeData] method).
	 *
	 * @param patientId the id of the newly invited patient.
	 * @return true if exchange data was initialized, false if the patient already has a key pair and the exchange data
	 * will be initialized in the standard way (automatically on the first time data is shared with the user).
	 */
	suspend fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Boolean
}

interface PatientBasicApi : PatientBasicFlavourlessApi, PatientBasicFlavouredApi<EncryptedPatient>

@InternalIcureApi
private abstract class AbstractPatientBasicFlavouredApi<E : Patient>(
	protected val rawApi: RawPatientApi,
	private val config: BasicApiConfiguration,
) :
	PatientBasicFlavouredApi<E> {
	override suspend fun modifyPatient(entity: E): E =
		rawApi.modifyPatient(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


	override suspend fun getPatient(entityId: String): E = rawApi.getPatient(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun filterPatientsBy(filter: AbstractFilter<Patient>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchPatientsBy(filter).successBody(),
			this::getPatients
		)

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String?,
		filterValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	) = rawApi.findPatientsByNameBirthSsinAuto(
		healthcarePartyId,
		filterValue,
		startKey,
		startDocumentId,
		limit,
		sortDirection,
	).successBody().map { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	) = rawApi.listPatientsOfHcParty(
		hcPartyId,
		sortField,
		startKey,
		startDocumentId,
		limit,
		sortDirection,
	).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listOfMergesAfter(date: Long) = rawApi.listOfMergesAfter(date).successBody().map { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findPatientsModifiedAfter(date, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	) = rawApi.listPatientsByHcParty(
		hcPartyId,
		sortField,
		startKey,
		startDocumentId,
		limit,
		sortDirection,
	).successBody().map { maybeDecrypt(it) }

	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	) = rawApi.findPatientsByHealthcareParty(
		hcPartyId,
		sortField,
		startKey,
		startDocumentId,
		limit,
		sortDirection,
	).successBody().map { maybeDecrypt(it) }

	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findPatientsIdsByHealthcareParty(hcPartyId, startKey, startDocumentId, limit).successBody()

	@Deprecated("This method has undefined behaviour in case multiple patients have the same external id. You should use the corresponding filter instead.")
	override suspend fun getPatientByExternalId(externalId: String) = rawApi.getPatientByExternalId(externalId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int?,
	) = rawApi.fuzzySearch(firstName, lastName, dateOfBirth).successBody().map { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long?,
		desc: Boolean?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDeletedPatients(startDate, endDate, desc, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
	@Deprecated("Will be replaced by filter")
	override suspend fun listDeletedPatientsByName(
		firstName: String?,
		lastName: String?,
	) = rawApi.listDeletedPatientsByName(firstName, lastName).successBody().map { maybeDecrypt(it) }

	override suspend fun getPatients(patientIds: List<String>) = rawApi.getPatients(ListOfIds(patientIds)).successBody().map { maybeDecrypt(it) }
	@Deprecated("Will be replaced by filter")
	override suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	) = rawApi.getPatientByHealthcarePartyAndIdentifier(hcPartyId, id, system).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyPatients(patientDtos: List<EncryptedPatient>) = rawApi.modifyPatients(patientDtos).successBody()
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDuplicatesBySsin(hcPartyId, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDuplicatesByName(hcPartyId, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedPatient
	abstract suspend fun maybeDecrypt(entity: EncryptedPatient): E

	override suspend fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Int?): E {
		tailrec suspend fun findLastMergedPatientInHierarchy(patient: E, depth: Int): E {
			val mergeId = patient.mergeToPatientId
			return if (mergeId != null) {
				require (maxMergeDepth == null || depth < maxMergeDepth) {
					"Merge chain for patient $patientId is longer than configured maxMergeDepth $maxMergeDepth"
				}
				findLastMergedPatientInHierarchy(getPatient(mergeId), depth + 1)
			} else patient
		}

		return findLastMergedPatientInHierarchy(getPatient(patientId), 0)
	}

	override suspend fun mergePatients(from: Patient, mergedInto: E): E {
		requireNotNull(mergedInto.rev) {
			"Into patient should have a non-null rev"
		}
		return rawApi.mergePatients(
			intoId = mergedInto.id,
			fromId = from.id,
			expectedFromRev = requireNotNull(from.rev) {
				"From patient should have a non-null rev"
			},
			updatedInto = validateAndMaybeEncrypt(mergedInto)
		).let {
			maybeDecrypt(it.successBody())
		}
	}
}

@InternalIcureApi
private abstract class AbstractPatientFlavouredApi<E : Patient>(
	rawApi: RawPatientApi,
	private val config: ApiConfiguration
) : AbstractPatientBasicFlavouredApi<E>(rawApi, config), PatientFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.patient

	override suspend fun shareWith(
		delegateId: String,
		patient: E,
		options: PatientShareOptions,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			patient.withTypeInfo(),
			false,
			mapOf(delegateId to options),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(patient: E, delegates: Map<String, PatientShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			patient.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(patient: E, delegates: Map<String, PatientShareOptions>): E =
		tryShareWithMany(patient, delegates).updatedEntityOrThrow()

	override suspend fun initialiseConfidentialSecretId(patient: E): E {
		requireNotNull(patient.rev) {
			"Patient must be created before confidential secret id initialisation"
		}
		return crypto.entity.initialiseConfidentialSecretId(
			patient.withTypeInfo(),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		} ?: patient
	}
}

@InternalIcureApi
private class AbstractPatientBasicFlavourlessApi(val rawApi: RawPatientApi, val config: BasicApiConfiguration) : PatientBasicFlavourlessApi {
	override suspend fun matchPatientsBy(filter: AbstractFilter<Patient>) = rawApi.matchPatientsBy(filter).successBody()
	override suspend fun deletePatient(entityId: String) = rawApi.deletePatient(entityId).successBody()
	override suspend fun deletePatients(entityIds: List<String>) = rawApi.deletePatients(ListOfIds(entityIds)).successBody()
	override suspend fun undeletePatients(patientIds: List<String>) = rawApi.undeletePatient(patientIds.joinToString(",")).successBody()
	override suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation =
		config.crypto.entityAccessInformationProvider.getDataOwnersWithAccessTo(patient.withTypeInfo())
	@Deprecated("This method gives inaccurate results outside of the simples scenarios, use match instead")
	override suspend fun countOfPatients(hcPartyId: String) = ensureNonNull(rawApi.countOfPatients(hcPartyId).successBody().numberValue) {
		"Count of patients has no number value"
	}.toInt()
	override suspend fun subscribeToEvents(
		events: Set<com.icure.sdk.subscription.SubscriptionEventType>,
		filter: AbstractFilter<Patient>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedPatient> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedPatient.serializer(),
			events = events,
			filter = filter,
			qualifiedName = Patient.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(PatientAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal class PatientApiImpl(
	private val rawApi: RawPatientApi,
	private val rawHealthcarePartyApi: RawHealthcarePartyApi,
	private val rawHealthElementApi: RawHealthElementApi,
	private val rawFormApi: RawFormApi,
	private val rawContactApi: RawContactApi,
	private val rawInvoiceApi: RawInvoiceApi,
	private val rawCalendarItemApi: RawCalendarItemApi,
	private val rawClassificationApi: RawClassificationApi,
	private val config: ApiConfiguration
) : PatientApi, PatientFlavouredApi<DecryptedPatient> by object :
	AbstractPatientFlavouredApi<DecryptedPatient>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedPatient): EncryptedPatient =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedPatient.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedPatient): DecryptedPatient =
		crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedPatient.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")

}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, config) {
	override val encrypted: PatientFlavouredApi<EncryptedPatient> =
		object : AbstractPatientFlavouredApi<EncryptedPatient>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
		}

	override val tryAndRecover: PatientFlavouredApi<Patient> =
		object : AbstractPatientFlavouredApi<Patient>(rawApi, config) {

			override suspend fun maybeDecrypt(entity: EncryptedPatient): Patient =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedPatient.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Patient): EncryptedPatient = when (entity) {
				is EncryptedPatient -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedPatient.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedPatient -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedPatient.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }
			}
		}

	override suspend fun createPatient(patient: DecryptedPatient): DecryptedPatient {
		require(patient.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createPatient(
			encrypt(patient),
		).successBody().let { decrypt(it) }
	}

	override suspend fun createPatients(patientDtos: List<DecryptedPatient>) = rawApi.createPatients(patientDtos.map { encrypt(it) }).successBody()

	private suspend fun findDelegationStubsForHcPartyAndParent(
		delegationSecretKeys: List<String>,
		hcpId: String,
		parentId: String?,
		stubGetter: suspend (String, List<String>) -> List<IcureStub>
	): List<IcureStub> {
		val stubs = stubGetter(hcpId, delegationSecretKeys) +
			if(parentId != null) stubGetter(parentId, delegationSecretKeys) else emptyList()
		return stubs.distinctBy { it.id }
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.patient

	override suspend fun shareAllDataOfPatient(
		patientId: String,
		delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>
	): ShareAllPatientDataOptions.Result {

		val allTags = delegatesWithShareType.values.flatMap { it.toList() }.toSet()

		val hcp = rawHealthcarePartyApi.getCurrentHealthcareParty().successBody() // Shall we do it for any data owner?
		val parentId = hcp.parentId
		val patient = encrypted.getPatient(patientId).let { patient ->
			crypto.entity.ensureEncryptionKeysInitialised(patient.withTypeInfo())?.let {
				encrypted.modifyPatient(it)
			} ?: patient
		}

		val delegationSecretKeys = getSecretIdsOf(patient)

		val shareStatus = if(delegationSecretKeys.isNotEmpty()) {
			suspend fun <T : HasEncryptionMetadata> doShareEntitiesAndUpdateStatus(
				entities: List<EntityWithTypeInfo<T>>,
				tagsCondition: (tags: Set<ShareAllPatientDataOptions.Tag>) -> Boolean,
				doShareMinimal: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<Nothing>>
			): ShareAllPatientDataOptions.EntityResult {
				val delegatesToApply = delegatesWithShareType.entries.mapNotNull { (delegateId, types) ->
					delegateId.takeIf { tagsCondition(types) }
				}
				return if(entities.isNotEmpty() && delegatesToApply.isNotEmpty()) {
					// Used a mutable list in the fold to avoid creating a new list at each iteration
					val updates = entities.fold(mutableListOf<Pair<EntityWithTypeInfo<T>, Map<String, DelegateShareOptions>>>()) { acc, entity ->
						val secretIds = crypto.entity.secretIdsOf(entity, null)
						val entityEncryptionKeys = crypto.entity.encryptionKeysOf(entity, null)
						acc.apply {
							add(entity to delegatesToApply.associateWith {
								DelegateShareOptions(
									shareSecretIds = secretIds,
									shareEncryptionKeys = entityEncryptionKeys,
									shareOwningEntityIds = setOf(patient.id),
									requestedPermissions = RequestedPermission.MaxWrite
								)
							})
						}
					}
					try {
						val result = crypto.entity.bulkShareOrUpdateEncryptedEntityMetadataNoEntities(updates, doShareMinimal)
						ShareAllPatientDataOptions.EntityResult(
							success = result.updateErrors.isEmpty(),
							error = BulkShareFailure(
								result.updateErrors,
								"Error while sharing (some) entities of type ${entities.firstOrNull()?.type} for patient ${patient.id}"
							).takeIf { result.updateErrors.isNotEmpty() },
							modified = result.successfulUpdates.map { it.entityId }.toSet().size
						)
					} catch (e: Exception) {
						ShareAllPatientDataOptions.EntityResult(
							success = false,
							error = FailedRequest("${e::class.simpleName}: ${e.message}")
						)
					}
				} else {
					ShareAllPatientDataOptions.EntityResult(success = true)
				}
			}

			val retrievedHealthElements = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawHealthElementApi.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareHealthElementsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedHealthElements.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.HealthElement) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawHealthElementApi.bulkShareMinimal(params).successBody() }

			val retrievedForms = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawFormApi.findFormsDelegationsStubsByHCPartyAndPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareFormsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedForms.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.Form) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawFormApi.bulkShareMinimal(params).successBody() }

			val retrievedContacts = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawContactApi.findContactsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareContactsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedContacts.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.Contact) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawContactApi.bulkShareMinimal(params).successBody() }

			val retrievedInvoices = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawInvoiceApi.findInvoicesDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareInvoicesResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedInvoices.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.Invoice) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.FinancialInformation) },
			) { params -> rawInvoiceApi.bulkShareMinimal(params).successBody() }

			val retrievedCalendarItems = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawCalendarItemApi.findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareCalendarItemsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedCalendarItems.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.CalendarItem) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawCalendarItemApi.bulkShareMinimal(params).successBody() }

			val retrievedClassifications = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawClassificationApi.findClassificationsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareClassificationResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedClassifications.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.Classification) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawClassificationApi.bulkShareMinimal(params).successBody() }

			mapOf(
				ShareAllPatientDataOptions.ShareableEntity.HealthElement to shareHealthElementsResult,
				ShareAllPatientDataOptions.ShareableEntity.Form to shareFormsResult,
				ShareAllPatientDataOptions.ShareableEntity.Contact to shareContactsResult,
				ShareAllPatientDataOptions.ShareableEntity.Invoice to shareInvoicesResult,
				ShareAllPatientDataOptions.ShareableEntity.CalendarItem to shareCalendarItemsResult,
				ShareAllPatientDataOptions.ShareableEntity.Classification to shareClassificationResult,
			)
		} else {
			ShareAllPatientDataOptions.ShareableEntity.entries.associateWith { entity ->
				ShareAllPatientDataOptions.EntityResult(
					success = false.takeIf { allTags.contains(entity.type) || allTags.contains(ShareAllPatientDataOptions.Tag.All) },
					error = null,
					modified = 0
				)
			}
		}

		val patientStatus = try {
			val result = crypto.entity.bulkShareOrUpdateEncryptedEntityMetadataNoEntities(listOf(
				patient.withTypeInfo() to delegatesWithShareType.keys.associateWith {
					DelegateShareOptions(
						shareSecretIds = delegationSecretKeys,
						shareEncryptionKeys = getEncryptionKeysOf(patient),
						shareOwningEntityIds = setOf(),
						requestedPermissions = RequestedPermission.MaxWrite
					)
				}
			)) { params -> rawApi.bulkShareMinimal(params).successBody() }
			ShareAllPatientDataOptions.EntityResult(
				success = result.updateErrors.isEmpty(),
				error = BulkShareFailure(
					errors = result.updateErrors,
					"Error while sharing patient ${patient.id}"
				).takeIf { result.updateErrors.isNotEmpty() },
				modified = result.successfulUpdates.map { it.entityId }.toSet().size
			)
		} catch (e: Exception) {
			ShareAllPatientDataOptions.EntityResult(
				success = false,
				error = FailedRequest("${e::class.simpleName}: ${e.message}")
			)
		}

		return ShareAllPatientDataOptions.Result(
			patient = patient,
			statuses = shareStatus + (ShareAllPatientDataOptions.ShareableEntity.Patient to patientStatus)
		)
	}

	@Deprecated("This method combines the getPatientId of a child document (contact, health element, ...) with the getPatientResolvingMerges method. Use the methods individually instead.")
	override suspend fun getPatientIdOfChildDocumentForHcpAndHcpParents(
		childDocument: EntityWithTypeInfo<*>
	): String {
		val parentIds = crypto.entity.owningEntityIdsOf(childDocument, null)
		check(parentIds.isNotEmpty()) {
			"Parent id is empty in CFK of child document with id ${childDocument.id}"
		}
		check(parentIds.size == 1) {
			"Child document with id ${childDocument.id} contains multiple parent ids in its CFKs"
		}

		tailrec suspend fun findLastMergedPatientInHierarchy(patient: DecryptedPatient, maxMergeLevel: Int): DecryptedPatient {
			return if(patient.mergeToPatientId != null) {
				require(maxMergeLevel > 0) {
					"Too many merged levels for parent (Patient) of child document ${childDocument.id}"
				}
				findLastMergedPatientInHierarchy(getPatient(patient.mergeToPatientId), maxMergeLevel - 1)
			} else patient
		}

		return findLastMergedPatientInHierarchy(getPatient(parentIds.first()), 10).id
 	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedPatient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedPatient =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedPatient(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			null,
			null,
			initialiseEncryptionKey = true,
			initialiseSecretId = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	override suspend fun hasWriteAccess(patient: Patient): Boolean = crypto.entity.hasWriteAccess(patient.withTypeInfo())

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun getSecretIdsOf(patient: Patient): Set<String> =
		crypto.entity.secretIdsOf(patient.withTypeInfo(), null)

	override suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString> =
		crypto.entity.encryptionKeysOf(patient.withTypeInfo(), null)

	override suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String> =
		crypto.entity.getConfidentialSecretIdsOf(patient.withTypeInfo(), null)

	private suspend fun encrypt(entity: DecryptedPatient) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedPatient.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }

	private suspend fun decryptOrNull(entity: EncryptedPatient): DecryptedPatient? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedPatient.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }

	override suspend fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Boolean {
		val patient = encrypted.getPatient(patientId)
		if (patient.publicKeysSpki.isNotEmpty()) return false
		crypto.exchangeDataManager.getOrCreateEncryptionDataTo(patientId, true)
		return true
	}

	override suspend fun decrypt(patient: EncryptedPatient): DecryptedPatient =
		decryptOrNull(patient) ?: throw EntityEncryptionException("Patient cannot be decrypted")

	override suspend fun tryDecrypt(patient: EncryptedPatient): Patient =
		decryptOrNull(patient) ?: patient
}

@InternalIcureApi
internal class PatientBasicApiImpl(
	rawApi: RawPatientApi,
	private val config: BasicApiConfiguration
) : PatientBasicApi, PatientBasicFlavouredApi<EncryptedPatient> by object :
	AbstractPatientBasicFlavouredApi<EncryptedPatient>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), config.encryption.patient)

	override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, config)
