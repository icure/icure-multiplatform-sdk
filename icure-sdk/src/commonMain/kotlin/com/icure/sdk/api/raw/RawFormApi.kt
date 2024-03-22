package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.EncryptedIcureStub
import com.icure.sdk.model.Form
import com.icure.sdk.model.FormTemplate
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
import io.ktor.utils.io.ByteReadChannel
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
class RawFormApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getForm(formId: String): HttpResponse<EncryptedForm> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form",formId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getForms(formIds: ListOfIds): HttpResponse<List<EncryptedForm>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formIds)
		}.wrap()


	suspend fun getFormByLogicalUuid(logicalUuid: String): HttpResponse<EncryptedForm> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","logicalUuid",logicalUuid)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getFormsByLogicalUuid(logicalUuid: String): HttpResponse<List<EncryptedForm>> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","all","logicalUuid",logicalUuid)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getFormsByUniqueId(uniqueId: String): HttpResponse<List<EncryptedForm>> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","all","uniqueId",uniqueId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getFormByUniqueId(uniqueId: String): HttpResponse<EncryptedForm> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","uniqueId",uniqueId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getChildrenForms(formId: String, hcPartyId: String):
			HttpResponse<List<EncryptedForm>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","childrenOf",formId,hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createForm(ft: Form): HttpResponse<EncryptedForm> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ft)
		}.wrap()


	suspend fun modifyForm(formDto: Form): HttpResponse<EncryptedForm> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formDto)
		}.wrap()


	suspend fun deleteForms(formIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formIds)
		}.wrap()


	suspend fun deleteForm(formId: String): HttpResponse<DocIdentifier> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form",formId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyForms(formDtos: List<Form>): HttpResponse<List<EncryptedForm>> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formDtos)
		}.wrap()


	suspend fun createForms(formDtos: List<Form>): HttpResponse<List<EncryptedForm>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formDtos)
		}.wrap()


	suspend fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		healthElementId: String? = null,
		planOfActionId: String? = null,
		formTemplateId: String? = null,
	): HttpResponse<List<EncryptedForm>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("healthElementId", healthElementId)
				parameter("planOfActionId", planOfActionId)
				parameter("formTemplateId", formTemplateId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findFormsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		healthElementId: String? = null,
		planOfActionId: String? = null,
		formTemplateId: String? = null,
	): HttpResponse<List<EncryptedForm>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("healthElementId", healthElementId)
				parameter("planOfActionId", planOfActionId)
				parameter("formTemplateId", formTemplateId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	suspend fun findFormsByHCPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedForm, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","byHcPartySecretForeignKey")
				parameter("hcPartyId", hcPartyId)
				parameter("secretPatientKey", secretPatientKey)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listFormsDelegationsStubsByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretFKeys: String): HttpResponse<List<EncryptedIcureStub>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","byHcPartySecretForeignKeys","delegations")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listFormsDelegationsStubsByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: List<String>): HttpResponse<List<EncryptedIcureStub>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","byHcPartySecretForeignKeys","delegations")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	suspend fun getFormTemplate(formTemplateId: String, raw: Boolean? = null):
			HttpResponse<FormTemplate> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template",formTemplateId)
				parameter("raw", raw)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean? = null,
	): HttpResponse<List<FormTemplate>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template",specialityCode,"guid",formTemplateGuid)
				parameter("raw", raw)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		loadLayout: Boolean? = null,
		raw: Boolean? = null,
	): HttpResponse<List<FormTemplate>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template","bySpecialty",specialityCode)
				parameter("loadLayout", loadLayout)
				parameter("raw", raw)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getFormTemplates(loadLayout: Boolean? = null, raw: Boolean? = null):
			HttpResponse<List<FormTemplate>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template")
				parameter("loadLayout", loadLayout)
				parameter("raw", raw)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createFormTemplate(ft: FormTemplate): HttpResponse<FormTemplate> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ft)
		}.wrap()


	suspend fun deleteFormTemplate(formTemplateId: String): HttpResponse<DocIdentifier> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template",formTemplateId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun updateFormTemplate(formTemplateId: String, ft: FormTemplate):
			HttpResponse<FormTemplate> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template",formTemplateId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ft)
		}.wrap()


	suspend fun setTemplateAttachment(formTemplateId: String, payload: ByteArray):
			HttpResponse<String> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","template",formTemplateId,"attachment")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.OctetStream)
			setBody(ByteReadChannel(payload))
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedForm>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedForm>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","form","bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}