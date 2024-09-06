package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.KeywordApi
import com.icure.cardinal.sdk.api.raw.RawKeywordApi
import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.utils.InternalIcureApi

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