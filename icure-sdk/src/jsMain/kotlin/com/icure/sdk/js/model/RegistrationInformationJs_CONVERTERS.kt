package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.RegistrationInformation
import kotlin.String

public fun registrationInformation_toJs(obj: RegistrationInformation): RegistrationInformationJs {
	val firstName = obj.firstName
	val lastName = obj.lastName
	val emailAddress = obj.emailAddress
	val userOptions = obj.userOptions
	val userRoles = setToArray(
		obj.userRoles,
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = obj.minimumKrakenVersion
	return RegistrationInformationJs(js("{" +
		"firstName:firstName," +
		"lastName:lastName," +
		"emailAddress:emailAddress," +
		"userOptions:userOptions," +
		"userRoles:userRoles," +
		"minimumKrakenVersion:minimumKrakenVersion" +
	"}"))
}

public fun registrationInformation_fromJs(obj: RegistrationInformationJs): RegistrationInformation {
	val firstName = obj.firstName
	val lastName = obj.lastName
	val emailAddress = obj.emailAddress
	val userOptions = obj.userOptions
	val userRoles = arrayToSet(
		obj.userRoles,
		"obj.userRoles",
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = obj.minimumKrakenVersion
	return RegistrationInformation(
		firstName = firstName,
		lastName = lastName,
		emailAddress = emailAddress,
		userOptions = userOptions,
		userRoles = userRoles,
		minimumKrakenVersion = minimumKrakenVersion,
	)
}