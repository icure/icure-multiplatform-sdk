package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.TimeTableApi
import com.icure.cardinal.sdk.api.TimeTableBasicApi
import com.icure.cardinal.sdk.api.TimeTableBasicFlavouredApi
import com.icure.cardinal.sdk.api.TimeTableBasicFlavourlessApi
import com.icure.cardinal.sdk.api.TimeTableFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawTimeTableApi
import com.icure.cardinal.sdk.crypto.entities.SecretIdOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.TimeTableShareOptions
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapTimeTableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTimeTable
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.TimeTable
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
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractTimeTableBasicFlavouredApi<E : TimeTable>(protected val rawApi: RawTimeTableApi) :
	TimeTableBasicFlavouredApi<E> {
	override suspend fun modifyTimeTable(entity: E): E =
		rawApi.modifyTimeTable(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getTimeTable(entityId: String): E = rawApi.getTimeTable(entityId).successBody().let { maybeDecrypt(it) }
	@Deprecated("Use filter instead")
	override suspend fun getTimeTablesByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	) = rawApi.getTimeTablesByPeriodAndAgendaId(startDate, endDate, agendaId).successBody().map { maybeDecrypt(it) }
	@Deprecated("Use filter instead")
	override suspend fun getTimeTablesByAgendaId(agendaId: String) = rawApi.getTimeTablesByAgendaId(agendaId).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedTimeTable
	abstract suspend fun maybeDecrypt(entity: EncryptedTimeTable): E

	override suspend fun getTimeTables(timeTableIds: List<String>): List<E> =
		rawApi.getTimeTables(ListOfIds(timeTableIds)).successBody().map { maybeDecrypt(it) }
}

@InternalIcureApi
private abstract class AbstractTimeTableFlavouredApi<E : TimeTable>(
	rawApi: RawTimeTableApi,
	private val config: ApiConfiguration
) : AbstractTimeTableBasicFlavouredApi<E>(rawApi), TimeTableFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.timeTable

	override suspend fun shareWith(
		delegateId: String,
		timeTable: E,
		options: TimeTableShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			timeTable.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: TimeTableShareOptions()),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(timeTable: E, delegates: Map<String, TimeTableShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			timeTable.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(timeTable: E, delegates: Map<String, TimeTableShareOptions>): E =
		tryShareWithMany(timeTable, delegates).updatedEntityOrThrow()

	override suspend fun filterTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): PaginatedListIterator<E> =
		filterTimeTablesBy(filter)

	override suspend fun filterTimeTablesBy(filter: FilterOptions<TimeTable>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchTimeTablesBy(
				mapTimeTableFilterOptions(
					filter,
					config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
					config.crypto.entity
				)
			).successBody(),
			::getTimeTables
		)
}

@InternalIcureApi
private class AbstractTimeTableBasicFlavourlessApi(val rawApi: RawTimeTableApi) : TimeTableBasicFlavourlessApi {
	override suspend fun deleteTimeTable(entityId: String) = rawApi.deleteTimeTable(entityId).successBody()
	override suspend fun deleteTimeTables(entityIds: List<String>) = rawApi.deleteTimeTables(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class TimeTableApiImpl(
	private val rawApi: RawTimeTableApi,
	private val config: ApiConfiguration
) : TimeTableApi, TimeTableFlavouredApi<DecryptedTimeTable> by object :
	AbstractTimeTableFlavouredApi<DecryptedTimeTable>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedTimeTable): EncryptedTimeTable =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedTimeTable.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedTimeTable>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedTimeTable): DecryptedTimeTable {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedTimeTable.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(config.jsonPatcher.patchTimeTable(it)) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, TimeTableBasicFlavourlessApi by AbstractTimeTableBasicFlavourlessApi(rawApi) {
	override val encrypted: TimeTableFlavouredApi<EncryptedTimeTable> =
		object : AbstractTimeTableFlavouredApi<EncryptedTimeTable>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedTimeTable): EncryptedTimeTable =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTimeTable.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedTimeTable): EncryptedTimeTable = entity
		}

	override val tryAndRecover: TimeTableFlavouredApi<TimeTable> =
		object : AbstractTimeTableFlavouredApi<TimeTable>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedTimeTable): TimeTable =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedTimeTable.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(config.jsonPatcher.patchTimeTable(it)) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: TimeTable): EncryptedTimeTable = when (entity) {
				is EncryptedTimeTable -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedTimeTable.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedTimeTable -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedTimeTable.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedTimeTable>(it) }
			}
		}

	override suspend fun createTimeTable(entity: DecryptedTimeTable): DecryptedTimeTable {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createTimeTable(
			encrypt(entity),
		).successBody().let { decrypt(it) }
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.timeTable

	override suspend fun getEncryptionKeysOf(timeTable: TimeTable): Set<HexString> = crypto.entity.encryptionKeysOf(timeTable.withTypeInfo(), null)

	override suspend fun hasWriteAccess(timeTable: TimeTable): Boolean = crypto.entity.hasWriteAccess(timeTable.withTypeInfo())

	override suspend fun decryptPatientIdOf(timeTable: TimeTable): Set<String> = crypto.entity.owningEntityIdsOf(timeTable.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: TimeTable, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedTimeTable?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
	): DecryptedTimeTable =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedTimeTable(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initializeEncryptionKey = true,
			initializeSecretId = false,
			autoDelegations = delegates  + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedTimeTable) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedTimeTable.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedTimeTable>(it) }

	private suspend fun decryptOrNull(entity: EncryptedTimeTable): DecryptedTimeTable? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedTimeTable.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(config.jsonPatcher.patchTimeTable(it)) }

	override suspend fun decrypt(timeTable: EncryptedTimeTable): DecryptedTimeTable =
		decryptOrNull(timeTable) ?: throw EntityEncryptionException("TimeTable cannot be decrypted")

	override suspend fun tryDecrypt(timeTable: EncryptedTimeTable): TimeTable =
		decryptOrNull(timeTable) ?: timeTable

	override suspend fun matchTimeTablesBy(filter: FilterOptions<TimeTable>): List<String> =
		rawApi.matchTimeTablesBy(
			mapTimeTableFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)
		).successBody()

	override suspend fun matchTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): List<String> =
		matchTimeTablesBy(filter)
}

@InternalIcureApi
internal class TimeTableBasicApiImpl(
	private val rawApi: RawTimeTableApi,
	private val config: BasicApiConfiguration
) : TimeTableBasicApi, TimeTableBasicFlavouredApi<EncryptedTimeTable> by object :
	AbstractTimeTableBasicFlavouredApi<EncryptedTimeTable>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedTimeTable): EncryptedTimeTable =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTimeTable.serializer(), config.encryption.timeTable)

	override suspend fun maybeDecrypt(entity: EncryptedTimeTable): EncryptedTimeTable = entity
}, TimeTableBasicFlavourlessApi by AbstractTimeTableBasicFlavourlessApi(rawApi) {
	override suspend fun matchTimeTablesBy(filter: BaseFilterOptions<TimeTable>): List<String> =
		rawApi.matchTimeTablesBy(
			mapTimeTableFilterOptions(
				filter,
				null,
				null
			)
		).successBody()

	override suspend fun matchTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): List<String> =
		matchTimeTablesBy(filter)

	override suspend fun filterTimeTablesBy(filter: BaseFilterOptions<TimeTable>): PaginatedListIterator<EncryptedTimeTable> =
		IdsPageIterator(
			matchTimeTablesBy(filter),
			::getTimeTables
		)

	override suspend fun filterTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): PaginatedListIterator<EncryptedTimeTable> =
		filterTimeTablesBy(filter)
}