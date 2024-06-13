package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.FrontEndMigration
import com.icure.sdk.model.embed.FrontEndMigrationStatus
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun frontEndMigration_toJs(obj: FrontEndMigration): FrontEndMigrationJs {
	val id = obj.id
	val rev = obj.rev ?: undefined
	val deletionDate = longToNumber(obj.deletionDate) ?: undefined
	val name = obj.name ?: undefined
	val startDate = longToNumber(obj.startDate) ?: undefined
	val endDate = longToNumber(obj.endDate) ?: undefined
	val status = obj.status?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val logs = obj.logs ?: undefined
	val userId = obj.userId ?: undefined
	val startKey = obj.startKey ?: undefined
	val startKeyDocId = obj.startKeyDocId ?: undefined
	val processCount = longToNumber(obj.processCount) ?: undefined
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	return FrontEndMigrationJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"startDate:startDate," +
		"endDate:endDate," +
		"status:status," +
		"logs:logs," +
		"userId:userId," +
		"startKey:startKey," +
		"startKeyDocId:startKeyDocId," +
		"processCount:processCount," +
		"properties:properties" +
	"}"))
}

public fun frontEndMigration_fromJs(obj: FrontEndMigrationJs): FrontEndMigration {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = obj.name
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val status = obj.status?.let { nonNull1 ->
		FrontEndMigrationStatus.valueOf(nonNull1)
	}
	val logs = obj.logs
	val userId = obj.userId
	val startKey = obj.startKey
	val startKeyDocId = obj.startKeyDocId
	val processCount = numberToLong(obj.processCount, "obj.processCount")
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	return FrontEndMigration(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		startDate = startDate,
		endDate = endDate,
		status = status,
		logs = logs,
		userId = userId,
		startKey = startKey,
		startKeyDocId = startKeyDocId,
		processCount = processCount,
		properties = properties,
	)
}
