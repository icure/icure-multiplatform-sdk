package com.icure.sdk.js.model.embed.form.template

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.embed.form.template.Group
import com.icure.sdk.model.embed.form.template.StructureElement

public fun group_toJs(obj: Group): GroupJs {
	val group = obj.group
	val fields = listToArray(
		obj.fields,
		{ x1: StructureElement ->
			structureElement_toJs(x1)
		},
	)
	return GroupJs(js("{" +
		"group:group," +
		"fields:fields" +
	"}"))
}

public fun group_fromJs(obj: GroupJs): Group {
	val group = obj.group
	val fields = arrayToList(
		obj.fields,
		"obj.fields",
		{ x1: StructureElementJs ->
			structureElement_fromJs(x1)
		},
	)
	return Group(
		group = group,
		fields = fields,
	)
}
