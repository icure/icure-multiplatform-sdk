// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.KeywordJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("KeywordApi")
public external interface KeywordApiJs {
	public fun getKeyword(frontEndMigrationId: String): Promise<KeywordJs>

	public fun createKeyword(frontEndMigration: KeywordJs): Promise<KeywordJs>

	public fun getKeywords(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<KeywordJs>>

	public fun modifyKeyword(keyword: KeywordJs): Promise<KeywordJs>

	public fun getKeywordsByUser(userId: String): Promise<Array<KeywordJs>>

	public fun deleteKeywords(keywordIds: Array<String>): Promise<Array<DocIdentifierJs>>
}
