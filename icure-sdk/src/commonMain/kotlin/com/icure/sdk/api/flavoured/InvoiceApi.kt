package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawInvoiceApi
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.data.LabelledOccurence
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.currentFuzzyDateTime
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Invoice.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface InvoiceBasicFlavourlessApi {
	suspend fun deleteInvoice(entityId: String): DocIdentifier
	suspend fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<IcureStub>
	suspend fun getTarificationsCodesOccurrences(minOccurrence: Int): List<LabelledOccurence>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface InvoiceBasicFlavouredApi<E : Invoice> {
	suspend fun modifyInvoice(entity: E): E
	suspend fun modifyInvoices(entities: List<E>): List<E>
	suspend fun getInvoice(entityId: String): E
	suspend fun getInvoices(entityIds: List<String>): List<E>
	suspend fun filterInvoicesBy(filterChain: FilterChain<Invoice>): List<E>
	suspend fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
	suspend fun reassignInvoice(invoice: E): E
	suspend fun mergeTo(invoiceId: String, ids: List<String>): E
	suspend fun validate(invoiceId: String, scheme: String, forcedValue: String): E
	suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String? = null,
		invoiceId: String? = null,
		gracePeriod: Int? = null,
		invoicingCodes: List<EncryptedInvoicingCode>
	): List<E>

	suspend fun removeCodes(userId: String, serviceId: String, secretFKeys: String, tarificationIds: List<String>): List<E>
	suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long? = null,
		toDate: Long? = null,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null
	): PaginatedList<E>

	suspend fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
	suspend fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): List<E>
	suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long? = null,
		to: Long? = null
	): List<E>

	suspend fun listInvoicesByContactIds(contactIds: List<String>): List<E>
	suspend fun listInvoicesByRecipientsIds(recipientsIds: List<String>): List<E>
	suspend fun listToInsurances(userIds: List<String>): List<E>
	suspend fun listToInsurancesUnsent(userIds: List<String>): List<E>
	suspend fun listToPatients(hcPartyId: String): List<E>
	suspend fun listToPatientsUnsent(hcPartyId: String?): List<E>
	suspend fun listInvoicesByIds(ids: List<String>): List<E>
	suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Long,
		to: Long
	): List<E>

	suspend fun listInvoicesByServiceIds(serviceIds: List<String>): List<E>
	suspend fun listAllHcpsByStatus(status: String, from: Long? = null, to: Long? = null, hcpIds: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface InvoiceFlavouredApi<E : Invoice> : InvoiceBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		invoice: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
	suspend fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface InvoiceApi : InvoiceBasicFlavourlessApi, InvoiceFlavouredApi<DecryptedInvoice> {
	suspend fun createInvoice(entity: DecryptedInvoice): DecryptedInvoice
	suspend fun createInvoices(entities: List<DecryptedInvoice>): List<DecryptedInvoice>
	suspend fun withEncryptionMetadata(
		base: DecryptedInvoice?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedInvoice

	val encrypted: InvoiceFlavouredApi<EncryptedInvoice>
	val tryAndRecover: InvoiceFlavouredApi<Invoice>
}

interface InvoiceBasicApi : InvoiceBasicFlavourlessApi, InvoiceBasicFlavouredApi<EncryptedInvoice>

@InternalIcureApi
private abstract class AbstractInvoiceBasicFlavouredApi<E : Invoice>(protected val rawApi: RawInvoiceApi) :
	InvoiceBasicFlavouredApi<E> {
	override suspend fun modifyInvoice(entity: E): E =
		rawApi.modifyInvoice(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyInvoices(entities: List<E>): List<E> =
		rawApi.modifyInvoices(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getInvoice(entityId: String): E = rawApi.getInvoice(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getInvoices(entityIds: List<String>): List<E> =
		rawApi.getInvoices(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterInvoicesBy(filterChain: FilterChain<Invoice>): List<E> =
		rawApi.filterInvoicesBy(filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findInvoicesByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	override suspend fun reassignInvoice(invoice: E): E =
		rawApi.reassignInvoice(validateAndMaybeEncrypt(invoice)).successBody().let { maybeDecrypt(it) }

	override suspend fun mergeTo(
		invoiceId: String,
		ids: List<String>,
		) = rawApi.mergeTo(invoiceId, ListOfIds(ids)).successBody().let { maybeDecrypt(it) }

	override suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
		): E = rawApi.validate(invoiceId, scheme, forcedValue).successBody().let { maybeDecrypt(it) }

	//TODO: Maybe manage a separate manifest for InvoicingCode and encrypt automatically
	override suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String?,
		invoiceId: String?,
		gracePeriod: Int?,
		invoicingCodes: List<EncryptedInvoicingCode>,
		): List<E> =
		rawApi.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId, invoiceId, gracePeriod, invoicingCodes).successBody().map { maybeDecrypt(it) }

	override suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
		): List<E> =
		rawApi.removeCodes(userId, serviceId, secretFKeys, tarificationIds).successBody().map { maybeDecrypt(it) }

	override suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long?,
		toDate: Long?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
		) = rawApi.findInvoicesByAuthor(hcPartyId, fromDate, toDate, startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId, secretPatientKeys.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): List<E> =
		rawApi.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long?,
		to: Long?,
	) = rawApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId, sentMediumType, invoiceType, sent, from, to).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByContactIds(contactIds: List<String>): List<E> =
		rawApi.listInvoicesByContactIds(ListOfIds(contactIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByRecipientsIds(recipientsIds: List<String>): List<E> =
		rawApi.listInvoicesByRecipientsIds(recipientsIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun listToInsurances(userIds: List<String>): List<E> =
		rawApi.listToInsurances(userIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun listToInsurancesUnsent(userIds: List<String>): List<E> =
		rawApi.listToInsurancesUnsent(userIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun listToPatients(hcPartyId: String): List<E> =
		rawApi.listToPatients(hcPartyId).successBody().map { maybeDecrypt(it) }

	override suspend fun listToPatientsUnsent(hcPartyId: String?): List<E> =
		rawApi.listToPatientsUnsent(hcPartyId).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByIds(ids: List<String>): List<E> =
		rawApi.listInvoicesByIds(ids.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Long,
		to: Long,
	): List<E> = rawApi.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status, from, to).successBody().map { maybeDecrypt(it) }

	override suspend fun listInvoicesByServiceIds(serviceIds: List<String>): List<E> =
		rawApi.listInvoicesByServiceIds(serviceIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun listAllHcpsByStatus(
		status: String,
		from: Long?,
		to: Long?,
		hcpIds: List<String>,
		): List<E> =
		rawApi.listAllHcpsByStatus(status, from, to, ListOfIds(hcpIds)).successBody().map { maybeDecrypt(it) }


	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedInvoice
	abstract suspend fun maybeDecrypt(entity: EncryptedInvoice): E
}

@InternalIcureApi
private abstract class AbstractInvoiceFlavouredApi<E : Invoice>(
	rawApi: RawInvoiceApi,
	private val crypto: InternalCryptoServices,
) : AbstractInvoiceBasicFlavouredApi<E>(rawApi), InvoiceFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		invoice: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			invoice.withTypeInfo(),
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

	override suspend fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listInvoiceIdsByDataOwnerPatientInvoiceDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getInvoices(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}

}

@InternalIcureApi
private class AbstractInvoiceBasicFlavourlessApi(val rawApi: RawInvoiceApi) : InvoiceBasicFlavourlessApi {
	override suspend fun deleteInvoice(entityId: String) = rawApi.deleteInvoice(entityId).successBody()
	override suspend fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findInvoicesDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()

	override suspend fun getTarificationsCodesOccurrences(
		minOccurrence: Int,
	) = rawApi.getTarificationsCodesOccurrences(minOccurrence.toLong()).successBody()

}

@InternalIcureApi
internal class InvoiceApiImpl(
	private val rawApi: RawInvoiceApi,
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	private val autofillAuthor: Boolean,
	) : InvoiceApi, InvoiceFlavouredApi<DecryptedInvoice> by object :
	AbstractInvoiceFlavouredApi<DecryptedInvoice>(rawApi, crypto) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedInvoice): EncryptedInvoice =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedInvoice.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedInvoice): DecryptedInvoice {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedInvoice.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, InvoiceBasicFlavourlessApi by AbstractInvoiceBasicFlavourlessApi(rawApi) {
	override val encrypted: InvoiceFlavouredApi<EncryptedInvoice> =
		object : AbstractInvoiceFlavouredApi<EncryptedInvoice>(rawApi, crypto) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedInvoice): EncryptedInvoice =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedInvoice.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedInvoice): EncryptedInvoice = entity
		}

	override val tryAndRecover: InvoiceFlavouredApi<Invoice> =
		object : AbstractInvoiceFlavouredApi<Invoice>(rawApi, crypto) {
			override suspend fun maybeDecrypt(entity: EncryptedInvoice): Invoice =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedInvoice.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Invoice): EncryptedInvoice = when (entity) {
				is EncryptedInvoice -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedInvoice.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedInvoice -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedInvoice.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }
			}
		}

	override suspend fun createInvoice(entity: DecryptedInvoice): DecryptedInvoice {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createInvoice(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createInvoices(entities: List<DecryptedInvoice>): List<DecryptedInvoice> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createInvoices(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedInvoice?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedInvoice =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedInvoice(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { autofillAuthor },
				groupId = base?.groupId ?: base?.id,
				invoiceDate = base?.invoiceDate ?: currentFuzzyDateTime(TimeZone.currentSystemDefault()),
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedInvoice) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedInvoice.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }

	suspend fun decrypt(entity: EncryptedInvoice, errorMessage: () -> String): DecryptedInvoice = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedInvoice.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class InvoiceBasicApiImpl(
	rawApi: RawInvoiceApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : InvoiceBasicApi, InvoiceBasicFlavouredApi<EncryptedInvoice> by object :
	AbstractInvoiceBasicFlavouredApi<EncryptedInvoice>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedInvoice): EncryptedInvoice =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedInvoice.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedInvoice): EncryptedInvoice = entity
}, InvoiceBasicFlavourlessApi by AbstractInvoiceBasicFlavourlessApi(rawApi)
