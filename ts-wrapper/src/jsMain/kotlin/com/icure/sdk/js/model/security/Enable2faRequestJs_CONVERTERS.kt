// auto-generated file
package com.icure.sdk.js.model.security

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.model.security.Enable2faRequest
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun enable2faRequest_toJs(obj: Enable2faRequest): Enable2faRequestJs {
	val secret = obj.secret
	val otpLength = intToNumber(obj.otpLength)
	return Enable2faRequestJs(js("{" +
		"secret:secret," +
		"otpLength:otpLength" +
	"}"))
}

public fun enable2faRequest_fromJs(obj: Enable2faRequestJs): Enable2faRequest {
	val secret = obj.secret
	val otpLength = numberToInt(obj.otpLength, "obj.otpLength")
	return Enable2faRequest(
		secret = secret,
		otpLength = otpLength,
	)
}
