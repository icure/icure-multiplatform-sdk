package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.stringToZonedDateTime
import com.icure.sdk.js.model.CheckedConverters.zonedDateTimeToString
import com.icure.sdk.model.couchdb.ReplicationStats
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun replicationStats_toJs(obj: ReplicationStats): ReplicationStatsJs {
	val revisionsChecked = intToNumber(obj.revisionsChecked) ?: undefined
	val missingRevisionsFound = intToNumber(obj.missingRevisionsFound) ?: undefined
	val docsRead = intToNumber(obj.docsRead) ?: undefined
	val docsWritten = intToNumber(obj.docsWritten) ?: undefined
	val changesPending = intToNumber(obj.changesPending) ?: undefined
	val docWriteFailures = intToNumber(obj.docWriteFailures) ?: undefined
	val checkpointedSourceSeq = obj.checkpointedSourceSeq ?: undefined
	val startTime = zonedDateTimeToString(obj.startTime) ?: undefined
	val error = obj.error ?: undefined
	return ReplicationStatsJs(js("{" +
		"revisionsChecked:revisionsChecked," +
		"missingRevisionsFound:missingRevisionsFound," +
		"docsRead:docsRead," +
		"docsWritten:docsWritten," +
		"changesPending:changesPending," +
		"docWriteFailures:docWriteFailures," +
		"checkpointedSourceSeq:checkpointedSourceSeq," +
		"startTime:startTime," +
		"error:error" +
	"}"))
}

public fun replicationStats_fromJs(obj: ReplicationStatsJs): ReplicationStats {
	val revisionsChecked = numberToInt(obj.revisionsChecked, "obj.revisionsChecked")
	val missingRevisionsFound = numberToInt(obj.missingRevisionsFound, "obj.missingRevisionsFound")
	val docsRead = numberToInt(obj.docsRead, "obj.docsRead")
	val docsWritten = numberToInt(obj.docsWritten, "obj.docsWritten")
	val changesPending = numberToInt(obj.changesPending, "obj.changesPending")
	val docWriteFailures = numberToInt(obj.docWriteFailures, "obj.docWriteFailures")
	val checkpointedSourceSeq = obj.checkpointedSourceSeq
	val startTime = stringToZonedDateTime(obj.startTime, "obj.startTime")
	val error = obj.error
	return ReplicationStats(
		revisionsChecked = revisionsChecked,
		missingRevisionsFound = missingRevisionsFound,
		docsRead = docsRead,
		docsWritten = docsWritten,
		changesPending = changesPending,
		docWriteFailures = docWriteFailures,
		checkpointedSourceSeq = checkpointedSourceSeq,
		startTime = startTime,
		error = error,
	)
}
