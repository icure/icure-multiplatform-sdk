package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.CheckedConverters.stringToZonedDateTime
import com.icure.sdk.js.model.CheckedConverters.zonedDateTimeToString
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.couchdb.ReplicatorDocument
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map

@Suppress("UNUSED_VARIABLE")
public fun replicatorDocument_toJs(obj: ReplicatorDocument): ReplicatorDocumentJs {
	val id = obj.id
	val rev = obj.rev ?: undefined
	val source = obj.source?.let { nonNull1 ->
		remote_toJs(nonNull1)
	} ?: undefined
	val target = obj.target?.let { nonNull1 ->
		remote_toJs(nonNull1)
	} ?: undefined
	val owner = obj.owner ?: undefined
	val create_target = obj.create_target ?: undefined
	val continuous = obj.continuous ?: undefined
	val doc_ids = listToArray(
		obj.doc_ids,
		{ x1: String ->
			x1
		},
	) ?: undefined
	val replicationState = obj.replicationState ?: undefined
	val replicationStateTime = zonedDateTimeToString(obj.replicationStateTime) ?: undefined
	val replicationStats = obj.replicationStats?.let { nonNull1 ->
		replicationStats_toJs(nonNull1)
	} ?: undefined
	val errorCount = intToNumber(obj.errorCount) ?: undefined
	val revsInfo = listToArray(
		obj.revsInfo,
		{ x1: Map<String, String> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	) ?: undefined
	val revHistory = mapToObject(
		obj.revHistory,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	) ?: undefined
	return ReplicatorDocumentJs(js("{" +
		"id:id," +
		"rev:rev," +
		"source:source," +
		"target:target," +
		"owner:owner," +
		"create_target:create_target," +
		"continuous:continuous," +
		"doc_ids:doc_ids," +
		"replicationState:replicationState," +
		"replicationStateTime:replicationStateTime," +
		"replicationStats:replicationStats," +
		"errorCount:errorCount," +
		"revsInfo:revsInfo," +
		"revHistory:revHistory" +
	"}"))
}

public fun replicatorDocument_fromJs(obj: ReplicatorDocumentJs): ReplicatorDocument {
	val id = obj.id
	val rev = obj.rev
	val source = obj.source?.let { nonNull1 ->
		remote_fromJs(nonNull1)
	}
	val target = obj.target?.let { nonNull1 ->
		remote_fromJs(nonNull1)
	}
	val owner = obj.owner
	val create_target = obj.create_target
	val continuous = obj.continuous
	val doc_ids = arrayToList(
		obj.doc_ids,
		"obj.doc_ids",
		{ x1: String ->
			x1
		},
	)
	val replicationState = obj.replicationState
	val replicationStateTime = stringToZonedDateTime(obj.replicationStateTime,
			"obj.replicationStateTime")
	val replicationStats = obj.replicationStats?.let { nonNull1 ->
		replicationStats_fromJs(nonNull1)
	}
	val errorCount = numberToInt(obj.errorCount, "obj.errorCount")
	val revsInfo = arrayToList(
		obj.revsInfo,
		"obj.revsInfo",
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val revHistory = objectToMapNullsafe(
		obj.revHistory,
		"obj.revHistory",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return ReplicatorDocument(
		id = id,
		rev = rev,
		source = source,
		target = target,
		owner = owner,
		create_target = create_target,
		continuous = continuous,
		doc_ids = doc_ids,
		replicationState = replicationState,
		replicationStateTime = replicationStateTime,
		replicationStats = replicationStats,
		errorCount = errorCount,
		revsInfo = revsInfo,
		revHistory = revHistory,
	)
}
