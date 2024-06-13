package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.SchoolingInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun schoolingInfo_toJs(obj: SchoolingInfo): SchoolingInfoJs {
	val startDate = longToNumber(obj.startDate) ?: undefined
	val endDate = longToNumber(obj.endDate) ?: undefined
	val school = obj.school ?: undefined
	val typeOfEducation = obj.typeOfEducation?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	} ?: undefined
	return SchoolingInfoJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"school:school," +
		"typeOfEducation:typeOfEducation" +
	"}"))
}

public fun schoolingInfo_fromJs(obj: SchoolingInfoJs): SchoolingInfo {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val school = obj.school
	val typeOfEducation = obj.typeOfEducation?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	return SchoolingInfo(
		startDate = startDate,
		endDate = endDate,
		school = school,
		typeOfEducation = typeOfEducation,
	)
}
