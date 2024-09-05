// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.model.embed.SchoolingInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun schoolingInfo_toJs(obj: SchoolingInfo): SchoolingInfoJs {
	val startDate = nullToUndefined(
		longToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		longToNumber(obj.endDate)
	)
	val school = nullToUndefined(
		obj.school
	)
	val typeOfEducation = nullToUndefined(
		obj.typeOfEducation?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
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
	val school = undefinedToNull(obj.school)
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
