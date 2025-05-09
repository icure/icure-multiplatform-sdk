package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue

interface KeywordApi {
	suspend fun getKeyword(keywordId: String): Keyword?
	suspend fun createKeyword(keyword: Keyword): Keyword
	@Deprecated("Will be replaced by filters")
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

