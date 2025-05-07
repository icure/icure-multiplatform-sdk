package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.InvoiceApi
import com.icure.cardinal.sdk.api.InvoiceBasicApi
import com.icure.cardinal.sdk.api.InvoiceBasicFlavouredApi
import com.icure.cardinal.sdk.api.InvoiceBasicFlavourlessApi
import com.icure.cardinal.sdk.api.InvoiceFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawEntityReferenceApi
import com.icure.cardinal.sdk.api.raw.RawInvoiceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EntityReference
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.currentFuzzyDateTime
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.cardinal.sdk.utils.pagination.encodeStartKey
import com.icure.utils.InternalIcureApi
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractInvoiceBasicFlavouredApi<E : Invoice>(
	protected val rawApi: RawInvoiceApi
) : InvoiceBasicFlavouredApi<E>, FlavouredApi<EncryptedInvoice, E> {
	override suspend fun modifyInvoice(entity: E): E =
		rawApi.modifyInvoice(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyInvoices(entities: List<E>): List<E> =
		rawApi.modifyInvoices(validateAndMaybeEncrypt(entities)).successBody().let { maybeDecrypt(it) }

	override suspend fun getInvoice(entityId: String): E? =
		rawApi.getInvoice(entityId).successBodyOrNull404()?.let { maybeDecrypt(null, it) }

	override suspend fun getInvoices(entityIds: List<String>): List<E> =
		rawApi.getInvoices(ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }

	override suspend fun reassignInvoice(invoice: E): E =
		rawApi.reassignInvoice(validateAndMaybeEncrypt(null, invoice)).successBody().let { maybeDecrypt(null, it) }

	override suspend fun mergeTo(
		invoiceId: String,
		ids: List<String>,
		) = rawApi.mergeTo(invoiceId, ListOfIds(ids)).successBody().let { maybeDecrypt(null, it) }

	override suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
		): E = rawApi.validate(invoiceId, scheme, forcedValue).successBody().let { maybeDecrypt(null, it) }

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
		rawApi.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId, invoiceId, gracePeriod, invoicingCodes).successBody().let { maybeDecrypt(it) }

	override suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
		): List<E> =
		rawApi.removeCodes(userId, serviceId, secretFKeys, tarificationIds).successBody().let { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterInvoicesBy()"))
	override suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long?,
		toDate: Long?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
		) = rawApi.findInvoicesByAuthor(hcPartyId, fromDate, toDate, startKey.encodeStartKey(), startDocumentId, limit).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): List<E> =
		rawApi.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long?,
		to: Long?,
	) = rawApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId, sentMediumType, invoiceType, sent, from, to).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByContactIds(contactIds: List<String>): List<E> =
		rawApi.listInvoicesByContactIds(ListOfIds(contactIds)).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByRecipientsIds(recipientsIds: List<String>): List<E> =
		rawApi.listInvoicesByRecipientsIds(recipientsIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToInsurances(userIds: List<String>): List<E> =
		rawApi.listToInsurances(userIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToInsurancesUnsent(userIds: List<String>): List<E> =
		rawApi.listToInsurancesUnsent(userIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToPatients(hcPartyId: String): List<E> =
		rawApi.listToPatients(hcPartyId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToPatientsUnsent(hcPartyId: String?): List<E> =
		rawApi.listToPatientsUnsent(hcPartyId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByIds(ids: List<String>): List<E> =
		rawApi.listInvoicesByIds(ids.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Long,
		to: Long,
	): List<E> = rawApi.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status, from, to).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByServiceIds(serviceIds: List<String>): List<E> =
		rawApi.listInvoicesByServiceIds(serviceIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listAllHcpsByStatus(
		status: String,
		from: Long?,
		to: Long?,
		hcpIds: List<String>,
		): List<E> =
		rawApi.listAllHcpsByStatus(status, from, to, ListOfIds(hcpIds)).successBody().let { maybeDecrypt(it) }
}

@InternalIcureApi
private abstract class AbstractInvoiceFlavouredApi<E : Invoice>(
	rawApi: RawInvoiceApi,
	protected val config: ApiConfiguration
) : AbstractInvoiceBasicFlavouredApi<E>(rawApi), InvoiceFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		invoice: E,
		options: InvoiceShareOptions?,
	): E =
		shareWithMany(invoice, mapOf(delegateId to (options ?: InvoiceShareOptions())))

	override suspend fun shareWithMany(invoice: E, delegates: Map<String, InvoiceShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			invoice,
			EntityWithEncryptionMetadataTypeName.Invoice,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getInvoice(it) ?: throw NotFoundException("invoice $it not found") },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()


	@Deprecated("Use filter instead")
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
			secretPatientKeys = ListOfIds(
				config.crypto.entity.secretIdsOf(
					null,
					patient,
					EntityWithEncryptionMetadataTypeName.Patient,
					null
				).toList())
		).successBody()
	) { ids ->
		rawApi.getInvoices(ListOfIds(ids)).successBody().let { maybeDecrypt(it) }
	}

}

