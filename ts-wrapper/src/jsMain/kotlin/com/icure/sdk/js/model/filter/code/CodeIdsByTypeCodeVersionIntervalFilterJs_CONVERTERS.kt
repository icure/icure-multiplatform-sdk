package com.icure.sdk.js.model.filter.code

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun codeIdsByTypeCodeVersionIntervalFilter_toJs(obj: CodeIdsByTypeCodeVersionIntervalFilter):
		CodeIdsByTypeCodeVersionIntervalFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val startType = nullToUndefined(
		obj.startType
	)
	val startCode = nullToUndefined(
		obj.startCode
	)
	val startVersion = nullToUndefined(
		obj.startVersion
	)
	val endType = nullToUndefined(
		obj.endType
	)
	val endCode = nullToUndefined(
		obj.endCode
	)
	val endVersion = nullToUndefined(
		obj.endVersion
	)
	return CodeIdsByTypeCodeVersionIntervalFilterJs(js("{" +
		"desc:desc," +
		"startType:startType," +
		"startCode:startCode," +
		"startVersion:startVersion," +
		"endType:endType," +
		"endCode:endCode," +
		"endVersion:endVersion" +
	"}"))
}

public
		fun codeIdsByTypeCodeVersionIntervalFilter_fromJs(obj: CodeIdsByTypeCodeVersionIntervalFilterJs):
		CodeIdsByTypeCodeVersionIntervalFilter {
	val desc = undefinedToNull(obj.desc)
	val startType = undefinedToNull(obj.startType)
	val startCode = undefinedToNull(obj.startCode)
	val startVersion = undefinedToNull(obj.startVersion)
	val endType = undefinedToNull(obj.endType)
	val endCode = undefinedToNull(obj.endCode)
	val endVersion = undefinedToNull(obj.endVersion)
	return CodeIdsByTypeCodeVersionIntervalFilter(
		desc = desc,
		startType = startType,
		startCode = startCode,
		startVersion = startVersion,
		endType = endType,
		endCode = endCode,
		endVersion = endVersion,
	)
}
