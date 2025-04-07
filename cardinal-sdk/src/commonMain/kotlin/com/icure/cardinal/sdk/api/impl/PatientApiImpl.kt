package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.PatientApi
import com.icure.cardinal.sdk.api.PatientBasicApi
import com.icure.cardinal.sdk.api.PatientBasicFlavouredApi
import com.icure.cardinal.sdk.api.PatientBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.PatientBasicFlavourlessApi
import com.icure.cardinal.sdk.api.PatientBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.PatientBasicInGroupApi
import com.icure.cardinal.sdk.api.PatientFlavouredApi
import com.icure.cardinal.sdk.api.PatientFlavouredInGroupApi
import com.icure.cardinal.sdk.api.PatientInGroupApi
import com.icure.cardinal.sdk.api.raw.RawCalendarItemApi
import com.icure.cardinal.sdk.api.raw.RawClassificationApi
import com.icure.cardinal.sdk.api.raw.RawContactApi
import com.icure.cardinal.sdk.api.raw.RawFormApi
import com.icure.cardinal.sdk.api.raw.RawHealthElementApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawInvoiceApi
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecurityMetadataType
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.asIcureStub
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapPatientFilterOptions
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.couchdb.SortDirection
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedPatient, EncryptedPatient> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedPatient.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Patient,
	manifest = EntitiesEncryptedFieldsManifests::patient
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedPatient, DecryptedPatient> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedPatient.serializer(),
	decryptedSerializer = DecryptedPatient.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Patient,
	manifest = EntitiesEncryptedFieldsManifests::patient,
	patchJson = JsonPatcher::patchPatient
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedPatient, Patient> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedPatient.serializer(),
	decryptedSerializer = DecryptedPatient.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Patient,
	manifest = EntitiesEncryptedFieldsManifests::patient,
	patchJson = JsonPatcher::patchPatient
)

