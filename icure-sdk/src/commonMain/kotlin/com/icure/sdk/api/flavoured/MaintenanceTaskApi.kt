package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.crypto.BasicCryptoApi
import com.icure.sdk.crypto.InternalCryptoApi
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MaintenanceTaskBasicFlavourlessApi {
	suspend fun deleteMaintenanceTask(entityId: String): DocIdentifier
	suspend fun deleteMaintenanceTasks(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MaintenanceTaskBasicFlavouredApi<E : MaintenanceTask> {
	suspend fun modifyMaintenanceTask(entity: E): E
	suspend fun getMaintenanceTask(entityId: String): E
	suspend fun filterMaintenanceTasksBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<MaintenanceTask>
	): PaginatedList<E, *>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface MaintenanceTaskFlavouredApi<E : MaintenanceTask> : MaintenanceTaskBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface MaintenanceTaskApi : MaintenanceTaskBasicFlavourlessApi, MaintenanceTaskFlavouredApi<DecryptedMaintenanceTask> {
	suspend fun createMaintenanceTask(entity: DecryptedMaintenanceTask): DecryptedMaintenanceTask

	/**
	 * Creates a maintenance task with initialised encryption metadata, using the provided maintenance task as a base.
	 * @param maintenanceTask a maintenance task with initialised content, to be used as a base for the result.
	 * @param user the current user. If provided the auto-delegations from the user will be used in addition to
	 * [delegates], and the user details will be used to autofill author information (if not provided author information
	 * will be autofilled by the server for explicit data owners).
	 * @param delegates users that will be granted access to the maintenance task (in addition to the current data owner
	 * and, if user is non-null, auto-delegations).
	 */
	suspend fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTask?,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
	): DecryptedMaintenanceTask

	val encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>
	val tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask>
}

interface MaintenanceTaskBasicApi : MaintenanceTaskBasicFlavourlessApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>

@InternalIcureApi
private abstract class AbstractMaintenanceTaskBasicFlavouredApi<E : MaintenanceTask>(protected val rawApi: RawMaintenanceTaskApi) :
	MaintenanceTaskBasicFlavouredApi<E> {
	override suspend fun modifyMaintenanceTask(entity: E): E =
		rawApi.modifyMaintenanceTask(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


	override suspend fun getMaintenanceTask(entityId: String): E = rawApi.getMaintenanceTask(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<MaintenanceTask>,
	): PaginatedList<E, *> =
		// TODO fix filter typing
		rawApi.filterMaintenanceTasksBy(startDocumentId, limit, filterChain as FilterChain<EncryptedMaintenanceTask>).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedMaintenanceTask
	abstract suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): E
}

@InternalIcureApi
private abstract class AbstractMaintenanceTaskFlavouredApi<E : MaintenanceTask>(
	rawApi: RawMaintenanceTaskApi,
	private val crypto: InternalCryptoApi
) : AbstractMaintenanceTaskBasicFlavouredApi<E>(rawApi), MaintenanceTaskFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
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
}

@InternalIcureApi
private class AbstractMaintenanceTaskBasicFlavourlessApi(val rawApi: RawMaintenanceTaskApi) : MaintenanceTaskBasicFlavourlessApi {
	override suspend fun deleteMaintenanceTask(entityId: String) = rawApi.deleteMaintenanceTask(entityId).successBody()
	override suspend fun deleteMaintenanceTasks(entityIds: List<String>) = rawApi.deleteMaintenanceTasks(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class MaintenanceTaskApiImpl(
	private val rawApi: RawMaintenanceTaskApi,
	private val crypto: InternalCryptoApi,
	private val fieldsToEncrypt: EncryptedFieldsManifest,
	private val autofillAuthor: Boolean,
) : MaintenanceTaskApi, MaintenanceTaskFlavouredApi<DecryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskFlavouredApi<DecryptedMaintenanceTask>(rawApi, crypto) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedMaintenanceTask): EncryptedMaintenanceTask =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedMaintenanceTask.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedMaintenanceTask>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): DecryptedMaintenanceTask {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedMaintenanceTask.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi) {
	override val encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask> =
		object : AbstractMaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>(rawApi, crypto) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMaintenanceTask.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask = entity
		}

	override val tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask> =
		object : AbstractMaintenanceTaskFlavouredApi<MaintenanceTask>(rawApi, crypto) {
			override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): MaintenanceTask =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedMaintenanceTask.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: MaintenanceTask): EncryptedMaintenanceTask = when (entity) {
				is EncryptedMaintenanceTask -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedMaintenanceTask.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedMaintenanceTask -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedMaintenanceTask.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedMaintenanceTask>(it) }
			}
		}

	override suspend fun createMaintenanceTask(entity: DecryptedMaintenanceTask): DecryptedMaintenanceTask {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createMaintenanceTask(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTask?,
		user: User?,
		delegates: Map<String, AccessLevel>,
	): DecryptedMaintenanceTask =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(maintenanceTask ?: DecryptedMaintenanceTask(crypto.primitives.strongRandom.randomUUID())).copy(
				created = maintenanceTask?.created ?: currentEpochMs(),
				modified = maintenanceTask?.modified ?: currentEpochMs(),
				responsible = maintenanceTask?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = maintenanceTask?.author ?: user?.id?.takeIf { autofillAuthor },
			).withTypeInfo(),
			null,
			null,
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + (user?.autoDelegationsFor(DelegationTag.All) ?: emptyMap()),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedMaintenanceTask) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedMaintenanceTask.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedMaintenanceTask>(it) }

	suspend fun decrypt(entity: EncryptedMaintenanceTask, errorMessage: () -> String): DecryptedMaintenanceTask = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedMaintenanceTask.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class MaintenanceTaskBasicApiImpl(
	rawApi: RawMaintenanceTaskApi,
	private val crypto: BasicCryptoApi,
	private val fieldsToEncrypt: EncryptedFieldsManifest,
) : MaintenanceTaskBasicApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask =
		crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMaintenanceTask.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask = entity
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi)
