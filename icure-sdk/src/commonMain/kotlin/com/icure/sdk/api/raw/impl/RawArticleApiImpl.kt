package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawArticleApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedArticle
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawArticleApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawArticleApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Article)

	// region common endpoints

	override suspend fun createArticle(articleDto: EncryptedArticle): HttpResponse<EncryptedArticle> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "article")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(articleDto)
		}.wrap()

	override suspend fun deleteArticles(articleIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "article", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(articleIds)
		}.wrap()

	override suspend fun deleteArticle(articleId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "article", articleId)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getArticle(articleId: String): HttpResponse<EncryptedArticle> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "article", articleId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun modifyArticle(articleDto: EncryptedArticle): HttpResponse<EncryptedArticle> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "article")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(articleDto)
		}.wrap()

	override suspend fun getArticles(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedArticle>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "article")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedArticle>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "article", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
