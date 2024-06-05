// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.KeywordApi
import com.icure.sdk.js.api.KeywordApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.KeywordJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.keyword_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.Keyword
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class KeywordApiImplJs(
	private val keywordApi: KeywordApi,
) : KeywordApiJs {
	override fun getKeyword(frontEndMigrationId: String): Promise<KeywordJs> = GlobalScope.promise {
		keyword_toJs(keywordApi.getKeyword(frontEndMigrationId))}


	override fun createKeyword(frontEndMigration: KeywordJs): Promise<KeywordJs> =
			GlobalScope.promise {
		keyword_toJs(keywordApi.createKeyword(com.icure.sdk.js.model.keyword_fromJs(frontEndMigration)))}


	override fun getKeywords(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<KeywordJs>> = GlobalScope.promise {
		paginatedList_toJs(
			keywordApi.getKeywords(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Keyword ->
				keyword_toJs(x1)
			},
		)}


	override fun modifyKeyword(keyword: KeywordJs): Promise<KeywordJs> = GlobalScope.promise {
		keyword_toJs(keywordApi.modifyKeyword(com.icure.sdk.js.model.keyword_fromJs(keyword)))}


	override fun getKeywordsByUser(userId: String): Promise<Array<KeywordJs>> = GlobalScope.promise {
		listToArray(
			keywordApi.getKeywordsByUser(userId),
			{ x1: Keyword ->
				keyword_toJs(x1)
			},
		)}


	override fun deleteKeywords(keywordIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			keywordApi.deleteKeywords(arrayToList(
				keywordIds,
				"keywordIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}

}
