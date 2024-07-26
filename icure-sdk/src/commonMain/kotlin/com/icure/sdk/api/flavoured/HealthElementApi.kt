package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.crypto.entities.HealthElementShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
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
import com.icure.sdk.serialization.HealthElementAbstractFilterSerializer
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
interface HealthElementBasicFlavourlessApi : Subscribable<HealthElement, EncryptedHealthElement>  {
	/**
	 * Get the ids of all health elements matching the provided filter.
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): List<String>

	/**
	 * Deletes {{an entity}}. If you don't have write access to the {{entity}} the method will fail.
	 * @param entityId id of the {{entity}}.
	 * @return the id and revision of the deleted {{entity}}.
	 */
	suspend fun deleteHealthElement(entityId: String): DocIdentifier

	/**
	 * Deletes many {{entities}}. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the {{entities}}.
	 * @return the id and revision of the deleted {{entities}}. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteHealthElements(entityIds: List<String>): List<DocIdentifier>

	@Deprecated("Will be replaced by filter")
	suspend fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): List<IcureStub>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface HealthElementBasicFlavouredApi<E : HealthElement> {
	/**
	 * Modifies {{an entity}}. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity {{an entity}} with update content
	 * @return the {{entity}} updated with the provided content and a new revision.
	 */
	suspend fun modifyHealthElement(entity: E): E

	/**
	 * Modifies multiple {{entities}}. Ignores all {{entities}} for which you don't have write access.
	 * Flavoured method.
	 * @param entities {{entities}} with update content
	 * @return the updated {{entities}} with a new revision.
	 */
	suspend fun modifyHealthElements(entities: List<E>): List<E>

	/**
	 * Get {{an entity}} by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not {{an entity}}, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId {{an entity}} id.
	 * @return the {{entity}} with id [entityId].
	 */
	suspend fun getHealthElement(entityId: String): E

	/**
	 * Get multiple {{entities}} by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not {{an entity}}, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of {{entities}} ids
	 * @return all {{entities}} that you can access with one of the provided ids.
	 */
	suspend fun getHealthElements(entityIds: List<String>): List<E>

