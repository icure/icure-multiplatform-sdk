package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.embed.KeywordSubword
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun keywordSubword_toJs(obj: KeywordSubword): KeywordSubwordJs {
	val value = obj.value ?: undefined
	val subWords = listToArray(
		obj.subWords,
		{ x1: KeywordSubword ->
			keywordSubword_toJs(x1)
		},
	) ?: undefined
	return KeywordSubwordJs(js("{" +
		"value:value," +
		"subWords:subWords" +
	"}"))
}

public fun keywordSubword_fromJs(obj: KeywordSubwordJs): KeywordSubword {
	val value = obj.value
	val subWords = arrayToList(
		obj.subWords,
		"obj.subWords",
		{ x1: KeywordSubwordJs ->
			keywordSubword_fromJs(x1)
		},
	)
	return KeywordSubword(
		value = value,
		subWords = subWords,
	)
}
