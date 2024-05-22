package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.embed.MessageAttachment
import kotlin.String

public fun messageAttachment_toJs(obj: MessageAttachment): MessageAttachmentJs {
	val type = obj.type?.let { nonNull1 ->
		documentLocation_toJs(nonNull1)
	}
	val ids = listToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	return MessageAttachmentJs(js("{" +
		"type:type," +
		"ids:ids" +
	"}"))
}

public fun messageAttachment_fromJs(obj: MessageAttachmentJs): MessageAttachment {
	val type = obj.type?.let { nonNull1 ->
		documentLocation_fromJs(nonNull1)
	}
	val ids = arrayToList(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	return MessageAttachment(
		type = type,
		ids = ids,
	)
}
