package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.model.FormTemplate as ModelFormTemplate
import org.taktik.icure.entities.FormTemplate as EntitiesFormTemplate

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawFormApi {
	// region common endpoints

	suspend fun getForm(formId: String): HttpResponse<EncryptedForm>

	suspend fun getForms(formIds: ListOfIds): HttpResponse<List<EncryptedForm>>

	suspend fun getFormByLogicalUuid(logicalUuid: String): HttpResponse<EncryptedForm>

	suspend fun getFormsByLogicalUuid(logicalUuid: String): HttpResponse<List<EncryptedForm>>

	suspend fun getFormsByUniqueId(uniqueId: String): HttpResponse<List<EncryptedForm>>

	suspend fun getFormByUniqueId(uniqueId: String): HttpResponse<EncryptedForm>

	suspend fun getChildrenForms(
		formId: String,
		hcPartyId: String,
	): HttpResponse<List<EncryptedForm>>

	suspend fun createForm(ft: EncryptedForm): HttpResponse<EncryptedForm>

	suspend fun modifyForm(formDto: EncryptedForm): HttpResponse<EncryptedForm>

	suspend fun deleteForms(formIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteFormsWithRev(formIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteForm(
		formId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteForm(
		formId: String,
		rev: String,
	): HttpResponse<EncryptedForm>

	suspend fun purgeForm(
		formId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun modifyForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>>

	suspend fun createForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>>

	suspend fun listFormIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun findFormsDelegationsStubsByIds(formIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun getFormTemplate(
		formTemplateId: String,
		raw: Boolean? = null,
	): HttpResponse<ModelFormTemplate>

	suspend fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean? = null,
	): HttpResponse<List<ModelFormTemplate>>

	suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		loadLayout: Boolean? = null,
		raw: Boolean? = null,
	): HttpResponse<List<ModelFormTemplate>>

	suspend fun getFormTemplates(
		loadLayout: Boolean? = null,
		raw: Boolean? = null,
	): HttpResponse<List<ModelFormTemplate>>

	suspend fun createFormTemplate(ft: ModelFormTemplate): HttpResponse<ModelFormTemplate>

	suspend fun deleteFormTemplate(formTemplateId: String): HttpResponse<EntitiesFormTemplate>

	suspend fun updateFormTemplate(
		formTemplateId: String,
		ft: ModelFormTemplate,
	): HttpResponse<ModelFormTemplate>

	suspend fun setTemplateAttachment(
		formTemplateId: String,
		payload: ByteArray,
	): HttpResponse<String>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedForm>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun matchFormsBy(filter: AbstractFilter<Form>): HttpResponse<List<String>>
	// endregion
}
