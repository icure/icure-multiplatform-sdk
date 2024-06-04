package com.icure.sdk.api.flavoured

import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.api.raw.RawFormApi
import com.icure.sdk.crypto.entities.FormShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.Form
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface FormBasicFlavourlessApi {
	suspend fun deleteForm(entityId: String): DocIdentifier
	suspend fun deleteForms(entityIds: List<String>): List<DocIdentifier>
	suspend fun getFormTemplate(formTemplateId: String, raw: Boolean? = null): FormTemplate
	suspend fun getFormTemplatesByGuid(formTemplateGuid: String, specialityCode: String, raw: Boolean? = null): List<FormTemplate>
	suspend fun listFormTemplatesBySpeciality(specialityCode: String, raw: Boolean? = null): List<FormTemplate>
	suspend fun getFormTemplates(loadLayout: Boolean? = null, raw: Boolean? = null): List<FormTemplate>
	suspend fun createFormTemplate(formTemplate: FormTemplate): FormTemplate
	suspend fun deleteFormTemplate(formTemplateId: String): DocIdentifier
	suspend fun updateFormTemplate(formTemplate: FormTemplate): FormTemplate
	suspend fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): String
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface FormBasicFlavouredApi<E : Form> {
	suspend fun modifyForm(entity: E): E
	suspend fun modifyForms(entities: List<E>): List<E>
	suspend fun getForm(entityId: String): E
	suspend fun getForms(entityIds: List<String>): List<E>

	suspend fun getFormByLogicalUuid(logicalUuid: String): E
	suspend fun getFormsByLogicalUuid(logicalUuid: String): List<E>
	suspend fun getFormsByUniqueId(uniqueId: String): List<E>
	suspend fun getFormByUniqueId(uniqueId: String): E
	suspend fun getChildrenForms(hcPartyId: String, parentId: String): List<E>
	suspend fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		healthElementId: String? = null,
		planOfActionId: String? = null,
		formTemplateId: String? = null
	): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface FormFlavouredApi<E : Form> : FormBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		form: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param form the [Form] to share.
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
		form: E,
		delegates: Map<String, FormShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param form the [Form] to share.
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
		form: E,
		delegates: Map<String, FormShareOptions>
	): E

	suspend fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface FormApi : FormBasicFlavourlessApi, FormFlavouredApi<DecryptedForm> {
	suspend fun createForm(entity: DecryptedForm): DecryptedForm
	suspend fun createForms(entities: List<DecryptedForm>): List<DecryptedForm>
	suspend fun withEncryptionMetadata(
		base: DecryptedForm?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedForm
	suspend fun getEncryptionKeysOf(form: Form): Set<HexString>
	suspend fun hasWriteAccess(form: Form): Boolean
	suspend fun decryptPatientIdOf(form: Form): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Form, delegates: Set<String>)

	val encrypted: FormFlavouredApi<EncryptedForm>
	val tryAndRecover: FormFlavouredApi<Form>
}

interface FormBasicApi : FormBasicFlavourlessApi, FormBasicFlavouredApi<EncryptedForm>

