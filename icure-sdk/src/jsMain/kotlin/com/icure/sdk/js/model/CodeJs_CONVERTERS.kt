package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.appendixType_fromJs
import com.icure.sdk.js.model.base.appendixType_toJs
import com.icure.sdk.js.model.base.codeFlag_fromJs
import com.icure.sdk.js.model.base.codeFlag_toJs
import com.icure.sdk.js.model.embed.PeriodicityJs
import com.icure.sdk.js.model.embed.periodicity_fromJs
import com.icure.sdk.js.model.embed.periodicity_toJs
import com.icure.sdk.model.Code
import com.icure.sdk.model.base.AppendixType
import com.icure.sdk.model.base.CodeFlag
import com.icure.sdk.model.embed.Periodicity
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

public fun code_toJs(obj: Code): CodeJs {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = longToNumber(obj.deletionDate)
	val context = obj.context
	val type = obj.type
	val code = obj.code
	val version = obj.version
	val label = mapToObject(
		obj.label,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val author = obj.author
	val regions = setToArray(
		obj.regions,
		{ x1: String ->
			x1
		},
	)
	val periodicity = setToArray(
		obj.periodicity,
		{ x1: Periodicity ->
			periodicity_toJs(x1)
		},
	)
	val level = intToNumber(obj.level)
	val links = setToArray(
		obj.links,
		{ x1: String ->
			x1
		},
	)
	val qualifiedLinks = mapToObject(
		obj.qualifiedLinks,
		{ x1: String ->
			x1
		},
		{ x1: List<String> ->
			listToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val flags = setToArray(
		obj.flags,
		{ x1: CodeFlag ->
			codeFlag_toJs(x1)
		},
	)
	val searchTerms = mapToObject(
		obj.searchTerms,
		{ x1: String ->
			x1
		},
		{ x1: Set<String> ->
			setToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val data = obj.data
	val appendices = mapToObject(
		obj.appendices,
		{ x1: AppendixType ->
			appendixType_toJs(x1)
		},
		{ x1: String ->
			x1
		},
	)
	val disabled = obj.disabled
	return CodeJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"context:context," +
		"type:type," +
		"code:code," +
		"version:version," +
		"label:label," +
		"author:author," +
		"regions:regions," +
		"periodicity:periodicity," +
		"level:level," +
		"links:links," +
		"qualifiedLinks:qualifiedLinks," +
		"flags:flags," +
		"searchTerms:searchTerms," +
		"data:data," +
		"appendices:appendices," +
		"disabled:disabled" +
	"}"))
}

public fun code_fromJs(obj: CodeJs): Code {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val context = obj.context
	val type = obj.type
	val code = obj.code
	val version = obj.version
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val author = obj.author
	val regions = arrayToSet(
		obj.regions,
		"obj.regions",
		{ x1: String ->
			x1
		},
	)
	val periodicity = arrayToSet(
		obj.periodicity,
		"obj.periodicity",
		{ x1: PeriodicityJs ->
			periodicity_fromJs(x1)
		},
	)
	val level = numberToInt(obj.level, "obj.level")
	val links = arrayToSet(
		obj.links,
		"obj.links",
		{ x1: String ->
			x1
		},
	)
	val qualifiedLinks = objectToMap(
		obj.qualifiedLinks,
		"obj.qualifiedLinks",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val flags = arrayToSet(
		obj.flags,
		"obj.flags",
		{ x1: String ->
			codeFlag_fromJs(x1)
		},
	)
	val searchTerms = objectToMap(
		obj.searchTerms,
		"obj.searchTerms",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val data = obj.data
	val appendices = objectToMap(
		obj.appendices,
		"obj.appendices",
		{ x1: String ->
			appendixType_fromJs(x1)
		},
		{ x1: String ->
			x1
		},
	)
	val disabled = obj.disabled
	return Code(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		context = context,
		type = type,
		code = code,
		version = version,
		label = label,
		author = author,
		regions = regions,
		periodicity = periodicity,
		level = level,
		links = links,
		qualifiedLinks = qualifiedLinks,
		flags = flags,
		searchTerms = searchTerms,
		data = data,
		appendices = appendices,
		disabled = disabled,
	)
}
