package com.icure.sdk.js.model

import com.icure.sdk.model.DataOwnerRegistrationSuccess

public fun dataOwnerRegistrationSuccess_toJs(obj: DataOwnerRegistrationSuccess):
		DataOwnerRegistrationSuccessJs {
	val userLogin = obj.userLogin
	val userId = obj.userId
	val token = obj.token
	return DataOwnerRegistrationSuccessJs(js("{" +
		"userLogin:userLogin," +
		"userId:userId," +
		"token:token" +
	"}"))
}

public fun dataOwnerRegistrationSuccess_fromJs(obj: DataOwnerRegistrationSuccessJs):
		DataOwnerRegistrationSuccess {
	val userLogin = obj.userLogin
	val userId = obj.userId
	val token = obj.token
	return DataOwnerRegistrationSuccess(
		userLogin = userLogin,
		userId = userId,
		token = token,
	)
}
