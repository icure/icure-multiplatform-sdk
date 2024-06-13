package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.dynamicToJson
import com.icure.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.EntityTemplate
import kotlin.String
import kotlin.Suppress
import kotlinx.serialization.json.JsonElement

@Suppress("UNUSED_VARIABLE")
public fun entityTemplate_toJs(obj: EntityTemplate): EntityTemplateJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val keywords = nullToUndefined(
		setToArray(
			obj.keywords,
			{ x1: String ->
				x1
			},
		)
	)
	val entityType = nullToUndefined(
		obj.entityType
	)
	val subType = nullToUndefined(
		obj.subType
	)
	val defaultTemplate = nullToUndefined(
		obj.defaultTemplate
	)
	val entity = listToArray(
		obj.entity,
		{ x1: JsonElement ->
			jsonToDynamic(x1)
		},
	)
	return EntityTemplateJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"userId:userId," +
		"descr:descr," +
		"keywords:keywords," +
		"entityType:entityType," +
		"subType:subType," +
		"defaultTemplate:defaultTemplate," +
		"entity:entity" +
	"}"))
}

public fun entityTemplate_fromJs(obj: EntityTemplateJs): EntityTemplate {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val userId = undefinedToNull(obj.userId)
	val descr = undefinedToNull(obj.descr)
	val keywords = arrayToSet(
		obj.keywords,
		"obj.keywords",
		{ x1: String ->
			x1
		},
	)
	val entityType = undefinedToNull(obj.entityType)
	val subType = undefinedToNull(obj.subType)
	val defaultTemplate = undefinedToNull(obj.defaultTemplate)
	val entity = arrayToList(
		obj.entity,
		"obj.entity",
		{ x1: dynamic ->
			dynamicToJson(x1, "x1")
		},
	)
	return EntityTemplate(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		userId = userId,
		descr = descr,
		keywords = keywords,
		entityType = entityType,
		subType = subType,
		defaultTemplate = defaultTemplate,
		entity = entity,
	)
}
