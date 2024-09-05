// auto-generated file
package com.icure.cardinal.sdk.js.model.embed.form.template

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.form.template.Section
import com.icure.cardinal.sdk.model.embed.form.template.StructureElement
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun section_toJs(obj: Section): SectionJs {
	val section = obj.section
	val fields = listToArray(
		obj.fields,
		{ x1: StructureElement ->
			structureElement_toJs(x1)
		},
	)
	val description = nullToUndefined(
		obj.description
	)
	val keywords = nullToUndefined(
		listToArray(
			obj.keywords,
			{ x1: String ->
				x1
			},
		)
	)
	return SectionJs(js("{" +
		"section:section," +
		"fields:fields," +
		"description:description," +
		"keywords:keywords" +
	"}"))
}

public fun section_fromJs(obj: SectionJs): Section {
	val section = obj.section
	val fields = arrayToList(
		obj.fields,
		"obj.fields",
		{ x1: StructureElementJs ->
			structureElement_fromJs(x1)
		},
	)
	val description = undefinedToNull(obj.description)
	val keywords = arrayToList(
		obj.keywords,
		"obj.keywords",
		{ x1: String ->
			x1
		},
	)
	return Section(
		section = section,
		fields = fields,
		description = description,
		keywords = keywords,
	)
}
