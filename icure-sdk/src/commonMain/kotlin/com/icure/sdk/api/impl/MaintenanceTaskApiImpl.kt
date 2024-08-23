package com.icure.sdk.api.impl

import com.icure.sdk.api.MaintenanceTaskApi
import com.icure.sdk.api.MaintenanceTaskBasicApi
import com.icure.sdk.api.MaintenanceTaskBasicFlavouredApi
import com.icure.sdk.api.MaintenanceTaskBasicFlavourlessApi
import com.icure.sdk.api.MaintenanceTaskFlavouredApi
import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.filters.mapMaintenanceTaskFilterOptions
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.serialization.MaintenanceTaskAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement


@InternalIcureApi
private abstract class AbstractMaintenanceTaskBasicFlavouredApi<E : MaintenanceTask>(
	protected val rawApi: RawMaintenanceTaskApi,
	private val config: BasicApiConfiguration
) :
	MaintenanceTaskBasicFlavouredApi<E> {
	override suspend fun modifyMaintenanceTask(entity: E): E =
		rawApi.modifyMaintenanceTask(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


	override suspend fun getMaintenanceTask(entityId: String): E = rawApi.getMaintenanceTask(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getMaintenanceTasks(entityIds: List<String>): List<E> = rawApi.getMaintenanceTasks(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

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
		options: MaintenanceTaskShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			maintenanceTask.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: MaintenanceTaskShareOptions()),
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

	override suspend fun filterMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): PaginatedListIterator<E> =
		filterMaintenanceTasksBy(filter)

	override suspend fun filterMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchMaintenanceTasksBy(mapMaintenanceTaskFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)).successBody(),
			this::getMaintenanceTasks
		)
}

@InternalIcureApi
private class AbstractMaintenanceTaskBasicFlavourlessApi(val rawApi: RawMaintenanceTaskApi, private val config: BasicApiConfiguration) :
	MaintenanceTaskBasicFlavourlessApi {
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
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi, config) {
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createMaintenanceTask(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
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
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(maintenanceTask ?: DecryptedMaintenanceTask(crypto.primitives.strongRandom.randomUUID())).copy(
				created = maintenanceTask?.created ?: currentEpochMs(),
				modified = maintenanceTask?.modified ?: currentEpochMs(),
				responsible = maintenanceTask?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = maintenanceTask?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			null,
			null,
			initializeEncryptionKey = true,
			initializeSecretId = false,
			autoDelegations = delegates + (user?.autoDelegationsFor(DelegationTag.All) ?: emptyMap()),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedMaintenanceTask) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedMaintenanceTask.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedMaintenanceTask>(it) }

	private suspend fun decryptOrNull(entity: EncryptedMaintenanceTask): DecryptedMaintenanceTask? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedMaintenanceTask.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(it) }

	override suspend fun decrypt(maintenanceTask: EncryptedMaintenanceTask): DecryptedMaintenanceTask =
		decryptOrNull(maintenanceTask) ?: throw EntityEncryptionException("MaintenanceTask cannot be decrypted")

	override suspend fun tryDecrypt(maintenanceTask: EncryptedMaintenanceTask): MaintenanceTask =
		decryptOrNull(maintenanceTask) ?: maintenanceTask

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<MaintenanceTask>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMaintenanceTask> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedMaintenanceTask.serializer(),
			events = events,
			filter = mapMaintenanceTaskFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			),
			qualifiedName = MaintenanceTask.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MaintenanceTaskAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun matchMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): List<String> =
		matchMaintenanceTasksBy(filter)

	override suspend fun matchMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): List<String> =
		rawApi.matchMaintenanceTasksBy(mapMaintenanceTaskFilterOptions(
			filter,
			config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
			config.crypto.entity
		)).successBody()
}

@InternalIcureApi
internal class MaintenanceTaskBasicApiImpl(
	private val rawApi: RawMaintenanceTaskApi,
	private val config: BasicApiConfiguration
) : MaintenanceTaskBasicApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMaintenanceTask.serializer(), config.encryption.maintenanceTask)

	override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask = entity
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi, config) {
	override suspend fun filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): PaginatedListIterator<EncryptedMaintenanceTask> =
		filterMaintenanceTasksBy(filter)

	override suspend fun filterMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): PaginatedListIterator<EncryptedMaintenanceTask> =
		IdsPageIterator(
			matchMaintenanceTasksBy(filter),
			this::getMaintenanceTasks
		)

	override suspend fun matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): List<String> =
		matchMaintenanceTasksBy(filter)

	override suspend fun matchMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): List<String> =
		rawApi.matchMaintenanceTasksBy(mapMaintenanceTaskFilterOptions(
			filter,
			null,
			null
		)).successBody()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<MaintenanceTask>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMaintenanceTask> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedMaintenanceTask.serializer(),
			events = events,
			filter = mapMaintenanceTaskFilterOptions(filter, null, null),
			qualifiedName = MaintenanceTask.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MaintenanceTaskAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
