// auto-generated file
package com.icure.cardinal.sdk.js.model.embed.form.template

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup
import com.icure.cardinal.sdk.model.embed.form.template.StructureElement
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun fieldsGroup_toJs(obj: FieldsGroup): FieldsGroupJs {
	val group = obj.group
	val fields = nullToUndefined(
		listToArray(
			obj.fields,
			{ x1: StructureElement ->
				structureElement_toJs(x1)
			},
		)
	)
	return FieldsGroupJs(js("{" +
		"group:group," +
		"fields:fields" +
	"}"))
}

public fun fieldsGroup_fromJs(obj: FieldsGroupJs): FieldsGroup {
	val group = obj.group
	val fields = arrayToList(
		obj.fields,
		"obj.fields",
		{ x1: StructureElementJs ->
			structureElement_fromJs(x1)
		},
	)
	return FieldsGroup(
		group = group,
		fields = fields,
	)
}
