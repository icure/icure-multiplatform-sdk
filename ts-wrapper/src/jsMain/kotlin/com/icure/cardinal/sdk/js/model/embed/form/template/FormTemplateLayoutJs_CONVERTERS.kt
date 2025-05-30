// auto-generated file
package com.icure.cardinal.sdk.js.model.embed.form.template

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.form.template.Action
import com.icure.cardinal.sdk.model.embed.form.template.FormTemplateLayout
import com.icure.cardinal.sdk.model.embed.form.template.Section
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun formTemplateLayout_toJs(obj: FormTemplateLayout): FormTemplateLayoutJs {
	val form = obj.form
	val actions = listToArray(
		obj.actions,
		{ x1: Action ->
			action_toJs(x1)
		},
	)
	val sections = listToArray(
		obj.sections,
		{ x1: Section ->
			section_toJs(x1)
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
	return FormTemplateLayoutJs(js("{" +
		"form:form," +
		"actions:actions," +
		"sections:sections," +
		"description:description," +
		"keywords:keywords" +
	"}"))
}

public fun formTemplateLayout_fromJs(obj: FormTemplateLayoutJs): FormTemplateLayout {
	val form = obj.form
	val actions = arrayToList(
		obj.actions,
		"obj.actions",
		{ x1: ActionJs ->
			action_fromJs(x1)
		},
	)
	val sections = arrayToList(
		obj.sections,
		"obj.sections",
		{ x1: SectionJs ->
			section_fromJs(x1)
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
	return FormTemplateLayout(
		form = form,
		actions = actions,
		sections = sections,
		description = description,
		keywords = keywords,
	)
}
