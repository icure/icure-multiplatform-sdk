package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.crypto.entities.HealthElementShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
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
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.subscription.Subscribable
import com.icure.sdk.subscription.Subscription
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface HealthcareElementBasicFlavourlessApi : Subscribable<HealthElement, EncryptedHealthElement>  {
	suspend fun matchHealthcareElementsBy(filter: AbstractFilter<HealthElement>): List<String>
	suspend fun deleteHealthcareElement(entityId: String): DocIdentifier
	suspend fun deleteHealthcareElements(entityIds: List<String>): List<DocIdentifier>
	suspend fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): List<IcureStub>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface HealthcareElementBasicFlavouredApi<E : HealthElement> {
	suspend fun modifyHealthcareElement(entity: E): E
	suspend fun modifyHealthcareElements(entities: List<E>): List<E>
	suspend fun getHealthcareElement(entityId: String): E
	suspend fun getHealthcareElements(entityIds: List<String>): List<E>
	suspend fun filterHealthcareElementsBy(
		filterChain: FilterChain<HealthElement>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E>
	suspend fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface HealthcareElementFlavouredApi<E : HealthElement> : HealthcareElementBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param healthElement the [HealthElement] to share.
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
		healthElement: E,
		delegates: Map<String, HealthElementShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param healthElement the [HealthElement] to share.
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
		healthElement: E,
		delegates: Map<String, HealthElementShareOptions>
	): E

	suspend fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface HealthcareElementApi : HealthcareElementBasicFlavourlessApi, HealthcareElementFlavouredApi<DecryptedHealthElement> {
	suspend fun createHealthcareElement(entity: DecryptedHealthElement): DecryptedHealthElement
	suspend fun createHealthcareElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement>
	suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedHealthElement
	suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString>
	suspend fun hasWriteAccess(healthElement: HealthElement): Boolean
	suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>)

	val encrypted: HealthcareElementFlavouredApi<EncryptedHealthElement>
	val tryAndRecover: HealthcareElementFlavouredApi<HealthElement>
}

interface HealthcareElementBasicApi : HealthcareElementBasicFlavourlessApi, HealthcareElementBasicFlavouredApi<EncryptedHealthElement>

@InternalIcureApi
private abstract class AbstractHealthcareElementBasicFlavouredApi<E : HealthElement>(
	protected val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) :	HealthcareElementBasicFlavouredApi<E> {
	override suspend fun modifyHealthcareElement(entity: E): E =
		rawApi.modifyHealthElement(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyHealthcareElements(entities: List<E>): List<E> =
		rawApi.modifyHealthElements(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getHealthcareElement(entityId: String): E =
		rawApi.getHealthElement(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getHealthcareElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterHealthcareElementsBy(
		filterChain: FilterChain<HealthElement>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.filterHealthElementsBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedHealthElement
	abstract suspend fun maybeDecrypt(entity: EncryptedHealthElement): E
}

@InternalIcureApi
private abstract class AbstractHealthcareElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	private val config: ApiConfiguration
) : AbstractHealthcareElementBasicFlavouredApi<E>(rawApi, config), HealthcareElementFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.healthElement

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

	override suspend fun tryShareWithMany(healthElement: E, delegates: Map<String, HealthElementShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			healthElement.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(healthElement: E, delegates: Map<String, HealthElementShareOptions>): E =
		tryShareWithMany(healthElement, delegates).updatedEntityOrThrow()

	override suspend fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listHealthElementIdsByDataOwnerPatientOpeningDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getHealthElements(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}

}

@InternalIcureApi
private class AbstractHealthcareElementBasicFlavourlessApi(
	val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) : HealthcareElementBasicFlavourlessApi {
	override suspend fun matchHealthcareElementsBy(filter: AbstractFilter<HealthElement>) =
		rawApi.matchHealthElementsBy(filter).successBody()
	override suspend fun deleteHealthcareElement(entityId: String) = rawApi.deleteHealthElement(entityId).successBody()
	override suspend fun deleteHealthcareElements(entityIds: List<String>) = rawApi.deleteHealthElements(ListOfIds(entityIds)).successBody()
	override suspend fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()
	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<HealthElement>,
		subscriptionConfig: Subscription.Configuration
	): Subscription<EncryptedHealthElement> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl.replace("https://", "").replace("http://", ""),
			path = "/ws/v2/notification/subscribe",
			deserializeEntity = { Serialization.json.decodeFromString(it) },
			events = events,
			filter = filter,
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = { Serialization.json.encodeToString(it) },
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal class HealthcareElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: ApiConfiguration
) : HealthcareElementApi, HealthcareElementFlavouredApi<DecryptedHealthElement> by object :
	AbstractHealthcareElementFlavouredApi<DecryptedHealthElement>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedHealthElement): EncryptedHealthElement =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedHealthElement.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): DecryptedHealthElement {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}
}, HealthcareElementBasicFlavourlessApi by AbstractHealthcareElementBasicFlavourlessApi(rawApi, config) {

	override val encrypted: HealthcareElementFlavouredApi<EncryptedHealthElement> =
		object : AbstractHealthcareElementFlavouredApi<EncryptedHealthElement>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
		}

	override val tryAndRecover: HealthcareElementFlavouredApi<HealthElement> =
		object : AbstractHealthcareElementFlavouredApi<HealthElement>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): HealthElement =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: HealthElement): EncryptedHealthElement = when (entity) {
				is EncryptedHealthElement -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedHealthElement -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedHealthElement.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }
			}
		}

	override suspend fun createHealthcareElement(entity: DecryptedHealthElement): DecryptedHealthElement {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElement(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createHealthcareElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElements(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.healthElement

	override suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedHealthElement =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedHealthElement(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates  + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString> = crypto.entity.encryptionKeysOf(healthElement.withTypeInfo(), null)

	override suspend fun hasWriteAccess(healthElement: HealthElement): Boolean = crypto.entity.hasWriteAccess(healthElement.withTypeInfo())

	override suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<String> = crypto.entity.owningEntityIdsOf(healthElement.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedHealthElement) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedHealthElement.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	suspend fun decrypt(entity: EncryptedHealthElement, errorMessage: () -> String): DecryptedHealthElement =
		crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
			?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class HealthcareElementBasicApiImpl(
	rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) : HealthcareElementBasicApi, HealthcareElementBasicFlavouredApi<EncryptedHealthElement> by object :
	AbstractHealthcareElementBasicFlavouredApi<EncryptedHealthElement>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), config.encryption.healthElement)

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
}, HealthcareElementBasicFlavourlessApi by AbstractHealthcareElementBasicFlavourlessApi(rawApi, config)
