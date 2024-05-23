package com.icure.sdk.js.model.embed.form.template

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.model.embed.form.template.DropdownField
import kotlin.String

public fun dropdownField_toJs(obj: DropdownField): DropdownFieldJs {
	val field = obj.field
	val shortLabel = obj.shortLabel
	val rows = intToNumber(obj.rows)
	val columns = intToNumber(obj.columns)
	val grows = obj.grows
	val multiline = obj.multiline
	val schema = obj.schema
	val tags = listToArray(
		obj.tags,
		{ x1: String ->
			x1
		},
	)
	val codifications = listToArray(
		obj.codifications,
		{ x1: String ->
			x1
		},
	)
	val options = mapToObject<_, _, String>(
		obj.options,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val labels = mapToObject<_, _, String>(
		obj.labels,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val value = obj.value
	val unit = obj.unit
	val required = obj.required
	val hideCondition = obj.hideCondition
	val now = obj.now
	val translate = obj.translate
	return DropdownFieldJs(js("{" +
		"field:field," +
		"shortLabel:shortLabel," +
		"rows:rows," +
		"columns:columns," +
		"grows:grows," +
		"multiline:multiline," +
		"schema:schema," +
		"tags:tags," +
		"codifications:codifications," +
		"options:options," +
		"labels:labels," +
		"value:value," +
		"unit:unit," +
		"required:required," +
		"hideCondition:hideCondition," +
		"now:now," +
		"translate:translate" +
	"}"))
}

public fun dropdownField_fromJs(obj: DropdownFieldJs): DropdownField {
	val field = obj.field
	val shortLabel = obj.shortLabel
	val rows = numberToInt(obj.rows, "obj.rows")
	val columns = numberToInt(obj.columns, "obj.columns")
	val grows = obj.grows
	val multiline = obj.multiline
	val schema = obj.schema
	val tags = arrayToList(
		obj.tags,
		"obj.tags",
		{ x1: String ->
			x1
		},
	)
	val codifications = arrayToList(
		obj.codifications,
		"obj.codifications",
		{ x1: String ->
			x1
		},
	)
	val options = objectToMapNullsafe(
		obj.options,
		"obj.options",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val labels = objectToMapNullsafe(
		obj.labels,
		"obj.labels",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val value = obj.value
	val unit = obj.unit
	val required = obj.required
	val hideCondition = obj.hideCondition
	val now = obj.now
	val translate = obj.translate
	return DropdownField(
		field = field,
		shortLabel = shortLabel,
		rows = rows,
		columns = columns,
		grows = grows,
		multiline = multiline,
		schema = schema,
		tags = tags,
		codifications = codifications,
		options = options,
		labels = labels,
		value = value,
		unit = unit,
		required = required,
		hideCondition = hideCondition,
		now = now,
		translate = translate,
	)
}
