// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.RegistrationSuccess
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun registrationSuccess_toJs(obj: RegistrationSuccess): RegistrationSuccessJs {
	val groupId = obj.groupId
	val userId = obj.userId
	val token = obj.token
	return RegistrationSuccessJs(js("{" +
		"groupId:groupId," +
		"userId:userId," +
		"token:token" +
	"}"))
}

public fun registrationSuccess_fromJs(obj: RegistrationSuccessJs): RegistrationSuccess {
	val groupId = obj.groupId
	val userId = obj.userId
	val token = obj.token
	return RegistrationSuccess(
		groupId = groupId,
		userId = userId,
		token = token,
	)
}
