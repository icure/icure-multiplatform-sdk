package com.icure.sdk.api

import com.icure.sdk.api.raw.RawKeywordApi
import com.icure.sdk.model.Keyword
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi

interface KeywordApi {
	suspend fun getKeyword(frontEndMigrationId: String): Keyword
	suspend fun createKeyword(frontEndMigration: Keyword): Keyword
	suspend fun getKeywords(
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<Keyword>
	suspend fun modifyKeyword(keyword: Keyword): Keyword
	suspend fun getKeywordsByUser(userId: String): List<Keyword>
	suspend fun deleteKeywords(keywordIds: List<String>): List<DocIdentifier>
}

@InternalIcureApi
internal class KeywordApiImpl(
	private val rawApi: RawKeywordApi,
) : KeywordApi {
	override suspend fun getKeyword(frontEndMigrationId: String) = rawApi.getKeyword(frontEndMigrationId).successBody()

	override suspend fun createKeyword(frontEndMigration: Keyword) =
		rawApi.createKeyword(frontEndMigration).successBody()

	override suspend fun getKeywords(startDocumentId: String?, limit: Int?): PaginatedList<Keyword> = rawApi.getKeywords(startDocumentId, limit).successBody()

	override suspend fun modifyKeyword(keyword: Keyword) = rawApi.modifyKeyword(keyword).successBody()

	override suspend fun getKeywordsByUser(userId: String) = rawApi.getKeywordsByUser(userId).successBody()

	override suspend fun deleteKeywords(keywordIds: List<String>) = rawApi.deleteKeywords(ListOfIds(keywordIds)).successBody()
}

