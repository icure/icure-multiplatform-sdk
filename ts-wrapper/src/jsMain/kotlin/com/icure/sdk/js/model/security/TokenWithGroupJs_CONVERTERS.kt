package com.icure.sdk.js.model.security

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.security.TokenWithGroup
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun tokenWithGroup_toJs(obj: TokenWithGroup): TokenWithGroupJs {
	val token = obj.token
	val groupId = obj.groupId
	val groupName = nullToUndefined(
		obj.groupName
	)
	return TokenWithGroupJs(js("{" +
		"token:token," +
		"groupId:groupId," +
		"groupName:groupName" +
	"}"))
}

public fun tokenWithGroup_fromJs(obj: TokenWithGroupJs): TokenWithGroup {
	val token = obj.token
	val groupId = obj.groupId
	val groupName = undefinedToNull(obj.groupName)
	return TokenWithGroup(
		token = token,
		groupId = groupId,
		groupName = groupName,
	)
}
