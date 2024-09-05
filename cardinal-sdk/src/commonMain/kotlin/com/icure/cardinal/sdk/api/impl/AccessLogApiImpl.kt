package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AccessLogApi
import com.icure.cardinal.sdk.api.AccessLogBasicApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavouredApi
import com.icure.cardinal.sdk.api.AccessLogBasicFlavourlessApi
import com.icure.cardinal.sdk.api.AccessLogFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawAccessLogApi
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SecretIdOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapAccessLogFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochInstant
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractAccessLogBasicFlavouredApi<E : AccessLog>(
	protected val rawApi: RawAccessLogApi
) : AccessLogBasicFlavouredApi<E> {
	protected open suspend fun getSecureDelegationKeys() = emptyList<String>()

	override suspend fun modifyAccessLog(entity: E): E =
		rawApi.modifyAccessLog(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getAccessLog(entityId: String): E = rawApi.getAccessLog(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getAccessLogs(entityIds: List<String>): List<E> =
		rawApi.getAccessLogByIds(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findAccessLogsBy(fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

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
		rawApi.findAccessLogsByUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit, descending).successBody()
			.map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findAccessLogsInGroup(groupId, fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedAccessLog
	abstract suspend fun maybeDecrypt(entity: EncryptedAccessLog): E
}

@InternalIcureApi
private abstract class AbstractAccessLogFlavouredApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	private val config: ApiConfiguration
) : AbstractAccessLogBasicFlavouredApi<E>(rawApi), AccessLogFlavouredApi<E> {
	protected val crypto: InternalCryptoServices get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.accessLog

	override suspend fun getSecureDelegationKeys(): List<String> =
		crypto.exchangeDataManager.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.AccessLog)?.map { it.s } ?: emptyList()

	override suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		options: AccessLogShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			accessLog.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: AccessLogShareOptions()),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(accessLog: E, delegates: Map<String, AccessLogShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			accessLog.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(accessLog: E, delegates: Map<String, AccessLogShareOptions>): E =
		tryShareWithMany(accessLog, delegates).updatedEntityOrThrow()

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
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getAccessLogByIds(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
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
	override suspend fun deleteAccessLog(entityId: String) = rawApi.deleteAccessLog(entityId).successBody()
	override suspend fun deleteAccessLogs(entityIds: List<String>) = rawApi.deleteAccessLogs(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class AccessLogApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: ApiConfiguration
) : AccessLogApi, AccessLogFlavouredApi<DecryptedAccessLog> by object :
	AbstractAccessLogFlavouredApi<DecryptedAccessLog>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedAccessLog): EncryptedAccessLog =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedAccessLog.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedAccessLog): DecryptedAccessLog {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedAccessLog.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(config.jsonPatcher.patchAccessLog(it)) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi) {

	override val encrypted: AccessLogFlavouredApi<EncryptedAccessLog> =
		object : AbstractAccessLogFlavouredApi<EncryptedAccessLog>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedAccessLog.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity

		}

	override val tryAndRecover: AccessLogFlavouredApi<AccessLog> =
		object : AbstractAccessLogFlavouredApi<AccessLog>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedAccessLog): AccessLog =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedAccessLog.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(config.jsonPatcher.patchAccessLog(it)) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: AccessLog): EncryptedAccessLog = when (entity) {
				is EncryptedAccessLog -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedAccessLog.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedAccessLog -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedAccessLog.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }
			}
		}

	private val crypto get() = config.crypto

	override suspend fun getEncryptionKeysOf(accessLog: AccessLog): Set<HexString> = crypto.entity.encryptionKeysOf(accessLog.withTypeInfo(), null)

	override suspend fun hasWriteAccess(accessLog: AccessLog): Boolean = crypto.entity.hasWriteAccess(accessLog.withTypeInfo())

	override suspend fun decryptPatientIdOf(accessLog: AccessLog): Set<String> = crypto.entity.owningEntityIdsOf(accessLog.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: AccessLog, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createAccessLog(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
	): DecryptedAccessLog =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedAccessLog(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				date = base?.date ?: currentEpochInstant(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initializeEncryptionKey = true,
			initializeSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedAccessLog) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedAccessLog.serializer(),
		config.encryption.accessLog,
	) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	private suspend fun decryptOrNull(entity: EncryptedAccessLog): DecryptedAccessLog? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedAccessLog.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(config.jsonPatcher.patchAccessLog(it)) }

	override suspend fun decrypt(accessLog: EncryptedAccessLog): DecryptedAccessLog =
		decryptOrNull(accessLog) ?: throw EntityEncryptionException("AccessLog cannot be decrypted")

	override suspend fun tryDecrypt(accessLog: EncryptedAccessLog): AccessLog =
		decryptOrNull(accessLog) ?: accessLog

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
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
		config.crypto.validationService.validateEncryptedEntity(
			entity.withTypeInfo(),
			EncryptedAccessLog.serializer(),
			config.encryption.accessLog
		)

	override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity
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