@InternalIcureApi
private open class AbstractPatientBasicFlavouredApi<E : Patient>(
	protected val rawApi: RawPatientApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedPatient, E>
) : PatientBasicFlavouredApi<E>, PatientBasicFlavouredInGroupApi<E>, FlavouredApi<EncryptedPatient, E> by flavour {
	override suspend fun createPatient(patient: E): E =
		doCreatePatient(null, patient)

	override suspend fun createPatient(patient: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doCreatePatient(patient.groupId, patient.entity), patient.groupId)

	private suspend fun doCreatePatient(groupId: String?, patient: E): E {
		require(patient.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		val encrypted = validateAndMaybeEncrypt(groupId, patient)
		return (
			if (groupId == null)
				rawApi.createPatient(encrypted)
			else
				rawApi.createPatientInGroup(groupId, encrypted)
			).successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun undeletePatientById(id: String, rev: String): E =
		rawApi.undeletePatient(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun undeletePatients(ids: List<StoredDocumentIdentifier>): List<E> =
		rawApi.undeletePatients(ListOfIdsAndRev(ids)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyPatient(entity: E): E =
		rawApi.modifyPatient(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun getPatient(entityId: String): E =
		doGetPatient(null, entityId)

	override suspend fun getPatient(groupId: String, entityId: String): GroupScoped<E> =
		GroupScoped(doGetPatient(groupId, entityId), groupId)

	protected suspend fun doGetPatient(groupId: String?, entityId: String) =
		doGetEncryptedPatient(groupId, entityId).let { maybeDecrypt(groupId, it) }

	private suspend fun doGetEncryptedPatient(groupId: String?, entityId: String) =
		(
			if (groupId == null)
				rawApi.getPatient(entityId)
			else
				rawApi.getPatientInGroup(groupId = groupId, patientId = entityId)
		).successBody()


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
	).successBody().let { maybeDecrypt(it) }
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
	).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listOfMergesAfter(date: Long) = rawApi.listOfMergesAfter(date).successBody().let { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findPatientsModifiedAfter(date, startKey, startDocumentId, limit).successBody().let { maybeDecrypt(it) }
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
	).successBody().let { maybeDecrypt(it) }

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
	).successBody().let { maybeDecrypt(it) }

	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findPatientsIdsByHealthcareParty(hcPartyId, startKey, startDocumentId, limit).successBody()

	@Deprecated("This method has undefined behaviour in case multiple patients have the same external id. You should use the corresponding filter instead.")
	override suspend fun getPatientByExternalId(externalId: String) = rawApi.getPatientByExternalId(externalId).successBody().let { maybeDecrypt(null, it) }

	@Deprecated("Use filter instead")
	override suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int?,
	) = rawApi.fuzzySearch(firstName, lastName, dateOfBirth).successBody().let { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long?,
		desc: Boolean?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDeletedPatients(startDate, endDate, desc, startKey, startDocumentId, limit).successBody().let { maybeDecrypt(it) }
	@Deprecated("Use filter instead")
	override suspend fun listDeletedPatientsByName(
		firstName: String?,
		lastName: String?,
	) = rawApi.listDeletedPatientsByName(firstName, lastName).successBody().let { maybeDecrypt(it) }

	override suspend fun getPatients(patientIds: List<String>) = rawApi.getPatients(ListOfIds(patientIds)).successBody().let { maybeDecrypt(it) }
	@Deprecated("Use filter instead")
	override suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	) = rawApi.getPatientByHealthcarePartyAndIdentifier(hcPartyId, id, system).successBody().let { maybeDecrypt(null, it) }

	override suspend fun modifyPatients(patientDtos: List<EncryptedPatient>) = rawApi.modifyPatients(patientDtos).successBody()
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDuplicatesBySsin(hcPartyId, startKey, startDocumentId, limit).successBody().let { maybeDecrypt(it) }
	@Deprecated("List methods are deprecated", replaceWith = ReplaceWith("filterPatientsBy()"))
	override suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findDuplicatesByName(hcPartyId, startKey, startDocumentId, limit).successBody().let { maybeDecrypt(it) }

	override suspend fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Int?): E =
		doGetPatientResolvingMerges(null, patientId, maxMergeDepth)

	override suspend fun getPatientResolvingMerges(
		groupId: String,
		patientId: String,
		maxMergeDepth: Int?
	): GroupScoped<E> =
		doGetPatientResolvingMerges(groupId, patientId, maxMergeDepth).let { GroupScoped(it, groupId) }

	private suspend fun doGetPatientResolvingMerges(
		groupId: String?,
		patientId: String,
		maxMergeDepth: Int?
	): E {
		tailrec suspend fun findLastMergedPatientInHierarchy(patient: EncryptedPatient, depth: Int): EncryptedPatient {
			val mergeId = patient.mergeToPatientId
			return if (mergeId != null) {
				require (maxMergeDepth == null || depth < maxMergeDepth) {
					"Merge chain for patient $patientId is longer than configured maxMergeDepth $maxMergeDepth"
				}
				findLastMergedPatientInHierarchy(doGetEncryptedPatient(groupId, mergeId), depth + 1)
			} else patient
		}

		return findLastMergedPatientInHierarchy(doGetEncryptedPatient(groupId, patientId), 0).let {
			maybeDecrypt(groupId, it)
		}
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
			updatedInto = validateAndMaybeEncrypt(null, mergedInto)
		).let {
			maybeDecrypt(null, it.successBody())
		}
	}
}

