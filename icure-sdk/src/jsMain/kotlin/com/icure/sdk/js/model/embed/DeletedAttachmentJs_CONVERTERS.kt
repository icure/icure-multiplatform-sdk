package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.DeletedAttachment

public fun deletedAttachment_toJs(obj: DeletedAttachment): DeletedAttachmentJs {
	val couchDbAttachmentId = obj.couchDbAttachmentId
	val objectStoreAttachmentId = obj.objectStoreAttachmentId
	val key = obj.key
	val deletionTime = longToNumber(obj.deletionTime)
	return DeletedAttachmentJs(js("{" +
		"couchDbAttachmentId:couchDbAttachmentId," +
		"objectStoreAttachmentId:objectStoreAttachmentId," +
		"key:key," +
		"deletionTime:deletionTime" +
	"}"))
}

public fun deletedAttachment_fromJs(obj: DeletedAttachmentJs): DeletedAttachment {
	val couchDbAttachmentId = obj.couchDbAttachmentId
	val objectStoreAttachmentId = obj.objectStoreAttachmentId
	val key = obj.key
	val deletionTime = numberToLong(obj.deletionTime, "obj.deletionTime")
	return DeletedAttachment(
		couchDbAttachmentId = couchDbAttachmentId,
		objectStoreAttachmentId = objectStoreAttachmentId,
		key = key,
		deletionTime = deletionTime,
	)
}
