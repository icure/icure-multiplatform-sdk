package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawTimeTableApi
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedTimeTable
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("TimeTable.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface TimeTableBasicFlavourlessApi {
	suspend fun deleteTimeTable(entityId: String): DocIdentifier
	suspend fun deleteTimeTables(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface TimeTableBasicFlavouredApi<E : TimeTable> {
	suspend fun modifyTimeTable(entity: E): E
	suspend fun getTimeTable(entityId: String): E

	suspend fun getTimeTablesByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<E>
	suspend fun getTimeTablesByAgendaId(agendaId: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface TimeTableFlavouredApi<E : TimeTable> : TimeTableBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		timeTable: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface TimeTableApi : TimeTableBasicFlavourlessApi, TimeTableFlavouredApi<DecryptedTimeTable> {
	suspend fun createTimeTable(entity: DecryptedTimeTable): DecryptedTimeTable
	suspend fun withEncryptionMetadata(
		base: DecryptedTimeTable?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedTimeTable

	val encrypted: TimeTableFlavouredApi<EncryptedTimeTable>
	val tryAndRecover: TimeTableFlavouredApi<TimeTable>
}

interface TimeTableBasicApi : TimeTableBasicFlavourlessApi, TimeTableBasicFlavouredApi<EncryptedTimeTable>

@InternalIcureApi
private abstract class AbstractTimeTableBasicFlavouredApi<E : TimeTable>(protected val rawApi: RawTimeTableApi) :
	TimeTableBasicFlavouredApi<E> {
	override suspend fun modifyTimeTable(entity: E): E =
		rawApi.modifyTimeTable(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getTimeTable(entityId: String): E = rawApi.getTimeTable(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getTimeTablesByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
		) = rawApi.getTimeTablesByPeriodAndAgendaId(startDate, endDate, agendaId).successBody().map { maybeDecrypt(it) }
	override suspend fun getTimeTablesByAgendaId(agendaId: String) = rawApi.getTimeTablesByAgendaId(agendaId).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedTimeTable
	abstract suspend fun maybeDecrypt(entity: EncryptedTimeTable): E
}

@InternalIcureApi
private abstract class AbstractTimeTableFlavouredApi<E : TimeTable>(
	rawApi: RawTimeTableApi,
	private val crypto: InternalCryptoServices,
) : AbstractTimeTableBasicFlavouredApi<E>(rawApi), TimeTableFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		timeTable: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			timeTable.withTypeInfo(),
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
}

@InternalIcureApi
private class AbstractTimeTableBasicFlavourlessApi(val rawApi: RawTimeTableApi) : TimeTableBasicFlavourlessApi {
	override suspend fun deleteTimeTable(entityId: String) = rawApi.deleteTimeTable(entityId).successBody()
	override suspend fun deleteTimeTables(entityIds: List<String>) = rawApi.deleteTimeTables(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class TimeTableApiImpl(
	private val rawApi: RawTimeTableApi,
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	private val autofillAuthor: Boolean,
) : TimeTableApi, TimeTableFlavouredApi<DecryptedTimeTable> by object :
	AbstractTimeTableFlavouredApi<DecryptedTimeTable>(rawApi, crypto) {
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
		) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, TimeTableBasicFlavourlessApi by AbstractTimeTableBasicFlavourlessApi(rawApi) {
	override val encrypted: TimeTableFlavouredApi<EncryptedTimeTable> =
		object : AbstractTimeTableFlavouredApi<EncryptedTimeTable>(rawApi, crypto) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedTimeTable): EncryptedTimeTable =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTimeTable.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedTimeTable): EncryptedTimeTable = entity
		}

	override val tryAndRecover: TimeTableFlavouredApi<TimeTable> =
		object : AbstractTimeTableFlavouredApi<TimeTable>(rawApi, crypto) {
			override suspend fun maybeDecrypt(entity: EncryptedTimeTable): TimeTable =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedTimeTable.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(it) }
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createTimeTable(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedTimeTable?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
	): DecryptedTimeTable =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedTimeTable(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { autofillAuthor },
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates  + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedTimeTable) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedTimeTable.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedTimeTable>(it) }

	suspend fun decrypt(entity: EncryptedTimeTable, errorMessage: () -> String): DecryptedTimeTable = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedTimeTable.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class TimeTableBasicApiImpl(
	rawApi: RawTimeTableApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : TimeTableBasicApi, TimeTableBasicFlavouredApi<EncryptedTimeTable> by object :
	AbstractTimeTableBasicFlavouredApi<EncryptedTimeTable>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedTimeTable): EncryptedTimeTable =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTimeTable.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedTimeTable): EncryptedTimeTable = entity
}, TimeTableBasicFlavourlessApi by AbstractTimeTableBasicFlavourlessApi(rawApi)
