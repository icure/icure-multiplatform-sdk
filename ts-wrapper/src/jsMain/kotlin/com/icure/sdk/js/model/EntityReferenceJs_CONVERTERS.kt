package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.EntityReference
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun entityReference_toJs(obj: EntityReference): EntityReferenceJs {
	val id = obj.id
	val rev = obj.rev ?: undefined
	val deletionDate = longToNumber(obj.deletionDate) ?: undefined
	val docId = obj.docId ?: undefined
	return EntityReferenceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"docId:docId" +
	"}"))
}

public fun entityReference_fromJs(obj: EntityReferenceJs): EntityReference {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val docId = obj.docId
	return EntityReference(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		docId = docId,
	)
}
