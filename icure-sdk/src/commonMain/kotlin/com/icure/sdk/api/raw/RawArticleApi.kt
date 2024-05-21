package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedArticle
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawArticleApi {
	// region common endpoints

	suspend fun createArticle(articleDto: EncryptedArticle): HttpResponse<EncryptedArticle>

	suspend fun deleteArticles(articleIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteArticle(articleId: String): HttpResponse<DocIdentifier>

	suspend fun getArticle(articleId: String): HttpResponse<EncryptedArticle>

	suspend fun modifyArticle(articleDto: EncryptedArticle): HttpResponse<EncryptedArticle>

	suspend fun getArticles(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedArticle>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedArticle>>>
	// endregion
}
