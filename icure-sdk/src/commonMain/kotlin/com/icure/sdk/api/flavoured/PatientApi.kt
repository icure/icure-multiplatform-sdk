package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.crypto.BasicInternalCryptoApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.HealthElement
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
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.websocket.Connection
import com.icure.sdk.websocket.ConnectionImpl
import com.icure.sdk.websocket.Subscribable
import com.icure.sdk.websocket.WebSocketAuthProvider
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.time.Duration

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Patient.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface PatientBasicFlavourlessApi {
	suspend fun matchPatientsBy(filter: AbstractFilter<EncryptedPatient>): List<String>
	suspend fun deletePatient(entityId: String): DocIdentifier
	suspend fun deletePatients(entityIds: List<String>): List<DocIdentifier>
	suspend fun undeletePatient(patientIds: String): List<DocIdentifier>
	suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface PatientBasicFlavouredApi<E : Patient>: Subscribable<Patient, E> {
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

	suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String>

	//	suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String> = crypto.entity.getConfidentialSecretIdsOf(patient.withTypeInfo(), null)
	//

	//	}
}

interface PatientBasicApi : PatientBasicFlavourlessApi, PatientBasicFlavouredApi<EncryptedPatient>

@InternalIcureApi
private abstract class AbstractPatientBasicFlavouredApi<E : Patient>(
	protected val rawApi: RawPatientApi,
	private val webSocketAuthProvider: WebSocketAuthProvider,
) :
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

	@OptIn(InternalAPI::class)
	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<Patient>,
		onConnected: suspend () -> Unit,
		channelCapacity: Int,
		retryDelay: Duration,
		retryDelayExponentFactor: Double,
		maxRetries: Int,
		eventFired: suspend (E) -> Unit
	): Connection {
		return ConnectionImpl.initialize(
			client = rawApi.httpClient,
			hostname = this.rawApi.apiUrl.replace("https://", "").replace("http://", ""),
			path = "/ws/v2/notification/subscribe",
			serializer = EncryptedPatient.serializer(),
			events = events,
			filter = filter,
			qualifiedName = Patient.KRAKEN_QUALIFIED_NAME,
			subscriptionSerializer = { Serialization.json.encodeToString(it) },
			webSocketAuthProvider = webSocketAuthProvider,
			onOpenListener = onConnected,
			retryDelay = retryDelay,
			retryDelayExponentFactor = retryDelayExponentFactor,
			maxRetries = maxRetries,
			eventCallback = { event ->
				eventFired(maybeDecrypt(event))
			}
		)
	}

	abstract suspend fun tryMaybeDecrypt(entity: EncryptedPatient): E?
	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedPatient
	abstract suspend fun maybeDecrypt(entity: EncryptedPatient): E
}

@InternalIcureApi
private abstract class AbstractPatientFlavouredApi<E : Patient>(
	rawApi: RawPatientApi,
	private val crypto: InternalCryptoServices,
	webSocketAuthProvider: WebSocketAuthProvider,
) : AbstractPatientBasicFlavouredApi<E>(rawApi, webSocketAuthProvider), PatientFlavouredApi<E> {
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
	override suspend fun matchPatientsBy(filter: AbstractFilter<EncryptedPatient>) = rawApi.matchPatientsBy(filter).successBody()
	override suspend fun deletePatient(entityId: String) = rawApi.deletePatient(entityId).successBody()
	override suspend fun deletePatients(entityIds: List<String>) = rawApi.deletePatients(ListOfIds(entityIds)).successBody()
	override suspend fun undeletePatient(patientIds: String) = rawApi.undeletePatient(patientIds).successBody()
	override suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation =
		crypto.entityAccessInformationProvider.getDataOwnersWithAccessTo(patient.withTypeInfo())
}

@InternalIcureApi
internal class PatientApiImpl(
	private val rawApi: RawPatientApi,
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	private val autofillAuthor: Boolean,
	webSocketAuthProvider: WebSocketAuthProvider
) : PatientApi, PatientFlavouredApi<DecryptedPatient> by object :
	AbstractPatientFlavouredApi<DecryptedPatient>(rawApi, crypto, webSocketAuthProvider) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedPatient): EncryptedPatient =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedPatient.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }

	override suspend fun tryMaybeDecrypt(entity: EncryptedPatient): DecryptedPatient? {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedPatient.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}

	override suspend fun maybeDecrypt(entity: EncryptedPatient): DecryptedPatient {
		return tryMaybeDecrypt(entity)
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, crypto) {
	override val encrypted: PatientFlavouredApi<EncryptedPatient> =
		object : AbstractPatientFlavouredApi<EncryptedPatient>(rawApi, crypto, webSocketAuthProvider) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), fieldsToEncrypt)

			override suspend fun tryMaybeDecrypt(entity: EncryptedPatient): EncryptedPatient? = entity

			override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
		}

	override val tryAndRecover: PatientFlavouredApi<Patient> =
		object : AbstractPatientFlavouredApi<Patient>(rawApi, crypto, webSocketAuthProvider) {
			override suspend fun tryMaybeDecrypt(entity: EncryptedPatient): Patient =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedPatient.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
					?: entity

			override suspend fun maybeDecrypt(entity: EncryptedPatient): Patient =
				tryMaybeDecrypt(entity)

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

}

@InternalIcureApi
internal class PatientBasicApiImpl(
	rawApi: RawPatientApi,
	crypto: BasicInternalCryptoApi,
	webSocketAuthProvider: WebSocketAuthProvider,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : PatientBasicApi, PatientBasicFlavouredApi<EncryptedPatient> by object :
	AbstractPatientBasicFlavouredApi<EncryptedPatient>(rawApi, webSocketAuthProvider) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedPatient): EncryptedPatient =
		crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedPatient.serializer(), fieldsToEncrypt)

	override suspend fun tryMaybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity

	override suspend fun maybeDecrypt(entity: EncryptedPatient): EncryptedPatient = entity
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, crypto)
