package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.couchdb.DatabaseInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun databaseInfo_toJs(obj: DatabaseInfo): DatabaseInfoJs {
	val id = obj.id
	val updateSeq = obj.updateSeq
	val fileSize = longToNumber(obj.fileSize)
	val externalSize = longToNumber(obj.externalSize)
	val activeSize = longToNumber(obj.activeSize)
	val docs = longToNumber(obj.docs)
	val q = intToNumber(obj.q)
	val n = intToNumber(obj.n)
	val w = intToNumber(obj.w)
	val r = intToNumber(obj.r)
	return DatabaseInfoJs(js("{" +
		"id:id," +
		"updateSeq:updateSeq," +
		"fileSize:fileSize," +
		"externalSize:externalSize," +
		"activeSize:activeSize," +
		"docs:docs," +
		"q:q," +
		"n:n," +
		"w:w," +
		"r:r" +
	"}"))
}

public fun databaseInfo_fromJs(obj: DatabaseInfoJs): DatabaseInfo {
	val id = obj.id
	val updateSeq = obj.updateSeq
	val fileSize = numberToLong(obj.fileSize, "obj.fileSize")
	val externalSize = numberToLong(obj.externalSize, "obj.externalSize")
	val activeSize = numberToLong(obj.activeSize, "obj.activeSize")
	val docs = numberToLong(obj.docs, "obj.docs")
	val q = numberToInt(obj.q, "obj.q")
	val n = numberToInt(obj.n, "obj.n")
	val w = numberToInt(obj.w, "obj.w")
	val r = numberToInt(obj.r, "obj.r")
	return DatabaseInfo(
		id = id,
		updateSeq = updateSeq,
		fileSize = fileSize,
		externalSize = externalSize,
		activeSize = activeSize,
		docs = docs,
		q = q,
		n = n,
		w = w,
		r = r,
	)
}