@InternalIcureApi
private abstract class AbstractFormBasicFlavouredApi<E : Form>(protected val rawApi: RawFormApi) :
	FormBasicFlavouredApi<E> {
	override suspend fun modifyForm(entity: E): E =
		rawApi.modifyForm(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyForms(entities: List<E>): List<E> =
		rawApi.modifyForms(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getForm(entityId: String): E = rawApi.getForm(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getForms(entityIds: List<String>): List<E> =
		rawApi.getForms(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun getFormByLogicalUuid(logicalUuid: String) = rawApi.getFormByLogicalUuid(logicalUuid).successBody().let { maybeDecrypt(it) }

	override suspend fun getFormsByLogicalUuid(logicalUuid: String) = rawApi.getFormsByLogicalUuid(logicalUuid).successBody().map { maybeDecrypt(it) }

	override suspend fun getFormsByUniqueId(uniqueId: String) = rawApi.getFormsByUniqueId(uniqueId).successBody().map { maybeDecrypt(it) }

	override suspend fun getFormByUniqueId(uniqueId: String) = rawApi.getFormByUniqueId(uniqueId).successBody().let { maybeDecrypt(it) }

	override suspend fun getChildrenForms(hcPartyId: String, parentId: String) = rawApi.getChildrenForms(parentId, hcPartyId).successBody().map { maybeDecrypt(it) }

	override suspend fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		healthElementId: String?,
		planOfActionId: String?,
		formTemplateId: String?,
		) = rawApi.listFormsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys, healthElementId, planOfActionId, formTemplateId).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedForm
	abstract suspend fun maybeDecrypt(entity: EncryptedForm): E
}

@InternalIcureApi
private abstract class AbstractFormFlavouredApi<E : Form>(
	rawApi: RawFormApi,
	private val config: ApiConfiguration,
) : AbstractFormBasicFlavouredApi<E>(rawApi), FormFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.form

	override suspend fun shareWith(
		delegateId: String,
		form: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			form.withTypeInfo(),
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

	override suspend fun tryShareWithMany(form: E, delegates: Map<String, FormShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			form.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(form: E, delegates: Map<String, FormShareOptions>): E =
		tryShareWithMany(form, delegates).updatedEntityOrThrow()

	override suspend fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listFormIdsByDataOwnerPatientOpeningDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getForms(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}
}

@InternalIcureApi
private class AbstractFormBasicFlavourlessApi(val rawApi: RawFormApi) : FormBasicFlavourlessApi {
	override suspend fun deleteForm(entityId: String) = rawApi.deleteForm(entityId).successBody()
	override suspend fun deleteForms(entityIds: List<String>) = rawApi.deleteForms(ListOfIds(entityIds)).successBody()
	override suspend fun getFormTemplate(
		formTemplateId: String,
		raw: Boolean?,
	) = rawApi.getFormTemplate(formTemplateId, raw).successBody()

	override suspend fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	) = rawApi.getFormTemplatesByGuid(formTemplateGuid, specialityCode, raw).successBody()

	override suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		raw: Boolean?,
	) = rawApi.listFormTemplatesBySpeciality(specialityCode, raw).successBody()

	override suspend fun getFormTemplates(
		loadLayout: Boolean?,
		raw: Boolean?,
	) = rawApi.getFormTemplates(loadLayout, raw).successBody()

	override suspend fun createFormTemplate(
		formTemplate: FormTemplate,
	) = rawApi.createFormTemplate(formTemplate).successBody()

	override suspend fun deleteFormTemplate(
		formTemplateId: String,
	) = rawApi.deleteFormTemplate(formTemplateId).successBody()

	override suspend fun updateFormTemplate(
		formTemplate: FormTemplate,
	) = rawApi.updateFormTemplate(formTemplate.id, formTemplate).successBody()

	override suspend fun setTemplateAttachment(
		formTemplateId: String,
		payload: ByteArray,
    ) = rawApi.setTemplateAttachment(formTemplateId, payload).successBody()
}

@InternalIcureApi
internal class FormApiImpl(
	private val rawApi: RawFormApi,
	private val config: ApiConfiguration,
) : FormApi, FormFlavouredApi<DecryptedForm> by object :
	AbstractFormFlavouredApi<DecryptedForm>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedForm): EncryptedForm =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedForm.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedForm>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedForm): DecryptedForm {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedForm.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedForm>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, FormBasicFlavourlessApi by AbstractFormBasicFlavourlessApi(rawApi) {
	override val encrypted: FormFlavouredApi<EncryptedForm> =
		object : AbstractFormFlavouredApi<EncryptedForm>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedForm): EncryptedForm =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedForm.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedForm): EncryptedForm = entity
		}

	override val tryAndRecover: FormFlavouredApi<Form> =
		object : AbstractFormFlavouredApi<Form>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedForm): Form =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedForm.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedForm>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Form): EncryptedForm = when (entity) {
				is EncryptedForm -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedForm.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedForm -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedForm.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedForm>(it) }
			}
		}

	override suspend fun createForm(entity: DecryptedForm): DecryptedForm {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createForm(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createForms(entities: List<DecryptedForm>): List<DecryptedForm> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createForms(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.form

	override suspend fun withEncryptionMetadata(
		base: DecryptedForm?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
	): DecryptedForm =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedForm(crypto.primitives.strongRandom.randomUUID())).copy(
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

	override suspend fun getEncryptionKeysOf(form: Form): Set<HexString> = crypto.entity.encryptionKeysOf(form.withTypeInfo(), null)

	override suspend fun hasWriteAccess(form: Form): Boolean = crypto.entity.hasWriteAccess(form.withTypeInfo())

	override suspend fun decryptPatientIdOf(form: Form): Set<String> = crypto.entity.owningEntityIdsOf(form.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Form, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedForm) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedForm.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedForm>(it) }

	suspend fun decrypt(entity: EncryptedForm, errorMessage: () -> String): DecryptedForm = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedForm.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedForm>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class FormBasicApiImpl(
	rawApi: RawFormApi,
	private val config: BasicApiConfiguration
) : FormBasicApi, FormBasicFlavouredApi<EncryptedForm> by object :
	AbstractFormBasicFlavouredApi<EncryptedForm>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedForm): EncryptedForm =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedForm.serializer(), config.encryption.form)

	override suspend fun maybeDecrypt(entity: EncryptedForm): EncryptedForm = entity
}, FormBasicFlavourlessApi by AbstractFormBasicFlavourlessApi(rawApi)
