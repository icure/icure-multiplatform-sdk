package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AccessLogApi
import com.icure.cardinal.sdk.api.AccessLogBasicApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavouredApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavourlessApi
import com.icure.cardinal.sdk.api.AccessLogFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawAccessLogApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapAccessLogFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochInstant
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractAccessLogBasicFlavouredApi<E : AccessLog>(
	protected val rawApi: RawAccessLogApi
) : AccessLogBasicFlavouredApi<E>, FlavouredApi<EncryptedAccessLog, E> {
	override suspend fun createAccessLog(entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createAccessLog(
			validateAndMaybeEncrypt(null, entity),
		).successBody().let {
			maybeDecrypt(null, it)
		}
	}
	
	override suspend fun undeleteAccessLogById(id: String, rev: String): E =
		rawApi.undeleteAccessLog(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyAccessLog(entity: E): E =
		rawApi.modifyAccessLog(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun getAccessLog(entityId: String): E? =
		rawApi.getAccessLog(entityId).successBodyOrNull404()?.let { maybeDecrypt(null, it) }

	override suspend fun getAccessLogs(entityIds: List<String>): List<E> =
		maybeDecrypt(rawApi.getAccessLogByIds(ListOfIds(entityIds)).successBody())

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findAccessLogsBy(fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody())

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findAccessLogsByUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit, descending).successBody())

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findAccessLogsInGroup(groupId, fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody())
}

@InternalIcureApi
private abstract class AbstractAccessLogFlavouredApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	protected val config: ApiConfiguration
) : AbstractAccessLogBasicFlavouredApi<E>(rawApi), AccessLogFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		options: AccessLogShareOptions?,
	): E =
		shareWithMany(accessLog, mapOf(Pair(delegateId, options ?: AccessLogShareOptions())))

	override suspend fun shareWithMany(accessLog: E, delegates: Map<String, AccessLogShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			accessLog,
			EntityWithEncryptionMetadataTypeName.AccessLog,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getAccessLog(it) ?: throw NotFoundException("Access log $it not found") },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listAccessLogIdsByDataOwnerPatientDate(
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
				).toList()
			)
		).successBody()
	) { ids ->
		maybeDecrypt(rawApi.getAccessLogByIds(ListOfIds(ids)).successBody())
	}

	override suspend fun filterAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): PaginatedListIterator<E> =
		filterAccessLogsBy(filter)

	override suspend fun filterAccessLogsBy(filter: FilterOptions<AccessLog>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchAccessLogsBy(mapAccessLogFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)).successBody(),
			::getAccessLogs
		)
}

