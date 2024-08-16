// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.ReferenceRange
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun referenceRange_toJs(obj: ReferenceRange): ReferenceRangeJs {
	val low = nullToUndefined(
		obj.low
	)
	val high = nullToUndefined(
		obj.high
	)
	val stringValue = nullToUndefined(
		obj.stringValue
	)
	val tags = listToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = listToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val age = nullToUndefined(
		obj.age?.let { nonNull1 ->
			range_toJs(nonNull1)
		}
	)
	return ReferenceRangeJs(js("{" +
		"low:low," +
		"high:high," +
		"stringValue:stringValue," +
		"tags:tags," +
		"codes:codes," +
		"notes:notes," +
		"age:age" +
	"}"))
}

public fun referenceRange_fromJs(obj: ReferenceRangeJs): ReferenceRange {
	val low = undefinedToNull(obj.low)
	val high = undefinedToNull(obj.high)
	val stringValue = undefinedToNull(obj.stringValue)
	val tags = arrayToList(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToList(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val age = obj.age?.let { nonNull1 ->
		range_fromJs(nonNull1)
	}
	return ReferenceRange(
		low = low,
		high = high,
		stringValue = stringValue,
		tags = tags,
		codes = codes,
		notes = notes,
		age = age,
	)
}
