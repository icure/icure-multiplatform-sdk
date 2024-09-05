// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.LetterValue
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun letterValue_toJs(obj: LetterValue): LetterValueJs {
	val letter = nullToUndefined(
		obj.letter
	)
	val index = nullToUndefined(
		obj.index
	)
	val coefficient = nullToUndefined(
		obj.coefficient
	)
	val value = nullToUndefined(
		obj.value
	)
	return LetterValueJs(js("{" +
		"letter:letter," +
		"index:index," +
		"coefficient:coefficient," +
		"value:value" +
	"}"))
}

public fun letterValue_fromJs(obj: LetterValueJs): LetterValue {
	val letter = undefinedToNull(obj.letter)
	val index = undefinedToNull(obj.index)
	val coefficient = undefinedToNull(obj.coefficient)
	val value = undefinedToNull(obj.value)
	return LetterValue(
		letter = letter,
		index = index,
		coefficient = coefficient,
		value = value,
	)
}
