// auto-generated file
package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.stringToZonedDateTime
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.CheckedConverters.zonedDateTimeToString
import com.icure.sdk.model.couchdb.ReplicationStats
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun replicationStats_toJs(obj: ReplicationStats): ReplicationStatsJs {
	val revisionsChecked = nullToUndefined(
		intToNumber(obj.revisionsChecked)
	)
	val missingRevisionsFound = nullToUndefined(
		intToNumber(obj.missingRevisionsFound)
	)
	val docsRead = nullToUndefined(
		intToNumber(obj.docsRead)
	)
	val docsWritten = nullToUndefined(
		intToNumber(obj.docsWritten)
	)
	val changesPending = nullToUndefined(
		intToNumber(obj.changesPending)
	)
	val docWriteFailures = nullToUndefined(
		intToNumber(obj.docWriteFailures)
	)
	val checkpointedSourceSeq = nullToUndefined(
		obj.checkpointedSourceSeq
	)
	val startTime = nullToUndefined(
		zonedDateTimeToString(obj.startTime)
	)
	val error = nullToUndefined(
		obj.error
	)
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
	val checkpointedSourceSeq = undefinedToNull(obj.checkpointedSourceSeq)
	val startTime = stringToZonedDateTime(obj.startTime, "obj.startTime")
	val error = undefinedToNull(obj.error)
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
