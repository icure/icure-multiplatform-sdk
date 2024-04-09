package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.InternalCryptoApi
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
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
	suspend fun matchPatientsBy(filter: AbstractFilter<EncryptedPatient>): List<String>
	suspend fun deletePatient(entityId: String): DocIdentifier
	suspend fun deletePatients(entityIds: List<String>): List<DocIdentifier>
	suspend fun undeletePatient(patientIds: String): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface PatientBasicFlavouredApi<E : Patient> {
	suspend fun modifyPatient(entity: E): E
	suspend fun getPatient(entityId: String): E
	suspend fun filterPatientsBy(
		filterChain: FilterChain<EncryptedPatient>,
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
	suspend fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String? = null,
		startDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>

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
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface PatientApi : PatientBasicFlavourlessApi, PatientFlavouredApi<DecryptedPatient> {
	suspend fun createPatient(patient: DecryptedPatient): DecryptedPatient
	suspend fun withEncryptionMetadata(
		base: DecryptedPatient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption
	): DecryptedPatient

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

}

interface PatientBasicApi : PatientBasicFlavourlessApi, PatientBasicFlavouredApi<EncryptedPatient>

@InternalIcureApi
private abstract class AbstractPatientBasicFlavouredApi<E : Patient>(protected val rawApi: RawPatientApi) :
	PatientBasicFlavouredApi<E> {
	override suspend fun modifyPatient(entity: E): E =
		rawApi.modifyPatient(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


	override suspend fun getPatient(entityId: String): E = rawApi.getPatient(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun filterPatientsBy(
		filterChain: FilterChain<EncryptedPatient>,
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
	override suspend fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findPatientsByAccessLogUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }
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
	private val encryptionService: EntityEncryptionService,
) : AbstractPatientBasicFlavouredApi<E>(rawApi), PatientFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		patient: E,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
			patient.withTypeInfo(),
			false,
			mapOf(
				delegateId to SimpleDelegateShareOptions(
					shareSecretIds = shareSecretIds,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}
}

@InternalIcureApi
private class AbstractPatientBasicFlavourlessApi(val rawApi: RawPatientApi) : PatientBasicFlavourlessApi {
	override suspend fun matchPatientsBy(filter: AbstractFilter<EncryptedPatient>) = rawApi.matchPatientsBy(filter).successBody()
	override suspend fun deletePatient(entityId: String) = rawApi.deletePatient(entityId).successBody()
	override suspend fun deletePatients(entityIds: List<String>) = rawApi.deletePatients(ListOfIds(entityIds)).successBody()
	override suspend fun undeletePatient(patientIds: String) = rawApi.undeletePatient(patientIds).successBody()
}

@InternalIcureApi
internal class PatientApiImpl(
	private val rawApi: RawPatientApi,
	private val crypto: InternalCryptoApi,
	private val encryptionService: EntityEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	private val autofillAuthor: Boolean,
) : PatientApi, PatientFlavouredApi<DecryptedPatient> by object :
	AbstractPatientFlavouredApi<DecryptedPatient>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedPatient): EncryptedPatient =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedPatient.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedPatient): DecryptedPatient {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedPatient.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi) {
	override val encrypted: PatientFlavouredApi<EncryptedPatient> =
		object : AbstractPatientFlavouredApi<EncryptedPatient>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
		}

	override val tryAndRecover: PatientFlavouredApi<Patient> =
		object : AbstractPatientFlavouredApi<Patient>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedPatient): Patient =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedPatient.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Patient): EncryptedPatient = when (entity) {
				is EncryptedPatient -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedPatient.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedPatient -> encryptionService.encryptEntity(
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


	override suspend fun withEncryptionMetadata(
		base: DecryptedPatient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedPatient =
		encryptionService.entityWithInitialisedEncryptedMetadata(
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

	private suspend fun encrypt(entity: DecryptedPatient) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedPatient.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }

	suspend fun decrypt(entity: EncryptedPatient, errorPatient: () -> String): DecryptedPatient = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedPatient.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
		?: throw EntityEncryptionException(errorPatient())

}

@InternalIcureApi
internal class PatientBasicApiImpl(
	rawApi: RawPatientApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : PatientBasicApi, PatientBasicFlavouredApi<EncryptedPatient> by object :
	AbstractPatientBasicFlavouredApi<EncryptedPatient>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi)
