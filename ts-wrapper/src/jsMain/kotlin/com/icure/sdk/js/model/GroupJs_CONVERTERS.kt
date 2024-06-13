package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.security.OperationTokenJs
import com.icure.sdk.js.model.security.operationToken_fromJs
import com.icure.sdk.js.model.security.operationToken_toJs
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.Group
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.model.embed.UserType
import com.icure.sdk.model.security.OperationToken
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun group_toJs(obj: Group): GroupJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val name = nullToUndefined(
		obj.name
	)
	val password = nullToUndefined(
		obj.password
	)
	val servers = nullToUndefined(
		listToArray(
			obj.servers,
			{ x1: String ->
				x1
			},
		)
	)
	val superAdmin = obj.superAdmin
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val defaultUserRoles = mapToObject(
		obj.defaultUserRoles,
		{ x1: UserType ->
			x1.name
		},
		{ x1: Set<String> ->
			setToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val operationTokens = mapToObject(
		obj.operationTokens,
		{ x1: String ->
			x1
		},
		{ x1: OperationToken ->
			operationToken_toJs(x1)
		},
	)
	val sharedEntities = mapToObject(
		obj.sharedEntities,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = nullToUndefined(
		obj.minimumKrakenVersion
	)
	val minimumAuthenticationClassForElevatedPrivileges =
			obj.minimumAuthenticationClassForElevatedPrivileges.name
	val superGroup = nullToUndefined(
		obj.superGroup
	)
	return GroupJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"tags:tags," +
		"name:name," +
		"password:password," +
		"servers:servers," +
		"superAdmin:superAdmin," +
		"properties:properties," +
		"defaultUserRoles:defaultUserRoles," +
		"operationTokens:operationTokens," +
		"sharedEntities:sharedEntities," +
		"minimumKrakenVersion:minimumKrakenVersion," +
		"minimumAuthenticationClassForElevatedPrivileges:minimumAuthenticationClassForElevatedPrivileges," +
		"superGroup:superGroup" +
	"}"))
}

public fun group_fromJs(obj: GroupJs): Group {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val name = undefinedToNull(obj.name)
	val password = undefinedToNull(obj.password)
	val servers = arrayToList(
		obj.servers,
		"obj.servers",
		{ x1: String ->
			x1
		},
	)
	val superAdmin = obj.superAdmin
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val defaultUserRoles = objectToMap(
		obj.defaultUserRoles,
		"obj.defaultUserRoles",
		{ x1: String ->
			UserType.valueOf(x1)
		},
		{ x1: Array<String> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val operationTokens = objectToMap(
		obj.operationTokens,
		"obj.operationTokens",
		{ x1: String ->
			x1
		},
		{ x1: OperationTokenJs ->
			operationToken_fromJs(x1)
		},
	)
	val sharedEntities = objectToMap(
		obj.sharedEntities,
		"obj.sharedEntities",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val minimumKrakenVersion = undefinedToNull(obj.minimumKrakenVersion)
	val minimumAuthenticationClassForElevatedPrivileges =
			AuthenticationClass.valueOf(obj.minimumAuthenticationClassForElevatedPrivileges)
	val superGroup = undefinedToNull(obj.superGroup)
	return Group(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		tags = tags,
		name = name,
		password = password,
		servers = servers,
		superAdmin = superAdmin,
		properties = properties,
		defaultUserRoles = defaultUserRoles,
		operationTokens = operationTokens,
		sharedEntities = sharedEntities,
		minimumKrakenVersion = minimumKrakenVersion,
		minimumAuthenticationClassForElevatedPrivileges = minimumAuthenticationClassForElevatedPrivileges,
		superGroup = superGroup,
	)
}
