package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.Group
import com.icure.sdk.model.UserGroup
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun userGroup_toJs(obj: UserGroup): UserGroupJs {
	val groupId = obj.groupId
	val groupName = obj.groupName
	val groupsHierarchy = listToArray(
		obj.groupsHierarchy,
		{ x1: Group ->
			group_toJs(x1)
		},
	)
	val userId = obj.userId
	val login = obj.login
	val name = obj.name
	val email = obj.email
	val phone = obj.phone
	val patientId = obj.patientId
	val healthcarePartyId = obj.healthcarePartyId
	val deviceId = obj.deviceId
	val nameOfParentOfTopmostGroupInHierarchy = obj.nameOfParentOfTopmostGroupInHierarchy
	return UserGroupJs(js("{" +
		"groupId:groupId," +
		"groupName:groupName," +
		"groupsHierarchy:groupsHierarchy," +
		"userId:userId," +
		"login:login," +
		"name:name," +
		"email:email," +
		"phone:phone," +
		"patientId:patientId," +
		"healthcarePartyId:healthcarePartyId," +
		"deviceId:deviceId," +
		"nameOfParentOfTopmostGroupInHierarchy:nameOfParentOfTopmostGroupInHierarchy" +
	"}"))
}

public fun userGroup_fromJs(obj: UserGroupJs): UserGroup {
	val groupId = obj.groupId
	val groupName = obj.groupName
	val groupsHierarchy = arrayToList(
		obj.groupsHierarchy,
		"obj.groupsHierarchy",
		{ x1: GroupJs ->
			group_fromJs(x1)
		},
	)
	val userId = obj.userId
	val login = obj.login
	val name = obj.name
	val email = obj.email
	val phone = obj.phone
	val patientId = obj.patientId
	val healthcarePartyId = obj.healthcarePartyId
	val deviceId = obj.deviceId
	val nameOfParentOfTopmostGroupInHierarchy = obj.nameOfParentOfTopmostGroupInHierarchy
	return UserGroup(
		groupId = groupId,
		groupName = groupName,
		groupsHierarchy = groupsHierarchy,
		userId = userId,
		login = login,
		name = name,
		email = email,
		phone = phone,
		patientId = patientId,
		healthcarePartyId = healthcarePartyId,
		deviceId = deviceId,
		nameOfParentOfTopmostGroupInHierarchy = nameOfParentOfTopmostGroupInHierarchy,
	)
}
