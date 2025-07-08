package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.FormApi
import com.icure.cardinal.sdk.api.FormBasicApi
import com.icure.cardinal.sdk.api.FormBasicFlavouredApi
import com.icure.cardinal.sdk.api.FormBasicFlavourlessApi
import com.icure.cardinal.sdk.api.FormFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawFormApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapFormFilterOptions
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractFormBasicFlavouredApi<E : Form>(protected val rawApi: RawFormApi) :
	FormBasicFlavouredApi<E>, FlavouredApi<EncryptedForm, E> {
	override suspend fun createForm(entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createForm(
			validateAndMaybeEncrypt(null, entity),
		).successBody().let {
			maybeDecrypt(null, it)
		}
	}

	override suspend fun createForms(entities: List<E>): List<E> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createForms(
			validateAndMaybeEncrypt(null, entities),
		).successBody().let {
			maybeDecrypt(null, it)
		}
	}

	override suspend fun undeleteFormById(id: String, rev: String): E =
		rawApi.undeleteForm(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyForm(entity: E): E =
		rawApi.modifyForm(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyForms(entities: List<E>): List<E> =
		rawApi.modifyForms(entities.let { validateAndMaybeEncrypt(it) }).successBody().let { maybeDecrypt(it) }

	override suspend fun getForm(entityId: String): E = rawApi.getForm(entityId).successBody().let { maybeDecrypt(null, it) }
	override suspend fun getForms(entityIds: List<String>): List<E> =
		rawApi.getForms(ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }

	override suspend fun getLatestFormByLogicalUuid(logicalUuid: String) = rawApi.getFormByLogicalUuid(logicalUuid).successBody().let { maybeDecrypt(null, it) }

	@Deprecated("Use filter instead")
	override suspend fun getFormsByLogicalUuid(logicalUuid: String) = rawApi.getFormsByLogicalUuid(logicalUuid).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getFormsByUniqueId(uniqueId: String) = rawApi.getFormsByUniqueId(uniqueId).successBody().let { maybeDecrypt(it) }

	override suspend fun getLatestFormByUniqueId(uniqueId: String) = rawApi.getFormByUniqueId(uniqueId).successBody().let { maybeDecrypt(null, it) }

	@Deprecated("Use filter instead")
	override suspend fun getChildrenForms(hcPartyId: String, parentId: String) = rawApi.getChildrenForms(parentId, hcPartyId).successBody().let { maybeDecrypt(it) }
}

@InternalIcureApi
private abstract class AbstractFormFlavouredApi<E : Form>(
	rawApi: RawFormApi,
	protected val config: ApiConfiguration,
) : AbstractFormBasicFlavouredApi<E>(rawApi), FormFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		form: E,
		options: FormShareOptions?,
	): E =
		shareWithMany(form, mapOf(delegateId to (options ?: FormShareOptions())))

	override suspend fun shareWithMany(form: E, delegates: Map<String, FormShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			form,
			EntityWithEncryptionMetadataTypeName.Form,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getForm(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
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
			secretPatientKeys = ListOfIds(config.crypto.entity.secretIdsOf(null, patient, EntityWithEncryptionMetadataTypeName.Patient, null).toList())
		).successBody()
	) { ids ->
		rawApi.getForms(ListOfIds(ids)).successBody().let { maybeDecrypt(it) }
	}

	override suspend fun filterFormsBySorted(filter: SortableFilterOptions<Form>): PaginatedListIterator<E> =
		filterFormsBy(filter)

	override suspend fun filterFormsBy(filter: FilterOptions<Form>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchFormsBy(
				mapFormFilterOptions(
					filter,
					config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
					config.crypto.entity
				)
			).successBody(),
			::getForms
		)
}

