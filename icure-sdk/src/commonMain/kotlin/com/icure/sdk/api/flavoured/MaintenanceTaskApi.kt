package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.serialization.MaintenanceTaskAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.Subscribable
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MaintenanceTaskBasicFlavourlessApi: Subscribable<MaintenanceTask, EncryptedMaintenanceTask> {
	/**
	 * Deletes a maintenance task. If you don't have write access to the maintenance task the method will fail.
	 * @param entityId id of the maintenance task.
	 * @return the id and revision of the deleted maintenance task.
	 */
	suspend fun deleteMaintenanceTask(entityId: String): DocIdentifier

	/**
	 * Deletes many maintenance tasks. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the maintenance tasks.
	 * @return the id and revision of the deleted maintenance tasks. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteMaintenanceTasks(entityIds: List<String>): List<DocIdentifier>
	
	/**
	 * Get the ids of all maintenance tasks matching the provided filter.
	 * @param filter a maintenance task filter
	 * @return a list of maintenance task ids
	 */
	suspend fun matchMaintenanceTasksBy(filter: AbstractFilter<MaintenanceTask>): List<String>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MaintenanceTaskBasicFlavouredApi<E : MaintenanceTask> {
	/**
	 * Modifies a maintenance task. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a maintenance task with update content
	 * @return the maintenance task updated with the provided content and a new revision.
	 */
	suspend fun modifyMaintenanceTask(entity: E): E

	/**
	 * Get a maintenance task by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a maintenance task, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a maintenance task id.
	 * @return the maintenance task with id [entityId].
	 */
	suspend fun getMaintenanceTask(entityId: String): E

	/**
	 * Get multiple maintenance tasks by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a maintenance task, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of maintenance tasks ids
	 * @return all maintenance tasks that you can access with one of the provided ids.
	 */
	suspend fun getMaintenanceTasks(entityIds: List<String>): List<E>

	/**
	 * @param filter a maintenance task filter
	 * @return an iterator that iterates over all maintenance tasks matching the provided filter.
	 */
	suspend fun filterMaintenanceTasksBy(
		filter: AbstractFilter<MaintenanceTask>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface MaintenanceTaskFlavouredApi<E : MaintenanceTask> : MaintenanceTaskBasicFlavouredApi<E> {
	/**
	 * Share a maintenance task with another data owner. The maintenance task must already exist in the database for this method to
	 * succeed. If you want to share the maintenance task before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the maintenance task
	 * @param maintenanceTask the maintenance task to share with [delegateId]
	 * @param options specifies how the maintenance task will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the maintenance task. Refer
	 * to the documentation of [MaintenanceTaskShareOptions] for more information.
	 * @return the updated maintenance task if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		maintenanceTask: E,
		@DefaultValue("null")
		options: MaintenanceTaskShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share a maintenance task with multiple data owners. The maintenance task must already exist in the database for this method to
	 * succeed. If you want to share the maintenance task before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param maintenanceTask the maintenance task to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated maintenance task if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		maintenanceTask: E,
		delegates: Map<String, MaintenanceTaskShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a maintenance task with multiple data owners. The maintenance task must already exist in the database for this method to
	 * succeed. If you want to share the maintenance task before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param maintenanceTask the maintenance task to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated maintenance task.
	 */
	suspend fun shareWithMany(
		maintenanceTask: E,
		delegates: Map<String, MaintenanceTaskShareOptions>
	): E
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface MaintenanceTaskApi : MaintenanceTaskBasicFlavourlessApi, MaintenanceTaskFlavouredApi<DecryptedMaintenanceTask> {
	/**
	 * Create a new maintenance task. The provided maintenance task must have the encryption metadata initialized.
	 * @param entity a maintenance task with initialized encryption metadata
	 * @return the created maintenance task with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createMaintenanceTask(entity: DecryptedMaintenanceTask): DecryptedMaintenanceTask

	/**
	 * Creates a maintenance task with initialized encryption metadata, using the provided maintenance task as a base.
	 * @param maintenanceTask a maintenance task with initialized content, to be used as a base for the result.
	 * @param user the current user. If provided the auto-delegations from the user will be used in addition to
	 * [delegates], and the user details will be used to autofill author information (if not provided author information
	 * will be autofilled by the server for explicit data owners).
	 * @param delegates users that will be granted access to the maintenance task (in addition to the current data owner
	 * and, if user is non-null, auto-delegations).
	 */
	suspend fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTask?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
	): DecryptedMaintenanceTask

	/**
	 * Attempts to extract the encryption keys of a maintenance task. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param maintenanceTask a maintenance task
	 * @return the encryption keys extracted from the provided maintenance task.
	 */
	suspend fun getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Set<HexString>

	/**
	 * Specifies if the current user has write access to a maintenance task.
	 * @param maintenanceTask a maintenance task
	 * @return if the current user has write access to the provided maintenance task
	 */
	suspend fun hasWriteAccess(maintenanceTask: MaintenanceTask): Boolean

	/**
	 * Attempts to extract the patient id linked to a maintenance task.
	 * Note: maintenance tasks usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param maintenanceTask a maintenance task
	 * @return the id of the patient linked to the maintenance task, or empty if the current user can't access any patient id
	 * of the maintenance task.
	 */
	suspend fun decryptPatientIdOf(maintenanceTask: MaintenanceTask): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a maintenance task.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided maintenance task. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the maintenance task the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any MaintenanceTask,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a maintenance task E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any maintenance task that you have shared with P, H will be able to know that the maintenance task was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a maintenance task that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a maintenance task
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTask, delegates: Set<String>)

	/**
	 * Decrypts a maintenance task, throwing an exception if it is not possible.
	 * @param maintenanceTask a maintenance task
	 * @return the decrypted maintenance task
	 * @throws EntityEncryptionException if the maintenance task could not be decrypted
	 */
	suspend fun decrypt(maintenanceTask: EncryptedMaintenanceTask): DecryptedMaintenanceTask

	/**
	 * Tries to decrypt a maintenance task, returns the input if it is not possible.
	 * @param maintenanceTask an encrypted maintenance task
	 * @return the decrypted maintenance task if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(maintenanceTask: EncryptedMaintenanceTask): MaintenanceTask

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
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

	override suspend fun getMaintenanceTasks(entityIds: List<String>): List<E> = rawApi.getMaintenanceTasks(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterMaintenanceTasksBy(filter: AbstractFilter<MaintenanceTask>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchMaintenanceTasksBy(filter).successBody(),
			this::getMaintenanceTasks
		)

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
}

@InternalIcureApi
private class AbstractMaintenanceTaskBasicFlavourlessApi(val rawApi: RawMaintenanceTaskApi, private val config: BasicApiConfiguration) : MaintenanceTaskBasicFlavourlessApi {
	override suspend fun deleteMaintenanceTask(entityId: String) = rawApi.deleteMaintenanceTask(entityId).successBody()
	override suspend fun deleteMaintenanceTasks(entityIds: List<String>) = rawApi.deleteMaintenanceTasks(ListOfIds(entityIds)).successBody()
	override suspend fun matchMaintenanceTasksBy(filter: AbstractFilter<MaintenanceTask>): List<String> = rawApi.matchMaintenanceTasksBy(filter).successBody()
	override suspend fun subscribeToEvents(
		events: Set<com.icure.sdk.subscription.SubscriptionEventType>,
		filter: AbstractFilter<MaintenanceTask>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMaintenanceTask> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedMaintenanceTask.serializer(),
			events = events,
			filter = filter,
			qualifiedName = MaintenanceTask.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MaintenanceTaskAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
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
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi, config)
