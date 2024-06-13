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
	val compoundPrescription = obj.compoundPrescription
	val substanceProduct = obj.substanceProduct?.let { nonNull1 ->
		substanceproduct_toJs(nonNull1)
	}
	val medicinalProduct = obj.medicinalProduct?.let { nonNull1 ->
		medicinalproduct_toJs(nonNull1)
	}
	val numberOfPackages = intToNumber(obj.numberOfPackages)
	val batch = obj.batch
	val expirationDate = longToNumber(obj.expirationDate)
	val instructionForPatient = obj.instructionForPatient
	val instructionForReimbursement = obj.instructionForReimbursement
	val commentForDelivery = obj.commentForDelivery
	val drugRoute = obj.drugRoute
	val temporality = obj.temporality
	val frequency = obj.frequency?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val reimbursementReason = obj.reimbursementReason?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val substitutionAllowed = obj.substitutionAllowed
	val beginMoment = longToNumber(obj.beginMoment)
	val endMoment = longToNumber(obj.endMoment)
	val deliveryMoment = longToNumber(obj.deliveryMoment)
	val endExecutionMoment = longToNumber(obj.endExecutionMoment)
	val duration = obj.duration?.let { nonNull1 ->
		duration_toJs(nonNull1)
	}
	val renewal = obj.renewal?.let { nonNull1 ->
		renewal_toJs(nonNull1)
	}
	val knownUsage = obj.knownUsage
	val regimen = listToArray(
		obj.regimen,
		{ x1: RegimenItem ->
			regimenItem_toJs(x1)
		},
	)
	val posology = obj.posology
	val agreements = mapToObject(
		obj.agreements,
		{ x1: String ->
			x1
		},
		{ x1: ParagraphAgreement ->
			paragraphAgreement_toJs(x1)
		},
	)
	val medicationSchemeIdOnSafe = obj.medicationSchemeIdOnSafe
	val medicationSchemeSafeVersion = intToNumber(obj.medicationSchemeSafeVersion)
	val medicationSchemeTimeStampOnSafe = longToNumber(obj.medicationSchemeTimeStampOnSafe)
	val medicationSchemeDocumentId = obj.medicationSchemeDocumentId
	val safeIdName = obj.safeIdName
	val idOnSafes = obj.idOnSafes
	val timestampOnSafe = longToNumber(obj.timestampOnSafe)
	val changeValidated = obj.changeValidated
	val newSafeMedication = obj.newSafeMedication
	val medicationUse = obj.medicationUse
	val beginCondition = obj.beginCondition
	val endCondition = obj.endCondition
	val origin = obj.origin
	val medicationChanged = obj.medicationChanged
	val posologyChanged = obj.posologyChanged
	val suspension = listToArray(
		obj.suspension,
		{ x1: Suspension ->
			suspension_toJs(x1)
		},
	)
	val prescriptionRID = obj.prescriptionRID
	val status = intToNumber(obj.status)
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
