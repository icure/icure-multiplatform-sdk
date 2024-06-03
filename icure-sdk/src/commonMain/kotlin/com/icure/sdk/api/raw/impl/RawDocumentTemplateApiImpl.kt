package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawDocumentTemplateApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import kotlinx.serialization.json.Json
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDocumentTemplateApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawDocumentTemplateApi {
	// region common endpoints

	override suspend fun getDocumentTemplate(documentTemplateId: String): HttpResponse<DocumentTemplate> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", documentTemplateId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteDocumentTemplates(documentTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentTemplateIds)
		}.wrap()

	override suspend fun findDocumentTemplatesBySpeciality(
		specialityCode: String,
		loadAttachment: Boolean?,
	): HttpResponse<List<DocumentTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", "bySpecialty", specialityCode)
				parameter("loadAttachment", loadAttachment)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun listDocumentTemplatesByDocumentType(
		documentTypeCode: String,
		loadAttachment: Boolean?,
	): HttpResponse<List<DocumentTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", "byDocumentType", documentTypeCode)
				parameter("loadAttachment", loadAttachment)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun listDocumentTemplatesByDocumentTypeForCurrentUser(
		documentTypeCode: String,
		loadAttachment: Boolean?,
	): HttpResponse<List<DocumentTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", "byDocumentTypeForCurrentUser", documentTypeCode)
				parameter("loadAttachment", loadAttachment)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun listDocumentTemplates(loadAttachment: Boolean?): HttpResponse<List<DocumentTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate")
				parameter("loadAttachment", loadAttachment)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun findAllDocumentTemplates(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<DocumentTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", "find", "all")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createDocumentTemplate(ft: DocumentTemplate): HttpResponse<DocumentTemplate> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun modifyDocumentTemplate(
		documentTemplateId: String,
		ft: DocumentTemplate,
	): HttpResponse<DocumentTemplate> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", documentTemplateId)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun getDocumentTemplateAttachment(
		documentTemplateId: String,
		attachmentId: String,
	): HttpResponse<ByteArray> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", documentTemplateId, "attachment", attachmentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.OctetStream)
		}.wrap()

	override suspend fun getAttachmentText(
		documentTemplateId: String,
		attachmentId: String,
	): HttpResponse<ByteArray> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", documentTemplateId, "attachmentText", attachmentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.OctetStream)
		}.wrap()

	override suspend fun setDocumentTemplateAttachment(
		documentTemplateId: String,
		payload: ByteArray,
	): HttpResponse<DocumentTemplate> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "doctemplate", documentTemplateId, "attachment")
			}
			setAuthorizationWith(authService)
			contentType(Application.OctetStream)
			accept(Application.Json)
			setBody(ByteReadChannel(payload))
		}.wrap()

	// endregion
}
