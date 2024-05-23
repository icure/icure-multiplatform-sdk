// auto-generated file
package com.icure.sdk.js.api

import com.icure.sdk.js.model.DocumentTemplateJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("DocumentTemplateApi")
public external interface DocumentTemplateApiJs {
	public fun getDocumentTemplate(documentTemplateId: String): Promise<DocumentTemplateJs>

	public fun createDocumentTemplate(documentTemplate: DocumentTemplateJs):
			Promise<DocumentTemplateJs>

	public fun modifyDocumentTemplate(documentTemplate: DocumentTemplateJs):
			Promise<DocumentTemplateJs>

	public fun deleteDocumentTemplates(documentTemplateIds: Array<String>):
			Promise<Array<DocIdentifierJs>>

	public fun listDocumentTemplatesBySpeciality(specialityCode: String):
			Promise<Array<DocumentTemplateJs>>

	public fun listDocumentTemplatesByDocumentType(documentTypeCode: String):
			Promise<Array<DocumentTemplateJs>>

	public fun listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: String):
			Promise<Array<DocumentTemplateJs>>

	public fun listDocumentTemplates(): Promise<Array<DocumentTemplateJs>>

	public fun findAllDocumentTemplates(
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DocumentTemplateJs>>

	public fun getDocumentTemplateAttachment(documentTemplateId: String, attachmentId: String):
			Promise<ByteArray>

	public fun getAttachmentText(documentTemplateId: String, attachmentId: String): Promise<ByteArray>

	public fun setDocumentTemplateAttachment(documentTemplateId: String, payload: ByteArray):
			Promise<DocumentTemplateJs>
}
