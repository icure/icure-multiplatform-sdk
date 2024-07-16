package com.icure.sdk.api

import com.icure.sdk.api.raw.RawDocumentTemplateApi
import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi

interface DocumentTemplateApi {
	suspend fun getDocumentTemplate(documentTemplateId: String): DocumentTemplate
	suspend fun createDocumentTemplate(documentTemplate: DocumentTemplate): DocumentTemplate
	suspend fun modifyDocumentTemplate(documentTemplate: DocumentTemplate): DocumentTemplate
	suspend fun deleteDocumentTemplates(documentTemplateIds: List<String>): List<DocIdentifier>
	suspend fun listDocumentTemplatesBySpeciality(specialityCode: String): List<DocumentTemplate>
	suspend fun listDocumentTemplatesByDocumentType(documentTypeCode: String): List<DocumentTemplate>
	suspend fun listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: String): List<DocumentTemplate>
	suspend fun listDocumentTemplates(): List<DocumentTemplate>
	suspend fun findAllDocumentTemplates(
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<DocumentTemplate>

	suspend fun getDocumentTemplateAttachment(documentTemplateId: String, attachmentId: String): ByteArray
	suspend fun getAttachmentText(documentTemplateId: String, attachmentId: String): ByteArray
	suspend fun setDocumentTemplateAttachment(documentTemplateId: String, payload: ByteArray): DocumentTemplate
	fun getAttachmentUrl(documentId: String, attachmentId: String): String
}

@InternalIcureApi
internal class DocumentTemplateApiImpl(
	private val apiUrl: String,
	private val rawApi: RawDocumentTemplateApi,
) : DocumentTemplateApi {
	override suspend fun getDocumentTemplate(documentTemplateId: String) = rawApi.getDocumentTemplate(documentTemplateId).successBody()

	override suspend fun createDocumentTemplate(documentTemplate: DocumentTemplate) =
		rawApi.createDocumentTemplate(documentTemplate).successBody()

	override suspend fun modifyDocumentTemplate(documentTemplate: DocumentTemplate) =
		rawApi.modifyDocumentTemplate(documentTemplate.id, documentTemplate).successBody()

	override suspend fun deleteDocumentTemplates(documentTemplateIds: List<String>) = rawApi.deleteDocumentTemplates(
		ListOfIds(documentTemplateIds)).successBody()
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

