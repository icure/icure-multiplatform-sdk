package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.LetterValue

public fun letterValue_toJs(obj: LetterValue): LetterValueJs {
	val letter = obj.letter
	val index = obj.index
	val coefficient = obj.coefficient
	val value = obj.value
	return LetterValueJs(js("{" +
		"letter:letter," +
		"index:index," +
		"coefficient:coefficient," +
		"value:value" +
	"}"))
}

public fun letterValue_fromJs(obj: LetterValueJs): LetterValue {
	val letter = obj.letter
	val index = obj.index
	val coefficient = obj.coefficient
	val value = obj.value
	return LetterValue(
		letter = letter,
		index = index,
		coefficient = coefficient,
		value = value,
	)
}
