// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.security.AuthenticationToken
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun authenticationToken_toJs(obj: AuthenticationToken): AuthenticationTokenJs {
	val token = nullToUndefined(
		obj.token
	)
	val creationTime = longToNumber(obj.creationTime)
	val validity = longToNumber(obj.validity)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	return AuthenticationTokenJs(js("{" +
		"token:token," +
		"creationTime:creationTime," +
		"validity:validity," +
		"deletionDate:deletionDate" +
	"}"))
}

public fun authenticationToken_fromJs(obj: AuthenticationTokenJs): AuthenticationToken {
	val token = undefinedToNull(obj.token)
	val creationTime = numberToLong(obj.creationTime, "obj.creationTime")
	val validity = numberToLong(obj.validity, "obj.validity")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	return AuthenticationToken(
		token = token,
		creationTime = creationTime,
		validity = validity,
		deletionDate = deletionDate,
	)
}
