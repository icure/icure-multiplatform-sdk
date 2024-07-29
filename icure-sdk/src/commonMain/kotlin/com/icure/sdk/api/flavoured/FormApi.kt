package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawFormApi
import com.icure.sdk.crypto.entities.FormShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
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
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface FormBasicFlavourlessApi {
	/**
	 * Deletes a form. If you don't have write access to the form the method will fail.
	 * @param entityId id of the form.
	 * @return the id and revision of the deleted form.
	 */
	suspend fun deleteForm(entityId: String): DocIdentifier

	/**
	 * Deletes many forms. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the forms.
	 * @return the id and revision of the deleted forms. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteForms(entityIds: List<String>): List<DocIdentifier>

	suspend fun getFormTemplate(
		formTemplateId: String,
		@DefaultValue("null")
		raw: Boolean? = null
	): FormTemplate

	@Deprecated("Will be replaced by filter")
	suspend fun getFormTemplatesByGuid(formTemplateGuid: String, specialityCode: String, raw: Boolean? = null): List<FormTemplate>

	@Deprecated("Will be replaced by filter")
	suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		@DefaultValue("null")
		raw: Boolean? = null
	): List<FormTemplate>

	@Deprecated("Will be replaced by filter")
	suspend fun getFormTemplates(
		@DefaultValue("null")
		loadLayout: Boolean? = null,
		@DefaultValue("null")
		raw: Boolean? = null
	): List<FormTemplate>

	/**
	 * Create a new form template. Your user must have the permission to create form templates.
	 * @param formTemplate a form template
	 * @return the created form template with updated revision
	 */
	suspend fun createFormTemplate(formTemplate: FormTemplate): FormTemplate

	/**
	 * Deletes a form template. Your user must have the permission to delete form templates.
	 * @param formTemplateId the id of a form template
	 * @return the id and revision of the deleted template
	 */
	suspend fun deleteFormTemplate(formTemplateId: String): DocIdentifier

	/**
	 * Modifies a form template. Your user must have the permission to modify form templates.
	 * @param formTemplate a form template with updated content
	 * @return the updated form template, with updated revision
	 */
	suspend fun updateFormTemplate(formTemplate: FormTemplate): FormTemplate

	/**
	 * Sets the attachment to the form template.
	 */
	suspend fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): String
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface FormBasicFlavouredApi<E : Form> {
	/**
	 * Modifies a form. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a form with update content
	 * @return the form updated with the provided content and a new revision.
	 */
	suspend fun modifyForm(entity: E): E

	/**
	 * Modifies multiple forms. Ignores all forms for which you don't have write access.
	 * Flavoured method.
	 * @param entities forms with update content
	 * @return the updated forms with a new revision.
	 */
	suspend fun modifyForms(entities: List<E>): List<E>

	/**
	 * Get a form by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a form, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a form id.
	 * @return the form with id [entityId].
	 */
	suspend fun getForm(entityId: String): E

	/**
	 * Get multiple forms by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a form, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of forms ids
	 * @return all forms that you can access with one of the provided ids.
	 */
	suspend fun getForms(entityIds: List<String>): List<E>

	/**
	 * Get the latest form according to the [Form.created] field with the provided [Form.logicalUuid].
	 * If there are multiple forms with the provided logical uuid that have the same value for created (which also
	 * matches the latest) the behaviour of this method is undefined. If you think this situation may happen in your
	 * application you should not use this method and instead use filters to get all forms with the provided logical
	 * uuid.
	 * Flavoured method.
	 * @param logicalUuid a form logical uuid
	 * @return the latest form with the provided logical uuid.
	 */
	// TODO the backend currently get all forms, sorts them and then returns the latest. We could have the view be
	//  sorted instead
	suspend fun getLatestFormByLogicalUuid(logicalUuid: String): E

	/**
	 * Get the latest form according to the [Form.created] field with the provided [Form.uniqueId].
	 * If there are multiple forms with the provided unique id that have the same value for created (which also
	 * matches the latest) the behaviour of this method is undefined. If you think this situation may happen in your
	 * application you should not use this method and instead use filters to get all forms with the provided id.
	 * Flavoured method.
	 * @param uniqueId a form unique id
	 * @return the latest form with the provided unique id.
	 */
	// TODO the backend currently get all forms, sorts them and then returns the latest. We could have the view be
	//  sorted instead
	suspend fun getLatestFormByUniqueId(uniqueId: String): E

	@Deprecated("Will be replaced by filter")
	suspend fun getFormsByLogicalUuid(logicalUuid: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun getFormsByUniqueId(uniqueId: String): List<E>

	@Deprecated("Will be replaced by filter") // listFormsByHcPartyAndParentId
	suspend fun getChildrenForms(hcPartyId: String, parentId: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		@DefaultValue("null")
		healthElementId: String? = null,
		@DefaultValue("null")
		planOfActionId: String? = null,
		@DefaultValue("null")
		formTemplateId: String? = null
	): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface FormFlavouredApi<E : Form> : FormBasicFlavouredApi<E> {
	/**
	 * Share a form with another data owner. The form must already exist in the database for this method to
	 * succeed. If you want to share the form before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param delegateId the owner that will gain access to the form
	 * @param form the form to share with [delegateId]
	 * @param options specifies how the form will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the form. Refer
	 * to the documentation of [FormShareOptions] for more information.
	 * @return the updated form if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		form: E,
		@DefaultValue("null")
		options: FormShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share a form with multiple data owners. The form must already exist in the database for this method to
	 * succeed. If you want to share the form before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param form the form to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated form if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		form: E,
		delegates: Map<String, FormShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a form with multiple data owners. The form must already exist in the database for this method to
	 * succeed. If you want to share the form before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param form the form to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated form.
	 */
	suspend fun shareWithMany(
		form: E,
		delegates: Map<String, FormShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
	suspend fun findFormsByHcPartyPatient(
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
interface FormApi : FormBasicFlavourlessApi, FormFlavouredApi<DecryptedForm> {
	/**
	 * Create a new form. The provided form must have the encryption metadata initialised.
	 * @param entity a form with initialised encryption metadata
	 * @return the created form with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createForm(entity: DecryptedForm): DecryptedForm

	/**
	 * Create multiple forms. All the provided forms must have the encryption metadata initialised, otherwise
	 * this method fails without doing anything.
	 * @param entities forms with initialised encryption metadata
	 * @return the created forms with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any form in the input was not initialised.
	 */
	suspend fun createForms(entities: List<DecryptedForm>): List<DecryptedForm>

	/**
	 * Creates a new form with initialised encryption metadata
	 * @param base a form with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the form.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new form
	 * @return a form with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedForm?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedForm

	/**
	 * Attempts to extract the encryption keys of a form. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param form a form
	 * @return the encryption keys extracted from the provided form.
	 */
	suspend fun getEncryptionKeysOf(form: Form): Set<HexString>

	/**
	 * Specifies if the current user has write access to a form.
	 * @param form a form
	 * @return if the current user has write access to the provided form
	 */
	suspend fun hasWriteAccess(form: Form): Boolean

	/**
	 * Attempts to extract the patient id linked to a form.
	 * Note: forms usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param form a form
	 * @return the id of the patient linked to the form, or empty if the current user can't access any patient id
	 * of the form.
	 */
	suspend fun decryptPatientIdOf(form: Form): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a form.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided form. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the form the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Form,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a form E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any form that you have shared with P, H will be able to know that the form was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a form that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a form
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Form, delegates: Set<String>)

	/**
	 * Decrypts a form, throwing an exception if it is not possible.
	 * @param form a form
	 * @return the decrypted form
	 * @throws EntityEncryptionException if the form could not be decrypted
	 */
	suspend fun decrypt(form: EncryptedForm): DecryptedForm

	/**
	 * Tries to decrypt a form, returns the input if it is not possible.
	 * @param form an encrypted form
	 * @return the decrypted form if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(form: EncryptedForm): Form

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: FormFlavouredApi<EncryptedForm>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
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

	override suspend fun getLatestFormByLogicalUuid(logicalUuid: String) = rawApi.getFormByLogicalUuid(logicalUuid).successBody().let { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun getFormsByLogicalUuid(logicalUuid: String) = rawApi.getFormsByLogicalUuid(logicalUuid).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun getFormsByUniqueId(uniqueId: String) = rawApi.getFormsByUniqueId(uniqueId).successBody().map { maybeDecrypt(it) }

	override suspend fun getLatestFormByUniqueId(uniqueId: String) = rawApi.getFormByUniqueId(uniqueId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun getChildrenForms(hcPartyId: String, parentId: String) = rawApi.getChildrenForms(parentId, hcPartyId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
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
		options: FormShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			form.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: FormShareOptions()),
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

	@Deprecated("Will be replaced by filter")
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

	@Deprecated("Will be replaced by filter")
	override suspend fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	) = rawApi.getFormTemplatesByGuid(formTemplateGuid, specialityCode, raw).successBody()

	@Deprecated("Will be replaced by filter")
	override suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		raw: Boolean?,
	) = rawApi.listFormTemplatesBySpeciality(specialityCode, raw).successBody()

	@Deprecated("Will be replaced by filter")
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
			decrypt(it)
		}
	}

	override suspend fun createForms(entities: List<DecryptedForm>): List<DecryptedForm> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createForms(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it)
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

	private suspend fun decryptOrNull(entity: EncryptedForm): DecryptedForm? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedForm.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedForm>(it) }

	override suspend fun decrypt(form: EncryptedForm): DecryptedForm =
		decryptOrNull(form) ?: throw EntityEncryptionException("Form cannot be decrypted")

	override suspend fun tryDecrypt(form: EncryptedForm): Form =
		decryptOrNull(form) ?: form

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
