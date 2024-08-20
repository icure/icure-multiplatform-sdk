// auto-generated file
package com.icure.sdk.js.model.embed.form.template

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.form.template.TimePicker
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun timePicker_toJs(obj: TimePicker): TimePickerJs {
	val field = obj.field
	val shortLabel = nullToUndefined(
		obj.shortLabel
	)
	val rows = nullToUndefined(
		intToNumber(obj.rows)
	)
	val columns = nullToUndefined(
		intToNumber(obj.columns)
	)
	val grows = nullToUndefined(
		obj.grows
	)
	val multiline = nullToUndefined(
		obj.multiline
	)
	val schema = nullToUndefined(
		obj.schema
	)
	val tags = nullToUndefined(
		listToArray(
			obj.tags,
			{ x1: String ->
				x1
			},
		)
	)
	val codifications = nullToUndefined(
		listToArray(
			obj.codifications,
			{ x1: String ->
				x1
			},
		)
	)
	val options = nullToUndefined(
		mapToObject(
			obj.options,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val labels = nullToUndefined(
		mapToObject(
			obj.labels,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val value = nullToUndefined(
		obj.value
	)
	val unit = nullToUndefined(
		obj.unit
	)
	val required = nullToUndefined(
		obj.required
	)
	val hideCondition = nullToUndefined(
		obj.hideCondition
	)
	val now = nullToUndefined(
		obj.now
	)
	val translate = nullToUndefined(
		obj.translate
	)
	return TimePickerJs(js("{" +
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

public fun timePicker_fromJs(obj: TimePickerJs): TimePicker {
	val field = obj.field
	val shortLabel = undefinedToNull(obj.shortLabel)
	val rows = numberToInt(obj.rows, "obj.rows")
	val columns = numberToInt(obj.columns, "obj.columns")
	val grows = undefinedToNull(obj.grows)
	val multiline = undefinedToNull(obj.multiline)
	val schema = undefinedToNull(obj.schema)
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
	val value = undefinedToNull(obj.value)
	val unit = undefinedToNull(obj.unit)
	val required = undefinedToNull(obj.required)
	val hideCondition = undefinedToNull(obj.hideCondition)
	val now = undefinedToNull(obj.now)
	val translate = undefinedToNull(obj.translate)
	return TimePicker(
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
