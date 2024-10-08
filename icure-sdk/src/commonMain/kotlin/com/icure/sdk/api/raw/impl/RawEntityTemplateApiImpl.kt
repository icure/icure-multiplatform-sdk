package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawEntityTemplateApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EntityTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawEntityTemplateApiImpl(
	private val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawEntityTemplateApi {
	// region common endpoints

	override suspend fun listEntityTemplatesBy(
		userId: String,
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "find", userId, type)
				parameter("searchString", searchString)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listAllEntityTemplatesBy(
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "findAll", type)
				parameter("searchString", searchString)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "find", userId, type, "keyword", keyword)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findAllEntityTemplatesByKeyword(
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "findAll", type, "keyword", keyword)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createEntityTemplate(c: EntityTemplate): HttpResponse<EntityTemplate> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getEntityTemplates(entityTemplateIds: ListOfIds): HttpResponse<List<EntityTemplate>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateIds)
		}.wrap()

	override suspend fun getEntityTemplate(entityTemplateId: String): HttpResponse<EntityTemplate> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", entityTemplateId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyEntityTemplate(entityTemplateDto: EntityTemplate): HttpResponse<EntityTemplate> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateDto)
		}.wrap()

	override suspend fun modifyEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun createEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun deleteEntityTemplate(entityTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(entityTemplateIds)
		}.wrap()

	// endregion
}
