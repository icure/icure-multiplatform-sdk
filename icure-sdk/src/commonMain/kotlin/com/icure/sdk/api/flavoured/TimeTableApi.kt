package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawTimeTableApi
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.TimeTableShareOptions
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
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface TimeTableBasicFlavourlessApi {
	/**
	 * Deletes a time-table. If you don't have write access to the time-table the method will fail.
	 * @param entityId id of the time-table.
	 * @return the id and revision of the deleted time-table.
	 */
	suspend fun deleteTimeTable(entityId: String): DocIdentifier

	/**
	 * Deletes many time-tables. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the time-tables.
	 * @return the id and revision of the deleted time-tables. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteTimeTables(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface TimeTableBasicFlavouredApi<E : TimeTable> {
	/**
	 * Modifies a time-table. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a time-table with update content
	 * @return the time-table updated with the provided content and a new revision.
	 */
	suspend fun modifyTimeTable(entity: E): E

	/**
	 * Get a time-table by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a time-table, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a time-table id.
	 * @return the time-table with id [entityId].
	 */
	suspend fun getTimeTable(entityId: String): E

	@Deprecated("Will be replaced by a filter")
	suspend fun getTimeTablesByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<E>

	@Deprecated("Will be replaced by a filter")
	suspend fun getTimeTablesByAgendaId(agendaId: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface TimeTableFlavouredApi<E : TimeTable> : TimeTableBasicFlavouredApi<E> {
	/**
	 * Share a time-table with another data owner. The time-table must already exist in the database for this method to
	 * succeed. If you want to share the time-table before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the time-table
	 * @param timeTable the time-table to share with [delegateId]
	 * @param options specifies how the time-table will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the time-table. Refer
	 * to the documentation of [TimeTableShareOptions] for more information.
	 * @return the updated time-table if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		timeTable: E,
		@DefaultValue("null")
		options: TimeTableShareOptions? = null
	): SimpleShareResult<E>


	/**
	 * Share a time-table with multiple data owners. The time-table must already exist in the database for this method to
	 * succeed. If you want to share the time-table before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param timeTable the time-table to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated time-table if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		timeTable: E,
		delegates: Map<String, TimeTableShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a time-table with multiple data owners. The time-table must already exist in the database for this method to
	 * succeed. If you want to share the time-table before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param timeTable the time-table to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated time-table.
	 */
	suspend fun shareWithMany(
		timeTable: E,
		delegates: Map<String, TimeTableShareOptions>
	): E
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface TimeTableApi : TimeTableBasicFlavourlessApi, TimeTableFlavouredApi<DecryptedTimeTable> {
	/**
	 * Create a new time-table. The provided time-table must have the encryption metadata initialized.
	 * @param entity a time-table with initialized encryption metadata
	 * @return the created time-table with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createTimeTable(entity: DecryptedTimeTable): DecryptedTimeTable

	/**
	 * Creates a new time-table with initialized encryption metadata
	 * @param base a time-table with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the time-table.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new time-table
	 * @return a time-table with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedTimeTable?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedTimeTable

	/**
	 * Attempts to extract the encryption keys of a time-table. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param timeTable a time-table
	 * @return the encryption keys extracted from the provided time-table.
	 */
	suspend fun getEncryptionKeysOf(timeTable: TimeTable): Set<HexString>

	/**
	 * Specifies if the current user has write access to a time-table.
	 * @param timeTable a time-table
	 * @return if the current user has write access to the provided time-table
	 */
	suspend fun hasWriteAccess(timeTable: TimeTable): Boolean

	/**
	 * Attempts to extract the patient id linked to a time-table.
	 * Note: time-tables usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param timeTable a time-table
	 * @return the id of the patient linked to the time-table, or empty if the current user can't access any patient id
	 * of the time-table.
	 */
	suspend fun decryptPatientIdOf(timeTable: TimeTable): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a time-table.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided time-table. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the time-table the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any TimeTable,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a time-table E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any time-table that you have shared with P, H will be able to know that the time-table was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a time-table that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a time-table
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: TimeTable, delegates: Set<String>)

	/**
	 * Decrypts a time-table, throwing an exception if it is not possible.
	 * @param timeTable a time-table
	 * @return the decrypted time-table
	 * @throws EntityEncryptionException if the time-table could not be decrypted
	 */
	suspend fun decrypt(timeTable: EncryptedTimeTable): DecryptedTimeTable

	/**
	 * Tries to decrypt a time-table, returns the input if it is not possible.
	 * @param timeTable an encrypted time-table
	 * @return the decrypted time-table if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(timeTable: EncryptedTimeTable): TimeTable

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: TimeTableFlavouredApi<EncryptedTimeTable>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: TimeTableFlavouredApi<TimeTable>
}

interface TimeTableBasicApi : TimeTableBasicFlavourlessApi, TimeTableBasicFlavouredApi<EncryptedTimeTable>

@InternalIcureApi
private abstract class AbstractTimeTableBasicFlavouredApi<E : TimeTable>(protected val rawApi: RawTimeTableApi) :
	TimeTableBasicFlavouredApi<E> {
	override suspend fun modifyTimeTable(entity: E): E =
		rawApi.modifyTimeTable(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getTimeTable(entityId: String): E = rawApi.getTimeTable(entityId).successBody().let { maybeDecrypt(it) }
	@Deprecated("Will be replaced by a filter")
	override suspend fun getTimeTablesByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	) = rawApi.getTimeTablesByPeriodAndAgendaId(startDate, endDate, agendaId).successBody().map { maybeDecrypt(it) }
	@Deprecated("Will be replaced by a filter")
	override suspend fun getTimeTablesByAgendaId(agendaId: String) = rawApi.getTimeTablesByAgendaId(agendaId).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedTimeTable
	abstract suspend fun maybeDecrypt(entity: EncryptedTimeTable): E
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
		) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(it) }
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
	) { Serialization.json.decodeFromJsonElement<DecryptedTimeTable>(it) }

	override suspend fun decrypt(timeTable: EncryptedTimeTable): DecryptedTimeTable =
		decryptOrNull(timeTable) ?: throw EntityEncryptionException("TimeTable cannot be decrypted")

	override suspend fun tryDecrypt(timeTable: EncryptedTimeTable): TimeTable =
		decryptOrNull(timeTable) ?: timeTable
}

@InternalIcureApi
internal class TimeTableBasicApiImpl(
	rawApi: RawTimeTableApi,
	private val config: BasicApiConfiguration
) : TimeTableBasicApi, TimeTableBasicFlavouredApi<EncryptedTimeTable> by object :
	AbstractTimeTableBasicFlavouredApi<EncryptedTimeTable>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedTimeTable): EncryptedTimeTable =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTimeTable.serializer(), config.encryption.timeTable)

	override suspend fun maybeDecrypt(entity: EncryptedTimeTable): EncryptedTimeTable = entity
}, TimeTableBasicFlavourlessApi by AbstractTimeTableBasicFlavourlessApi(rawApi)
