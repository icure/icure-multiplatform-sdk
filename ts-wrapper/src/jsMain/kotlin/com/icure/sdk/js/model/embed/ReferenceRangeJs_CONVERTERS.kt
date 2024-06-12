package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.ReferenceRange

public fun referenceRange_toJs(obj: ReferenceRange): ReferenceRangeJs {
	val low = obj.low
	val high = obj.high
	val stringValue = obj.stringValue
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
	val age = obj.age?.let { nonNull1 ->
		range_toJs(nonNull1)
	}
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
	val low = obj.low
	val high = obj.high
	val stringValue = obj.stringValue
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
