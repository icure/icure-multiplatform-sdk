package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.embed.CalendarItemTagJs
import com.icure.sdk.js.model.embed.DelegationJs
import com.icure.sdk.js.model.embed.address_fromJs
import com.icure.sdk.js.model.embed.address_toJs
import com.icure.sdk.js.model.embed.calendarItemTag_fromJs
import com.icure.sdk.js.model.embed.calendarItemTag_toJs
import com.icure.sdk.js.model.embed.delegation_fromJs
import com.icure.sdk.js.model.embed.delegation_toJs
import com.icure.sdk.js.model.embed.flowItem_fromJs
import com.icure.sdk.js.model.embed.flowItem_toJs
import com.icure.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.sdk.js.model.embed.securityMetadata_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.DecryptedCalendarItem
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.CalendarItemTag
import com.icure.sdk.model.embed.Delegation
import kotlin.Array
import kotlin.String
import kotlin.collections.Set

public fun calendarItem_toJs(obj: DecryptedCalendarItem): DecryptedCalendarItemJs {
	val id = obj.id
	val rev = obj.rev
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
	val deletionDate = longToNumber(obj.deletionDate)
	val title = obj.title
	val calendarItemTypeId = obj.calendarItemTypeId
	val masterCalendarItemId = obj.masterCalendarItemId
	val patientId = obj.patientId
	val important = obj.important
	val homeVisit = obj.homeVisit
	val phoneNumber = obj.phoneNumber
	val placeId = obj.placeId
	val address = obj.address?.let { nonNull1 ->
		address_toJs(nonNull1)
	}
	val addressText = obj.addressText
	val startTime = longToNumber(obj.startTime)
	val endTime = longToNumber(obj.endTime)
	val confirmationTime = longToNumber(obj.confirmationTime)
	val cancellationTimestamp = longToNumber(obj.cancellationTimestamp)
	val confirmationId = obj.confirmationId
	val duration = longToNumber(obj.duration)
	val allDay = obj.allDay
	val details = obj.details
	val wasMigrated = obj.wasMigrated
	val agendaId = obj.agendaId
	val hcpId = obj.hcpId
	val recurrenceId = obj.recurrenceId
	val meetingTags = setToArray(
		obj.meetingTags,
		{ x1: CalendarItemTag ->
			calendarItemTag_toJs(x1)
		},
	)
	val flowItem = obj.flowItem?.let { nonNull1 ->
		flowItem_toJs(nonNull1)
	}
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return DecryptedCalendarItemJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"title:title," +
		"calendarItemTypeId:calendarItemTypeId," +
		"masterCalendarItemId:masterCalendarItemId," +
		"patientId:patientId," +
		"important:important," +
		"homeVisit:homeVisit," +
		"phoneNumber:phoneNumber," +
		"placeId:placeId," +
		"address:address," +
		"addressText:addressText," +
		"startTime:startTime," +
		"endTime:endTime," +
		"confirmationTime:confirmationTime," +
		"cancellationTimestamp:cancellationTimestamp," +
		"confirmationId:confirmationId," +
		"duration:duration," +
		"allDay:allDay," +
		"details:details," +
		"wasMigrated:wasMigrated," +
		"agendaId:agendaId," +
		"hcpId:hcpId," +
		"recurrenceId:recurrenceId," +
		"meetingTags:meetingTags," +
		"flowItem:flowItem," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun calendarItem_fromJs(obj: DecryptedCalendarItemJs): DecryptedCalendarItem {
	val id = obj.id
	val rev = obj.rev
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val title = obj.title
	val calendarItemTypeId = obj.calendarItemTypeId
	val masterCalendarItemId = obj.masterCalendarItemId
	val patientId = obj.patientId
	val important = obj.important
	val homeVisit = obj.homeVisit
	val phoneNumber = obj.phoneNumber
	val placeId = obj.placeId
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	val addressText = obj.addressText
	val startTime = numberToLong(obj.startTime, "obj.startTime")
	val endTime = numberToLong(obj.endTime, "obj.endTime")
	val confirmationTime = numberToLong(obj.confirmationTime, "obj.confirmationTime")
	val cancellationTimestamp = numberToLong(obj.cancellationTimestamp, "obj.cancellationTimestamp")
	val confirmationId = obj.confirmationId
	val duration = numberToLong(obj.duration, "obj.duration")
	val allDay = obj.allDay
	val details = obj.details
	val wasMigrated = obj.wasMigrated
	val agendaId = obj.agendaId
	val hcpId = obj.hcpId
	val recurrenceId = obj.recurrenceId
	val meetingTags = arrayToSet(
		obj.meetingTags,
		"obj.meetingTags",
		{ x1: CalendarItemTagJs ->
			calendarItemTag_fromJs(x1)
		},
	)
	val flowItem = obj.flowItem?.let { nonNull1 ->
		flowItem_fromJs(nonNull1)
	}
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedCalendarItem(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		title = title,
		calendarItemTypeId = calendarItemTypeId,
		masterCalendarItemId = masterCalendarItemId,
		patientId = patientId,
		important = important,
		homeVisit = homeVisit,
		phoneNumber = phoneNumber,
		placeId = placeId,
		address = address,
		addressText = addressText,
		startTime = startTime,
		endTime = endTime,
		confirmationTime = confirmationTime,
		cancellationTimestamp = cancellationTimestamp,
		confirmationId = confirmationId,
		duration = duration,
		allDay = allDay,
		details = details,
		wasMigrated = wasMigrated,
		agendaId = agendaId,
		hcpId = hcpId,
		recurrenceId = recurrenceId,
		meetingTags = meetingTags,
		flowItem = flowItem,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun calendarItem_toJs(obj: EncryptedCalendarItem): EncryptedCalendarItemJs {
	val id = obj.id
	val rev = obj.rev
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
	val deletionDate = longToNumber(obj.deletionDate)
	val title = obj.title
	val calendarItemTypeId = obj.calendarItemTypeId
	val masterCalendarItemId = obj.masterCalendarItemId
	val patientId = obj.patientId
	val important = obj.important
	val homeVisit = obj.homeVisit
	val phoneNumber = obj.phoneNumber
	val placeId = obj.placeId
	val address = obj.address?.let { nonNull1 ->
		address_toJs(nonNull1)
	}
	val addressText = obj.addressText
	val startTime = longToNumber(obj.startTime)
	val endTime = longToNumber(obj.endTime)
	val confirmationTime = longToNumber(obj.confirmationTime)
	val cancellationTimestamp = longToNumber(obj.cancellationTimestamp)
	val confirmationId = obj.confirmationId
	val duration = longToNumber(obj.duration)
	val allDay = obj.allDay
	val details = obj.details
	val wasMigrated = obj.wasMigrated
	val agendaId = obj.agendaId
	val hcpId = obj.hcpId
	val recurrenceId = obj.recurrenceId
	val meetingTags = setToArray(
		obj.meetingTags,
		{ x1: CalendarItemTag ->
			calendarItemTag_toJs(x1)
		},
	)
	val flowItem = obj.flowItem?.let { nonNull1 ->
		flowItem_toJs(nonNull1)
	}
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	return EncryptedCalendarItemJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"title:title," +
		"calendarItemTypeId:calendarItemTypeId," +
		"masterCalendarItemId:masterCalendarItemId," +
		"patientId:patientId," +
		"important:important," +
		"homeVisit:homeVisit," +
		"phoneNumber:phoneNumber," +
		"placeId:placeId," +
		"address:address," +
		"addressText:addressText," +
		"startTime:startTime," +
		"endTime:endTime," +
		"confirmationTime:confirmationTime," +
		"cancellationTimestamp:cancellationTimestamp," +
		"confirmationId:confirmationId," +
		"duration:duration," +
		"allDay:allDay," +
		"details:details," +
		"wasMigrated:wasMigrated," +
		"agendaId:agendaId," +
		"hcpId:hcpId," +
		"recurrenceId:recurrenceId," +
		"meetingTags:meetingTags," +
		"flowItem:flowItem," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun calendarItem_fromJs(obj: EncryptedCalendarItemJs): EncryptedCalendarItem {
	val id = obj.id
	val rev = obj.rev
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val title = obj.title
	val calendarItemTypeId = obj.calendarItemTypeId
	val masterCalendarItemId = obj.masterCalendarItemId
	val patientId = obj.patientId
	val important = obj.important
	val homeVisit = obj.homeVisit
	val phoneNumber = obj.phoneNumber
	val placeId = obj.placeId
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	val addressText = obj.addressText
	val startTime = numberToLong(obj.startTime, "obj.startTime")
	val endTime = numberToLong(obj.endTime, "obj.endTime")
	val confirmationTime = numberToLong(obj.confirmationTime, "obj.confirmationTime")
	val cancellationTimestamp = numberToLong(obj.cancellationTimestamp, "obj.cancellationTimestamp")
	val confirmationId = obj.confirmationId
	val duration = numberToLong(obj.duration, "obj.duration")
	val allDay = obj.allDay
	val details = obj.details
	val wasMigrated = obj.wasMigrated
	val agendaId = obj.agendaId
	val hcpId = obj.hcpId
	val recurrenceId = obj.recurrenceId
	val meetingTags = arrayToSet(
		obj.meetingTags,
		"obj.meetingTags",
		{ x1: CalendarItemTagJs ->
			calendarItemTag_fromJs(x1)
		},
	)
	val flowItem = obj.flowItem?.let { nonNull1 ->
		flowItem_fromJs(nonNull1)
	}
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedCalendarItem(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		title = title,
		calendarItemTypeId = calendarItemTypeId,
		masterCalendarItemId = masterCalendarItemId,
		patientId = patientId,
		important = important,
		homeVisit = homeVisit,
		phoneNumber = phoneNumber,
		placeId = placeId,
		address = address,
		addressText = addressText,
		startTime = startTime,
		endTime = endTime,
		confirmationTime = confirmationTime,
		cancellationTimestamp = cancellationTimestamp,
		confirmationId = confirmationId,
		duration = duration,
		allDay = allDay,
		details = details,
		wasMigrated = wasMigrated,
		agendaId = agendaId,
		hcpId = hcpId,
		recurrenceId = recurrenceId,
		meetingTags = meetingTags,
		flowItem = flowItem,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

public fun calendarItem_toJs(obj: CalendarItem): CalendarItemJs = when (obj) {
	is EncryptedCalendarItem -> calendarItem_toJs(obj)
	is DecryptedCalendarItem -> calendarItem_toJs(obj)
}

public fun calendarItem_fromJs(obj: CalendarItemJs): CalendarItem = if (obj.isEncrypted) {
	calendarItem_fromJs(obj as EncryptedCalendarItemJs)
} else {
	calendarItem_fromJs(obj as DecryptedCalendarItemJs)
}
