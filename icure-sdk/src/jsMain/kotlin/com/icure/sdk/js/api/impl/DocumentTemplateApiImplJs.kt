// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.DocumentTemplateApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.DocumentTemplateApiJs
import com.icure.sdk.js.api.DocumentTemplateApi_findAllDocumentTemplates_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.DocumentTemplateJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.documentTemplate_fromJs
import com.icure.sdk.js.model.documentTemplate_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.ByteArray
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
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
		val documentTemplateIdConverted: String = documentTemplateId
		val result = documentTemplateApi.getDocumentTemplate(
			documentTemplateIdConverted,
		)
		documentTemplate_toJs(result)
	}

	override fun createDocumentTemplate(documentTemplate: DocumentTemplateJs):
			Promise<DocumentTemplateJs> = GlobalScope.promise {
		val documentTemplateConverted: DocumentTemplate = documentTemplate_fromJs(documentTemplate)
		val result = documentTemplateApi.createDocumentTemplate(
			documentTemplateConverted,
		)
		documentTemplate_toJs(result)
	}

	override fun modifyDocumentTemplate(documentTemplate: DocumentTemplateJs):
			Promise<DocumentTemplateJs> = GlobalScope.promise {
		val documentTemplateConverted: DocumentTemplate = documentTemplate_fromJs(documentTemplate)
		val result = documentTemplateApi.modifyDocumentTemplate(
			documentTemplateConverted,
		)
		documentTemplate_toJs(result)
	}

	override fun deleteDocumentTemplates(documentTemplateIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val documentTemplateIdsConverted: List<String> = arrayToList(
			documentTemplateIds,
			"documentTemplateIds",
			{ x1: String ->
				x1
			},
		)
		val result = documentTemplateApi.deleteDocumentTemplates(
			documentTemplateIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun listDocumentTemplatesBySpeciality(specialityCode: String):
			Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		val specialityCodeConverted: String = specialityCode
		val result = documentTemplateApi.listDocumentTemplatesBySpeciality(
			specialityCodeConverted,
		)
		listToArray(
			result,
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)
	}

	override fun listDocumentTemplatesByDocumentType(documentTypeCode: String):
			Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		val documentTypeCodeConverted: String = documentTypeCode
		val result = documentTemplateApi.listDocumentTemplatesByDocumentType(
			documentTypeCodeConverted,
		)
		listToArray(
			result,
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)
	}

	override fun listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: String):
			Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		val documentTypeCodeConverted: String = documentTypeCode
		val result = documentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUser(
			documentTypeCodeConverted,
		)
		listToArray(
			result,
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)
	}

	override fun listDocumentTemplates(): Promise<Array<DocumentTemplateJs>> = GlobalScope.promise {
		val result = documentTemplateApi.listDocumentTemplates(
		)
		listToArray(
			result,
			{ x1: DocumentTemplate ->
				documentTemplate_toJs(x1)
			},
		)
	}

	override
			fun findAllDocumentTemplates(options: DocumentTemplateApi_findAllDocumentTemplates_Options?):
			Promise<PaginatedListJs<DocumentTemplateJs>> {
		val _options: DocumentTemplateApi_findAllDocumentTemplates_Options = options ?: js("{}")
		return GlobalScope.promise {
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = documentTemplateApi.findAllDocumentTemplates(
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DocumentTemplate ->
					documentTemplate_toJs(x1)
				},
			)
		}
	}

	override fun getDocumentTemplateAttachment(documentTemplateId: String, attachmentId: String):
			Promise<ByteArray> = GlobalScope.promise {
		val documentTemplateIdConverted: String = documentTemplateId
		val attachmentIdConverted: String = attachmentId
		val result = documentTemplateApi.getDocumentTemplateAttachment(
			documentTemplateIdConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun getAttachmentText(documentTemplateId: String, attachmentId: String):
			Promise<ByteArray> = GlobalScope.promise {
		val documentTemplateIdConverted: String = documentTemplateId
		val attachmentIdConverted: String = attachmentId
		val result = documentTemplateApi.getAttachmentText(
			documentTemplateIdConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun setDocumentTemplateAttachment(documentTemplateId: String, payload: ByteArray):
			Promise<DocumentTemplateJs> = GlobalScope.promise {
		val documentTemplateIdConverted: String = documentTemplateId
		val payloadConverted: ByteArray = payload
		val result = documentTemplateApi.setDocumentTemplateAttachment(
			documentTemplateIdConverted,
			payloadConverted,
		)
		documentTemplate_toJs(result)
	}

	override fun getAttachmentUrl(documentId: String, attachmentId: String): String {
		val documentIdConverted: String = documentId
		val attachmentIdConverted: String = attachmentId
		val result = documentTemplateApi.getAttachmentUrl(
			documentIdConverted,
			attachmentIdConverted,
		)
		return result
	}
}
