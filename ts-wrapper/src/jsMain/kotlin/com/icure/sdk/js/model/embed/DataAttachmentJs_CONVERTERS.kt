package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.embed.DataAttachment
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun dataAttachment_toJs(obj: DataAttachment): DataAttachmentJs {
	val couchDbAttachmentId = obj.couchDbAttachmentId ?: undefined
	val objectStoreAttachmentId = obj.objectStoreAttachmentId ?: undefined
	val utis = listToArray(
		obj.utis,
		{ x1: String ->
			x1
		},
	)
	return DataAttachmentJs(js("{" +
		"couchDbAttachmentId:couchDbAttachmentId," +
		"objectStoreAttachmentId:objectStoreAttachmentId," +
		"utis:utis" +
	"}"))
}

public fun dataAttachment_fromJs(obj: DataAttachmentJs): DataAttachment {
	val couchDbAttachmentId = obj.couchDbAttachmentId
	val objectStoreAttachmentId = obj.objectStoreAttachmentId
	val utis = arrayToList(
		obj.utis,
		"obj.utis",
		{ x1: String ->
			x1
		},
	)
	return DataAttachment(
		couchDbAttachmentId = couchDbAttachmentId,
		objectStoreAttachmentId = objectStoreAttachmentId,
		utis = utis,
	)
}
