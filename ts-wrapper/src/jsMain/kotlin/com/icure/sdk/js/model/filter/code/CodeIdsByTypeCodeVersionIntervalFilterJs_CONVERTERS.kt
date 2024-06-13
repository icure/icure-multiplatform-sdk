package com.icure.sdk.js.model.filter.code

import com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun codeIdsByTypeCodeVersionIntervalFilter_toJs(obj: CodeIdsByTypeCodeVersionIntervalFilter):
		CodeIdsByTypeCodeVersionIntervalFilterJs {
	val desc = obj.desc ?: undefined
	val startType = obj.startType ?: undefined
	val startCode = obj.startCode ?: undefined
	val startVersion = obj.startVersion ?: undefined
	val endType = obj.endType ?: undefined
	val endCode = obj.endCode ?: undefined
	val endVersion = obj.endVersion ?: undefined
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
	val desc = obj.desc
	val startType = obj.startType
	val startCode = obj.startCode
	val startVersion = obj.startVersion
	val endType = obj.endType
	val endCode = obj.endCode
	val endVersion = obj.endVersion
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