@InternalIcureApi
private class AbstractPatientFlavouredApi<E : Patient>(
	rawApi: RawPatientApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedPatient, E>
) : AbstractPatientBasicFlavouredApi<E>(rawApi, config, flavour), PatientFlavouredApi<E>, PatientFlavouredInGroupApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		patient: E,
		options: PatientShareOptions?,
	): E =
		shareWithMany(patient, mapOf(delegateId to (options ?: PatientShareOptions())))

	override suspend fun shareWithMany(patient: E, delegates: Map<String, PatientShareOptions>): E =
		doShareWithMany(null, patient, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		patient: GroupScoped<E>,
		options: PatientShareOptions?
	): GroupScoped<E> =
		shareWithMany(patient, mapOf(delegate to (options ?: PatientShareOptions())))

	override suspend fun shareWithMany(
		patient: GroupScoped<E>,
		delegates: Map<EntityReferenceInGroup, PatientShareOptions>
	): GroupScoped<E> =
		GroupScoped(doShareWithMany(patient.groupId, patient.entity, delegates), patient.groupId)

	private suspend fun doShareWithMany(
		groupId: String?,
		patient: E,
		delegates: Map<EntityReferenceInGroup, PatientShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			groupId,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			delegates,
			true,
			{ doGetPatient(groupId, it) },
			{
				maybeDecrypt(
					groupId,
					if (groupId == null)
						rawApi.bulkShare(it).successBody()
					else
						rawApi.bulkShare(it, groupId).successBody()
				)
			}
		).updatedEntityOrThrow()

	private suspend fun doInitializeConfidentialSecretId(groupId: String?, patient: E): E {
		requireNotNull(patient.rev) {
			"Patient must be created before confidential secret id initialisation"
		}
		return config.crypto.entity.initializeConfidentialSecretId(
			groupId,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			{ doGetPatient(groupId, it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		) ?: patient
	}

	override suspend fun initializeConfidentialSecretId(patient: E): E =
		doInitializeConfidentialSecretId(null, patient)

	override suspend fun initializeConfidentialSecretId(patient: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doInitializeConfidentialSecretId(patient.groupId, patient.entity), patient.groupId)

	override suspend fun filterPatientsBySorted(filter: SortableFilterOptions<Patient>): PaginatedListIterator<E> =
		filterPatientsBy(filter)

	override suspend fun filterPatientsBy(filter: FilterOptions<Patient>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchPatientsBy(mapPatientFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)).successBody(),
			this::getPatients
		)
}

@InternalIcureApi
private class AbstractPatientBasicFlavourlessApi(val rawApi: RawPatientApi, val config: BasicApiConfiguration) :
	PatientBasicFlavourlessApi, PatientBasicFlavourlessInGroupApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deletePatientUnsafe(entityId: String): StoredDocumentIdentifier =
		rawApi.deletePatient(entityId).successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deletePatientsUnsafe(entityIds: List<String>): List<StoredDocumentIdentifier> =
		rawApi.deletePatients(ListOfIds(entityIds)).successBody().toStoredDocumentIdentifier()

	override suspend fun deletePatientById(entityId: String, rev: String): StoredDocumentIdentifier =
		rawApi.deletePatient(entityId, rev).successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	override suspend fun deletePatientsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		rawApi.deletePatientsWithRev(ListOfIdsAndRev(entityIds)).successBody().toStoredDocumentIdentifier()

	override suspend fun purgePatientById(id: String, rev: String) {
		rawApi.purgePatient(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation =
		doGetDataOwnersWithAccessTo(null, patient)

	override suspend fun getDataOwnersWithAccessTo(patient: GroupScoped<Patient>): EntityAccessInformation =
		doGetDataOwnersWithAccessTo(patient.groupId, patient.entity).mapNullGroupTo(patient.groupId)

	private suspend fun doGetDataOwnersWithAccessTo(groupId: String?, patient: Patient): EntityAccessInformation =
		config.crypto.entityAccessInformationProvider.getDataOwnersWithAccessTo(groupId, patient, EntityWithEncryptionMetadataTypeName.Patient)

	@Deprecated("This method gives inaccurate results outside of the simples scenarios, use match instead")
	override suspend fun countOfPatients(hcPartyId: String) = ensureNonNull(rawApi.countOfPatients(hcPartyId).successBody().numberValue) {
		"Count of patients has no number value"
	}.toInt()
}

@InternalIcureApi
internal fun initPatientApi(
	rawApi: RawPatientApi,
	rawHealthcarePartyApi: RawHealthcarePartyApi,
	rawHealthElementApi: RawHealthElementApi,
	rawFormApi: RawFormApi,
	rawContactApi: RawContactApi,
	rawInvoiceApi: RawInvoiceApi,
	rawCalendarItemApi: RawCalendarItemApi,
	rawClassificationApi: RawClassificationApi,
	config: ApiConfiguration
): PatientApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractPatientFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractPatientFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractPatientFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	val basicFlavourless = AbstractPatientBasicFlavourlessApi(rawApi, config)
	return PatientApiImpl(
		rawApi,
		rawHealthcarePartyApi,
		rawHealthElementApi,
		rawFormApi,
		rawContactApi,
		rawInvoiceApi,
		rawCalendarItemApi,
		rawClassificationApi,
		config,
		decryptedApi,
		encryptedApi,
		tryAndRecoverApi,
		basicFlavourless
	)
}

