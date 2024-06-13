package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.dynamicToJson
import com.icure.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.EntityTemplate
import kotlin.String
import kotlin.Suppress
import kotlinx.serialization.json.JsonElement

@Suppress("UNUSED_VARIABLE")
public fun entityTemplate_toJs(obj: EntityTemplate): EntityTemplateJs {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = longToNumber(obj.deletionDate)
	val userId = obj.userId
	val descr = obj.descr
	val keywords = setToArray(
		obj.keywords,
		{ x1: String ->
			x1
		},
	)
	val entityType = obj.entityType
	val subType = obj.subType
	val defaultTemplate = obj.defaultTemplate
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
	val rev = obj.rev
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val userId = obj.userId
	val descr = obj.descr
	val keywords = arrayToSet(
		obj.keywords,
		"obj.keywords",
		{ x1: String ->
			x1
		},
	)
	val entityType = obj.entityType
	val subType = obj.subType
	val defaultTemplate = obj.defaultTemplate
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
