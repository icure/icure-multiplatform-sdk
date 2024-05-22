package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Measure
import com.icure.sdk.model.embed.ReferenceRange

public fun measure_toJs(obj: Measure): MeasureJs {
	val value = obj.value
	val ref = obj.ref
	val severity = intToNumber(obj.severity)
	val severityCode = obj.severityCode
	val evolution = intToNumber(obj.evolution)
	val unit = obj.unit
	val unitCodes = setToArray(
		obj.unitCodes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val comment = obj.comment
	val comparator = obj.comparator
	val sign = obj.sign
	val referenceRanges = listToArray(
		obj.referenceRanges,
		{ x1: ReferenceRange ->
			referenceRange_toJs(x1)
		},
	)
	return MeasureJs(js("{" +
		"value:value," +
		"ref:ref," +
		"severity:severity," +
		"severityCode:severityCode," +
		"evolution:evolution," +
		"unit:unit," +
		"unitCodes:unitCodes," +
		"comment:comment," +
		"comparator:comparator," +
		"sign:sign," +
		"referenceRanges:referenceRanges" +
	"}"))
}

public fun measure_fromJs(obj: MeasureJs): Measure {
	val value = obj.value
	val ref = obj.ref
	val severity = numberToInt(obj.severity, "obj.severity")
	val severityCode = obj.severityCode
	val evolution = numberToInt(obj.evolution, "obj.evolution")
	val unit = obj.unit
	val unitCodes = arrayToSet(
		obj.unitCodes,
		"obj.unitCodes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val comment = obj.comment
	val comparator = obj.comparator
	val sign = obj.sign
	val referenceRanges = arrayToList(
		obj.referenceRanges,
		"obj.referenceRanges",
		{ x1: ReferenceRangeJs ->
			referenceRange_fromJs(x1)
		},
	)
	return Measure(
		value = value,
		ref = ref,
		severity = severity,
		severityCode = severityCode,
		evolution = evolution,
		unit = unit,
		unitCodes = unitCodes,
		comment = comment,
		comparator = comparator,
		sign = sign,
		referenceRanges = referenceRanges,
	)
}
