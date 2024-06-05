// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.DocumentTemplateApi
import com.icure.sdk.js.api.DocumentTemplateApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DocumentTemplateJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.documentTemplate_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.ByteArray
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DocumentTemplateApiImplJs(
	private val documentTemplateApi: DocumentTemplateApi,
) : DocumentTemplateApiJs {
	override fun getDocumentTemplate(documentTemplateId: String): Promise<DocumentTemplateJs> =
			GlobalScope.promise {
		documentTemplate_toJs(documentTemplateApi.getDocumentTemplate(documentTemplateId))}


	override fun createDocumentTemplate(documentTemplate: DocumentTemplateJs):
			Promise<DocumentTemplateJs> = GlobalScope.promise {
		documentTemplate_toJs(documentTemplateApi.createDocumentTemplate(com.icure.sdk.js.model.documentTemplate_fromJs(documentTemplate)))}


	override fun modifyDocumentTemplate(documentTemplate: DocumentTemplateJs):
			Promise<DocumentTemplateJs> = GlobalScope.promise {
		documentTemplate_toJs(documentTemplateApi.modifyDocumentTemplate(com.icure.sdk.js.model.documentTemplate_fromJs(documentTemplate)))}


	override fun deleteDocumentTemplates(documentTemplateIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		listToArray(
			documentTemplateApi.deleteDocumentTemplates(arrayToList(
				documentTemplateIds,
				"documentTemplateIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun listDocumentTemplatesBySpeciality(specialityCode: String):
			Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		listToArray(
			documentTemplateApi.listDocumentTemplatesBySpeciality(specialityCode),
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)}


	override fun listDocumentTemplatesByDocumentType(documentTypeCode: String):
			Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		listToArray(
			documentTemplateApi.listDocumentTemplatesByDocumentType(documentTypeCode),
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)}


	override fun listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: String):
			Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		listToArray(
			documentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode),
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)}


	override fun listDocumentTemplates(): Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		listToArray(
			documentTemplateApi.listDocumentTemplates(),
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)}


	override fun findAllDocumentTemplates(
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DocumentTemplateJs>> = GlobalScope.promise {
		paginatedList_toJs(
			documentTemplateApi.findAllDocumentTemplates(startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)}


	override fun getDocumentTemplateAttachment(documentTemplateId: String, attachmentId: String):
			Promise<ByteArray> = GlobalScope.promise {
		documentTemplateApi.getDocumentTemplateAttachment(documentTemplateId, attachmentId)}


	override fun getAttachmentText(documentTemplateId: String, attachmentId: String):
			Promise<ByteArray> = GlobalScope.promise {
		documentTemplateApi.getAttachmentText(documentTemplateId, attachmentId)}


	override fun setDocumentTemplateAttachment(documentTemplateId: String, payload: ByteArray):
			Promise<DocumentTemplateJs> = GlobalScope.promise {
		documentTemplate_toJs(documentTemplateApi.setDocumentTemplateAttachment(documentTemplateId,
				payload))}


	override fun getAttachmentUrl(documentId: String, attachmentId: String): String =
			documentTemplateApi.getAttachmentUrl(documentId, attachmentId)
}
