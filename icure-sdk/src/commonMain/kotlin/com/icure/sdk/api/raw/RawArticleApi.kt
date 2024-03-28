package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.model.EncryptedArticle
import com.icure.sdk.model.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.delete
import io.ktor.client.request.`get`
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
class RawArticleApi(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
	// region common endpoints

	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Article)

	suspend fun createArticle(articleDto: EncryptedArticle): HttpResponse<EncryptedArticle> =
		post {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "article")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(articleDto)
		}.wrap()

	suspend fun deleteArticles(articleIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "article", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(articleIds)
		}.wrap()

	suspend fun deleteArticle(articleId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "article", articleId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getArticle(articleId: String): HttpResponse<EncryptedArticle> =
		get {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "article", articleId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun modifyArticle(articleDto: EncryptedArticle): HttpResponse<EncryptedArticle> =
		put {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "article")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(articleDto)
		}.wrap()

	suspend fun getArticles(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedArticle, JsonString>> =
		get {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "article")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedArticle>>> =
		put {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "article", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