@InternalIcureApi
private class AbstractAccessLogBasicFlavourlessApi(val rawApi: RawAccessLogApi) : AccessLogBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteAccessLogUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteAccessLog(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteAccessLogsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteAccessLogs(ListOfIds(entityIds)).successBody()

	override suspend fun deleteAccessLogById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteAccessLog(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteAccessLogsByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier> =
		rawApi.deleteAccessLogsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeAccessLogById(id: String, rev: String) {
		rawApi.purgeAccessLog(id, rev).successBodyOrThrowRevisionConflict()
	}
}

@InternalIcureApi
internal class AccessLogApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: ApiConfiguration
) : AccessLogApi, AccessLogFlavouredApi<DecryptedAccessLog> by object :
	AbstractAccessLogFlavouredApi<DecryptedAccessLog>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedAccessLog>
	): List<EncryptedAccessLog> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.AccessLog,
			DecryptedAccessLog.serializer(),
			this.config.encryption.accessLog
		) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedAccessLog>
	): List<DecryptedAccessLog> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.AccessLog,
			EncryptedAccessLog.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(this.config.jsonPatcher.patchAccessLog(it)) }

}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi) {

	override val encrypted: AccessLogFlavouredApi<EncryptedAccessLog> =
		object : AbstractAccessLogFlavouredApi<EncryptedAccessLog>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedAccessLog>
			): List<EncryptedAccessLog> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.AccessLog,
					EncryptedAccessLog.serializer(),
					config.encryption.accessLog
				)


			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedAccessLog>
			): List<EncryptedAccessLog> =
				entities
		}

	override val tryAndRecover: AccessLogFlavouredApi<AccessLog> =
		object : AbstractAccessLogFlavouredApi<AccessLog>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<AccessLog>
			): List<EncryptedAccessLog> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.AccessLog,
					EncryptedAccessLog.serializer(),
					DecryptedAccessLog.serializer(),
					config.encryption.accessLog
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedAccessLog>
			): List<AccessLog> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.AccessLog,
					EncryptedAccessLog.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(config.jsonPatcher.patchAccessLog(it)) }
		}

	private val crypto get() = config.crypto

	override suspend fun getEncryptionKeysOf(accessLog: AccessLog): Set<HexString> = crypto.entity.encryptionKeysOf(null, accessLog, EntityWithEncryptionMetadataTypeName.AccessLog, null)

	override suspend fun hasWriteAccess(accessLog: AccessLog): Boolean = crypto.entity.hasWriteAccess(null, accessLog, EntityWithEncryptionMetadataTypeName.AccessLog)

	override suspend fun decryptPatientIdOf(accessLog: AccessLog): Set<String> = crypto.entity.owningEntityIdsOf(null, accessLog, EntityWithEncryptionMetadataTypeName.AccessLog, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: AccessLog, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(null, entity, EntityWithEncryptionMetadataTypeName.AccessLog, delegates.asLocalDataOwnerReferences())
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
	): DecryptedAccessLog =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = null,
			entity = (base ?: DecryptedAccessLog(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				date = base?.date ?: currentEpochInstant(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			entityType = EntityWithEncryptionMetadataTypeName.AccessLog,
			owningEntityDetails = OwningEntityDetails(
				null,
				patient.id,
				crypto.entity.resolveSecretIdOption(
					null,
					patient,
					EntityWithEncryptionMetadataTypeName.Patient,
					secretId
				)
			),
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun decrypt(accessLog: EncryptedAccessLog): DecryptedAccessLog =
		crypto.entity.decryptEntities(
			null,
			listOf(accessLog),
			EntityWithEncryptionMetadataTypeName.AccessLog,
			EncryptedAccessLog.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(config.jsonPatcher.patchAccessLog(it)) }.single()

	override suspend fun tryDecrypt(accessLog: EncryptedAccessLog): AccessLog =
		crypto.entity.tryDecryptEntities(
			null,
			listOf(accessLog),
			EntityWithEncryptionMetadataTypeName.AccessLog,
			EncryptedAccessLog.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(config.jsonPatcher.patchAccessLog(it)) }.single()

	override suspend fun matchAccessLogsBy(filter: FilterOptions<AccessLog>): List<String> =
		rawApi.matchAccessLogsBy(mapAccessLogFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)).successBody()

	override suspend fun matchAccessLogsBySorted(filter: SortableFilterOptions<AccessLog>): List<String> =
		matchAccessLogsBy(filter)
}

@InternalIcureApi
internal class AccessLogBasicApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: BasicApiConfiguration
) : AccessLogBasicApi, AccessLogBasicFlavouredApi<EncryptedAccessLog> by object :
	AbstractAccessLogBasicFlavouredApi<EncryptedAccessLog>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedAccessLog>
	): List<EncryptedAccessLog> =
		config.crypto.validationService.validateEncryptedEntities(
			entities,
			EntityWithEncryptionMetadataTypeName.AccessLog,
			EncryptedAccessLog.serializer(),
			config.encryption.accessLog
		)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedAccessLog>
	): List<EncryptedAccessLog> = entities
}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi) {
	override suspend fun matchAccessLogsBy(filter: BaseFilterOptions<AccessLog>): List<String> =
		rawApi.matchAccessLogsBy(mapAccessLogFilterOptions(filter, null, null)).successBody()

	override suspend fun matchAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): List<String> =
		matchAccessLogsBy(filter)

	override suspend fun filterAccessLogsBy(filter: BaseFilterOptions<AccessLog>): PaginatedListIterator<EncryptedAccessLog> =
		IdsPageIterator(matchAccessLogsBy(filter), ::getAccessLogs)

	override suspend fun filterAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): PaginatedListIterator<EncryptedAccessLog> =
		filterAccessLogsBy(filter)
}
