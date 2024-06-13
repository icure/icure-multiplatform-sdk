package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.embed.DatabaseSynchronizationJs
import com.icure.sdk.js.model.embed.databaseSynchronization_fromJs
import com.icure.sdk.js.model.embed.databaseSynchronization_toJs
import com.icure.sdk.model.Replication
import com.icure.sdk.model.embed.DatabaseSynchronization
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun replication_toJs(obj: Replication): ReplicationJs {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = longToNumber(obj.deletionDate)
	val name = obj.name
	val context = obj.context
	val databaseSynchronizations = listToArray(
		obj.databaseSynchronizations,
		{ x1: DatabaseSynchronization ->
			databaseSynchronization_toJs(x1)
		},
	)
	return ReplicationJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"context:context," +
		"databaseSynchronizations:databaseSynchronizations" +
	"}"))
}

public fun replication_fromJs(obj: ReplicationJs): Replication {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = obj.name
	val context = obj.context
	val databaseSynchronizations = arrayToList(
		obj.databaseSynchronizations,
		"obj.databaseSynchronizations",
		{ x1: DatabaseSynchronizationJs ->
			databaseSynchronization_fromJs(x1)
		},
	)
	return Replication(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		context = context,
		databaseSynchronizations = databaseSynchronizations,
	)
}
