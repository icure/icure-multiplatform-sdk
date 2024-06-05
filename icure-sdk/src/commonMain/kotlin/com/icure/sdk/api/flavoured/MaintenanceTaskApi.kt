package com.icure.sdk.api.flavoured

import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.websocket.Connection
import com.icure.sdk.websocket.ConnectionImpl
import com.icure.sdk.websocket.EmittedEvent
import com.icure.sdk.websocket.Subscribable
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.time.Duration

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MaintenanceTaskBasicFlavourlessApi {
	suspend fun deleteMaintenanceTask(entityId: String): DocIdentifier
	suspend fun deleteMaintenanceTasks(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MaintenanceTaskBasicFlavouredApi<E : MaintenanceTask>: Subscribable<MaintenanceTask, E> {
	suspend fun modifyMaintenanceTask(entity: E): E
	suspend fun getMaintenanceTask(entityId: String): E
	suspend fun filterMaintenanceTasksBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<MaintenanceTask>
	): PaginatedList<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface MaintenanceTaskFlavouredApi<E : MaintenanceTask> : MaintenanceTaskBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		maintenanceTask: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>


	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param maintenanceTask the [MaintenanceTask] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the [SimpleShareResult] of the operation: the updated entity if the operation was successful or details of the error if
	 * the operation failed.
	 */
	suspend fun tryShareWithMany(
		maintenanceTask: E,
		delegates: Map<String, MaintenanceTaskShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param maintenanceTask the [MaintenanceTask] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the updated entity.
	 * @throws IllegalStateException if the operation was not successful.
	 */
	suspend fun shareWithMany(
		maintenanceTask: E,
		delegates: Map<String, MaintenanceTaskShareOptions>
	): E
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
	suspend fun getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Set<HexString>
	suspend fun hasWriteAccess(maintenanceTask: MaintenanceTask): Boolean
	suspend fun decryptPatientIdOf(maintenanceTask: MaintenanceTask): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTask, delegates: Set<String>)

	val encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>
	val tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask>
}

interface MaintenanceTaskBasicApi : MaintenanceTaskBasicFlavourlessApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>

@InternalIcureApi
private abstract class AbstractMaintenanceTaskBasicFlavouredApi<E : MaintenanceTask>(
	protected val rawApi: RawMaintenanceTaskApi,
	private val config: BasicApiConfiguration
) :
	MaintenanceTaskBasicFlavouredApi<E> {
	override suspend fun modifyMaintenanceTask(entity: E): E =
		rawApi.modifyMaintenanceTask(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


	override suspend fun getMaintenanceTask(entityId: String): E = rawApi.getMaintenanceTask(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<MaintenanceTask>,
	): PaginatedList<E> =
		rawApi.filterMaintenanceTasksBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	@OptIn(InternalAPI::class)
	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<MaintenanceTask>,
		onConnected: suspend () -> Unit,
		channelCapacity: Int,
		retryDelay: Duration,
		retryDelayExponentFactor: Double,
		maxRetries: Int,
		eventFired: suspend (E) -> Unit
	): Connection {
		return ConnectionImpl.initialize(
			client = config.httpClient,
			hostname = config.apiUrl.replace("https://", "").replace("http://", ""),
			path = "/ws/v2/notification/subscribe",
			serializer = EncryptedMaintenanceTask.serializer(),
			events = events,
			filter = filter,
			qualifiedName = MaintenanceTask.KRAKEN_QUALIFIED_NAME,
			subscriptionSerializer = { Serialization.json.encodeToString(it) },
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			onOpenListener = onConnected,
			retryDelay = retryDelay,
			retryDelayExponentFactor = retryDelayExponentFactor,
			maxRetries = maxRetries,
			eventCallback = { entity, onEvent ->
				try {
					eventFired(maybeDecrypt(entity))
				} catch (e: EntityEncryptionException) {
					onEvent(EmittedEvent.Error(e.message, false))
				}
			}
		)
	}

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedMaintenanceTask
	abstract suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): E
}

@InternalIcureApi
private abstract class AbstractMaintenanceTaskFlavouredApi<E : MaintenanceTask>(
	rawApi: RawMaintenanceTaskApi,
	private val config: ApiConfiguration
) : AbstractMaintenanceTaskBasicFlavouredApi<E>(rawApi, config), MaintenanceTaskFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.maintenanceTask

	override suspend fun shareWith(
		delegateId: String,
		maintenanceTask: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			maintenanceTask.withTypeInfo(),
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptionsImpl(
					shareSecretIds = null,
					shareEncryptionKey = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(maintenanceTask: E, delegates: Map<String, MaintenanceTaskShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			maintenanceTask.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(maintenanceTask: E, delegates: Map<String, MaintenanceTaskShareOptions>): E =
		tryShareWithMany(maintenanceTask, delegates).updatedEntityOrThrow()
}

@InternalIcureApi
private class AbstractMaintenanceTaskBasicFlavourlessApi(val rawApi: RawMaintenanceTaskApi) : MaintenanceTaskBasicFlavourlessApi {
	override suspend fun deleteMaintenanceTask(entityId: String) = rawApi.deleteMaintenanceTask(entityId).successBody()
	override suspend fun deleteMaintenanceTasks(entityIds: List<String>) = rawApi.deleteMaintenanceTasks(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class MaintenanceTaskApiImpl(
	private val rawApi: RawMaintenanceTaskApi,
	private val config: ApiConfiguration
) : MaintenanceTaskApi, MaintenanceTaskFlavouredApi<DecryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskFlavouredApi<DecryptedMaintenanceTask>(rawApi, config) {
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
		object : AbstractMaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMaintenanceTask.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask = entity
		}

	override val tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask> =
		object : AbstractMaintenanceTaskFlavouredApi<MaintenanceTask>(rawApi, config) {
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createMaintenanceTask(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.maintenanceTask

	override suspend fun getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Set<HexString> = crypto.entity.encryptionKeysOf(maintenanceTask.withTypeInfo(), null)

	override suspend fun hasWriteAccess(maintenanceTask: MaintenanceTask): Boolean = crypto.entity.hasWriteAccess(maintenanceTask.withTypeInfo())

	override suspend fun decryptPatientIdOf(maintenanceTask: MaintenanceTask): Set<String> = crypto.entity.owningEntityIdsOf(maintenanceTask.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTask, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
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
				responsible = maintenanceTask?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = maintenanceTask?.author ?: user?.id?.takeIf { config.autofillAuthor },
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
	private val config: BasicApiConfiguration
) : MaintenanceTaskBasicApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMaintenanceTask.serializer(), config.encryption.maintenanceTask)

	override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask = entity
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi)
