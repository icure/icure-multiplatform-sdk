package com.icure.sdk.api.flavoured

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.data.LabelledOccurence
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.ensure
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

@OptIn(InternalIcureApi::class)
val serviceEncryptedFieldsManifest = EncryptedFieldsManifest(
	path = "Service.",
	topLevelFields = setOf("content"),
	nestedObjectsKeys = emptyMap(),
	mapsValuesKeys = emptyMap(),
	arraysValuesKeys = emptyMap(),
)

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest(
		path = "Contact.",
		topLevelFields = setOf("descr"),
		nestedObjectsKeys = emptyMap(),
		mapsValuesKeys = emptyMap(),
		arraysValuesKeys = mapOf("services" to serviceEncryptedFieldsManifest),
	)

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ContactBasicFlavourlessApi {
	suspend fun matchContactsBy(filter: AbstractFilter<EncryptedContact>): List<String>
	suspend fun deleteContact(entityId: String): DocIdentifier
	suspend fun deleteContacts(entityIds: List<String>): List<DocIdentifier>
	suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): List<IcureStub>

	suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long): List<LabelledOccurence>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ContactBasicFlavouredApi<E : Contact, S : Service> {
	suspend fun modifyContact(entity: E): E
	suspend fun modifyContacts(entities: List<E>): List<E>
	suspend fun getContact(entityId: String): E
	suspend fun getContacts(entityIds: List<String>): List<E>
	suspend fun filterContactsBy(filterChain: FilterChain<EncryptedContact>, startDocumentId: String?, limit: Int?): PaginatedList<E>
	suspend fun findContactsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>

	suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E>
	suspend fun listContactsByExternalId(externalId: String): List<E>
	suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E>
	suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E>
	suspend fun listContactsByHCPartyAndPatientForeignKeys(hcPartyId: String, patientIds: List<String>): List<E>
	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String? = null,
		skipClosedContacts: Boolean? = null,
	): List<E>

	suspend fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
	suspend fun getService(serviceId: String): S
	suspend fun getServices(entityIds: List<String>): List<S>
	suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S>
	suspend fun listServicesByAssociationId(associationId: String): List<S>
	suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S>
	suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>

	suspend fun filterServicesBy(filterChain: FilterChain<EncryptedService>, startDocumentId: String?, limit: Int?): PaginatedList<S>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ContactFlavouredApi<E : Contact, S : Service> : ContactBasicFlavouredApi<E, S> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	suspend fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): List<DecryptedContact>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface ContactApi : ContactBasicFlavourlessApi, ContactFlavouredApi<DecryptedContact, DecryptedService> {
	suspend fun createContact(entity: DecryptedContact): DecryptedContact
	suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact>
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedContact,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedContact

	val encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService>
	val tryAndRecover: ContactFlavouredApi<Contact, Service>
}

interface ContactBasicApi : ContactBasicFlavourlessApi, ContactBasicFlavouredApi<EncryptedContact, EncryptedService>

