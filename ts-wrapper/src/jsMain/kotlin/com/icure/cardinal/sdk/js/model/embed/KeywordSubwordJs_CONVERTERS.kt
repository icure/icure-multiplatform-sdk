// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.KeywordSubword
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun keywordSubword_toJs(obj: KeywordSubword): KeywordSubwordJs {
	val value = nullToUndefined(
		obj.value
	)
	val subWords = nullToUndefined(
		listToArray(
			obj.subWords,
			{ x1: KeywordSubword ->
				keywordSubword_toJs(x1)
			},
		)
	)
	return KeywordSubwordJs(js("{" +
		"value:value," +
		"subWords:subWords" +
	"}"))
}

public fun keywordSubword_fromJs(obj: KeywordSubwordJs): KeywordSubword {
	val value = undefinedToNull(obj.value)
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
