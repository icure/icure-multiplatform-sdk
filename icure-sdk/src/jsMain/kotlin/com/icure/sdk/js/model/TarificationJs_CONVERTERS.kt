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
import com.icure.sdk.js.model.base.linkQualification_fromJs
import com.icure.sdk.js.model.base.linkQualification_toJs
import com.icure.sdk.js.model.embed.DecryptedValorisationJs
import com.icure.sdk.js.model.embed.LetterValueJs
import com.icure.sdk.js.model.embed.PeriodicityJs
import com.icure.sdk.js.model.embed.letterValue_fromJs
import com.icure.sdk.js.model.embed.letterValue_toJs
import com.icure.sdk.js.model.embed.periodicity_fromJs
import com.icure.sdk.js.model.embed.periodicity_toJs
import com.icure.sdk.js.model.embed.valorisation_fromJs
import com.icure.sdk.js.model.embed.valorisation_toJs
import com.icure.sdk.model.Tarification
import com.icure.sdk.model.base.AppendixType
import com.icure.sdk.model.base.CodeFlag
import com.icure.sdk.model.base.LinkQualification
import com.icure.sdk.model.embed.DecryptedValorisation
import com.icure.sdk.model.embed.LetterValue
import com.icure.sdk.model.embed.Periodicity
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

public fun tarification_toJs(obj: Tarification): TarificationJs {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = longToNumber(obj.deletionDate)
	val label = mapToObject<_, _, String>(
		obj.label,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val context = obj.context
	val type = obj.type
	val code = obj.code
	val version = obj.version
	val author = obj.author
	val regions = setToArray(
		obj.regions,
		{ x1: String ->
			x1
		},
	)
	val periodicity = listToArray(
		obj.periodicity,
		{ x1: Periodicity ->
			periodicity_toJs(x1)
		},
	)
	val level = intToNumber(obj.level)
	val links = listToArray(
		obj.links,
		{ x1: String ->
			x1
		},
	)
	val qualifiedLinks = mapToObject<_, _, Array<String>>(
		obj.qualifiedLinks,
		{ x1: LinkQualification ->
			linkQualification_toJs(x1)
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
	val searchTerms = mapToObject<_, _, Array<String>>(
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
	val appendices = mapToObject<_, _, String>(
		obj.appendices,
		{ x1: AppendixType ->
			appendixType_toJs(x1)
		},
		{ x1: String ->
			x1
		},
	)
	val disabled = obj.disabled
	val valorisations = setToArray(
		obj.valorisations,
		{ x1: DecryptedValorisation ->
			valorisation_toJs(x1)
		},
	)
	val category = mapToObject<_, _, String>(
		obj.category,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val consultationCode = obj.consultationCode
	val hasRelatedCode = obj.hasRelatedCode
	val needsPrescriber = obj.needsPrescriber
	val relatedCodes = setToArray(
		obj.relatedCodes,
		{ x1: String ->
			x1
		},
	)
	val ngroup = obj.ngroup
	val letterValues = listToArray(
		obj.letterValues,
		{ x1: LetterValue ->
			letterValue_toJs(x1)
		},
	)
	return TarificationJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"label:label," +
		"context:context," +
		"type:type," +
		"code:code," +
		"version:version," +
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
		"disabled:disabled," +
		"valorisations:valorisations," +
		"category:category," +
		"consultationCode:consultationCode," +
		"hasRelatedCode:hasRelatedCode," +
		"needsPrescriber:needsPrescriber," +
		"relatedCodes:relatedCodes," +
		"ngroup:ngroup," +
		"letterValues:letterValues" +
	"}"))
}

public fun tarification_fromJs(obj: TarificationJs): Tarification {
	val id = obj.id
	val rev = obj.rev
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
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
	val context = obj.context
	val type = obj.type
	val code = obj.code
	val version = obj.version
	val author = obj.author
	val regions = arrayToSet(
		obj.regions,
		"obj.regions",
		{ x1: String ->
			x1
		},
	)
	val periodicity = arrayToList(
		obj.periodicity,
		"obj.periodicity",
		{ x1: PeriodicityJs ->
			periodicity_fromJs(x1)
		},
	)
	val level = numberToInt(obj.level, "obj.level")
	val links = arrayToList(
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
			linkQualification_fromJs(x1)
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
	val valorisations = arrayToSet(
		obj.valorisations,
		"obj.valorisations",
		{ x1: DecryptedValorisationJs ->
			valorisation_fromJs(x1)
		},
	)
	val category = objectToMap(
		obj.category,
		"obj.category",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val consultationCode = obj.consultationCode
	val hasRelatedCode = obj.hasRelatedCode
	val needsPrescriber = obj.needsPrescriber
	val relatedCodes = arrayToSet(
		obj.relatedCodes,
		"obj.relatedCodes",
		{ x1: String ->
			x1
		},
	)
	val ngroup = obj.ngroup
	val letterValues = arrayToList(
		obj.letterValues,
		"obj.letterValues",
		{ x1: LetterValueJs ->
			letterValue_fromJs(x1)
		},
	)
	return Tarification(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		label = label,
		context = context,
		type = type,
		code = code,
		version = version,
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
		valorisations = valorisations,
		category = category,
		consultationCode = consultationCode,
		hasRelatedCode = hasRelatedCode,
		needsPrescriber = needsPrescriber,
		relatedCodes = relatedCodes,
		ngroup = ngroup,
		letterValues = letterValues,
	)
}