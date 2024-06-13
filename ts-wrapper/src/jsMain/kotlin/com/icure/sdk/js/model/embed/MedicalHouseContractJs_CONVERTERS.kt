package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.ContractChangeType
import com.icure.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.sdk.model.embed.MedicalHouseContract
import com.icure.sdk.model.embed.MhcSignatureType
import com.icure.sdk.model.embed.SuspensionReason
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun medicalHouseContract_toJs(obj: DecryptedMedicalHouseContract):
		DecryptedMedicalHouseContractJs {
	val contractId = obj.contractId ?: undefined
	val validFrom = longToNumber(obj.validFrom) ?: undefined
	val validTo = longToNumber(obj.validTo) ?: undefined
	val mmNihii = obj.mmNihii ?: undefined
	val hcpId = obj.hcpId ?: undefined
	val changeType = obj.changeType?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val parentContractId = obj.parentContractId ?: undefined
	val changedBy = obj.changedBy ?: undefined
	val startOfContract = longToNumber(obj.startOfContract) ?: undefined
	val startOfCoverage = longToNumber(obj.startOfCoverage) ?: undefined
	val endOfContract = longToNumber(obj.endOfContract) ?: undefined
	val endOfCoverage = longToNumber(obj.endOfCoverage) ?: undefined
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = intToNumber(obj.unsubscriptionReasonId) ?: undefined
	val ptdStart = longToNumber(obj.ptdStart) ?: undefined
	val ptdEnd = longToNumber(obj.ptdEnd) ?: undefined
	val ptdLastInvoiced = longToNumber(obj.ptdLastInvoiced) ?: undefined
	val startOfSuspension = longToNumber(obj.startOfSuspension) ?: undefined
	val endOfSuspension = longToNumber(obj.endOfSuspension) ?: undefined
	val suspensionReason = obj.suspensionReason?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val suspensionSource = obj.suspensionSource ?: undefined
	val forcedSuspension = obj.forcedSuspension
	val signatureType = obj.signatureType?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val status = intToNumber(obj.status) ?: undefined
	val options = mapToObject(
		obj.options,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val receipts = mapToObject(
		obj.receipts,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	} ?: undefined
	return DecryptedMedicalHouseContractJs(js("{" +
		"contractId:contractId," +
		"validFrom:validFrom," +
		"validTo:validTo," +
		"mmNihii:mmNihii," +
		"hcpId:hcpId," +
		"changeType:changeType," +
		"parentContractId:parentContractId," +
		"changedBy:changedBy," +
		"startOfContract:startOfContract," +
		"startOfCoverage:startOfCoverage," +
		"endOfContract:endOfContract," +
		"endOfCoverage:endOfCoverage," +
		"kine:kine," +
		"gp:gp," +
		"ptd:ptd," +
		"nurse:nurse," +
		"noKine:noKine," +
		"noGp:noGp," +
		"noNurse:noNurse," +
		"unsubscriptionReasonId:unsubscriptionReasonId," +
		"ptdStart:ptdStart," +
		"ptdEnd:ptdEnd," +
		"ptdLastInvoiced:ptdLastInvoiced," +
		"startOfSuspension:startOfSuspension," +
		"endOfSuspension:endOfSuspension," +
		"suspensionReason:suspensionReason," +
		"suspensionSource:suspensionSource," +
		"forcedSuspension:forcedSuspension," +
		"signatureType:signatureType," +
		"status:status," +
		"options:options," +
		"receipts:receipts," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun medicalHouseContract_fromJs(obj: DecryptedMedicalHouseContractJs):
		DecryptedMedicalHouseContract {
	val contractId = obj.contractId
	val validFrom = numberToLong(obj.validFrom, "obj.validFrom")
	val validTo = numberToLong(obj.validTo, "obj.validTo")
	val mmNihii = obj.mmNihii
	val hcpId = obj.hcpId
	val changeType = obj.changeType?.let { nonNull1 ->
		ContractChangeType.valueOf(nonNull1)
	}
	val parentContractId = obj.parentContractId
	val changedBy = obj.changedBy
	val startOfContract = numberToLong(obj.startOfContract, "obj.startOfContract")
	val startOfCoverage = numberToLong(obj.startOfCoverage, "obj.startOfCoverage")
	val endOfContract = numberToLong(obj.endOfContract, "obj.endOfContract")
	val endOfCoverage = numberToLong(obj.endOfCoverage, "obj.endOfCoverage")
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = numberToInt(obj.unsubscriptionReasonId, "obj.unsubscriptionReasonId")
	val ptdStart = numberToLong(obj.ptdStart, "obj.ptdStart")
	val ptdEnd = numberToLong(obj.ptdEnd, "obj.ptdEnd")
	val ptdLastInvoiced = numberToLong(obj.ptdLastInvoiced, "obj.ptdLastInvoiced")
	val startOfSuspension = numberToLong(obj.startOfSuspension, "obj.startOfSuspension")
	val endOfSuspension = numberToLong(obj.endOfSuspension, "obj.endOfSuspension")
	val suspensionReason = obj.suspensionReason?.let { nonNull1 ->
		SuspensionReason.valueOf(nonNull1)
	}
	val suspensionSource = obj.suspensionSource
	val forcedSuspension = obj.forcedSuspension
	val signatureType = obj.signatureType?.let { nonNull1 ->
		MhcSignatureType.valueOf(nonNull1)
	}
	val status = numberToInt(obj.status, "obj.status")
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
	val receipts = objectToMap(
		obj.receipts,
		"obj.receipts",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedMedicalHouseContract(
		contractId = contractId,
		validFrom = validFrom,
		validTo = validTo,
		mmNihii = mmNihii,
		hcpId = hcpId,
		changeType = changeType,
		parentContractId = parentContractId,
		changedBy = changedBy,
		startOfContract = startOfContract,
		startOfCoverage = startOfCoverage,
		endOfContract = endOfContract,
		endOfCoverage = endOfCoverage,
		kine = kine,
		gp = gp,
		ptd = ptd,
		nurse = nurse,
		noKine = noKine,
		noGp = noGp,
		noNurse = noNurse,
		unsubscriptionReasonId = unsubscriptionReasonId,
		ptdStart = ptdStart,
		ptdEnd = ptdEnd,
		ptdLastInvoiced = ptdLastInvoiced,
		startOfSuspension = startOfSuspension,
		endOfSuspension = endOfSuspension,
		suspensionReason = suspensionReason,
		suspensionSource = suspensionSource,
		forcedSuspension = forcedSuspension,
		signatureType = signatureType,
		status = status,
		options = options,
		receipts = receipts,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun medicalHouseContract_toJs(obj: EncryptedMedicalHouseContract):
		EncryptedMedicalHouseContractJs {
	val contractId = obj.contractId ?: undefined
	val validFrom = longToNumber(obj.validFrom) ?: undefined
	val validTo = longToNumber(obj.validTo) ?: undefined
	val mmNihii = obj.mmNihii ?: undefined
	val hcpId = obj.hcpId ?: undefined
	val changeType = obj.changeType?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val parentContractId = obj.parentContractId ?: undefined
	val changedBy = obj.changedBy ?: undefined
	val startOfContract = longToNumber(obj.startOfContract) ?: undefined
	val startOfCoverage = longToNumber(obj.startOfCoverage) ?: undefined
	val endOfContract = longToNumber(obj.endOfContract) ?: undefined
	val endOfCoverage = longToNumber(obj.endOfCoverage) ?: undefined
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = intToNumber(obj.unsubscriptionReasonId) ?: undefined
	val ptdStart = longToNumber(obj.ptdStart) ?: undefined
	val ptdEnd = longToNumber(obj.ptdEnd) ?: undefined
	val ptdLastInvoiced = longToNumber(obj.ptdLastInvoiced) ?: undefined
	val startOfSuspension = longToNumber(obj.startOfSuspension) ?: undefined
	val endOfSuspension = longToNumber(obj.endOfSuspension) ?: undefined
	val suspensionReason = obj.suspensionReason?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val suspensionSource = obj.suspensionSource ?: undefined
	val forcedSuspension = obj.forcedSuspension
	val signatureType = obj.signatureType?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val status = intToNumber(obj.status) ?: undefined
	val options = mapToObject(
		obj.options,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val receipts = mapToObject(
		obj.receipts,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	} ?: undefined
	return EncryptedMedicalHouseContractJs(js("{" +
		"contractId:contractId," +
		"validFrom:validFrom," +
		"validTo:validTo," +
		"mmNihii:mmNihii," +
		"hcpId:hcpId," +
		"changeType:changeType," +
		"parentContractId:parentContractId," +
		"changedBy:changedBy," +
		"startOfContract:startOfContract," +
		"startOfCoverage:startOfCoverage," +
		"endOfContract:endOfContract," +
		"endOfCoverage:endOfCoverage," +
		"kine:kine," +
		"gp:gp," +
		"ptd:ptd," +
		"nurse:nurse," +
		"noKine:noKine," +
		"noGp:noGp," +
		"noNurse:noNurse," +
		"unsubscriptionReasonId:unsubscriptionReasonId," +
		"ptdStart:ptdStart," +
		"ptdEnd:ptdEnd," +
		"ptdLastInvoiced:ptdLastInvoiced," +
		"startOfSuspension:startOfSuspension," +
		"endOfSuspension:endOfSuspension," +
		"suspensionReason:suspensionReason," +
		"suspensionSource:suspensionSource," +
		"forcedSuspension:forcedSuspension," +
		"signatureType:signatureType," +
		"status:status," +
		"options:options," +
		"receipts:receipts," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun medicalHouseContract_fromJs(obj: EncryptedMedicalHouseContractJs):
		EncryptedMedicalHouseContract {
	val contractId = obj.contractId
	val validFrom = numberToLong(obj.validFrom, "obj.validFrom")
	val validTo = numberToLong(obj.validTo, "obj.validTo")
	val mmNihii = obj.mmNihii
	val hcpId = obj.hcpId
	val changeType = obj.changeType?.let { nonNull1 ->
		ContractChangeType.valueOf(nonNull1)
	}
	val parentContractId = obj.parentContractId
	val changedBy = obj.changedBy
	val startOfContract = numberToLong(obj.startOfContract, "obj.startOfContract")
	val startOfCoverage = numberToLong(obj.startOfCoverage, "obj.startOfCoverage")
	val endOfContract = numberToLong(obj.endOfContract, "obj.endOfContract")
	val endOfCoverage = numberToLong(obj.endOfCoverage, "obj.endOfCoverage")
	val kine = obj.kine
	val gp = obj.gp
	val ptd = obj.ptd
	val nurse = obj.nurse
	val noKine = obj.noKine
	val noGp = obj.noGp
	val noNurse = obj.noNurse
	val unsubscriptionReasonId = numberToInt(obj.unsubscriptionReasonId, "obj.unsubscriptionReasonId")
	val ptdStart = numberToLong(obj.ptdStart, "obj.ptdStart")
	val ptdEnd = numberToLong(obj.ptdEnd, "obj.ptdEnd")
	val ptdLastInvoiced = numberToLong(obj.ptdLastInvoiced, "obj.ptdLastInvoiced")
	val startOfSuspension = numberToLong(obj.startOfSuspension, "obj.startOfSuspension")
	val endOfSuspension = numberToLong(obj.endOfSuspension, "obj.endOfSuspension")
	val suspensionReason = obj.suspensionReason?.let { nonNull1 ->
		SuspensionReason.valueOf(nonNull1)
	}
	val suspensionSource = obj.suspensionSource
	val forcedSuspension = obj.forcedSuspension
	val signatureType = obj.signatureType?.let { nonNull1 ->
		MhcSignatureType.valueOf(nonNull1)
	}
	val status = numberToInt(obj.status, "obj.status")
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
	val receipts = objectToMap(
		obj.receipts,
		"obj.receipts",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedMedicalHouseContract(
		contractId = contractId,
		validFrom = validFrom,
		validTo = validTo,
		mmNihii = mmNihii,
		hcpId = hcpId,
		changeType = changeType,
		parentContractId = parentContractId,
		changedBy = changedBy,
		startOfContract = startOfContract,
		startOfCoverage = startOfCoverage,
		endOfContract = endOfContract,
		endOfCoverage = endOfCoverage,
		kine = kine,
		gp = gp,
		ptd = ptd,
		nurse = nurse,
		noKine = noKine,
		noGp = noGp,
		noNurse = noNurse,
		unsubscriptionReasonId = unsubscriptionReasonId,
		ptdStart = ptdStart,
		ptdEnd = ptdEnd,
		ptdLastInvoiced = ptdLastInvoiced,
		startOfSuspension = startOfSuspension,
		endOfSuspension = endOfSuspension,
		suspensionReason = suspensionReason,
		suspensionSource = suspensionSource,
		forcedSuspension = forcedSuspension,
		signatureType = signatureType,
		status = status,
		options = options,
		receipts = receipts,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun medicalHouseContract_toJs(obj: MedicalHouseContract): MedicalHouseContractJs = when (obj)
		{
	is EncryptedMedicalHouseContract -> medicalHouseContract_toJs(obj)
	is DecryptedMedicalHouseContract -> medicalHouseContract_toJs(obj)
}

public fun medicalHouseContract_fromJs(obj: MedicalHouseContractJs): MedicalHouseContract = if
		(obj.isEncrypted) {
	medicalHouseContract_fromJs(obj as EncryptedMedicalHouseContractJs)
} else {
	medicalHouseContract_fromJs(obj as DecryptedMedicalHouseContractJs)
}
