package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Annotation
import kotlin.String

public fun annotation_toJs(obj: Annotation): AnnotationJs {
	val id = obj.id
	val author = obj.author
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val text = obj.text
	val markdown = mapToObject<_, _, String>(
		obj.markdown,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val location = obj.location
	val confidential = obj.confidential
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf
	return AnnotationJs(js("{" +
		"id:id," +
		"author:author," +
		"created:created," +
		"modified:modified," +
		"text:text," +
		"markdown:markdown," +
		"location:location," +
		"confidential:confidential," +
		"tags:tags," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun annotation_fromJs(obj: AnnotationJs): Annotation {
	val id = obj.id
	val author = obj.author
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val text = obj.text
	val markdown = objectToMap(
		obj.markdown,
		"obj.markdown",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val location = obj.location
	val confidential = obj.confidential
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf
	return Annotation(
		id = id,
		author = author,
		created = created,
		modified = modified,
		text = text,
		markdown = markdown,
		location = location,
		confidential = confidential,
		tags = tags,
		encryptedSelf = encryptedSelf,
	)
}