@InternalIcureApi
private class AbstractInvoiceBasicFlavourlessApi(
	private val rawApi: RawInvoiceApi
) : InvoiceBasicFlavourlessApi {
	override suspend fun deleteInvoice(entityId: String) = rawApi.deleteInvoice(entityId).successBody()
	@Deprecated("Use filter instead")

	override suspend fun getTarificationsCodesOccurrences(
		minOccurrence: Int,
	) = rawApi.getTarificationsCodesOccurrences(minOccurrence.toLong()).successBody()

}

@InternalIcureApi
internal class InvoiceApiImpl(
	private val rawApi: RawInvoiceApi,
	private val rawEntityReferenceApi: RawEntityReferenceApi,
	private val config: ApiConfiguration,
) : InvoiceApi, InvoiceFlavouredApi<DecryptedInvoice> by object :
	AbstractInvoiceFlavouredApi<DecryptedInvoice>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedInvoice>
	): List<EncryptedInvoice> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Invoice,
			DecryptedInvoice.serializer(),
			this.config.encryption.invoice,
		) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedInvoice>
	): List<DecryptedInvoice> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Invoice,
			EncryptedInvoice.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(config.jsonPatcher.patchInvoice(it)) }
}, InvoiceBasicFlavourlessApi by AbstractInvoiceBasicFlavourlessApi(rawApi) {
	override val encrypted: InvoiceFlavouredApi<EncryptedInvoice> =
		object : AbstractInvoiceFlavouredApi<EncryptedInvoice>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedInvoice>
			): List<EncryptedInvoice> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.Invoice,
					EncryptedInvoice.serializer(),
					config.encryption.invoice
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedInvoice>
			): List<EncryptedInvoice> =
				entities
		}

	override val tryAndRecover: InvoiceFlavouredApi<Invoice> =
		object : AbstractInvoiceFlavouredApi<Invoice>(rawApi, config) {

			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Invoice>
			): List<EncryptedInvoice> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId = entitiesGroupId,
					entities = entities,
					entitiesType = EntityWithEncryptionMetadataTypeName.Invoice,
					encryptedSerializer = EncryptedInvoice.serializer(),
					decryptedSerializer = DecryptedInvoice.serializer(),
					fieldsToEncrypt = config.encryption.invoice
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedInvoice>
			): List<Invoice> =
				config.crypto.entity.decryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Invoice,
					EncryptedInvoice.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(config.jsonPatcher.patchInvoice(it)) }
		}

	private suspend fun createInvoice(entity: DecryptedInvoice): DecryptedInvoice {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createInvoice(
			config.crypto.entity.encryptEntities(
				null,
				listOf(entity),
				EntityWithEncryptionMetadataTypeName.Invoice,
				DecryptedInvoice.serializer(),
				config.encryption.invoice,
			) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }.single(),
		).successBody().let {
			decrypt(it)
		}
	}

	private suspend fun getNextInvoiceReference(prefix: String): Int =
		rawEntityReferenceApi.getLatest(prefix).successBodyOrNull()
			?.takeIf { it.id.startsWith(prefix) }
			?.id?.split(":")?.last()
			?.toIntOrNull()?.plus(1) ?: 1

	private suspend fun createInvoiceReference(nextReference: Int, invoiceId: String, prefix: String): EntityReference = rawEntityReferenceApi.createEntityReference(
		EntityReference(
			id = buildString {
				append(prefix)
				if (!prefix.endsWith(":")) {
					append(":")
				}
				append("$nextReference".padStart(6, '0'))
			},
			docId = invoiceId
		)
	).successBody()

	override suspend fun createInvoice(entity: DecryptedInvoice, prefix: String?): DecryptedInvoice = if(prefix != null) {
		val invoiceReference = createInvoiceReference(getNextInvoiceReference(prefix), entity.id, prefix)
		if(entity.internshipNihii != null) {
			entity.copy(invoiceReference = invoiceReference.id.split(":", limit = 2).last().replace("0", "1"))
		} else {
			entity.copy(invoiceReference = invoiceReference.id.split(":", limit = 2).last())
		}.let { createInvoice(it) }
	} else {
		createInvoice(entity)
	}

	override suspend fun createInvoices(entities: List<DecryptedInvoice>): List<DecryptedInvoice> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createInvoices(
			config.crypto.entity.encryptEntities(
				null,
				entities,
				EntityWithEncryptionMetadataTypeName.Invoice,
				DecryptedInvoice.serializer(),
				config.encryption.invoice,
			) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) },
		).successBody().map {
			decrypt(it)
		}
	}

	override suspend fun getEncryptionKeysOf(invoice: Invoice): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(null, invoice, EntityWithEncryptionMetadataTypeName.Invoice, null)

	override suspend fun hasWriteAccess(invoice: Invoice): Boolean =
		config.crypto.entity.hasWriteAccess(null, invoice, EntityWithEncryptionMetadataTypeName.Invoice)

	override suspend fun decryptPatientIdOf(invoice: Invoice): Set<String> =
		config.crypto.entity.owningEntityIdsOf(null, invoice, EntityWithEncryptionMetadataTypeName.Invoice, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Invoice, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.Invoice,
			delegates.asLocalDataOwnerReferences()
		)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedInvoice?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedInvoice =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedInvoice(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
				groupId = base?.groupId ?: base?.id,
				invoiceDate = base?.invoiceDate ?: currentFuzzyDateTime(TimeZone.currentSystemDefault()),
			),
			EntityWithEncryptionMetadataTypeName.Invoice,
			patient?.let {
				OwningEntityDetails(
					null,
					it.id,
					config.crypto.entity.resolveSecretIdOption(
						null,
						it,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData)
				.orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun decrypt(invoice: EncryptedInvoice): DecryptedInvoice =
		config.crypto.entity.decryptEntities(
			null,
			listOf(invoice),
			EntityWithEncryptionMetadataTypeName.Invoice,
			EncryptedInvoice.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(config.jsonPatcher.patchInvoice(it)) }.single()

	override suspend fun tryDecrypt(invoice: EncryptedInvoice): Invoice =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(invoice),
			EntityWithEncryptionMetadataTypeName.Invoice,
			EncryptedInvoice.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(config.jsonPatcher.patchInvoice(it)) }.single()
}

@InternalIcureApi
internal class InvoiceBasicApiImpl(
	rawApi: RawInvoiceApi,
	private val config: BasicApiConfiguration
) : InvoiceBasicApi, InvoiceBasicFlavouredApi<EncryptedInvoice> by object :
	AbstractInvoiceBasicFlavouredApi<EncryptedInvoice>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedInvoice>
	): List<EncryptedInvoice> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.Invoice, EncryptedInvoice.serializer(), config.encryption.invoice)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedInvoice>
	): List<EncryptedInvoice> =
		entities
}, InvoiceBasicFlavourlessApi by AbstractInvoiceBasicFlavourlessApi(rawApi)
