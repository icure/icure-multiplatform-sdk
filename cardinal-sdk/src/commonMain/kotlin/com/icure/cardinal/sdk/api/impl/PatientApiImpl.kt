package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.PatientApi
import com.icure.cardinal.sdk.api.PatientBasicApi
import com.icure.cardinal.sdk.api.PatientBasicFlavouredApi
import com.icure.cardinal.sdk.api.PatientBasicFlavourlessApi
import com.icure.cardinal.sdk.api.PatientFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawCalendarItemApi
import com.icure.cardinal.sdk.api.raw.RawClassificationApi
import com.icure.cardinal.sdk.api.raw.RawContactApi
import com.icure.cardinal.sdk.api.raw.RawFormApi
import com.icure.cardinal.sdk.api.raw.RawHealthElementApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawInvoiceApi
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
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
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractPatientBasicFlavouredApi<E : Patient>(
	protected val rawApi: RawPatientApi,
	private val config: BasicApiConfiguration,
) : PatientBasicFlavouredApi<E>, FlavouredApi<EncryptedPatient, E> {
	override suspend fun undeletePatientById(id: String, rev: String): E =
		rawApi.undeletePatient(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun undeletePatients(ids: List<IdWithMandatoryRev>): List<E> =
		rawApi.undeletePatients(ListOfIdsAndRev(ids)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyPatient(entity: E): E =
		rawApi.modifyPatient(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }


	override suspend fun getPatient(entityId: String): E = rawApi.getPatient(entityId).successBody().let { maybeDecrypt(null, it) }

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
			updatedInto = validateAndMaybeEncrypt(null, mergedInto)
		).let {
			maybeDecrypt(null, it.successBody())
		}
	}
}

@InternalIcureApi
private abstract class AbstractPatientFlavouredApi<E : Patient>(
	rawApi: RawPatientApi,
	protected val config: ApiConfiguration
) : AbstractPatientBasicFlavouredApi<E>(rawApi, config), PatientFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		patient: E,
		@DefaultValue("null")
		options: PatientShareOptions?,
	): E =
		shareWithMany(patient, mapOf(delegateId to (options ?: PatientShareOptions())))

	override suspend fun shareWithMany(patient: E, delegates: Map<String, PatientShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getPatient(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()

	override suspend fun initializeConfidentialSecretId(patient: E): E {
		requireNotNull(patient.rev) {
			"Patient must be created before confidential secret id initialisation"
		}
		return config.crypto.entity.initializeConfidentialSecretId(
			null,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			{ getPatient(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		) ?: patient
	}

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
	PatientBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deletePatientUnsafe(entityId: String): DocIdentifier =
		rawApi.deletePatient(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deletePatientsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deletePatients(ListOfIds(entityIds)).successBody()

	override suspend fun deletePatientById(entityId: String, rev: String): DocIdentifier =
		rawApi.deletePatient(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deletePatientsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deletePatientsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgePatientById(id: String, rev: String) {
		rawApi.purgePatient(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation =
		config.crypto.entityAccessInformationProvider.getDataOwnersWithAccessTo(null, patient, EntityWithEncryptionMetadataTypeName.Patient)

	@Deprecated("This method gives inaccurate results outside of the simples scenarios, use match instead")
	override suspend fun countOfPatients(hcPartyId: String) = ensureNonNull(rawApi.countOfPatients(hcPartyId).successBody().numberValue) {
		"Count of patients has no number value"
	}.toInt()
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
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedPatient>
	): List<EncryptedPatient> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Patient,
			DecryptedPatient.serializer(),
			this.config.encryption.patient,
		) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedPatient>
	): List<DecryptedPatient> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Patient,
			EncryptedPatient.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(config.jsonPatcher.patchPatient(it)) }
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, config) {
	override val encrypted: PatientFlavouredApi<EncryptedPatient> =
		object : AbstractPatientFlavouredApi<EncryptedPatient>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedPatient>
			): List<EncryptedPatient> =
				this.config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.Patient,
					EncryptedPatient.serializer(),
					this.config.encryption.patient
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedPatient>
			): List<EncryptedPatient> =
				entities
		}

	override val tryAndRecover: PatientFlavouredApi<Patient> =
		object : AbstractPatientFlavouredApi<Patient>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Patient>
			): List<EncryptedPatient> =
				this.config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId = entitiesGroupId,
					entities = entities,
					entitiesType = EntityWithEncryptionMetadataTypeName.Patient,
					encryptedSerializer = EncryptedPatient.serializer(),
					decryptedSerializer = DecryptedPatient.serializer(),
					fieldsToEncrypt = this.config.encryption.patient
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedPatient>
			): List<Patient> =
				this.config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Patient,
					EncryptedPatient.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(config.jsonPatcher.patchPatient(it)) }
		}

	override suspend fun createPatient(patient: DecryptedPatient): DecryptedPatient {
		require(patient.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createPatient(
			config.crypto.entity.encryptEntities(
				null,
				listOf(patient),
				EntityWithEncryptionMetadataTypeName.Patient,
				DecryptedPatient.serializer(),
				config.encryption.patient,
			) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }.single(),
		).successBody().let { decrypt(it) }
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
				return if(entities.isNotEmpty() && delegatesToApply.isNotEmpty()) {
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
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedPatient(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Patient,
			null,
			null,
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData)
				.orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun hasWriteAccess(patient: Patient): Boolean =
		config.crypto.entity.hasWriteAccess(null, patient, EntityWithEncryptionMetadataTypeName.Patient)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.Patient,
			delegates.asLocalDataOwnerReferences()
		)
	}

	override suspend fun getSecretIdsOf(patient: Patient): Set<String> =
		config.crypto.entity.secretIdsOf(null, patient, EntityWithEncryptionMetadataTypeName.Patient, null)

	override suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(null, patient, EntityWithEncryptionMetadataTypeName.Patient, null)

	override suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String> =
		config.crypto.entity.getConfidentialSecretIdsOf(
			null,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			null
		)

	override suspend fun forceInitializeExchangeDataToNewlyInvitedPatient(patientId: String): Boolean {
		val patient = encrypted.getPatient(patientId)
		if (patient.publicKeysSpki.isNotEmpty()) return false
		config.crypto.exchangeDataManager.getOrCreateEncryptionDataTo(
			null,
			DataOwnerReferenceInGroup(patientId, null),
			true
		)
		return true
	}

	override suspend fun decrypt(patient: EncryptedPatient): DecryptedPatient =
		config.crypto.entity.decryptEntities(
			null,
			listOf(patient),
			EntityWithEncryptionMetadataTypeName.Patient,
			EncryptedPatient.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(config.jsonPatcher.patchPatient(it)) }.single()

	override suspend fun tryDecrypt(patient: EncryptedPatient): Patient =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(patient),
			EntityWithEncryptionMetadataTypeName.Patient,
			EncryptedPatient.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(config.jsonPatcher.patchPatient(it)) }.single()

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
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
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
					owningEntityId = null,
					owningEntitySecretId = null,
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
internal class PatientBasicApiImpl(
	private val rawApi: RawPatientApi,
	private val config: BasicApiConfiguration
) : PatientBasicApi, PatientBasicFlavouredApi<EncryptedPatient> by object :
	AbstractPatientBasicFlavouredApi<EncryptedPatient>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedPatient>
	): List<EncryptedPatient> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.Patient, EncryptedPatient.serializer(), config.encryption.patient)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedPatient>
	): List<EncryptedPatient> =
		entities
}, PatientBasicFlavourlessApi by AbstractPatientBasicFlavourlessApi(rawApi, config) {
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
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
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
