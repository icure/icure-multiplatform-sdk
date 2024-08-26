// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.embed.address_fromJs
import com.icure.sdk.js.model.embed.address_toJs
import com.icure.sdk.model.MedicalLocation
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun medicalLocation_toJs(obj: MedicalLocation): MedicalLocationJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val name = nullToUndefined(
		obj.name
	)
	val description = nullToUndefined(
		obj.description
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val guardPost = nullToUndefined(
		obj.guardPost
	)
	val cbe = nullToUndefined(
		obj.cbe
	)
	val bic = nullToUndefined(
		obj.bic
	)
	val bankAccount = nullToUndefined(
		obj.bankAccount
	)
	val nihii = nullToUndefined(
		obj.nihii
	)
	val ssin = nullToUndefined(
		obj.ssin
	)
	val address = nullToUndefined(
		obj.address?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	val agendaIds = setToArray(
		obj.agendaIds,
		{ x1: String ->
			x1
		},
	)
	val options = mapToObject(
		obj.options,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val publicInformations = mapToObject(
		obj.publicInformations,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return MedicalLocationJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"description:description," +
		"responsible:responsible," +
		"guardPost:guardPost," +
		"cbe:cbe," +
		"bic:bic," +
		"bankAccount:bankAccount," +
		"nihii:nihii," +
		"ssin:ssin," +
		"address:address," +
		"agendaIds:agendaIds," +
		"options:options," +
		"publicInformations:publicInformations" +
	"}"))
}

public fun medicalLocation_fromJs(obj: MedicalLocationJs): MedicalLocation {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = undefinedToNull(obj.name)
	val description = undefinedToNull(obj.description)
	val responsible = undefinedToNull(obj.responsible)
	val guardPost = undefinedToNull(obj.guardPost)
	val cbe = undefinedToNull(obj.cbe)
	val bic = undefinedToNull(obj.bic)
	val bankAccount = undefinedToNull(obj.bankAccount)
	val nihii = undefinedToNull(obj.nihii)
	val ssin = undefinedToNull(obj.ssin)
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	val agendaIds = arrayToSet(
		obj.agendaIds,
		"obj.agendaIds",
		{ x1: String ->
			x1
		},
	)
	val options = objectToMap(
		obj.options,
		"obj.options",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val publicInformations = objectToMap(
		obj.publicInformations,
		"obj.publicInformations",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return MedicalLocation(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		description = description,
		responsible = responsible,
		guardPost = guardPost,
		cbe = cbe,
		bic = bic,
		bankAccount = bankAccount,
		nihii = nihii,
		ssin = ssin,
		address = address,
		agendaIds = agendaIds,
		options = options,
		publicInformations = publicInformations,
	)
}
