// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.KeywordApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.KeywordApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.KeywordJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.keyword_fromJs
import com.icure.cardinal.sdk.js.model.keyword_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
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
	override fun getKeyword(keywordId: String): Promise<KeywordJs?> = GlobalScope.promise {
		val keywordIdConverted: String = keywordId
		val result = keywordApi.getKeyword(
			keywordIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				keyword_toJs(nonNull1)
			}
		)
	}

	override fun createKeyword(keyword: KeywordJs): Promise<KeywordJs> = GlobalScope.promise {
		val keywordConverted: Keyword = keyword_fromJs(keyword)
		val result = keywordApi.createKeyword(
			keywordConverted,
		)
		keyword_toJs(result)
	}

	override fun getKeywords(options: dynamic): Promise<PaginatedListJs<KeywordJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
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
