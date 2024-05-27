package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawCalendarItemApi
import com.icure.sdk.api.raw.RawClassificationApi
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.api.raw.RawFormApi
import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.RawInvoiceApi
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.crypto.BasicInternalCryptoApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.DelegateShareOptions
import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareErrorsException
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DataOwnerRegistrationSuccess
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
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.extensions.publicKeysSpki
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Patient.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface PatientBasicFlavourlessApi {
	suspend fun matchPatientsBy(filter: AbstractFilter<Patient>): List<String>
	suspend fun deletePatient(entityId: String): DocIdentifier
	suspend fun deletePatients(entityIds: List<String>): List<DocIdentifier>
	suspend fun undeletePatient(patientIds: String): List<DocIdentifier>
	suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface PatientBasicFlavouredApi<E : Patient> {
	suspend fun modifyPatient(entity: E): E
	suspend fun getPatient(entityId: String): E
	suspend fun filterPatientsBy(
		filterChain: FilterChain<Patient>,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skip: Int? = null,
		sort: String? = null,
		desc: Boolean? = null
	): PaginatedList<E>

	suspend fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String? = null,
		filterValue: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	suspend fun listOfMergesAfter(date: Long): List<E>
	suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>

	suspend fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	suspend fun getPatientHcPartyKeysForDelegate(patientId: String): Map<String, String>
	suspend fun countOfPatients(hcPartyId: String): EncryptedContent
	suspend fun findPatientsByHealthcareParty(
		hcPartyId: String? = null,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): PaginatedList<E>

	suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<String>

	suspend fun getPatientByExternalId(externalId: String): E

	suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int? = null,
	): List<E>

	suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long? = null,
		desc: Boolean? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>

	suspend fun listDeletedPatientsByName(
		firstName: String? = null,
		lastName: String? = null,
	): List<E>

	suspend fun getPatients(patientIds: ListOfIds): List<E>
	suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String? = null,
	): E

	suspend fun modifyPatients(patientDtos: List<EncryptedPatient>): List<IdWithRev>
	suspend fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Long? = null,
		end: Long? = null,
	): E

	suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>

	suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>

	suspend fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatient,
	): E
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface PatientFlavouredApi<E : Patient> : PatientBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		patient: E,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param patient the [Patient] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the [SimpleShareResult] of the operation: the updated entity if the operation was successful or details of the error if
	 * the operation failed.
	 */
	suspend fun tryShareWithMany(
		patient: E,
		delegates: Map<String, PatientShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param patient the [Patient] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the updated entity.
	 * @throws IllegalStateException if the operation was not successful.
	 */
	suspend fun shareWithMany(
		patient: E,
		delegates: Map<String, PatientShareOptions>
	): E

	suspend fun initialiseConfidentialSecretId(patient: E): E
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface PatientApi : PatientBasicFlavourlessApi, PatientFlavouredApi<DecryptedPatient> {
	suspend fun getSecretIdsOf(patient: Patient): Set<String>
	suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString>
	suspend fun createPatient(patient: DecryptedPatient): DecryptedPatient
	suspend fun withEncryptionMetadata(
		base: DecryptedPatient? = null,
		user: User? = null,
		delegates: Map<String, AccessLevel> = emptyMap()
	): DecryptedPatient
	suspend fun createDelegationsDeAnonymizationMetadata(patient: Patient, dataOwnerIds: Set<String>)
	suspend fun hasWriteAccess(patient: Patient): Boolean
	suspend fun decryptPatientIdOf(patient: Patient): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Set<String>)

	val encrypted: PatientFlavouredApi<EncryptedPatient>
	val tryAndRecover: PatientFlavouredApi<Patient>
	suspend fun createPatients(patientDtos: List<DecryptedPatient>): List<IdWithRev>
	suspend fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String? = null,
		useShortToken: Boolean? = null,
		createAutoDelegation: Boolean = true,
		patient: DecryptedPatient
	): DataOwnerRegistrationSuccess

	suspend fun shareAllDataOfPatient(
		user: User,
		patientId: String,
		dataOwnerId: String,
		delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>
	): ShareAllPatientDataOptions.Result

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
	 * Once exchange data is initialized you can use the {@link IccRecoveryXApi.createExchangeDataRecoveryInfo} to
	 * generate a key that the patient will be able to use on his first login to immediately gain access to the exchange
	 * data (through the {@link IccRecoveryXApi.recoverExchangeData} method).
	 *
	 * @param patientId the id of the newly invited patient.
	 * @return true if exchange data was initialized, false if the patient already has a key pair and the exchange data
	 * will be initialized in the standard way (automatically on the first time data is shared with the user).
	 */
	suspend fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Boolean
}

