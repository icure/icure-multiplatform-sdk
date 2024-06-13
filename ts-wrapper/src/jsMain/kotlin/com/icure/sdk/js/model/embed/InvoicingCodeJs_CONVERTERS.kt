package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.DecryptedInvoicingCode
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoicingCode
import com.icure.sdk.model.embed.PaymentType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun invoicingCode_toJs(obj: DecryptedInvoicingCode): DecryptedInvoicingCodeJs {
	val id = obj.id ?: undefined
	val dateCode = longToNumber(obj.dateCode) ?: undefined
	val logicalId = obj.logicalId ?: undefined
	val label = obj.label ?: undefined
	val userId = obj.userId ?: undefined
	val contactId = obj.contactId ?: undefined
	val serviceId = obj.serviceId ?: undefined
	val tarificationId = obj.tarificationId ?: undefined
	val code = obj.code ?: undefined
	val paymentType = obj.paymentType?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val paid = obj.paid ?: undefined
	val totalAmount = obj.totalAmount ?: undefined
	val reimbursement = obj.reimbursement ?: undefined
	val patientIntervention = obj.patientIntervention ?: undefined
	val doctorSupplement = obj.doctorSupplement ?: undefined
	val conventionAmount = obj.conventionAmount ?: undefined
	val vat = obj.vat ?: undefined
	val error = obj.error ?: undefined
	val contract = obj.contract ?: undefined
	val contractDate = longToNumber(obj.contractDate) ?: undefined
	val units = intToNumber(obj.units) ?: undefined
	val side = intToNumber(obj.side) ?: undefined
	val timeOfDay = intToNumber(obj.timeOfDay) ?: undefined
	val eidReadingHour = intToNumber(obj.eidReadingHour) ?: undefined
	val eidReadingValue = obj.eidReadingValue ?: undefined
	val override3rdPayerCode = intToNumber(obj.override3rdPayerCode) ?: undefined
	val override3rdPayerReason = obj.override3rdPayerReason ?: undefined
	val transplantationCode = intToNumber(obj.transplantationCode) ?: undefined
	val prescriberNorm = intToNumber(obj.prescriberNorm) ?: undefined
	val percentNorm = intToNumber(obj.percentNorm) ?: undefined
	val prescriberNihii = obj.prescriberNihii ?: undefined
	val relatedCode = obj.relatedCode ?: undefined
	val prescriptionDate = longToNumber(obj.prescriptionDate) ?: undefined
	val derogationMaxNumber = intToNumber(obj.derogationMaxNumber) ?: undefined
	val prescriberSsin = obj.prescriberSsin ?: undefined
	val prescriberLastName = obj.prescriberLastName ?: undefined
	val prescriberFirstName = obj.prescriberFirstName ?: undefined
	val prescriberCdHcParty = obj.prescriberCdHcParty ?: undefined
	val locationNihii = obj.locationNihii ?: undefined
	val locationCdHcParty = obj.locationCdHcParty ?: undefined
	val locationService = intToNumber(obj.locationService) ?: undefined
	val admissionDate = longToNumber(obj.admissionDate) ?: undefined
	val canceled = obj.canceled ?: undefined
	val accepted = obj.accepted ?: undefined
	val pending = obj.pending ?: undefined
	val resent = obj.resent ?: undefined
	val archived = obj.archived ?: undefined
	val lost = obj.lost ?: undefined
	val insuranceJustification = intToNumber(obj.insuranceJustification) ?: undefined
	val cancelPatientInterventionReason = intToNumber(obj.cancelPatientInterventionReason) ?: undefined
	val status = longToNumber(obj.status) ?: undefined
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	} ?: undefined
	return DecryptedInvoicingCodeJs(js("{" +
		"id:id," +
		"dateCode:dateCode," +
		"logicalId:logicalId," +
		"label:label," +
		"userId:userId," +
		"contactId:contactId," +
		"serviceId:serviceId," +
		"tarificationId:tarificationId," +
		"code:code," +
		"paymentType:paymentType," +
		"paid:paid," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"doctorSupplement:doctorSupplement," +
		"conventionAmount:conventionAmount," +
		"vat:vat," +
		"error:error," +
		"contract:contract," +
		"contractDate:contractDate," +
		"units:units," +
		"side:side," +
		"timeOfDay:timeOfDay," +
		"eidReadingHour:eidReadingHour," +
		"eidReadingValue:eidReadingValue," +
		"override3rdPayerCode:override3rdPayerCode," +
		"override3rdPayerReason:override3rdPayerReason," +
		"transplantationCode:transplantationCode," +
		"prescriberNorm:prescriberNorm," +
		"percentNorm:percentNorm," +
		"prescriberNihii:prescriberNihii," +
		"relatedCode:relatedCode," +
		"prescriptionDate:prescriptionDate," +
		"derogationMaxNumber:derogationMaxNumber," +
		"prescriberSsin:prescriberSsin," +
		"prescriberLastName:prescriberLastName," +
		"prescriberFirstName:prescriberFirstName," +
		"prescriberCdHcParty:prescriberCdHcParty," +
		"locationNihii:locationNihii," +
		"locationCdHcParty:locationCdHcParty," +
		"locationService:locationService," +
		"admissionDate:admissionDate," +
		"canceled:canceled," +
		"accepted:accepted," +
		"pending:pending," +
		"resent:resent," +
		"archived:archived," +
		"lost:lost," +
		"insuranceJustification:insuranceJustification," +
		"cancelPatientInterventionReason:cancelPatientInterventionReason," +
		"status:status," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun invoicingCode_fromJs(obj: DecryptedInvoicingCodeJs): DecryptedInvoicingCode {
	val id = obj.id
	val dateCode = numberToLong(obj.dateCode, "obj.dateCode")
	val logicalId = obj.logicalId
	val label = obj.label
	val userId = obj.userId
	val contactId = obj.contactId
	val serviceId = obj.serviceId
	val tarificationId = obj.tarificationId
	val code = obj.code
	val paymentType = obj.paymentType?.let { nonNull1 ->
		PaymentType.valueOf(nonNull1)
	}
	val paid = obj.paid
	val totalAmount = obj.totalAmount
	val reimbursement = obj.reimbursement
	val patientIntervention = obj.patientIntervention
	val doctorSupplement = obj.doctorSupplement
	val conventionAmount = obj.conventionAmount
	val vat = obj.vat
	val error = obj.error
	val contract = obj.contract
	val contractDate = numberToLong(obj.contractDate, "obj.contractDate")
	val units = numberToInt(obj.units, "obj.units")
	val side = numberToInt(obj.side, "obj.side")
	val timeOfDay = numberToInt(obj.timeOfDay, "obj.timeOfDay")
	val eidReadingHour = numberToInt(obj.eidReadingHour, "obj.eidReadingHour")
	val eidReadingValue = obj.eidReadingValue
	val override3rdPayerCode = numberToInt(obj.override3rdPayerCode, "obj.override3rdPayerCode")
	val override3rdPayerReason = obj.override3rdPayerReason
	val transplantationCode = numberToInt(obj.transplantationCode, "obj.transplantationCode")
	val prescriberNorm = numberToInt(obj.prescriberNorm, "obj.prescriberNorm")
	val percentNorm = numberToInt(obj.percentNorm, "obj.percentNorm")
	val prescriberNihii = obj.prescriberNihii
	val relatedCode = obj.relatedCode
	val prescriptionDate = numberToLong(obj.prescriptionDate, "obj.prescriptionDate")
	val derogationMaxNumber = numberToInt(obj.derogationMaxNumber, "obj.derogationMaxNumber")
	val prescriberSsin = obj.prescriberSsin
	val prescriberLastName = obj.prescriberLastName
	val prescriberFirstName = obj.prescriberFirstName
	val prescriberCdHcParty = obj.prescriberCdHcParty
	val locationNihii = obj.locationNihii
	val locationCdHcParty = obj.locationCdHcParty
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val canceled = obj.canceled
	val accepted = obj.accepted
	val pending = obj.pending
	val resent = obj.resent
	val archived = obj.archived
	val lost = obj.lost
	val insuranceJustification = numberToInt(obj.insuranceJustification, "obj.insuranceJustification")
	val cancelPatientInterventionReason = numberToInt(obj.cancelPatientInterventionReason,
			"obj.cancelPatientInterventionReason")
	val status = numberToLong(obj.status, "obj.status")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedInvoicingCode(
		id = id,
		dateCode = dateCode,
		logicalId = logicalId,
		label = label,
		userId = userId,
		contactId = contactId,
		serviceId = serviceId,
		tarificationId = tarificationId,
		code = code,
		paymentType = paymentType,
		paid = paid,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		doctorSupplement = doctorSupplement,
		conventionAmount = conventionAmount,
		vat = vat,
		error = error,
		contract = contract,
		contractDate = contractDate,
		units = units,
		side = side,
		timeOfDay = timeOfDay,
		eidReadingHour = eidReadingHour,
		eidReadingValue = eidReadingValue,
		override3rdPayerCode = override3rdPayerCode,
		override3rdPayerReason = override3rdPayerReason,
		transplantationCode = transplantationCode,
		prescriberNorm = prescriberNorm,
		percentNorm = percentNorm,
		prescriberNihii = prescriberNihii,
		relatedCode = relatedCode,
		prescriptionDate = prescriptionDate,
		derogationMaxNumber = derogationMaxNumber,
		prescriberSsin = prescriberSsin,
		prescriberLastName = prescriberLastName,
		prescriberFirstName = prescriberFirstName,
		prescriberCdHcParty = prescriberCdHcParty,
		locationNihii = locationNihii,
		locationCdHcParty = locationCdHcParty,
		locationService = locationService,
		admissionDate = admissionDate,
		canceled = canceled,
		accepted = accepted,
		pending = pending,
		resent = resent,
		archived = archived,
		lost = lost,
		insuranceJustification = insuranceJustification,
		cancelPatientInterventionReason = cancelPatientInterventionReason,
		status = status,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun invoicingCode_toJs(obj: EncryptedInvoicingCode): EncryptedInvoicingCodeJs {
	val id = obj.id ?: undefined
	val dateCode = longToNumber(obj.dateCode) ?: undefined
	val logicalId = obj.logicalId ?: undefined
	val label = obj.label ?: undefined
	val userId = obj.userId ?: undefined
	val contactId = obj.contactId ?: undefined
	val serviceId = obj.serviceId ?: undefined
	val tarificationId = obj.tarificationId ?: undefined
	val code = obj.code ?: undefined
	val paymentType = obj.paymentType?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val paid = obj.paid ?: undefined
	val totalAmount = obj.totalAmount ?: undefined
	val reimbursement = obj.reimbursement ?: undefined
	val patientIntervention = obj.patientIntervention ?: undefined
	val doctorSupplement = obj.doctorSupplement ?: undefined
	val conventionAmount = obj.conventionAmount ?: undefined
	val vat = obj.vat ?: undefined
	val error = obj.error ?: undefined
	val contract = obj.contract ?: undefined
	val contractDate = longToNumber(obj.contractDate) ?: undefined
	val units = intToNumber(obj.units) ?: undefined
	val side = intToNumber(obj.side) ?: undefined
	val timeOfDay = intToNumber(obj.timeOfDay) ?: undefined
	val eidReadingHour = intToNumber(obj.eidReadingHour) ?: undefined
	val eidReadingValue = obj.eidReadingValue ?: undefined
	val override3rdPayerCode = intToNumber(obj.override3rdPayerCode) ?: undefined
	val override3rdPayerReason = obj.override3rdPayerReason ?: undefined
	val transplantationCode = intToNumber(obj.transplantationCode) ?: undefined
	val prescriberNorm = intToNumber(obj.prescriberNorm) ?: undefined
	val percentNorm = intToNumber(obj.percentNorm) ?: undefined
	val prescriberNihii = obj.prescriberNihii ?: undefined
	val relatedCode = obj.relatedCode ?: undefined
	val prescriptionDate = longToNumber(obj.prescriptionDate) ?: undefined
	val derogationMaxNumber = intToNumber(obj.derogationMaxNumber) ?: undefined
	val prescriberSsin = obj.prescriberSsin ?: undefined
	val prescriberLastName = obj.prescriberLastName ?: undefined
	val prescriberFirstName = obj.prescriberFirstName ?: undefined
	val prescriberCdHcParty = obj.prescriberCdHcParty ?: undefined
	val locationNihii = obj.locationNihii ?: undefined
	val locationCdHcParty = obj.locationCdHcParty ?: undefined
	val locationService = intToNumber(obj.locationService) ?: undefined
	val admissionDate = longToNumber(obj.admissionDate) ?: undefined
	val canceled = obj.canceled ?: undefined
	val accepted = obj.accepted ?: undefined
	val pending = obj.pending ?: undefined
	val resent = obj.resent ?: undefined
	val archived = obj.archived ?: undefined
	val lost = obj.lost ?: undefined
	val insuranceJustification = intToNumber(obj.insuranceJustification) ?: undefined
	val cancelPatientInterventionReason = intToNumber(obj.cancelPatientInterventionReason) ?: undefined
	val status = longToNumber(obj.status) ?: undefined
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	} ?: undefined
	return EncryptedInvoicingCodeJs(js("{" +
		"id:id," +
		"dateCode:dateCode," +
		"logicalId:logicalId," +
		"label:label," +
		"userId:userId," +
		"contactId:contactId," +
		"serviceId:serviceId," +
		"tarificationId:tarificationId," +
		"code:code," +
		"paymentType:paymentType," +
		"paid:paid," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"doctorSupplement:doctorSupplement," +
		"conventionAmount:conventionAmount," +
		"vat:vat," +
		"error:error," +
		"contract:contract," +
		"contractDate:contractDate," +
		"units:units," +
		"side:side," +
		"timeOfDay:timeOfDay," +
		"eidReadingHour:eidReadingHour," +
		"eidReadingValue:eidReadingValue," +
		"override3rdPayerCode:override3rdPayerCode," +
		"override3rdPayerReason:override3rdPayerReason," +
		"transplantationCode:transplantationCode," +
		"prescriberNorm:prescriberNorm," +
		"percentNorm:percentNorm," +
		"prescriberNihii:prescriberNihii," +
		"relatedCode:relatedCode," +
		"prescriptionDate:prescriptionDate," +
		"derogationMaxNumber:derogationMaxNumber," +
		"prescriberSsin:prescriberSsin," +
		"prescriberLastName:prescriberLastName," +
		"prescriberFirstName:prescriberFirstName," +
		"prescriberCdHcParty:prescriberCdHcParty," +
		"locationNihii:locationNihii," +
		"locationCdHcParty:locationCdHcParty," +
		"locationService:locationService," +
		"admissionDate:admissionDate," +
		"canceled:canceled," +
		"accepted:accepted," +
		"pending:pending," +
		"resent:resent," +
		"archived:archived," +
		"lost:lost," +
		"insuranceJustification:insuranceJustification," +
		"cancelPatientInterventionReason:cancelPatientInterventionReason," +
		"status:status," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun invoicingCode_fromJs(obj: EncryptedInvoicingCodeJs): EncryptedInvoicingCode {
	val id = obj.id
	val dateCode = numberToLong(obj.dateCode, "obj.dateCode")
	val logicalId = obj.logicalId
	val label = obj.label
	val userId = obj.userId
	val contactId = obj.contactId
	val serviceId = obj.serviceId
	val tarificationId = obj.tarificationId
	val code = obj.code
	val paymentType = obj.paymentType?.let { nonNull1 ->
		PaymentType.valueOf(nonNull1)
	}
	val paid = obj.paid
	val totalAmount = obj.totalAmount
	val reimbursement = obj.reimbursement
	val patientIntervention = obj.patientIntervention
	val doctorSupplement = obj.doctorSupplement
	val conventionAmount = obj.conventionAmount
	val vat = obj.vat
	val error = obj.error
	val contract = obj.contract
	val contractDate = numberToLong(obj.contractDate, "obj.contractDate")
	val units = numberToInt(obj.units, "obj.units")
	val side = numberToInt(obj.side, "obj.side")
	val timeOfDay = numberToInt(obj.timeOfDay, "obj.timeOfDay")
	val eidReadingHour = numberToInt(obj.eidReadingHour, "obj.eidReadingHour")
	val eidReadingValue = obj.eidReadingValue
	val override3rdPayerCode = numberToInt(obj.override3rdPayerCode, "obj.override3rdPayerCode")
	val override3rdPayerReason = obj.override3rdPayerReason
	val transplantationCode = numberToInt(obj.transplantationCode, "obj.transplantationCode")
	val prescriberNorm = numberToInt(obj.prescriberNorm, "obj.prescriberNorm")
	val percentNorm = numberToInt(obj.percentNorm, "obj.percentNorm")
	val prescriberNihii = obj.prescriberNihii
	val relatedCode = obj.relatedCode
	val prescriptionDate = numberToLong(obj.prescriptionDate, "obj.prescriptionDate")
	val derogationMaxNumber = numberToInt(obj.derogationMaxNumber, "obj.derogationMaxNumber")
	val prescriberSsin = obj.prescriberSsin
	val prescriberLastName = obj.prescriberLastName
	val prescriberFirstName = obj.prescriberFirstName
	val prescriberCdHcParty = obj.prescriberCdHcParty
	val locationNihii = obj.locationNihii
	val locationCdHcParty = obj.locationCdHcParty
	val locationService = numberToInt(obj.locationService, "obj.locationService")
	val admissionDate = numberToLong(obj.admissionDate, "obj.admissionDate")
	val canceled = obj.canceled
	val accepted = obj.accepted
	val pending = obj.pending
	val resent = obj.resent
	val archived = obj.archived
	val lost = obj.lost
	val insuranceJustification = numberToInt(obj.insuranceJustification, "obj.insuranceJustification")
	val cancelPatientInterventionReason = numberToInt(obj.cancelPatientInterventionReason,
			"obj.cancelPatientInterventionReason")
	val status = numberToLong(obj.status, "obj.status")
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedInvoicingCode(
		id = id,
		dateCode = dateCode,
		logicalId = logicalId,
		label = label,
		userId = userId,
		contactId = contactId,
		serviceId = serviceId,
		tarificationId = tarificationId,
		code = code,
		paymentType = paymentType,
		paid = paid,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		doctorSupplement = doctorSupplement,
		conventionAmount = conventionAmount,
		vat = vat,
		error = error,
		contract = contract,
		contractDate = contractDate,
		units = units,
		side = side,
		timeOfDay = timeOfDay,
		eidReadingHour = eidReadingHour,
		eidReadingValue = eidReadingValue,
		override3rdPayerCode = override3rdPayerCode,
		override3rdPayerReason = override3rdPayerReason,
		transplantationCode = transplantationCode,
		prescriberNorm = prescriberNorm,
		percentNorm = percentNorm,
		prescriberNihii = prescriberNihii,
		relatedCode = relatedCode,
		prescriptionDate = prescriptionDate,
		derogationMaxNumber = derogationMaxNumber,
		prescriberSsin = prescriberSsin,
		prescriberLastName = prescriberLastName,
		prescriberFirstName = prescriberFirstName,
		prescriberCdHcParty = prescriberCdHcParty,
		locationNihii = locationNihii,
		locationCdHcParty = locationCdHcParty,
		locationService = locationService,
		admissionDate = admissionDate,
		canceled = canceled,
		accepted = accepted,
		pending = pending,
		resent = resent,
		archived = archived,
		lost = lost,
		insuranceJustification = insuranceJustification,
		cancelPatientInterventionReason = cancelPatientInterventionReason,
		status = status,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun invoicingCode_toJs(obj: InvoicingCode): InvoicingCodeJs = when (obj) {
	is EncryptedInvoicingCode -> invoicingCode_toJs(obj)
	is DecryptedInvoicingCode -> invoicingCode_toJs(obj)
}

public fun invoicingCode_fromJs(obj: InvoicingCodeJs): InvoicingCode = if (obj.isEncrypted) {
	invoicingCode_fromJs(obj as EncryptedInvoicingCodeJs)
} else {
	invoicingCode_fromJs(obj as DecryptedInvoicingCodeJs)
}
