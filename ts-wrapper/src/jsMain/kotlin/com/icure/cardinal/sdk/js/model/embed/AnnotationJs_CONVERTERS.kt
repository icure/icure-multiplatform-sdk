// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.Annotation
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun annotation_toJs(obj: Annotation): AnnotationJs {
	val id = obj.id
	val author = nullToUndefined(
		obj.author
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val text = nullToUndefined(
		obj.text
	)
	val markdown = mapToObject(
		obj.markdown,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val location = nullToUndefined(
		obj.location
	)
	val confidential = nullToUndefined(
		obj.confidential
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf
	)
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
	val author = undefinedToNull(obj.author)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val text = undefinedToNull(obj.text)
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
	val location = undefinedToNull(obj.location)
	val confidential = undefinedToNull(obj.confidential)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = undefinedToNull(obj.encryptedSelf)
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