@InternalIcureApi
private class PatientApiImpl(
	private val rawApi: RawPatientApi,
	private val rawHealthcarePartyApi: RawHealthcarePartyApi,
	private val rawHealthElementApi: RawHealthElementApi,
	private val rawFormApi: RawFormApi,
	private val rawContactApi: RawContactApi,
	private val rawInvoiceApi: RawInvoiceApi,
	private val rawCalendarItemApi: RawCalendarItemApi,
	private val rawClassificationApi: RawClassificationApi,
	private val config: ApiConfiguration,
	private val decryptedFlavour: AbstractPatientFlavouredApi<DecryptedPatient>,
	private val encryptedFlavour: AbstractPatientFlavouredApi<EncryptedPatient>,
	private val tryAndRecoverFlavour: AbstractPatientFlavouredApi<Patient>,
	private val basicFlavourless: AbstractPatientBasicFlavourlessApi
) :
	PatientApi,
	PatientFlavouredApi<DecryptedPatient> by decryptedFlavour,
	PatientBasicFlavourlessApi by basicFlavourless {
	override val encrypted: PatientFlavouredApi<EncryptedPatient> = encryptedFlavour

	override val tryAndRecover: PatientFlavouredApi<Patient> = tryAndRecoverFlavour

	override val inGroup: PatientInGroupApi = object : PatientInGroupApi,
		PatientFlavouredInGroupApi<DecryptedPatient> by decryptedFlavour,
		PatientBasicFlavourlessInGroupApi by basicFlavourless {
		override val encrypted: PatientFlavouredInGroupApi<EncryptedPatient> = encryptedFlavour
		override val tryAndRecover: PatientFlavouredInGroupApi<Patient> = tryAndRecoverFlavour

		override suspend fun decrypt(patients: List<GroupScoped<EncryptedPatient>>): List<GroupScoped<DecryptedPatient>> =
			patients.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(patients: List<GroupScoped<EncryptedPatient>>): List<GroupScoped<Patient>> =
			patients.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun encryptOrValidate(patients: List<GroupScoped<Patient>>): List<GroupScoped<EncryptedPatient>> =
			patients.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.validateAndMaybeEncrypt(groupId, entities)
			}

		override suspend fun getSecretIdsOf(patient: GroupScoped<Patient>): Set<String> =
			doGetSecretIdsOf(patient.groupId, patient.entity)

		override suspend fun getEncryptionKeysOf(patient: GroupScoped<Patient>): Set<HexString> =
			doGetEncryptionKeysOf(patient.groupId, patient.entity)

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedPatient?,
			user: User?,
			delegates: Map<EntityReferenceInGroup, AccessLevel>
		): GroupScoped<DecryptedPatient> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					user,
					delegates
				),
				entityGroupId
			)

		override suspend fun hasWriteAccess(patient: GroupScoped<DecryptedPatient>): Boolean =
			doHasWriteAccess(patient.groupId, patient.entity)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<DecryptedPatient>,
			delegates: Set<EntityReferenceInGroup>
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)
	}

	override suspend fun createPatients(patients: List<DecryptedPatient>) =
		rawApi.createPatients(
			config.crypto.entity.encryptEntities(
				null,
				patients,
				EntityWithEncryptionMetadataTypeName.Patient,
				DecryptedPatient.serializer(),
				config.encryption.patient,
			) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }
		).successBody()

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

	override suspend fun shareAllDataOfPatient(
		patientId: String,
		delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>
	): ShareAllPatientDataOptions.Result {

		val allTags = delegatesWithShareType.values.flatMap { it.toList() }.toSet()

		val hcp = rawHealthcarePartyApi.getCurrentHealthcareParty().successBody() // Shall we do it for any data owner?
		val parentId = hcp.parentId
		val patient = encrypted.getPatient(patientId).let { patient ->
			config.crypto.entity.ensureEncryptionKeysInitialized(
				null,
				patient,
				EntityWithEncryptionMetadataTypeName.Patient
			)?.let {
				encrypted.modifyPatient(it)
			} ?: patient
		}
		val selfHierarchySet = config.crypto.dataOwnerApi.getCurrentDataOwnerHierarchyIds().toSet()

		val delegationSecretKeys = getSecretIdsOf(patient)

		val shareStatus = if(delegationSecretKeys.isNotEmpty()) {
			suspend fun <T : HasEncryptionMetadata> doShareEntitiesAndUpdateStatus(
				entities: List<T>,
				entitiesType: EntityWithEncryptionMetadataTypeName,
				tagsCondition: (tags: Set<ShareAllPatientDataOptions.Tag>) -> Boolean,
				getEntity: suspend (id: String) -> T,
				doShareMinimal: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<Nothing>>
			): ShareAllPatientDataOptions.EntityResult {
				val delegatesToApply = delegatesWithShareType.entries.mapNotNull { (delegateId, types) ->
					delegateId.takeIf { tagsCondition(types) }
				}
				return if (entities.isNotEmpty() && delegatesToApply.isNotEmpty()) {
					val allSecretIds = config.crypto.securityMetadataDecryptor.decryptAll(
						null,
						entities,
						entitiesType,
						selfHierarchySet,
						SecurityMetadataType.SecretId
					)
					val allEntityEncryptionKeys = config.crypto.securityMetadataDecryptor.decryptAll(
						null,
						entities,
						entitiesType,
						selfHierarchySet,
						SecurityMetadataType.EncryptionKey
					)
					val updates = mutableListOf<Pair<T, Map<String, DelegateShareOptions>>>().also { acc ->
						entities.forEach { entity ->
							acc.add(entity to delegatesToApply.associateWith {
								DelegateShareOptions(
									shareSecretIds = allSecretIds[entity.id]?.mapTo(mutableSetOf()) { it.value }.orEmpty(),
									shareEncryptionKeys = allEntityEncryptionKeys[entity.id]?.mapTo(mutableSetOf()) { it.value }.orEmpty(),
									shareOwningEntityIds = setOf(patient.id),
									requestedPermissions = RequestedPermission.MaxWrite
								)
							})
						}
					}
					try {
						val result = config.crypto.entity.bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
							updates,
							entitiesType,
							true,
							getEntity,
							doShareMinimal
						)
						ShareAllPatientDataOptions.EntityResult(
							success = result.updateErrors.isEmpty(),
							error = BulkShareFailure(
								result.updateErrors,
								"Error while sharing (some) entities of type $entitiesType for patient ${patient.id}"
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
				val heIds = rawHealthElementApi.listHealthElementIdsByDataOwnerPatientOpeningDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawHealthElementApi.listHealthElementsDelegationsStubById(ListOfIds(heIds)).successBody()
			}
			val shareHealthElementsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedHealthElements,
				entitiesType = EntityWithEncryptionMetadataTypeName.HealthElement,
				tagsCondition = {
					it.contains(ShareAllPatientDataOptions.Tag.All)
						|| it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation)
				},
				getEntity = { rawHealthElementApi.getHealthElement(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawHealthElementApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedForms = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val formIds =  rawFormApi.listFormIdsByDataOwnerPatientOpeningDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawFormApi.findFormsDelegationsStubsByIds(ListOfIds(formIds)).successBody()
			}
			val shareFormsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedForms,
				entitiesType = EntityWithEncryptionMetadataTypeName.Form,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawFormApi.getForm(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawFormApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedContacts = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val contactIds = rawContactApi.listContactIdsByDataOwnerPatientOpeningDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawContactApi.findContactsDelegationsStubsByIds(ListOfIds(contactIds)).successBody()
			}
			val shareContactsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedContacts,
				entitiesType = EntityWithEncryptionMetadataTypeName.Contact,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawContactApi.getContact(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawContactApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedInvoices = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val invoiceIds = rawInvoiceApi.listInvoiceIdsByDataOwnerPatientInvoiceDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawInvoiceApi.listInvoicesDelegationsStubsByIds(ListOfIds(invoiceIds)).successBody()
			}
			val shareInvoicesResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedInvoices,
				entitiesType = EntityWithEncryptionMetadataTypeName.Invoice,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.FinancialInformation) },
				getEntity = { rawInvoiceApi.getInvoice(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawInvoiceApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedCalendarItems = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawCalendarItemApi.findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareCalendarItemsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedCalendarItems,
				entitiesType = EntityWithEncryptionMetadataTypeName.CalendarItem,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawCalendarItemApi.getCalendarItem(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawCalendarItemApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedClassifications = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val classificationIds = rawClassificationApi.listClassificationIdsByDataOwnerPatientCreated(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawClassificationApi.findClassificationsDelegationsStubsByIds(ListOfIds(classificationIds)).successBody()
			}
			val shareClassificationResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedClassifications,
				entitiesType = EntityWithEncryptionMetadataTypeName.Classification,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawClassificationApi.getClassification(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawClassificationApi.bulkShareMinimal(params).successBody() }
			)

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
					success = false.takeIf { allTags.contains(entity.type) || allTags.contains(
						ShareAllPatientDataOptions.Tag.All) },
					error = null,
					modified = 0
				)
			}
		}

		val patientStatus = try {
			val result = config.crypto.entity.bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
				listOf(
					patient to delegatesWithShareType.keys.associateWith {
						DelegateShareOptions(
							shareSecretIds = delegationSecretKeys,
							shareEncryptionKeys = getEncryptionKeysOf(patient),
							shareOwningEntityIds = setOf(),
							requestedPermissions = RequestedPermission.MaxWrite
						)
					}
				),
				EntityWithEncryptionMetadataTypeName.Patient,
				true,
				{ getPatient(it) },
				{ params -> rawApi.bulkShareMinimal(params).successBody() }
			)
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
		val parentIds = config.crypto.entity.owningEntityIdsOf(null, childDocument.entity, childDocument.type, null)
		check(parentIds.isNotEmpty()) {
			"Parent id is empty in CFK of child document with id ${childDocument.entity.id}"
		}
		check(parentIds.size == 1) {
			"Child document with id ${childDocument.entity.id} contains multiple parent ids in its CFKs"
		}

		tailrec suspend fun findLastMergedPatientInHierarchy(patient: DecryptedPatient, maxMergeLevel: Int): DecryptedPatient {
			return if(patient.mergeToPatientId != null) {
				require(maxMergeLevel > 0) {
					"Too many merged levels for parent (Patient) of child document ${childDocument.entity.id}"
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
		doWithEncryptionMetadata(null, base, user, delegates.keyAsLocalDataOwnerReferences())

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedPatient?,
		user: User?,
		delegates: Map<EntityReferenceInGroup, AccessLevel>
	): DecryptedPatient =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId,
			(base ?: DecryptedPatient(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Patient,
			null,
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData)
				.orEmpty().keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun hasWriteAccess(patient: Patient): Boolean =
		doHasWriteAccess(null, patient)

	private suspend fun doHasWriteAccess(groupId: String?, patient: Patient): Boolean =
		config.crypto.entity.hasWriteAccess(groupId, patient, EntityWithEncryptionMetadataTypeName.Patient)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Set<String>) =
		doCreateDelegationDeAnonymizationMetadata(null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Patient, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.Patient,
			delegates
		)
	}

	override suspend fun getSecretIdsOf(patient: Patient): Set<String> =
		doGetSecretIdsOf(null, patient)

	private suspend fun doGetSecretIdsOf(groupId: String?, patient: Patient): Set<String> =
		config.crypto.entity.secretIdsOf(groupId, patient, EntityWithEncryptionMetadataTypeName.Patient, null)

	override suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString> =
		doGetEncryptionKeysOf(null, patient)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, patient: Patient): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(groupId, patient, EntityWithEncryptionMetadataTypeName.Patient, null)

	override suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String> =
		doGetConfidentialSecretIdsOf(null, patient)

	private suspend fun doGetConfidentialSecretIdsOf(groupId: String?, patient: Patient): Set<String> =
		config.crypto.entity.getConfidentialSecretIdsOf(
			groupId,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			null
		)

	override suspend fun forceInitializeExchangeDataToNewlyInvitedPatient(patientId: String): Boolean {
		val patient = encrypted.getPatient(patientId)
		if (patient.publicKeysSpki.isNotEmpty()) return false
		config.crypto.exchangeDataManager.getOrCreateEncryptionDataTo(
			null,
			EntityReferenceInGroup(patientId, null),
			true
		)
		return true
	}

	override suspend fun decrypt(patients: List<EncryptedPatient>): List<DecryptedPatient> =
		decryptedFlavour.maybeDecrypt(patients)

	override suspend fun tryDecrypt(patients: List<EncryptedPatient>): List<Patient> =
		tryAndRecoverFlavour.maybeDecrypt(patients)

	override suspend fun encryptOrValidate(patients: List<Patient>): List<EncryptedPatient> =
		tryAndRecoverFlavour.validateAndMaybeEncrypt(patients)

	override suspend fun matchPatientsBy(filter: FilterOptions<Patient>): List<String> =
		rawApi.matchPatientsBy(mapPatientFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)).successBody()

	override suspend fun matchPatientsBySorted(filter: SortableFilterOptions<Patient>): List<String> =
		matchPatientsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Patient>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedPatient> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedPatient.serializer(),
			events = events,
			filter = mapPatientFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity),
			qualifiedName = Patient.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(PatientAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun ensureEncryptionMetadataForSelfIsInitialized(sharingWith: Map<String, AccessLevel>): EncryptedPatient {
		val self = config.crypto.dataOwnerApi.getCurrentDataOwner()
		require (self is DataOwnerWithType.PatientDataOwner) { "Current user is not a data owner" }

		suspend fun doWith(self: EncryptedPatient): EncryptedPatient {
			val availableSecretIds = config.crypto.entity.secretIdsOf(null, self, EntityWithEncryptionMetadataTypeName.Patient, null)
			return if (availableSecretIds.isNotEmpty()) {
				self
			} else if (config.crypto.entity.hasEmptyEncryptionMetadata(self, EntityWithEncryptionMetadataTypeName.Patient)) {
				config.crypto.entity.entityWithInitializedEncryptedMetadata(
					entityGroupId = null,
					entity = self,
					entityType = EntityWithEncryptionMetadataTypeName.Patient,
					owningEntityDetails = null,
					initializeEncryptionKey = true,
					autoDelegations = sharingWith.keyAsLocalDataOwnerReferences()
				).updatedEntity
			} else {
				val secretIdShareOptions = SecretIdShareOptions.UseExactly(
					secretIds = setOf(config.crypto.primitives.strongRandom.randomUUID()),
					createUnknownSecretIds = true
				)
				val shareResult = config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
					entityGroupId = null,
					entity = self,
					entityType = EntityWithEncryptionMetadataTypeName.Patient,
					delegates = (mapOf(
						self.id to SimpleDelegateShareOptionsImpl(
							shareEncryptionKey = ShareMetadataBehaviour.IfAvailable,
							shareOwningEntityIds = ShareMetadataBehaviour.Never,
							shareSecretIds = secretIdShareOptions,
							requestedPermissions = RequestedPermission.Root
						)
					) + sharingWith.mapValues { (_, accessLevel) ->
						SimpleDelegateShareOptionsImpl(
							shareEncryptionKey = ShareMetadataBehaviour.Never,
							shareOwningEntityIds = ShareMetadataBehaviour.Never,
							shareSecretIds = secretIdShareOptions,
							requestedPermissions = when (accessLevel) {
								AccessLevel.Read -> RequestedPermission.FullRead
								AccessLevel.Write -> RequestedPermission.FullWrite
							}
						)
					}).keyAsLocalDataOwnerReferences(),
					autoRetry = false, // Will retry with the updated entity: maybe no need to update metadata after all
					getUpdatedEntity = { throw UnsupportedOperationException("No retry") },
					doRequestBulkShareOrUpdate = { rawApi.bulkShare(it).successBody() }
				)
				if (shareResult is SimpleShareResult.Failure && shareResult.errorsDetails.all { it.shouldRetry }) {
					val updatedSelf = rawApi.getPatient(self.id).successBody()
					if (updatedSelf.rev != self.rev) {
						ensureEncryptionMetadataForSelfIsInitialized(sharingWith)
					} else shareResult.updatedEntityOrThrow()
				} else shareResult.updatedEntityOrThrow()
			}
		}

		return doWith(self.dataOwner)
	}
}

