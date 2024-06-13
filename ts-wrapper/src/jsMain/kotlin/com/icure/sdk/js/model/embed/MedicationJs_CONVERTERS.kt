package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.Medication
import com.icure.sdk.model.embed.ParagraphAgreement
import com.icure.sdk.model.embed.RegimenItem
import com.icure.sdk.model.embed.Suspension
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun medication_toJs(obj: Medication): MedicationJs {
	val compoundPrescription = obj.compoundPrescription ?: undefined
	val substanceProduct = obj.substanceProduct?.let { nonNull1 ->
		substanceproduct_toJs(nonNull1)
	} ?: undefined
	val medicinalProduct = obj.medicinalProduct?.let { nonNull1 ->
		medicinalproduct_toJs(nonNull1)
	} ?: undefined
	val numberOfPackages = intToNumber(obj.numberOfPackages) ?: undefined
	val batch = obj.batch ?: undefined
	val expirationDate = longToNumber(obj.expirationDate) ?: undefined
	val instructionForPatient = obj.instructionForPatient ?: undefined
	val instructionForReimbursement = obj.instructionForReimbursement ?: undefined
	val commentForDelivery = obj.commentForDelivery ?: undefined
	val drugRoute = obj.drugRoute ?: undefined
	val temporality = obj.temporality ?: undefined
	val frequency = obj.frequency?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	} ?: undefined
	val reimbursementReason = obj.reimbursementReason?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	} ?: undefined
	val substitutionAllowed = obj.substitutionAllowed ?: undefined
	val beginMoment = longToNumber(obj.beginMoment) ?: undefined
	val endMoment = longToNumber(obj.endMoment) ?: undefined
	val deliveryMoment = longToNumber(obj.deliveryMoment) ?: undefined
	val endExecutionMoment = longToNumber(obj.endExecutionMoment) ?: undefined
	val duration = obj.duration?.let { nonNull1 ->
		duration_toJs(nonNull1)
	} ?: undefined
	val renewal = obj.renewal?.let { nonNull1 ->
		renewal_toJs(nonNull1)
	} ?: undefined
	val knownUsage = obj.knownUsage ?: undefined
	val regimen = listToArray(
		obj.regimen,
		{ x1: RegimenItem ->
			regimenItem_toJs(x1)
		},
	) ?: undefined
	val posology = obj.posology ?: undefined
	val agreements = mapToObject(
		obj.agreements,
		{ x1: String ->
			x1
		},
		{ x1: ParagraphAgreement ->
			paragraphAgreement_toJs(x1)
		},
	) ?: undefined
	val medicationSchemeIdOnSafe = obj.medicationSchemeIdOnSafe ?: undefined
	val medicationSchemeSafeVersion = intToNumber(obj.medicationSchemeSafeVersion) ?: undefined
	val medicationSchemeTimeStampOnSafe = longToNumber(obj.medicationSchemeTimeStampOnSafe) ?:
			undefined
	val medicationSchemeDocumentId = obj.medicationSchemeDocumentId ?: undefined
	val safeIdName = obj.safeIdName ?: undefined
	val idOnSafes = obj.idOnSafes ?: undefined
	val timestampOnSafe = longToNumber(obj.timestampOnSafe) ?: undefined
	val changeValidated = obj.changeValidated ?: undefined
	val newSafeMedication = obj.newSafeMedication ?: undefined
	val medicationUse = obj.medicationUse ?: undefined
	val beginCondition = obj.beginCondition ?: undefined
	val endCondition = obj.endCondition ?: undefined
	val origin = obj.origin ?: undefined
	val medicationChanged = obj.medicationChanged ?: undefined
	val posologyChanged = obj.posologyChanged ?: undefined
	val suspension = listToArray(
		obj.suspension,
		{ x1: Suspension ->
			suspension_toJs(x1)
		},
	) ?: undefined
	val prescriptionRID = obj.prescriptionRID ?: undefined
	val status = intToNumber(obj.status) ?: undefined
	return MedicationJs(js("{" +
		"compoundPrescription:compoundPrescription," +
		"substanceProduct:substanceProduct," +
		"medicinalProduct:medicinalProduct," +
		"numberOfPackages:numberOfPackages," +
		"batch:batch," +
		"expirationDate:expirationDate," +
		"instructionForPatient:instructionForPatient," +
		"instructionForReimbursement:instructionForReimbursement," +
		"commentForDelivery:commentForDelivery," +
		"drugRoute:drugRoute," +
		"temporality:temporality," +
		"frequency:frequency," +
		"reimbursementReason:reimbursementReason," +
		"substitutionAllowed:substitutionAllowed," +
		"beginMoment:beginMoment," +
		"endMoment:endMoment," +
		"deliveryMoment:deliveryMoment," +
		"endExecutionMoment:endExecutionMoment," +
		"duration:duration," +
		"renewal:renewal," +
		"knownUsage:knownUsage," +
		"regimen:regimen," +
		"posology:posology," +
		"agreements:agreements," +
		"medicationSchemeIdOnSafe:medicationSchemeIdOnSafe," +
		"medicationSchemeSafeVersion:medicationSchemeSafeVersion," +
		"medicationSchemeTimeStampOnSafe:medicationSchemeTimeStampOnSafe," +
		"medicationSchemeDocumentId:medicationSchemeDocumentId," +
		"safeIdName:safeIdName," +
		"idOnSafes:idOnSafes," +
		"timestampOnSafe:timestampOnSafe," +
		"changeValidated:changeValidated," +
		"newSafeMedication:newSafeMedication," +
		"medicationUse:medicationUse," +
		"beginCondition:beginCondition," +
		"endCondition:endCondition," +
		"origin:origin," +
		"medicationChanged:medicationChanged," +
		"posologyChanged:posologyChanged," +
		"suspension:suspension," +
		"prescriptionRID:prescriptionRID," +
		"status:status" +
	"}"))
}

