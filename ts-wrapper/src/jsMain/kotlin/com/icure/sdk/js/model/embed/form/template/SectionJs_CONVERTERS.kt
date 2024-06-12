package com.icure.sdk.js.model.embed.form.template

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.embed.form.template.Section
import com.icure.sdk.model.embed.form.template.StructureElement
import kotlin.String

public fun section_toJs(obj: Section): SectionJs {
	val section = obj.section
	val fields = listToArray(
		obj.fields,
		{ x1: StructureElement ->
			structureElement_toJs(x1)
		},
	)
	val description = obj.description
	val keywords = listToArray(
		obj.keywords,
		{ x1: String ->
			x1
		},
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
	val description = obj.description
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
