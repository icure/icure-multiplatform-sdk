package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.sdk.model.embed.DecryptedPlanOfAction
import com.icure.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.sdk.model.embed.EncryptedPlanOfAction
import com.icure.sdk.model.embed.PlanOfAction
import kotlin.String

public fun planOfAction_toJs(obj: DecryptedPlanOfAction): DecryptedPlanOfActionJs {
	val id = obj.id
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife)
	val prescriberId = obj.prescriberId
	val valueDate = longToNumber(obj.valueDate)
	val openingDate = longToNumber(obj.openingDate)
	val closingDate = longToNumber(obj.closingDate)
	val deadlineDate = longToNumber(obj.deadlineDate)
	val name = obj.name
	val descr = obj.descr
	val note = obj.note
	val idOpeningContact = obj.idOpeningContact
	val idClosingContact = obj.idClosingContact
	val status = intToNumber(obj.status)
	val documentIds = setToArray(
		obj.documentIds,
		{ x1: String ->
			x1
		},
	)
	val numberOfCares = intToNumber(obj.numberOfCares)
	val careTeamMemberships = listToArray(
		obj.careTeamMemberships,
		{ x1: DecryptedCareTeamMembership? ->
			x1?.let { nonNull2 ->
				careTeamMembership_toJs(nonNull2)
			}
		},
	)
	val relevant = obj.relevant
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedPlanOfActionJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"prescriberId:prescriberId," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"deadlineDate:deadlineDate," +
		"name:name," +
		"descr:descr," +
		"note:note," +
		"idOpeningContact:idOpeningContact," +
		"idClosingContact:idClosingContact," +
		"status:status," +
		"documentIds:documentIds," +
		"numberOfCares:numberOfCares," +
		"careTeamMemberships:careTeamMemberships," +
		"relevant:relevant," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun planOfAction_fromJs(obj: DecryptedPlanOfActionJs): DecryptedPlanOfAction {
	val id = obj.id
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val prescriberId = obj.prescriberId
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val deadlineDate = numberToLong(obj.deadlineDate, "obj.deadlineDate")
	val name = obj.name
	val descr = obj.descr
	val note = obj.note
	val idOpeningContact = obj.idOpeningContact
	val idClosingContact = obj.idClosingContact
	val status = numberToInt(obj.status, "obj.status")
	val documentIds = arrayToSet(
		obj.documentIds,
		"obj.documentIds",
		{ x1: String ->
			x1
		},
	)
	val numberOfCares = numberToInt(obj.numberOfCares, "obj.numberOfCares")
	val careTeamMemberships = arrayToList(
		obj.careTeamMemberships,
		"obj.careTeamMemberships",
		{ x1: DecryptedCareTeamMembershipJs? ->
			x1?.let { nonNull2 ->
				careTeamMembership_fromJs(nonNull2)
			}
		},
	)
	val relevant = obj.relevant
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedPlanOfAction(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		prescriberId = prescriberId,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		deadlineDate = deadlineDate,
		name = name,
		descr = descr,
		note = note,
		idOpeningContact = idOpeningContact,
		idClosingContact = idClosingContact,
		status = status,
		documentIds = documentIds,
		numberOfCares = numberOfCares,
		careTeamMemberships = careTeamMemberships,
		relevant = relevant,
		encryptedSelf = encryptedSelf,
	)
}

public fun planOfAction_toJs(obj: EncryptedPlanOfAction): EncryptedPlanOfActionJs {
	val id = obj.id
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife)
	val prescriberId = obj.prescriberId
	val valueDate = longToNumber(obj.valueDate)
	val openingDate = longToNumber(obj.openingDate)
	val closingDate = longToNumber(obj.closingDate)
	val deadlineDate = longToNumber(obj.deadlineDate)
	val name = obj.name
	val descr = obj.descr
	val note = obj.note
	val idOpeningContact = obj.idOpeningContact
	val idClosingContact = obj.idClosingContact
	val status = intToNumber(obj.status)
	val documentIds = setToArray(
		obj.documentIds,
		{ x1: String ->
			x1
		},
	)
	val numberOfCares = intToNumber(obj.numberOfCares)
	val careTeamMemberships = listToArray(
		obj.careTeamMemberships,
		{ x1: EncryptedCareTeamMembership? ->
			x1?.let { nonNull2 ->
				careTeamMembership_toJs(nonNull2)
			}
		},
	)
	val relevant = obj.relevant
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedPlanOfActionJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"prescriberId:prescriberId," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"deadlineDate:deadlineDate," +
		"name:name," +
		"descr:descr," +
		"note:note," +
		"idOpeningContact:idOpeningContact," +
		"idClosingContact:idClosingContact," +
		"status:status," +
		"documentIds:documentIds," +
		"numberOfCares:numberOfCares," +
		"careTeamMemberships:careTeamMemberships," +
		"relevant:relevant," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun planOfAction_fromJs(obj: EncryptedPlanOfActionJs): EncryptedPlanOfAction {
	val id = obj.id
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val prescriberId = obj.prescriberId
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val deadlineDate = numberToLong(obj.deadlineDate, "obj.deadlineDate")
	val name = obj.name
	val descr = obj.descr
	val note = obj.note
	val idOpeningContact = obj.idOpeningContact
	val idClosingContact = obj.idClosingContact
	val status = numberToInt(obj.status, "obj.status")
	val documentIds = arrayToSet(
		obj.documentIds,
		"obj.documentIds",
		{ x1: String ->
			x1
		},
	)
	val numberOfCares = numberToInt(obj.numberOfCares, "obj.numberOfCares")
	val careTeamMemberships = arrayToList(
		obj.careTeamMemberships,
		"obj.careTeamMemberships",
		{ x1: EncryptedCareTeamMembershipJs? ->
			x1?.let { nonNull2 ->
				careTeamMembership_fromJs(nonNull2)
			}
		},
	)
	val relevant = obj.relevant
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedPlanOfAction(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		prescriberId = prescriberId,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		deadlineDate = deadlineDate,
		name = name,
		descr = descr,
		note = note,
		idOpeningContact = idOpeningContact,
		idClosingContact = idClosingContact,
		status = status,
		documentIds = documentIds,
		numberOfCares = numberOfCares,
		careTeamMemberships = careTeamMemberships,
		relevant = relevant,
		encryptedSelf = encryptedSelf,
	)
}

public fun planOfAction_toJs(obj: PlanOfAction): PlanOfActionJs = when (obj) {
	is EncryptedPlanOfAction -> planOfAction_toJs(obj)
	is DecryptedPlanOfAction -> planOfAction_toJs(obj)
}

public fun planOfAction_fromJs(obj: PlanOfActionJs): PlanOfAction = if (obj.isEncrypted) {
	planOfAction_fromJs(obj as EncryptedPlanOfActionJs)
} else {
	planOfAction_fromJs(obj as DecryptedPlanOfActionJs)
}
