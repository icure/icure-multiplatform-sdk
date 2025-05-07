package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface FormBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteFormUnsafe(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteFormsUnsafe(entityIds: List<String>): List<DocIdentifier>
	
	/**
	 * Deletes a form. If you don't have write access to the form the method will fail.
	 * @param entityId id of the form.
	 * @param rev the latest known rev of the form to delete
	 * @return the id and revision of the deleted form.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteFormById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many forms. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the forms to delete.
	 * @return the id and revision of the deleted forms. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteFormsByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier>

	/**
	 * Permanently deletes a form.
	 * @param id id of the form to purge
	 * @param rev latest revision of the form
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeFormById(id: String, rev: String)

	/**
	 * Deletes a form. If you don't have write access to the form the method will fail.
	 * @param form the form to delete
	 * @return the id and revision of the deleted form.
	 * @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	suspend fun deleteForm(form: Form): DocIdentifier =
		deleteFormById(form.id, requireNotNull(form.rev) { "Can't delete a form that has no rev" })

	/**
	 * Deletes many forms. Ignores form for which you don't have write access or that don't match the latest revision.
	 * @param forms the forms to delete
	 * @return the id and revision of the deleted forms. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteForms(forms: List<Form>): List<DocIdentifier> =
		deleteFormsByIds(forms.map { form ->
			StoredDocumentIdentifier(form.id, requireNotNull(form.rev) { "Can't delete a form that has no rev" })
		})

	/**
	 * Permanently deletes a form.
	 * @param form the form to purge.
	 * @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	suspend fun purgeForm(form: Form) {
		purgeFormById(form.id, requireNotNull(form.rev) { "Can't delete a form that has no rev" })
	}

	suspend fun getFormTemplate(
		formTemplateId: String,
		@DefaultValue("null")
		raw: Boolean? = null
	): FormTemplate

	@Deprecated("Use filter instead")
	suspend fun getFormTemplatesByGuid(formTemplateGuid: String, specialityCode: String, raw: Boolean? = null): List<FormTemplate>

	@Deprecated("Use filter instead")
	suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		@DefaultValue("null")
		raw: Boolean? = null
	): List<FormTemplate>

	@Deprecated("Use filter instead")
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
	 * Create a new form. The provided form must have the encryption metadata initialized.
	 * @param entity a form with initialized encryption metadata
	 * @return the created form with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createForm(entity: E): E

	/**
	 * Create multiple forms. All the provided forms must have the encryption metadata initialized, otherwise
	 * this method fails without doing anything.
	 * @param entities forms with initialized encryption metadata
	 * @return the created forms with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any form in the input was not initialized.
	 */
	suspend fun createForms(entities: List<E>): List<E>

	/**
	 * Modifies a form. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a form with update content
	 * @return the form updated with the provided content and a new revision.
	 */
	suspend fun modifyForm(entity: E): E

	/**
	 * Restores a form that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteFormById(id: String, rev: String): E

	/**
	 * Restores a form that was marked as deleted.
	 * @param form the form to undelete
	 * @return the restored form.
	 * @throws RevisionConflictException if the provided form doesn't match the latest known revision
	 */
	suspend fun undeleteForm(form: Form): E =
		undeleteFormById(form.id, requireNotNull(form.rev) { "Can't delete a form that has no rev" })

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
	suspend fun getForm(entityId: String): E?

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

	@Deprecated("Use filter instead")
	suspend fun getFormsByLogicalUuid(logicalUuid: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun getFormsByUniqueId(uniqueId: String): List<E>

	@Deprecated("Use filter instead") // listFormsByHcPartyAndParentId
	suspend fun getChildrenForms(hcPartyId: String, parentId: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface FormFlavouredApi<E : Form> : FormBasicFlavouredApi<E> {
	/**
	 * Share a form with another data owner. The form must already exist in the database for this method to
	 * succeed. If you want to share the form before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
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
	): E

	/**
	 * Share a form with multiple data owners. The form must already exist in the database for this method to
	 * succeed. If you want to share the form before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
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

	@Deprecated("Use filter instead")
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

	/**
	 * Get an iterator that iterates through all forms matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterFormsBySorted] instead.
	 *
	 * @param filter a form filter
	 * @return an iterator that iterates over all forms matching the provided filter.
	 */
	suspend fun filterFormsBy(
		filter: FilterOptions<Form>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all forms matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterFormsBy].
	 *
	 * @param filter a form filter
	 * @return an iterator that iterates over all forms matching the provided filter.
	 */
	suspend fun filterFormsBySorted(
		filter: SortableFilterOptions<Form>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface FormApi : FormBasicFlavourlessApi, FormFlavouredApi<DecryptedForm> {
	/**
	 * Creates a new form with initialized encryption metadata
	 * @param base a form with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the form.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new form
	 * @return a form with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedForm?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
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
	 * Specifies if the current user has write access to a form through delegations.
	 * Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 * thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 * if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 * side this method will still return true if there is a delegation to the parent.
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

	/**
	 * Get the ids of all forms matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchFormsBySorted] instead.
	 *
	 * @param filter a form filter
	 * @return a list of form ids
	 */
	suspend fun matchFormsBy(filter: FilterOptions<Form>): List<String>

	/**
	 * Get the ids of all forms matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchFormsBy].
	 *
	 * @param filter a form filter
	 * @return a list of form ids
	 */
	suspend fun matchFormsBySorted(filter: SortableFilterOptions<Form>): List<String>
}

interface FormBasicApi : FormBasicFlavourlessApi, FormBasicFlavouredApi<EncryptedForm> {
	/**
	 * Get the ids of all forms matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchFormsBySorted] instead.
	 *
	 * @param filter a form filter
	 * @return a list of form ids
	 */
	suspend fun matchFormsBy(filter: BaseFilterOptions<Form>): List<String>

	/**
	 * Get the ids of all forms matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchFormsBy].
	 *
	 * @param filter a form filter
	 * @return a list of form ids
	 */
	suspend fun matchFormsBySorted(filter: BaseSortableFilterOptions<Form>): List<String>

	/**
	 * Get an iterator that iterates through all forms matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterFormsBySorted] instead.
	 *
	 * @param filter a form filter
	 * @return an iterator that iterates over all forms matching the provided filter.
	 */
	suspend fun filterFormsBy(
		filter: BaseFilterOptions<Form>
	): PaginatedListIterator<EncryptedForm>

	/**
	 * Get an iterator that iterates through all forms matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterFormsBy].
	 *
	 * @param filter a form filter
	 * @return an iterator that iterates over all forms matching the provided filter.
	 */
	suspend fun filterFormsBySorted(
		filter: BaseSortableFilterOptions<Form>
	): PaginatedListIterator<EncryptedForm>
}