@InternalIcureApi
internal fun initPatientBasicApi(
	rawApi: RawPatientApi,
	config: BasicApiConfiguration
): PatientBasicApi = PatientBasicApiImpl(
	rawApi,
	config,
	AbstractPatientBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config)),
	AbstractPatientBasicFlavourlessApi(rawApi, config)
)

@InternalIcureApi
private class PatientBasicApiImpl(
	private val rawApi: RawPatientApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractPatientBasicFlavouredApi<EncryptedPatient>,
	private val basicFlavourless: AbstractPatientBasicFlavourlessApi
) : PatientBasicApi,
	PatientBasicFlavouredApi<EncryptedPatient> by encryptedFlavour,
	PatientBasicFlavourlessApi by basicFlavourless {
	override val inGroup: PatientBasicInGroupApi = object :
		PatientBasicInGroupApi,
		PatientBasicFlavourlessInGroupApi by basicFlavourless,
		PatientBasicFlavouredInGroupApi<EncryptedPatient> by encryptedFlavour {}

	override suspend fun matchPatientsBy(filter: BaseFilterOptions<Patient>): List<String> =
		rawApi.matchPatientsBy(mapPatientFilterOptions(filter, null, null)).successBody()

	override suspend fun matchPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): List<String> =
		matchPatientsBy(filter)

	override suspend fun filterPatientsBy(filter: BaseFilterOptions<Patient>): PaginatedListIterator<EncryptedPatient> =
		IdsPageIterator(matchPatientsBy(filter), this::getPatients)

	override suspend fun filterPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): PaginatedListIterator<EncryptedPatient> =
		filterPatientsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Patient>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedPatient> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedPatient.serializer(),
			events = events,
			filter = mapPatientFilterOptions(filter, null, null),
			qualifiedName = Patient.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(PatientAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