public fun medication_fromJs(obj: MedicationJs): Medication {
	val compoundPrescription = obj.compoundPrescription
	val substanceProduct = obj.substanceProduct?.let { nonNull1 ->
		substanceproduct_fromJs(nonNull1)
	}
	val medicinalProduct = obj.medicinalProduct?.let { nonNull1 ->
		medicinalproduct_fromJs(nonNull1)
	}
	val numberOfPackages = numberToInt(obj.numberOfPackages, "obj.numberOfPackages")
	val batch = obj.batch
	val expirationDate = numberToLong(obj.expirationDate, "obj.expirationDate")
	val instructionForPatient = obj.instructionForPatient
	val instructionForReimbursement = obj.instructionForReimbursement
	val commentForDelivery = obj.commentForDelivery
	val drugRoute = obj.drugRoute
	val temporality = obj.temporality
	val frequency = obj.frequency?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val reimbursementReason = obj.reimbursementReason?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val substitutionAllowed = obj.substitutionAllowed
	val beginMoment = numberToLong(obj.beginMoment, "obj.beginMoment")
	val endMoment = numberToLong(obj.endMoment, "obj.endMoment")
	val deliveryMoment = numberToLong(obj.deliveryMoment, "obj.deliveryMoment")
	val endExecutionMoment = numberToLong(obj.endExecutionMoment, "obj.endExecutionMoment")
	val duration = obj.duration?.let { nonNull1 ->
		duration_fromJs(nonNull1)
	}
	val renewal = obj.renewal?.let { nonNull1 ->
		renewal_fromJs(nonNull1)
	}
	val knownUsage = obj.knownUsage
	val regimen = arrayToList(
		obj.regimen,
		"obj.regimen",
		{ x1: RegimenItemJs ->
			regimenItem_fromJs(x1)
		},
	)
	val posology = obj.posology
	val agreements = objectToMapNullsafe(
		obj.agreements,
		"obj.agreements",
		{ x1: String ->
			x1
		},
		{ x1: ParagraphAgreementJs ->
			paragraphAgreement_fromJs(x1)
		},
	)
	val medicationSchemeIdOnSafe = obj.medicationSchemeIdOnSafe
	val medicationSchemeSafeVersion = numberToInt(obj.medicationSchemeSafeVersion,
			"obj.medicationSchemeSafeVersion")
	val medicationSchemeTimeStampOnSafe = numberToLong(obj.medicationSchemeTimeStampOnSafe,
			"obj.medicationSchemeTimeStampOnSafe")
	val medicationSchemeDocumentId = obj.medicationSchemeDocumentId
	val safeIdName = obj.safeIdName
	val idOnSafes = obj.idOnSafes
	val timestampOnSafe = numberToLong(obj.timestampOnSafe, "obj.timestampOnSafe")
	val changeValidated = obj.changeValidated
	val newSafeMedication = obj.newSafeMedication
	val medicationUse = obj.medicationUse
	val beginCondition = obj.beginCondition
	val endCondition = obj.endCondition
	val origin = obj.origin
	val medicationChanged = obj.medicationChanged
	val posologyChanged = obj.posologyChanged
	val suspension = arrayToList(
		obj.suspension,
		"obj.suspension",
		{ x1: SuspensionJs ->
			suspension_fromJs(x1)
		},
	)
	val prescriptionRID = obj.prescriptionRID
	val status = numberToInt(obj.status, "obj.status")
	return Medication(
		compoundPrescription = compoundPrescription,
		substanceProduct = substanceProduct,
		medicinalProduct = medicinalProduct,
		numberOfPackages = numberOfPackages,
		batch = batch,
		expirationDate = expirationDate,
		instructionForPatient = instructionForPatient,
		instructionForReimbursement = instructionForReimbursement,
		commentForDelivery = commentForDelivery,
		drugRoute = drugRoute,
		temporality = temporality,
		frequency = frequency,
		reimbursementReason = reimbursementReason,
		substitutionAllowed = substitutionAllowed,
		beginMoment = beginMoment,
		endMoment = endMoment,
		deliveryMoment = deliveryMoment,
		endExecutionMoment = endExecutionMoment,
		duration = duration,
		renewal = renewal,
		knownUsage = knownUsage,
		regimen = regimen,
		posology = posology,
		agreements = agreements,
		medicationSchemeIdOnSafe = medicationSchemeIdOnSafe,
		medicationSchemeSafeVersion = medicationSchemeSafeVersion,
		medicationSchemeTimeStampOnSafe = medicationSchemeTimeStampOnSafe,
		medicationSchemeDocumentId = medicationSchemeDocumentId,
		safeIdName = safeIdName,
		idOnSafes = idOnSafes,
		timestampOnSafe = timestampOnSafe,
		changeValidated = changeValidated,
		newSafeMedication = newSafeMedication,
		medicationUse = medicationUse,
		beginCondition = beginCondition,
		endCondition = endCondition,
		origin = origin,
		medicationChanged = medicationChanged,
		posologyChanged = posologyChanged,
		suspension = suspension,
		prescriptionRID = prescriptionRID,
		status = status,
	)
}
