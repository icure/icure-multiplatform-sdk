package com.icure.sdk.api.raw

import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawDocumentTemplateApi {
	// region common endpoints

	suspend fun getDocumentTemplate(documentTemplateId: String): HttpResponse<DocumentTemplate>

	suspend fun deleteDocumentTemplates(documentTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun findDocumentTemplatesBySpeciality(
		specialityCode: String,
		loadLayout: Boolean? =
			null,
	): HttpResponse<List<DocumentTemplate>>

	suspend fun listDocumentTemplatesByDocumentType(
		documentTypeCode: String,
		loadLayout: Boolean? = null,
	): HttpResponse<List<DocumentTemplate>>

	suspend fun listDocumentTemplatesByDocumentTypeForCurrentUser(
		documentTypeCode: String,
		loadLayout: Boolean? = null,
	): HttpResponse<List<DocumentTemplate>>

	suspend fun listDocumentTemplates(loadLayout: Boolean? = null): HttpResponse<List<DocumentTemplate>>

	suspend fun findAllDocumentTemplates(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<DocumentTemplate>>

	suspend fun createDocumentTemplate(ft: DocumentTemplate): HttpResponse<DocumentTemplate>

	suspend fun modifyDocumentTemplate(
		documentTemplateId: String,
		ft: DocumentTemplate,
	): HttpResponse<DocumentTemplate>

	suspend fun getDocumentTemplateAttachment(
		documentTemplateId: String,
		attachmentId: String,
	): HttpResponse<ByteArray>

	suspend fun getAttachmentText(
		documentTemplateId: String,
		attachmentId: String,
	): HttpResponse<ByteArray>

	suspend fun setDocumentTemplateAttachment(
		documentTemplateId: String,
		payload: ByteArray,
	): HttpResponse<DocumentTemplate>
	// endregion
}
