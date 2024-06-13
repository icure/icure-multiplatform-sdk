package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.EmploymentInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun employmentInfo_toJs(obj: EmploymentInfo): EmploymentInfoJs {
	val startDate = longToNumber(obj.startDate) ?: undefined
	val endDate = longToNumber(obj.endDate) ?: undefined
	val professionType = obj.professionType?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	} ?: undefined
	val employer = obj.employer?.let { nonNull1 ->
		employer_toJs(nonNull1)
	} ?: undefined
	return EmploymentInfoJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"professionType:professionType," +
		"employer:employer" +
	"}"))
}

public fun employmentInfo_fromJs(obj: EmploymentInfoJs): EmploymentInfo {
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val professionType = obj.professionType?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val employer = obj.employer?.let { nonNull1 ->
		employer_fromJs(nonNull1)
	}
	return EmploymentInfo(
		startDate = startDate,
		endDate = endDate,
		professionType = professionType,
		employer = employer,
	)
}
