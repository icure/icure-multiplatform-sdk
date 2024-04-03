package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityDecryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("MaintenanceTask.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap())

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
		filterChain: FilterChain<EncryptedMaintenanceTask>
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
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedMaintenanceTask,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
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
		filterChain: FilterChain<EncryptedMaintenanceTask>,
	): PaginatedList<E, *> = rawApi.filterMaintenanceTasksBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedMaintenanceTask
	abstract suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): E
}

@InternalIcureApi
private abstract class AbstractMaintenanceTaskFlavouredApi<E : MaintenanceTask>(
	rawApi: RawMaintenanceTaskApi,
	private val encryptionService: EntityEncryptionService,
) : AbstractMaintenanceTaskBasicFlavouredApi<E>(rawApi), MaintenanceTaskFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
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
	private val encryptionService: EntityEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : MaintenanceTaskApi, MaintenanceTaskFlavouredApi<DecryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskFlavouredApi<DecryptedMaintenanceTask>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedMaintenanceTask): EncryptedMaintenanceTask =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedMaintenanceTask.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedMaintenanceTask>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): DecryptedMaintenanceTask {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedMaintenanceTask.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(it) }
			?: throw EntityDecryptionException("Entity ${entity.id} cannot be created")
	}
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi) {
	override val encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask> =
		object : AbstractMaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMaintenanceTask.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask = entity
		}

	override val tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask> =
		object : AbstractMaintenanceTaskFlavouredApi<MaintenanceTask>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): MaintenanceTask =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedMaintenanceTask.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: MaintenanceTask): EncryptedMaintenanceTask = when (entity) {
				is EncryptedMaintenanceTask -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedMaintenanceTask.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedMaintenanceTask -> encryptionService.encryptEntity(
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

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedMaintenanceTask,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedMaintenanceTask =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			healthcareElement.withTypeInfo(),
			patient.id,
			encryptionService.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + (
				(user.autoDelegations[DelegationTag.MedicalInformation] ?: emptySet()) +
					(user.autoDelegations[DelegationTag.All] ?: emptySet())
				).associateWith { AccessLevel.Write },
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedMaintenanceTask) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedMaintenanceTask.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedMaintenanceTask>(it) }

	suspend fun decrypt(entity: EncryptedMaintenanceTask, errorMessage: () -> String): DecryptedMaintenanceTask = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedMaintenanceTask.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(it) }
		?: throw EntityDecryptionException(errorMessage())

}

@InternalIcureApi
internal class MaintenanceTaskBasicApiImpl(
	rawApi: RawMaintenanceTaskApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : MaintenanceTaskBasicApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMaintenanceTask.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedMaintenanceTask): EncryptedMaintenanceTask = entity
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi)