	/**
	 * @param filter {{an entity}} filter
	 * @return an iterator that iterates over all {{entities}} matching the provided filter.
	 */
	suspend fun filterHealthElementsBy(filter: AbstractFilter<HealthElement>): PaginatedListIterator<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface HealthElementFlavouredApi<E : HealthElement> : HealthElementBasicFlavouredApi<E> {
	/**
	 * Share {{an entity}} with another data owner. The {{entity}} must already exist in the database for this method to
	 * succeed. If you want to share the {{entity}} before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param delegateId the owner that will gain access to the {{entity}}
	 * @param healthElement the {{entity}} to share with [delegateId]
	 * @param options specifies how the {{entity}} will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the {{entity}}. Refer
	 * to the documentation of [{{EntityType}}ShareOptions] for more information.
	 * @return the updated {{entity}} if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		healthElement: E,
		@DefaultValue("null")
		options: HealthElementShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share {{an entity}} with multiple data owners. The {{entity}} must already exist in the database for this method to
	 * succeed. If you want to share the {{entity}} before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param healthElement the {{entity}} to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated {{entity}} if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		healthElement: E,
		delegates: Map<String, HealthElementShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share {{an entity}} with multiple data owners. The {{entity}} must already exist in the database for this method to
	 * succeed. If you want to share the {{entity}} before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param healthElement the {{entity}} to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated {{entity}}.
	 */
	suspend fun shareWithMany(
		healthElement: E,
		delegates: Map<String, HealthElementShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
	suspend fun findHealthElementsByHcPartyPatient(
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
interface HealthElementApi : HealthElementBasicFlavourlessApi, HealthElementFlavouredApi<DecryptedHealthElement> {
	/**
	 * Create a new {{entity}}. The provided {{entity}} must have the encryption metadata initialised.
	 * @param entity {{an entity}} with initialised encryption metadata
	 * @return the created {{entity}} with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement

	/**
	 * Create multiple {{entities}}. All the provided {{entities}} must have the encryption metadata initialised, otherwise
	 * this method fails without doing anything.
	 * @param entities {{entities}} with initialised encryption metadata
	 * @return the created {{entities}} with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any {{entity}} in the input was not initialised.
	 */
	suspend fun createHealthElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement>

	/**
	 * Creates a new {{entity}} with initialised encryption metadata
	 * @param base {{an entity}} with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the {{entity}}.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new {{entity}}
	 * @return {{an entity}} with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
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

	/**
	 * Attempts to extract the encryption keys of {{an entity}}. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param healthElement {{an entity}}
	 * @return the encryption keys extracted from the provided {{entity}}.
	 */
	suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString>

	/**
	 * Specifies if the current user has write access to {{an entity}}.
	 * @param healthElement {{an entity}}
	 * @return if the current user has write access to the provided {{entity}}
	 */
	suspend fun hasWriteAccess(healthElement: HealthElement): Boolean

	/**
	 * Attempts to extract the patient id linked to {{an entity}}.
	 * Note: {{entities}} usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param healthElement {{an entity}}
	 * @return the id of the patient linked to the {{entity}}, or empty if the current user can't access any patient id
	 * of the {{entity}}.
	 */
	suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of {{an entity}}.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided {{entity}}. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the {{entity}} the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any {{EntityType}},
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have {{an entity}} E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any {{entity}} that you have shared with P, H will be able to know that the {{entity}} was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to {{an entity}} that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity {{an entity}}
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>)

	/**
	 * Decrypts {{an entity}}, throwing an exception if it is not possible.
	 * @param healthElement {{an entity}}
	 * @return the decrypted {{entity}}
	 * @throws EntityEncryptionException if the {{entity}} could not be decrypted
	 */
	suspend fun decrypt(healthElement: EncryptedHealthElement): DecryptedHealthElement

	/**
	 * Tries to decrypt {{an entity}}, returns the input if it is not possible.
	 * @param healthElement an encrypted {{entity}}
	 * @return the decrypted {{entity}} if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(healthElement: EncryptedHealthElement): HealthElement

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: HealthElementFlavouredApi<EncryptedHealthElement>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: HealthElementFlavouredApi<HealthElement>
}

interface HealthElementBasicApi : HealthElementBasicFlavourlessApi, HealthElementBasicFlavouredApi<EncryptedHealthElement>

@InternalIcureApi
private abstract class AbstractHealthElementBasicFlavouredApi<E : HealthElement>(
	protected val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) :	HealthElementBasicFlavouredApi<E> {
	override suspend fun modifyHealthElement(entity: E): E =
		rawApi.modifyHealthElement(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyHealthElements(entities: List<E>): List<E> =
		rawApi.modifyHealthElements(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getHealthElement(entityId: String): E =
		rawApi.getHealthElement(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getHealthElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterHealthElementsBy(filter: AbstractFilter<HealthElement>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchHealthElementsBy(filter).successBody(),
			this::getHealthElements
		)

	@Deprecated("Will be replaced by filter")
	override suspend fun findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedHealthElement
	abstract suspend fun maybeDecrypt(entity: EncryptedHealthElement): E
}

@InternalIcureApi
private abstract class AbstractHealthElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	private val config: ApiConfiguration
) : AbstractHealthElementBasicFlavouredApi<E>(rawApi, config), HealthElementFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.healthElement

	override suspend fun shareWith(
		delegateId: String,
		healthElement: E,
		options: HealthElementShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			healthElement.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: HealthElementShareOptions()),
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

	@Deprecated("Will be replaced by filter")
	override suspend fun findHealthElementsByHcPartyPatient(
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
private class AbstractHealthElementBasicFlavourlessApi(
	val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) : HealthElementBasicFlavourlessApi {
	override suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>) =
		rawApi.matchHealthElementsBy(filter).successBody()
	override suspend fun deleteHealthElement(entityId: String) = rawApi.deleteHealthElement(entityId).successBody()
	override suspend fun deleteHealthElements(entityIds: List<String>) = rawApi.deleteHealthElements(ListOfIds(entityIds)).successBody()
	@Deprecated("Will be replaced by filter")
	override suspend fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()
	override suspend fun subscribeToEvents(
		events: Set<com.icure.sdk.subscription.SubscriptionEventType>,
		filter: AbstractFilter<HealthElement>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedHealthElement> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedHealthElement.serializer(),
			events = events,
			filter = filter,
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(HealthElementAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal class HealthElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: ApiConfiguration
) : HealthElementApi, HealthElementFlavouredApi<DecryptedHealthElement> by object :
	AbstractHealthElementFlavouredApi<DecryptedHealthElement>(rawApi, config) {
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
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi(rawApi, config) {

	override val encrypted: HealthElementFlavouredApi<EncryptedHealthElement> =
		object : AbstractHealthElementFlavouredApi<EncryptedHealthElement>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
		}

	override val tryAndRecover: HealthElementFlavouredApi<HealthElement> =
		object : AbstractHealthElementFlavouredApi<HealthElement>(rawApi, config) {
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

	override suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElement(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun createHealthElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElements(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it)
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

	private suspend fun decryptOrNull(entity: EncryptedHealthElement): DecryptedHealthElement? =
		crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }

	override suspend fun decrypt(healthElement: EncryptedHealthElement): DecryptedHealthElement =
		decryptOrNull(healthElement) ?: throw EntityEncryptionException("HealthElement cannot be decrypted")

	override suspend fun tryDecrypt(healthElement: EncryptedHealthElement): HealthElement =
		decryptOrNull(healthElement) ?: healthElement
}

@InternalIcureApi
internal class HealthElementBasicApiImpl(
	rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) : HealthElementBasicApi, HealthElementBasicFlavouredApi<EncryptedHealthElement> by object :
	AbstractHealthElementBasicFlavouredApi<EncryptedHealthElement>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), config.encryption.healthElement)

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi(rawApi, config)
