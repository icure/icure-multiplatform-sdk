package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.embed.AgreementAppendix
import com.icure.sdk.model.embed.ParagraphAgreement
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun paragraphAgreement_toJs(obj: ParagraphAgreement): ParagraphAgreementJs {
	val timestamp = longToNumber(obj.timestamp) ?: undefined
	val paragraph = obj.paragraph ?: undefined
	val accepted = obj.accepted ?: undefined
	val inTreatment = obj.inTreatment ?: undefined
	val canceled = obj.canceled ?: undefined
	val careProviderReference = obj.careProviderReference ?: undefined
	val decisionReference = obj.decisionReference ?: undefined
	val start = longToNumber(obj.start) ?: undefined
	val end = longToNumber(obj.end) ?: undefined
	val cancelationDate = longToNumber(obj.cancelationDate) ?: undefined
	val quantityValue = obj.quantityValue ?: undefined
	val quantityUnit = obj.quantityUnit ?: undefined
	val ioRequestReference = obj.ioRequestReference ?: undefined
	val responseType = obj.responseType ?: undefined
	val refusalJustification = mapToObject(
		obj.refusalJustification,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	) ?: undefined
	val verses = setToArray(
		obj.verses,
		{ x1: Long ->
			longToNumber(x1)
		},
	) ?: undefined
	val coverageType = obj.coverageType ?: undefined
	val unitNumber = obj.unitNumber ?: undefined
	val strength = obj.strength ?: undefined
	val strengthUnit = obj.strengthUnit ?: undefined
	val agreementAppendices = listToArray(
		obj.agreementAppendices,
		{ x1: AgreementAppendix ->
			agreementAppendix_toJs(x1)
		},
	) ?: undefined
	val documentId = obj.documentId ?: undefined
	return ParagraphAgreementJs(js("{" +
		"timestamp:timestamp," +
		"paragraph:paragraph," +
		"accepted:accepted," +
		"inTreatment:inTreatment," +
		"canceled:canceled," +
		"careProviderReference:careProviderReference," +
		"decisionReference:decisionReference," +
		"start:start," +
		"end:end," +
		"cancelationDate:cancelationDate," +
		"quantityValue:quantityValue," +
		"quantityUnit:quantityUnit," +
		"ioRequestReference:ioRequestReference," +
		"responseType:responseType," +
		"refusalJustification:refusalJustification," +
		"verses:verses," +
		"coverageType:coverageType," +
		"unitNumber:unitNumber," +
		"strength:strength," +
		"strengthUnit:strengthUnit," +
		"agreementAppendices:agreementAppendices," +
		"documentId:documentId" +
	"}"))
}

public fun paragraphAgreement_fromJs(obj: ParagraphAgreementJs): ParagraphAgreement {
	val timestamp = numberToLong(obj.timestamp, "obj.timestamp")
	val paragraph = obj.paragraph
	val accepted = obj.accepted
	val inTreatment = obj.inTreatment
	val canceled = obj.canceled
	val careProviderReference = obj.careProviderReference
	val decisionReference = obj.decisionReference
	val start = numberToLong(obj.start, "obj.start")
	val end = numberToLong(obj.end, "obj.end")
	val cancelationDate = numberToLong(obj.cancelationDate, "obj.cancelationDate")
	val quantityValue = obj.quantityValue
	val quantityUnit = obj.quantityUnit
	val ioRequestReference = obj.ioRequestReference
	val responseType = obj.responseType
	val refusalJustification = objectToMapNullsafe(
		obj.refusalJustification,
		"obj.refusalJustification",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val verses = arrayToSet(
		obj.verses,
		"obj.verses",
		{ x1: Double ->
			numberToLong(x1, "x1")
		},
	)
	val coverageType = obj.coverageType
	val unitNumber = obj.unitNumber
	val strength = obj.strength
	val strengthUnit = obj.strengthUnit
	val agreementAppendices = arrayToList(
		obj.agreementAppendices,
		"obj.agreementAppendices",
		{ x1: AgreementAppendixJs ->
			agreementAppendix_fromJs(x1)
		},
	)
	val documentId = obj.documentId
	return ParagraphAgreement(
		timestamp = timestamp,
		paragraph = paragraph,
		accepted = accepted,
		inTreatment = inTreatment,
		canceled = canceled,
		careProviderReference = careProviderReference,
		decisionReference = decisionReference,
		start = start,
		end = end,
		cancelationDate = cancelationDate,
		quantityValue = quantityValue,
		quantityUnit = quantityUnit,
		ioRequestReference = ioRequestReference,
		responseType = responseType,
		refusalJustification = refusalJustification,
		verses = verses,
		coverageType = coverageType,
		unitNumber = unitNumber,
		strength = strength,
		strengthUnit = strengthUnit,
		agreementAppendices = agreementAppendices,
		documentId = documentId,
	)
}
