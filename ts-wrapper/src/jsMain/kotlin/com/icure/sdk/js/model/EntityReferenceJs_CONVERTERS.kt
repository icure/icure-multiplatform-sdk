// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.EntityReference
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun entityReference_toJs(obj: EntityReference): EntityReferenceJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val docId = nullToUndefined(
		obj.docId
	)
	return EntityReferenceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"docId:docId" +
	"}"))
}

public fun entityReference_fromJs(obj: EntityReferenceJs): EntityReference {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val docId = undefinedToNull(obj.docId)
	return EntityReference(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		docId = docId,
	)
}
