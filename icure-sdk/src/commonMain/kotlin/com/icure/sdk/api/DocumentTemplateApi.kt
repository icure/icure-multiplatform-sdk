package com.icure.sdk.api

import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue

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

