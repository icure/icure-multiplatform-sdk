package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.DeletedAttachment
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun deletedAttachment_toJs(obj: DeletedAttachment): DeletedAttachmentJs {
	val couchDbAttachmentId = nullToUndefined(
		obj.couchDbAttachmentId
	)
	val objectStoreAttachmentId = nullToUndefined(
		obj.objectStoreAttachmentId
	)
	val key = nullToUndefined(
		obj.key
	)
	val deletionTime = nullToUndefined(
		longToNumber(obj.deletionTime)
	)
	return DeletedAttachmentJs(js("{" +
		"couchDbAttachmentId:couchDbAttachmentId," +
		"objectStoreAttachmentId:objectStoreAttachmentId," +
		"key:key," +
		"deletionTime:deletionTime" +
	"}"))
}

public fun deletedAttachment_fromJs(obj: DeletedAttachmentJs): DeletedAttachment {
	val couchDbAttachmentId = undefinedToNull(obj.couchDbAttachmentId)
	val objectStoreAttachmentId = undefinedToNull(obj.objectStoreAttachmentId)
	val key = undefinedToNull(obj.key)
	val deletionTime = numberToLong(obj.deletionTime, "obj.deletionTime")
	return DeletedAttachment(
		couchDbAttachmentId = couchDbAttachmentId,
		objectStoreAttachmentId = objectStoreAttachmentId,
		key = key,
		deletionTime = deletionTime,
	)
}
