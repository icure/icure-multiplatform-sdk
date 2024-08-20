// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.PersonName
import com.icure.sdk.model.embed.PersonNameUse
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun personName_toJs(obj: PersonName): PersonNameJs {
	val lastName = nullToUndefined(
		obj.lastName
	)
	val firstNames = listToArray(
		obj.firstNames,
		{ x1: String ->
			x1
		},
	)
	val start = nullToUndefined(
		longToNumber(obj.start)
	)
	val end = nullToUndefined(
		longToNumber(obj.end)
	)
	val prefix = listToArray(
		obj.prefix,
		{ x1: String ->
			x1
		},
	)
	val suffix = listToArray(
		obj.suffix,
		{ x1: String ->
			x1
		},
	)
	val text = nullToUndefined(
		obj.text
	)
	val use = nullToUndefined(
		obj.use?.let { nonNull1 ->
			nonNull1.name
		}
	)
	return PersonNameJs(js("{" +
		"lastName:lastName," +
		"firstNames:firstNames," +
		"start:start," +
		"end:end," +
		"prefix:prefix," +
		"suffix:suffix," +
		"text:text," +
		"use:use" +
	"}"))
}

public fun personName_fromJs(obj: PersonNameJs): PersonName {
	val lastName = undefinedToNull(obj.lastName)
	val firstNames = arrayToList(
		obj.firstNames,
		"obj.firstNames",
		{ x1: String ->
			x1
		},
	)
	val start = numberToLong(obj.start, "obj.start")
	val end = numberToLong(obj.end, "obj.end")
	val prefix = arrayToList(
		obj.prefix,
		"obj.prefix",
		{ x1: String ->
			x1
		},
	)
	val suffix = arrayToList(
		obj.suffix,
		"obj.suffix",
		{ x1: String ->
			x1
		},
	)
	val text = undefinedToNull(obj.text)
	val use = obj.use?.let { nonNull1 ->
		PersonNameUse.valueOf(nonNull1)
	}
	return PersonName(
		lastName = lastName,
		firstNames = firstNames,
		start = start,
		end = end,
		prefix = prefix,
		suffix = suffix,
		text = text,
		use = use,
	)
}
