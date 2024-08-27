package com.icure.sdk.api.impl

import com.icure.sdk.api.FormApi
import com.icure.sdk.api.FormBasicApi
import com.icure.sdk.api.FormBasicFlavouredApi
import com.icure.sdk.api.FormBasicFlavourlessApi
import com.icure.sdk.api.FormFlavouredApi
import com.icure.sdk.api.raw.RawFormApi
import com.icure.sdk.crypto.entities.FormShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.filters.mapFormFilterOptions
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.Form
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

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

	@Deprecated("Use filter instead")
	override suspend fun getFormsByLogicalUuid(logicalUuid: String) = rawApi.getFormsByLogicalUuid(logicalUuid).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getFormsByUniqueId(uniqueId: String) = rawApi.getFormsByUniqueId(uniqueId).successBody().map { maybeDecrypt(it) }

	override suspend fun getLatestFormByUniqueId(uniqueId: String) = rawApi.getFormByUniqueId(uniqueId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getChildrenForms(hcPartyId: String, parentId: String) = rawApi.getChildrenForms(parentId, hcPartyId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
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
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getForms(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
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
	override suspend fun deleteForm(entityId: String) = rawApi.deleteForm(entityId).successBody()
	override suspend fun deleteForms(entityIds: List<String>) = rawApi.deleteForms(ListOfIds(entityIds)).successBody()
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
		) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }
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
				) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createForm(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun createForms(entities: List<DecryptedForm>): List<DecryptedForm> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
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
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedForm(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initializeEncryptionKey = true,
			initializeSecretId = false,
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
	) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }

	override suspend fun decrypt(form: EncryptedForm): DecryptedForm =
		decryptOrNull(form) ?: throw EntityEncryptionException("Form cannot be decrypted")

	override suspend fun tryDecrypt(form: EncryptedForm): Form =
		decryptOrNull(form) ?: form

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
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedForm): EncryptedForm =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedForm.serializer(), config.encryption.form)

	override suspend fun maybeDecrypt(entity: EncryptedForm): EncryptedForm = entity
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