@InternalIcureApi
private class AbstractFormBasicFlavourlessApi(val rawApi: RawFormApi) : FormBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteFormUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteForm(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteFormsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteForms(ListOfIds(entityIds)).successBody()

	override suspend fun deleteFormById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteForm(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteFormsByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier> =
		rawApi.deleteFormsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeFormById(id: String, rev: String) {
		rawApi.purgeForm(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun getFormTemplate(
		formTemplateId: String,
		raw: Boolean?,
	) = rawApi.getFormTemplate(formTemplateId, raw).successBody()

	@Deprecated("Use filter instead")
	override suspend fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	) = rawApi.getFormTemplatesByGuid(formTemplateGuid, specialityCode, raw).successBody()

	@Deprecated("Use filter instead")
	override suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		raw: Boolean?,
	) = rawApi.listFormTemplatesBySpeciality(specialityCode, raw).successBody()

	@Deprecated("Use filter instead")
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
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedForm>
	): List<EncryptedForm> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Form,
			DecryptedForm.serializer(),
			this.config.encryption.form,
		) { Serialization.json.decodeFromJsonElement<EncryptedForm>(it) }

	override suspend fun maybeDecrypt(entitiesGroupId: String?, entities: List<EncryptedForm>): List<DecryptedForm> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Form,
			EncryptedForm.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }
}, FormBasicFlavourlessApi by AbstractFormBasicFlavourlessApi(rawApi) {
	override val encrypted: FormFlavouredApi<EncryptedForm> =
		object : AbstractFormFlavouredApi<EncryptedForm>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedForm>
			): List<EncryptedForm> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.Form,
					EncryptedForm.serializer(),
					config.encryption.form
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedForm>
			): List<EncryptedForm> = entities
		}

	override val tryAndRecover: FormFlavouredApi<Form> =
		object : AbstractFormFlavouredApi<Form>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Form>
			): List<EncryptedForm> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId = entitiesGroupId,
					entities = entities,
					entitiesType = EntityWithEncryptionMetadataTypeName.Form,
					encryptedSerializer = EncryptedForm.serializer(),
					decryptedSerializer = DecryptedForm.serializer(),
					fieldsToEncrypt = config.encryption.form
				)

			override suspend fun maybeDecrypt(entitiesGroupId: String?, entities: List<EncryptedForm>): List<Form> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Form,
					EncryptedForm.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }
		}

	override suspend fun withEncryptionMetadata(
		base: DecryptedForm?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?,
	): DecryptedForm =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
            null,
            (base ?: DecryptedForm(config.crypto.primitives.strongRandom.randomUUID())).copy(
                created = base?.created ?: currentEpochMs(),
                modified = base?.modified ?: currentEpochMs(),
                responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
                author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
            ),
            EntityWithEncryptionMetadataTypeName.Form,
            OwningEntityDetails(
                null,
                patient.id,
                config.crypto.entity.resolveSecretIdOption(
                    null,
                    patient,
                    EntityWithEncryptionMetadataTypeName.Patient,
                    secretId
                ),
            ),
            initializeEncryptionKey = true,
            autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
                .orEmpty()).keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
		).updatedEntity

	override suspend fun getEncryptionKeysOf(form: Form): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(null, form, EntityWithEncryptionMetadataTypeName.Form, null)

	override suspend fun hasWriteAccess(form: Form): Boolean =
		config.crypto.entity.hasWriteAccess(null, form, EntityWithEncryptionMetadataTypeName.Form)

	override suspend fun decryptPatientIdOf(form: Form): Set<String> =
		config.crypto.entity.owningEntityIdsOf(null, form, EntityWithEncryptionMetadataTypeName.Form, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Form, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.Form,
			delegates.asLocalDataOwnerReferences()
		)
	}

	override suspend fun decrypt(form: EncryptedForm): DecryptedForm =
		config.crypto.entity.decryptEntities(
			null,
			listOf(form),
			EntityWithEncryptionMetadataTypeName.Form,
			EncryptedForm.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }.single()

	override suspend fun tryDecrypt(form: EncryptedForm): Form =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(form),
			EntityWithEncryptionMetadataTypeName.Form,
			EncryptedForm.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }.single()

	override suspend fun matchFormsBy(filter: FilterOptions<Form>): List<String> =
		rawApi.matchFormsBy(
			mapFormFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)
		).successBody()

	override suspend fun matchFormsBySorted(filter: SortableFilterOptions<Form>): List<String> =
		matchFormsBy(filter)
}

@InternalIcureApi
internal class FormBasicApiImpl(
	private val rawApi: RawFormApi,
	private val config: BasicApiConfiguration
) : FormBasicApi, FormBasicFlavouredApi<EncryptedForm> by object : AbstractFormBasicFlavouredApi<EncryptedForm>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedForm>
	): List<EncryptedForm> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.Form, EncryptedForm.serializer(), config.encryption.form)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedForm>
	): List<EncryptedForm> = entities
}, FormBasicFlavourlessApi by AbstractFormBasicFlavourlessApi(rawApi) {
	override suspend fun matchFormsBy(filter: BaseFilterOptions<Form>): List<String> =
		rawApi.matchFormsBy(
			mapFormFilterOptions(
				filter,
				null,
				null
			)
		).successBody()

	override suspend fun matchFormsBySorted(filter: BaseSortableFilterOptions<Form>): List<String> =
		matchFormsBy(filter)

	override suspend fun filterFormsBy(filter: BaseFilterOptions<Form>): PaginatedListIterator<EncryptedForm> =
		IdsPageIterator(matchFormsBy(filter), ::getForms)

	override suspend fun filterFormsBySorted(filter: BaseSortableFilterOptions<Form>): PaginatedListIterator<EncryptedForm> =
		filterFormsBySorted(filter)
}
