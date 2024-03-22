package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.ClassificationTemplate
import com.icure.sdk.model.EncryptedClassificationTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.delete
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawClassificationTemplateApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun createClassificationTemplate(c: ClassificationTemplate):
			HttpResponse<EncryptedClassificationTemplate> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun getClassificationTemplate(classificationTemplateId: String):
			HttpResponse<EncryptedClassificationTemplate> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate",classificationTemplateId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getClassificationTemplateByIds(ids: String):
			HttpResponse<List<EncryptedClassificationTemplate>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate","byIds",ids)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listClassificationTemplatesByHCPartyPatientForeignKeys(hcPartyId: String,
			secretFKeys: String): HttpResponse<List<EncryptedClassificationTemplate>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findClassificationTemplatesByHCPartyPatientForeignKey(
		hcPartyId: String,
		secretFKey: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedClassificationTemplate, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate","byHcPartySecretForeignKey")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKey", secretFKey)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun deleteClassificationTemplates(classificationTemplateIds: ListOfIds):
			HttpResponse<List<DocIdentifier>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(classificationTemplateIds)
		}.wrap()


	suspend fun deleteClassificationTemplate(classificationTemplateId: String):
			HttpResponse<DocIdentifier> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate",classificationTemplateId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyClassificationTemplate(classificationTemplateDto: ClassificationTemplate):
			HttpResponse<EncryptedClassificationTemplate> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(classificationTemplateDto)
		}.wrap()


	suspend fun findClassificationTemplatesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedClassificationTemplate, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedClassificationTemplate>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","classificationTemplate","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}
