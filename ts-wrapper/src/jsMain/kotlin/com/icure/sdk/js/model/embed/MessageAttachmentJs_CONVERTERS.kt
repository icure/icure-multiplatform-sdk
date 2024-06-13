package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.embed.DocumentLocation
import com.icure.sdk.model.embed.MessageAttachment
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun messageAttachment_toJs(obj: MessageAttachment): MessageAttachmentJs {
	val type = obj.type?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
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
		DocumentLocation.valueOf(nonNull1)
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
