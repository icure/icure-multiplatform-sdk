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
	val updateSeq = obj.updateSeq ?: undefined
	val fileSize = longToNumber(obj.fileSize) ?: undefined
	val externalSize = longToNumber(obj.externalSize) ?: undefined
	val activeSize = longToNumber(obj.activeSize) ?: undefined
	val docs = longToNumber(obj.docs) ?: undefined
	val q = intToNumber(obj.q) ?: undefined
	val n = intToNumber(obj.n) ?: undefined
	val w = intToNumber(obj.w) ?: undefined
	val r = intToNumber(obj.r) ?: undefined
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