@InternalIcureApi
private abstract class AbstractContactBasicFlavouredApi<E : Contact, S : Service>(protected val rawApi: RawContactApi) :
	ContactBasicFlavouredApi<E, S> {
	override suspend fun modifyContact(entity: E): E =
		rawApi.modifyContact(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyContacts(entities: List<E>): List<E> =
		rawApi.modifyContacts(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getContact(entityId: String): E = rawApi.getContact(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getContacts(entityIds: List<String>): List<E> =
		rawApi.getContacts(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterContactsBy(
		filterChain: FilterChain<EncryptedContact>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.filterContactsBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun findContactsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findContactsByHCPartyPatientForeignKey(hcPartyId, secretPatientKey, startKey.encodeStartKey(), startDocumentId, limit).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E> =
		rawApi.listContactByHCPartyServiceId(hcPartyId, serviceId).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByExternalId(externalId: String): List<E> =
		rawApi.listContactsByExternalId(externalId).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E> =
		rawApi.listContactsByHCPartyAndFormId(hcPartyId, formId).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E> =
		rawApi.listContactsByHCPartyAndFormIds(hcPartyId, ListOfIds(formIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		patientIds: List<String>,
	): List<E> = rawApi.listContactsByHCPartyAndPatientForeignKeys(hcPartyId, ListOfIds(patientIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String?,
		skipClosedContacts: Boolean?,
	): List<E> =
		rawApi.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, secretPatientKeys, planOfActionsIds, skipClosedContacts).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.closeForHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun getService(serviceId: String): S = rawApi.getService(serviceId).successBody().let { maybeDecryptService(it) }
	override suspend fun filterServicesBy(
		filterChain: FilterChain<EncryptedService>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<S> =
		rawApi.filterServicesBy(startDocumentId, limit, filterChain).successBody().map { maybeDecryptService(it) }

	override suspend fun getServices(entityIds: List<String>): List<S> =
		rawApi.getServices(ListOfIds(entityIds)).successBody().map { maybeDecryptService(it) }

	override suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S> =
		rawApi.getServicesLinkedTo(linkType, ListOfIds(ids)).successBody().map { maybeDecryptService(it) }

	override suspend fun listServicesByAssociationId(associationId: String): List<S> =
		rawApi.listServicesByAssociationId(associationId).successBody().map { maybeDecryptService(it) }

	override suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S> =
		rawApi.listServicesByHealthElementId(healthElementId, hcPartyId).successBody().map { maybeDecryptService(it) }

	override suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> = rawApi.findContactsByOpeningDate(startDate, endDate, hcPartyId, startKey.encodeStartKey(), startDocumentId, limit).successBody()
		.map { maybeDecrypt(it) }


	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedContact
	abstract suspend fun maybeDecrypt(entity: EncryptedContact): E
	abstract suspend fun maybeDecryptService(entity: EncryptedService): S
}

@InternalIcureApi
private abstract class AbstractContactFlavouredApi<E : Contact, S : Service>(
	rawApi: RawContactApi,
	private val encryptionService: EntityEncryptionService,
) : AbstractContactBasicFlavouredApi<E, S>(rawApi), ContactFlavouredApi<E, S> {
	override suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
			healthcareElement.withTypeInfo(),
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptions(
					shareSecretIds = null,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): List<DecryptedContact> {
		TODO("@vcp")
	}


}

suspend fun JsonObject.walkCompounds(transform: suspend (JsonObject) -> JsonObject): JsonObject =
	if (this["content"]?.jsonObject?.values?.all { c -> c.jsonObject.entries.all { (k, v) -> k == "compoundValue" || v == JsonNull || (v is JsonArray && v.isEmpty()) } } == true) JsonObject(
		mapValues { (k, v) ->
			if (k == "content")
				JsonObject(
					v.jsonObject.mapValues { (_, c) ->
						JsonObject(
							c.jsonObject["compoundValue"]?.jsonArray?.let { compoundServices ->
								mapOf(
									"compoundValue" to JsonArray(
										compoundServices.map { dSvc ->
											dSvc.jsonObject.walkCompounds(transform)
										},
									),
								)
							} ?: emptyMap(),
						)
					},
				)
			else v
		},
	) else transform(this)

@OptIn(InternalIcureApi::class)
internal suspend fun DecryptedService.encrypt(jsonEncryptionService: JsonEncryptionService, contactKey: AesKey): EncryptedService =
	Serialization.json.encodeToJsonElement<DecryptedService>(this).jsonObject
		.walkCompounds { jsonEncryptionService.encrypt(contactKey, it, serviceEncryptedFieldsManifest) }
		.let {
			Serialization.json.decodeFromJsonElement<EncryptedService>(it)
		}


@OptIn(InternalIcureApi::class)
internal suspend fun EncryptedService.validate(jsonEncryptionService: JsonEncryptionService): EncryptedService {
	return this.also { encryptedService ->
		Serialization.json.encodeToJsonElement<EncryptedService>(encryptedService).jsonObject
			.walkCompounds {
				it.also { encryptedJson ->
					require(!jsonEncryptionService.requiresEncryption(encryptedJson, serviceEncryptedFieldsManifest)) {
						"Service ${this.id} has some fields which should be encrypted according to the manifest but are not encrypted; you should not modify encrypted fields when working directly with encrypted entities."
					}
				}
			}
	}
}

@InternalIcureApi
internal fun Service.asIcureStubWithTypeInfo(): EntityWithTypeInfo<IcureStub> {
	ensure(this.delegations.isNotEmpty() || !this.securityMetadata?.secureDelegations.isNullOrEmpty()) { "The service must be include the encryption metadata to use this method. The Service gets populated with encryption metadata when it is obtained through one of the getServices, or filterServices method." }
	return EntityWithTypeInfo(
		IcureStub(
			id = id,
			rev = null,
			created = created,
			modified = modified,
			author = author,
			responsible = responsible,
			medicalLocationId = medicalLocationId,
			tags = tags,
			codes = codes,
			endOfLife = endOfLife,
			secretForeignKeys = secretForeignKeys ?: emptySet(),
			cryptedForeignKeys = cryptedForeignKeys,
			delegations = delegations,
			encryptionKeys = encryptionKeys,
			securityMetadata = securityMetadata,
		),
		EntityWithEncryptionMetadataTypeName.Contact,
	)
}

@InternalIcureApi
private class AbstractContactBasicFlavourlessApi(val rawApi: RawContactApi) : ContactBasicFlavourlessApi {
	override suspend fun matchContactsBy(filter: AbstractFilter<EncryptedContact>) = rawApi.matchContactsBy(filter).successBody()
	override suspend fun deleteContact(entityId: String) = rawApi.deleteContact(entityId).successBody()
	override suspend fun deleteContacts(entityIds: List<String>) = rawApi.deleteContacts(ListOfIds(entityIds)).successBody()
	override suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findContactsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()

	override suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long) =
		rawApi.getServiceCodesOccurrences(codeType, minOccurrences).successBody()
}

@InternalIcureApi
internal class ContactApiImpl(
	private val rawApi: RawContactApi,
	private val encryptionService: EntityEncryptionService,
	private val jsonEncryptionService: JsonEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : ContactApi, ContactFlavouredApi<DecryptedContact, DecryptedService> by object :
	AbstractContactFlavouredApi<DecryptedContact, DecryptedService>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedContact): EncryptedContact =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedContact.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedContact>(it) }.copy(
			services = entity.services.map {
				it.encrypt(
					jsonEncryptionService,
					encryptionService.tryDecryptAndImportAnyEncryptionKey(entity.withTypeInfo())?.key
						?: throw EntityEncryptionException("Cannot obtain key from contact"),
				)
			}.toSet(),
		)

	override suspend fun maybeDecrypt(entity: EncryptedContact): DecryptedContact {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedContact.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}

	override suspend fun maybeDecryptService(entity: EncryptedService): DecryptedService =
		try {
			encryptionService.tryDecryptAndImportAnyEncryptionKey(entity.asIcureStubWithTypeInfo())?.key
		} catch (e: InternalIcureException) {
			null
		}?.let { contactKey ->
			Serialization.json.encodeToJsonElement<EncryptedService>(entity).jsonObject
				.let { jsonEncryptionService.decrypt(contactKey, it) }
				.let {
					Serialization.json.decodeFromJsonElement<DecryptedService>(it)
				}
		} ?: throw EntityEncryptionException("Service ${entity.id} cannot be decrypted")

}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi) {
	override val encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService> =
		object : AbstractContactFlavouredApi<EncryptedContact, EncryptedService>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedContact): EncryptedContact =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedContact.serializer(), fieldsToEncrypt).copy(
					services = entity.services.map {
						it.validate(jsonEncryptionService)
					}.toSet(),
				)

			override suspend fun maybeDecrypt(entity: EncryptedContact): EncryptedContact = entity
			override suspend fun maybeDecryptService(entity: EncryptedService): EncryptedService = entity
		}

	override val tryAndRecover: ContactFlavouredApi<Contact, Service> =
		object : AbstractContactFlavouredApi<Contact, Service>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedContact): Contact =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedContact.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
					?: entity

			override suspend fun maybeDecryptService(entity: EncryptedService): Service = try {
				encryptionService.tryDecryptAndImportAnyEncryptionKey(entity.asIcureStubWithTypeInfo())?.key
			} catch (e: InternalIcureException) {
				null
			}?.let { contactKey ->
				Serialization.json.encodeToJsonElement<EncryptedService>(entity).jsonObject
					.let { jsonEncryptionService.decrypt(contactKey, it) }
					.let {
						Serialization.json.decodeFromJsonElement<DecryptedService>(it)
					}
			} ?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Contact): EncryptedContact = when (entity) {
				is EncryptedContact -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedContact.serializer(),
					fieldsToEncrypt,
				).copy(
					services = entity.services.map {
						it.validate(jsonEncryptionService)
					}.toSet(),
				)

				is DecryptedContact -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedContact.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedContact>(it) }.copy(
					services = entity.services.map {
						it.encrypt(
							jsonEncryptionService,
							encryptionService.tryDecryptAndImportAnyEncryptionKey(entity.withTypeInfo())?.key
								?: throw EntityEncryptionException("Cannot obtain key from contact"),
						)
					}.toSet(),
				)
			}
		}

	override suspend fun createContact(entity: DecryptedContact): DecryptedContact {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createContact(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createContacts(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedContact,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedContact =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			healthcareElement.withTypeInfo(),
			patient.id,
			encryptionService.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + (
				(user.autoDelegations[DelegationTag.MedicalInformation] ?: emptySet()) +
					(user.autoDelegations[DelegationTag.All] ?: emptySet())
				).associateWith { AccessLevel.Write },
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedContact) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedContact.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedContact>(it) }.copy(
		services = entity.services.map {
			it.encrypt(
				jsonEncryptionService,
				encryptionService.tryDecryptAndImportAnyEncryptionKey(entity.withTypeInfo())?.key
					?: throw EntityEncryptionException("Cannot obtain key from contact"),
			)
		}.toSet(),
	)

	suspend fun decrypt(entity: EncryptedContact, errorMessage: () -> String): DecryptedContact = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedContact.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class ContactBasicApiImpl(
	rawApi: RawContactApi,
	private val validationService: EntityValidationService,
	private val jsonEncryptionService: JsonEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : ContactBasicApi, ContactBasicFlavouredApi<EncryptedContact, EncryptedService> by object :
	AbstractContactBasicFlavouredApi<EncryptedContact, EncryptedService>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedContact): EncryptedContact =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedContact.serializer(), fieldsToEncrypt).copy(
			services = entity.services.map {
				it.validate(jsonEncryptionService)
			}.toSet(),
		)

	override suspend fun maybeDecrypt(entity: EncryptedContact): EncryptedContact = entity
	override suspend fun maybeDecryptService(entity: EncryptedService): EncryptedService = entity
}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi)
