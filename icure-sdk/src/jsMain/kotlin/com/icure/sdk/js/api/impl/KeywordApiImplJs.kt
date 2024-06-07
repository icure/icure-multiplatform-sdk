// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.KeywordApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.KeywordApiJs
import com.icure.sdk.js.api.KeywordApi_getKeywords_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.KeywordJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.keyword_fromJs
import com.icure.sdk.js.model.keyword_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.Keyword
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class KeywordApiImplJs(
	private val keywordApi: KeywordApi,
) : KeywordApiJs {
	override fun getKeyword(frontEndMigrationId: String): Promise<KeywordJs> = GlobalScope.promise {
		val frontEndMigrationIdConverted: String = frontEndMigrationId
		val result = keywordApi.getKeyword(
			frontEndMigrationIdConverted,
		)
		keyword_toJs(result)
	}

	override fun createKeyword(frontEndMigration: KeywordJs): Promise<KeywordJs> =
			GlobalScope.promise {
		val frontEndMigrationConverted: Keyword = keyword_fromJs(frontEndMigration)
		val result = keywordApi.createKeyword(
			frontEndMigrationConverted,
		)
		keyword_toJs(result)
	}

	override fun getKeywords(options: KeywordApi_getKeywords_Options?):
			Promise<PaginatedListJs<KeywordJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = keywordApi.getKeywords(
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Keyword ->
					keyword_toJs(x1)
				},
			)
		}
	}

	override fun modifyKeyword(keyword: KeywordJs): Promise<KeywordJs> = GlobalScope.promise {
		val keywordConverted: Keyword = keyword_fromJs(keyword)
		val result = keywordApi.modifyKeyword(
			keywordConverted,
		)
		keyword_toJs(result)
	}

	override fun getKeywordsByUser(userId: String): Promise<Array<KeywordJs>> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = keywordApi.getKeywordsByUser(
			userIdConverted,
		)
		listToArray(
			result,
			{ x1: Keyword ->
				keyword_toJs(x1)
			},
		)
	}

	override fun deleteKeywords(keywordIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val keywordIdsConverted: List<String> = arrayToList(
			keywordIds,
			"keywordIds",
			{ x1: String ->
				x1
			},
		)
		val result = keywordApi.deleteKeywords(
			keywordIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}
}
