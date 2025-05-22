// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.KeywordJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("KeywordApi")
public external interface KeywordApiJs {
	public fun getKeyword(keywordId: String): Promise<KeywordJs?>

	public fun createKeyword(keyword: KeywordJs): Promise<KeywordJs>

	public fun getKeywords(options: dynamic): Promise<PaginatedListJs<KeywordJs>>

	public fun modifyKeyword(keyword: KeywordJs): Promise<KeywordJs>

	public fun getKeywordsByUser(userId: String): Promise<Array<KeywordJs>>

	public fun deleteKeywords(keywordIds: Array<String>): Promise<Array<DocIdentifierJs>>
}
