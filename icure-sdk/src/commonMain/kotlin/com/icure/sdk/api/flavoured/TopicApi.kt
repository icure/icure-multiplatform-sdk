package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawTopicApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.requests.topic.AddParticipant
import com.icure.sdk.model.requests.topic.RemoveParticipant
import com.icure.sdk.utils.EntityDecryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Topic.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface TopicBasicFlavourlessApi {
	suspend fun deleteTopic(entityId: String): DocIdentifier
	suspend fun deleteTopics(entityIds: List<String>): List<DocIdentifier>
	suspend fun matchTopicsBy(filter: AbstractFilter<EncryptedTopic>): List<String>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface TopicBasicFlavouredApi<E : Topic> {
	suspend fun modifyTopic(entity: E): E
	suspend fun getTopic(entityId: String): E
	suspend fun getTopics(entityIds: List<String>): List<E>
	suspend fun filterTopicsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<EncryptedTopic>
	): PaginatedList<E, *>

	suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole): E
	suspend fun removeParticipant(entityId: String, dataOwnerId: String): E
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface TopicFlavouredApi<E : Topic> : TopicBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface TopicApi : TopicBasicFlavourlessApi, TopicFlavouredApi<DecryptedTopic> {
	suspend fun createTopic(entity: DecryptedTopic): DecryptedTopic
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedTopic,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedTopic

	val encrypted: TopicFlavouredApi<EncryptedTopic>
	val tryAndRecover: TopicFlavouredApi<Topic>
}

interface TopicBasicApi : TopicBasicFlavourlessApi, TopicBasicFlavouredApi<EncryptedTopic>

@InternalIcureApi
private abstract class AbstractTopicBasicFlavouredApi<E : Topic>(protected val rawApi: RawTopicApi) :
	TopicBasicFlavouredApi<E> {
	override suspend fun modifyTopic(entity: E): E =
		rawApi.modifyTopic(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getTopic(entityId: String): E = rawApi.getTopic(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getTopics(entityIds: List<String>): List<E> =
		rawApi.getTopics(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }
	override suspend fun filterTopicsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<EncryptedTopic>,
		) = rawApi.filterTopicsBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }
	override suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole) =
		rawApi.addParticipant(entityId, AddParticipant(dataOwnerId, topicRole)).successBody().let { maybeDecrypt(it) }
	override suspend fun removeParticipant(entityId: String, dataOwnerId: String) =
		rawApi.removeParticipant(entityId, RemoveParticipant(dataOwnerId)).successBody().let { maybeDecrypt(it) }


	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedTopic
	abstract suspend fun maybeDecrypt(entity: EncryptedTopic): E
}

@InternalIcureApi
private abstract class AbstractTopicFlavouredApi<E : Topic>(
	rawApi: RawTopicApi,
	private val encryptionService: EntityEncryptionService,
) : AbstractTopicBasicFlavouredApi<E>(rawApi), TopicFlavouredApi<E> {
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
private class AbstractTopicBasicFlavourlessApi(val rawApi: RawTopicApi) : TopicBasicFlavourlessApi {
	override suspend fun deleteTopic(entityId: String) = rawApi.deleteTopic(entityId).successBody()
	override suspend fun deleteTopics(entityIds: List<String>) = rawApi.deleteTopics(ListOfIds(entityIds)).successBody()
	override suspend fun matchTopicsBy(filter: AbstractFilter<EncryptedTopic>) = rawApi.matchTopicsBy(filter).successBody()
}

@InternalIcureApi
internal class TopicApiImpl(
	private val rawApi: RawTopicApi,
	private val encryptionService: EntityEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : TopicApi, TopicFlavouredApi<DecryptedTopic> by object :
	AbstractTopicFlavouredApi<DecryptedTopic>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedTopic): EncryptedTopic =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedTopic.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedTopic): DecryptedTopic {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedTopic.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(it) }
			?: throw EntityDecryptionException("Entity ${entity.id} cannot be created")
	}
}, TopicBasicFlavourlessApi by AbstractTopicBasicFlavourlessApi(rawApi) {
	override val encrypted: TopicFlavouredApi<EncryptedTopic> =
		object : AbstractTopicFlavouredApi<EncryptedTopic>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedTopic): EncryptedTopic =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTopic.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedTopic): EncryptedTopic = entity
		}

	override val tryAndRecover: TopicFlavouredApi<Topic> =
		object : AbstractTopicFlavouredApi<Topic>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedTopic): Topic =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedTopic.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Topic): EncryptedTopic = when (entity) {
				is EncryptedTopic -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedTopic.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedTopic -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedTopic.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }
			}
		}

	override suspend fun createTopic(entity: DecryptedTopic): DecryptedTopic {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createTopic(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedTopic,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedTopic =
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

	private suspend fun encrypt(entity: DecryptedTopic) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedTopic.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }

	suspend fun decrypt(entity: EncryptedTopic, errorMessage: () -> String): DecryptedTopic = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedTopic.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(it) }
		?: throw EntityDecryptionException(errorMessage())

}

@InternalIcureApi
internal class TopicBasicApiImpl(
	rawApi: RawTopicApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : TopicBasicApi, TopicBasicFlavouredApi<EncryptedTopic> by object :
	AbstractTopicBasicFlavouredApi<EncryptedTopic>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedTopic): EncryptedTopic =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTopic.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedTopic): EncryptedTopic = entity
}, TopicBasicFlavourlessApi by AbstractTopicBasicFlavourlessApi(rawApi)