interface PatientBasicApi : PatientBasicFlavourlessApi, PatientBasicFlavouredApi<EncryptedPatient>

@InternalIcureApi
private abstract class AbstractPatientBasicFlavouredApi<E : Patient>(protected val rawApi: RawPatientApi) :
	PatientBasicFlavouredApi<E> {
	override suspend fun modifyPatient(entity: E): E =
		rawApi.modifyPatient(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


	override suspend fun getPatient(entityId: String): E = rawApi.getPatient(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun filterPatientsBy(
		filterChain: FilterChain<Patient>,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		skip: Int?,
		sort: String?,
		desc: Boolean?,
	): PaginatedList<E> =
		rawApi.filterPatientsBy(
            startKey,
            startDocumentId,
            limit,
            skip,
            sort,
            desc, filterChain,
        ).successBody().map { maybeDecrypt(it) }

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

	override suspend fun listOfMergesAfter(date: Long) = rawApi.listOfMergesAfter(date).successBody().map { maybeDecrypt(it) }
	override suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findPatientsModifiedAfter(date, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
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

	override suspend fun getPatientHcPartyKeysForDelegate(patientId: String) = rawApi.getPatientHcPartyKeysForDelegate(patientId).successBody()
	override suspend fun countOfPatients(hcPartyId: String) = rawApi.countOfPatients(hcPartyId).successBody()
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

	override suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findPatientsIdsByHealthcareParty(hcPartyId, startKey, startDocumentId, limit).successBody()

	override suspend fun getPatientByExternalId(externalId: String) = rawApi.getPatientByExternalId(externalId).successBody().let { maybeDecrypt(it) }

	override suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int?,
	) = rawApi.fuzzySearch(firstName, lastName, dateOfBirth).successBody().map { maybeDecrypt(it) }
	override suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long?,
		desc: Boolean?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDeletedPatients(startDate, endDate, desc, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
	override suspend fun listDeletedPatientsByName(
		firstName: String?,
		lastName: String?,
	) = rawApi.listDeletedPatientsByName(firstName, lastName).successBody().map { maybeDecrypt(it) }

	override suspend fun getPatients(patientIds: ListOfIds) = rawApi.getPatients(patientIds).successBody().map { maybeDecrypt(it) }
	override suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	) = rawApi.getPatientByHealthcarePartyAndIdentifier(hcPartyId, id, system).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyPatients(patientDtos: List<EncryptedPatient>) = rawApi.modifyPatients(patientDtos).successBody()
	override suspend fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Long?,
		end: Long?,
	) = rawApi.modifyPatientReferral(patientId, referralId, start, end).successBody().let { maybeDecrypt(it) }
	override suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDuplicatesBySsin(hcPartyId, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
	override suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDuplicatesByName(hcPartyId, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
	override suspend fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatient,
	) = rawApi.mergePatients(intoId, fromId, expectedFromRev, updatedInto).successBody().let { maybeDecrypt(it) }


	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedPatient
	abstract suspend fun maybeDecrypt(entity: EncryptedPatient): E
}

@InternalIcureApi
private abstract class AbstractPatientFlavouredApi<E : Patient>(
	rawApi: RawPatientApi,
	private val crypto: InternalCryptoServices,
) : AbstractPatientBasicFlavouredApi<E>(rawApi), PatientFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		patient: E,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			patient.withTypeInfo(),
			false,
			mapOf(
				delegateId to SimpleDelegateShareOptionsImpl(
					shareSecretIds = shareSecretIds,
					shareEncryptionKey = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
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
private class AbstractPatientBasicFlavourlessApi(val rawApi: RawPatientApi, val crypto: BasicInternalCryptoApi) : PatientBasicFlavourlessApi {
	override suspend fun matchPatientsBy(filter: AbstractFilter<Patient>) = rawApi.matchPatientsBy(filter).successBody()
	override suspend fun deletePatient(entityId: String) = rawApi.deletePatient(entityId).successBody()
	override suspend fun deletePatients(entityIds: List<String>) = rawApi.deletePatients(ListOfIds(entityIds)).successBody()
	override suspend fun undeletePatient(patientIds: String) = rawApi.undeletePatient(patientIds).successBody()
	override suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation =
		crypto.entityAccessInformationProvider.getDataOwnersWithAccessTo(patient.withTypeInfo())
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
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	private val autofillAuthor: Boolean,
) : PatientApi, PatientFlavouredApi<DecryptedPatient> by object :
	AbstractPatientFlavouredApi<DecryptedPatient>(rawApi, crypto) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedPatient): EncryptedPatient =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedPatient.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedPatient): DecryptedPatient {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedPatient.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, crypto) {
	override val encrypted: PatientFlavouredApi<EncryptedPatient> =
		object : AbstractPatientFlavouredApi<EncryptedPatient>(rawApi, crypto) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
		}

	override val tryAndRecover: PatientFlavouredApi<Patient> =
		object : AbstractPatientFlavouredApi<Patient>(rawApi, crypto) {
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
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createPatients(patientDtos: List<DecryptedPatient>) = rawApi.createPatients(patientDtos.map { encrypt(it) }).successBody()

	override suspend fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String?,
		useShortToken: Boolean?,
		createAutoDelegation: Boolean,
		patient: DecryptedPatient,
	): DataOwnerRegistrationSuccess = rawApi.registerPatient(
		hcPartyId,
		groupId,
		token,
		useShortToken,
		createAutoDelegation,
		encrypt(patient),
	).successBody()

	override suspend fun shareAllDataOfPatient(
		user: User,
		patientId: String,
		dataOwnerId: String,
		delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>
	): ShareAllPatientDataOptions.Result {

		val allTags = delegatesWithShareType.values.flatMap { it.toList() }.toSet()

		val hcp = rawHealthcarePartyApi.getHealthcareParty(dataOwnerId).successBody() // Shall we do it for any data owner?
		val parentId = hcp.parentId
		val patient = encrypted.getPatient(patientId).let { patient ->
			crypto.entity.ensureEncryptionKeysInitialised(patient.withTypeInfo())?.let {
				encrypted.modifyPatient(it)
			} ?: patient
		}

		val delegationSecretKeys = getSecretIdsOf(patient)

		val shareStatus = if(delegationSecretKeys.isNotEmpty()) {

			suspend fun findDelegationStubsForHcPartyAndParent(
				stubGetter: suspend (String, List<String>) -> List<IcureStub>
			): List<IcureStub> {
				val stubs = stubGetter(hcp.id, delegationSecretKeys.toList()) +
					if(parentId != null) stubGetter(parentId, delegationSecretKeys.toList()) else emptyList()
				return stubs.distinctBy { it.id }
			}

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
							error = BulkShareErrorsException(
								result.updateErrors,
								"Error while sharing (some) entities of type ${entities.firstOrNull()?.type} for patient ${patient.id}"
							).takeIf { result.updateErrors.isNotEmpty() },
							modified = result.successfulUpdates.map { it.entityId }.toSet().size
						)
					} catch (e: Exception) {
						ShareAllPatientDataOptions.EntityResult(success = false, error = e)
					}
				} else {
					ShareAllPatientDataOptions.EntityResult(success = true)
				}
			}

			val retrievedHealthElements = findDelegationStubsForHcPartyAndParent { doId, delSecKeys ->
				rawHealthElementApi.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareHealthElementsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedHealthElements.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.HealthElement) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawHealthElementApi.bulkShareMinimal(params).successBody() }

			val retrievedForms = findDelegationStubsForHcPartyAndParent { doId, delSecKeys ->
				rawFormApi.findFormsDelegationsStubsByHCPartyAndPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareFormsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedForms.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.Form) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawFormApi.bulkShareMinimal(params).successBody() }

			val retrievedContacts = findDelegationStubsForHcPartyAndParent { doId, delSecKeys ->
				rawContactApi.findContactsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareContactsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedContacts.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.Contact) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawContactApi.bulkShareMinimal(params).successBody() }

			val retrievedInvoices = findDelegationStubsForHcPartyAndParent { doId, delSecKeys ->
				rawInvoiceApi.findInvoicesDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareInvoicesResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedInvoices.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.Invoice) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.FinancialInformation) },
			) { params -> rawInvoiceApi.bulkShareMinimal(params).successBody() }

			val retrievedCalendarItems = findDelegationStubsForHcPartyAndParent { doId, delSecKeys ->
				rawCalendarItemApi.findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareCalendarItemsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedCalendarItems.map { EntityWithTypeInfo(it, EntityWithEncryptionMetadataTypeName.CalendarItem) },
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation) },
			) { params -> rawCalendarItemApi.bulkShareMinimal(params).successBody() }

			val retrievedClassifications = findDelegationStubsForHcPartyAndParent { doId, delSecKeys ->
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
				error = BulkShareErrorsException(
					errors = result.updateErrors,
					"Error while sharing patient ${patient.id}"
				).takeIf { result.updateErrors.isNotEmpty() },
				modified = result.successfulUpdates.map { it.entityId }.toSet().size
			)
		} catch (e: Exception) {
			ShareAllPatientDataOptions.EntityResult(success = false, error = e)
		}

		return ShareAllPatientDataOptions.Result(
			patient = patient,
			statuses = shareStatus + (ShareAllPatientDataOptions.ShareableEntity.Patient to patientStatus)
		)
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
				responsible = base?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { autofillAuthor },
			).withTypeInfo(),
			null,
			null,
			initialiseEncryptionKey = true,
			initialiseSecretId = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	override suspend fun createDelegationsDeAnonymizationMetadata(patient: Patient, dataOwnerIds: Set<String>) =
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(patient.withTypeInfo(), dataOwnerIds)

	override suspend fun hasWriteAccess(patient: Patient): Boolean = crypto.entity.hasWriteAccess(patient.withTypeInfo())

	override suspend fun decryptPatientIdOf(patient: Patient): Set<String> = crypto.entity.owningEntityIdsOf(patient.withTypeInfo(), null)

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

	suspend fun decrypt(entity: EncryptedPatient, errorPatient: () -> String): DecryptedPatient = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedPatient.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
		?: throw EntityEncryptionException(errorPatient())

	override suspend fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Boolean {
		val patient = encrypted.getPatient(patientId)
		if (patient.publicKeysSpki.isNotEmpty()) return false
		crypto.exchangeDataManager.getOrCreateEncryptionDataTo(patientId, true)
		return true
	}
}

@InternalIcureApi
internal class PatientBasicApiImpl(
	rawApi: RawPatientApi,
	crypto: BasicInternalCryptoApi,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : PatientBasicApi, PatientBasicFlavouredApi<EncryptedPatient> by object :
	AbstractPatientBasicFlavouredApi<EncryptedPatient>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
		crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, crypto)
