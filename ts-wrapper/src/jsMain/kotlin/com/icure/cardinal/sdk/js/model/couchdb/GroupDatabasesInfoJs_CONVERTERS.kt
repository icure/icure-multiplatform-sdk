// auto-generated file
package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.model.couchdb.DatabaseInfo
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun groupDatabasesInfo_toJs(obj: GroupDatabasesInfo): GroupDatabasesInfoJs {
	val groupId = obj.groupId
	val databasesInfo = listToArray(
		obj.databasesInfo,
		{ x1: DatabaseInfo ->
			databaseInfo_toJs(x1)
		},
	)
	val gcpStorageSize = longToNumber(obj.gcpStorageSize)
	return GroupDatabasesInfoJs(js("{" +
		"groupId:groupId," +
		"databasesInfo:databasesInfo," +
		"gcpStorageSize:gcpStorageSize" +
	"}"))
}

public fun groupDatabasesInfo_fromJs(obj: GroupDatabasesInfoJs): GroupDatabasesInfo {
	val groupId = obj.groupId
	val databasesInfo = arrayToList(
		obj.databasesInfo,
		"obj.databasesInfo",
		{ x1: DatabaseInfoJs ->
			databaseInfo_fromJs(x1)
		},
	)
	val gcpStorageSize = numberToLong(obj.gcpStorageSize, "obj.gcpStorageSize")
	return GroupDatabasesInfo(
		groupId = groupId,
		databasesInfo = databasesInfo,
		gcpStorageSize = gcpStorageSize,
	)
}
