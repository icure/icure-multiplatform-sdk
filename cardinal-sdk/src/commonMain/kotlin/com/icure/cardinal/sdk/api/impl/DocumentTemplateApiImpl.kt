package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DocumentTemplateApi
import com.icure.cardinal.sdk.api.raw.RawDocumentTemplateApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.DocumentTemplate
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class DocumentTemplateApiImpl(
	private val apiUrl: String,
	private val rawApi: RawDocumentTemplateApi,
) : DocumentTemplateApi {
	override suspend fun getDocumentTemplate(documentTemplateId: String) = rawApi.getDocumentTemplate(documentTemplateId).successBody()

	override suspend fun createDocumentTemplate(documentTemplate: DocumentTemplate) =
		rawApi.createDocumentTemplate(documentTemplate).successBody()

	override suspend fun modifyDocumentTemplate(documentTemplate: DocumentTemplate) =
		rawApi.modifyDocumentTemplate(documentTemplate.id, documentTemplate).successBodyOrThrowRevisionConflict()

	override suspend fun deleteDocumentTemplates(documentTemplateIds: List<String>) = rawApi.deleteDocumentTemplates(
		ListOfIds(documentTemplateIds)
	).successBody()
	override suspend fun listDocumentTemplatesBySpeciality(specialityCode: String) = rawApi.findDocumentTemplatesBySpeciality(specialityCode).successBody()
	override suspend fun listDocumentTemplatesByDocumentType(documentTypeCode: String) = rawApi.listDocumentTemplatesByDocumentType(documentTypeCode).successBody()
	override suspend fun listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: String) = rawApi.listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode).successBody()
	override suspend fun listDocumentTemplates() = rawApi.listDocumentTemplates().successBody()
	override suspend fun findAllDocumentTemplates(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findAllDocumentTemplates(startKey, startDocumentId, limit).successBody()
	override suspend fun getDocumentTemplateAttachment(
		documentTemplateId: String,
		attachmentId: String,
	) = rawApi.getDocumentTemplateAttachment(documentTemplateId, attachmentId).successBody()
	override suspend fun getAttachmentText(
		documentTemplateId: String,
		attachmentId: String,
	) = rawApi.getAttachmentText(documentTemplateId, attachmentId).successBody()
	override suspend fun setDocumentTemplateAttachment(
		documentTemplateId: String,
		payload: ByteArray,
	) = rawApi.setDocumentTemplateAttachment(documentTemplateId, payload).successBody()

	override fun getAttachmentUrl(documentId: String, attachmentId: String): String =
		"$apiUrl/rest/v2/doctemplate/$documentId/attachment/$attachmentId"
}