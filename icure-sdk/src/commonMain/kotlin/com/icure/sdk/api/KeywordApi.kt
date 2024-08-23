package com.icure.sdk.api

import com.icure.sdk.model.Keyword
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue

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

