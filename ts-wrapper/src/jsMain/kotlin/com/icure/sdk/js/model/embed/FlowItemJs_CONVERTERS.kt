package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.FlowItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun flowItem_toJs(obj: FlowItem): FlowItemJs {
	val id = obj.id
	val title = obj.title
	val comment = obj.comment
	val receptionDate = longToNumber(obj.receptionDate)
	val processingDate = longToNumber(obj.processingDate)
	val processer = obj.processer
	val cancellationDate = longToNumber(obj.cancellationDate)
	val canceller = obj.canceller
	val cancellationReason = obj.cancellationReason
	val cancellationNote = obj.cancellationNote
	val status = obj.status
	val homeVisit = obj.homeVisit
	val municipality = obj.municipality
	val town = obj.town
	val zipCode = obj.zipCode
	val street = obj.street
	val building = obj.building
	val buildingNumber = obj.buildingNumber
	val doorbellName = obj.doorbellName
	val floor = obj.floor
	val letterBox = obj.letterBox
	val notesOps = obj.notesOps
	val notesContact = obj.notesContact
	val latitude = obj.latitude
	val longitude = obj.longitude
	val type = obj.type
	val emergency = obj.emergency
	val phoneNumber = obj.phoneNumber
	val patientId = obj.patientId
	val patientLastName = obj.patientLastName
	val patientFirstName = obj.patientFirstName
	val description = obj.description
	val interventionCode = obj.interventionCode
	return FlowItemJs(js("{" +
		"id:id," +
		"title:title," +
		"comment:comment," +
		"receptionDate:receptionDate," +
		"processingDate:processingDate," +
		"processer:processer," +
		"cancellationDate:cancellationDate," +
		"canceller:canceller," +
		"cancellationReason:cancellationReason," +
		"cancellationNote:cancellationNote," +
		"status:status," +
		"homeVisit:homeVisit," +
		"municipality:municipality," +
		"town:town," +
		"zipCode:zipCode," +
		"street:street," +
		"building:building," +
		"buildingNumber:buildingNumber," +
		"doorbellName:doorbellName," +
		"floor:floor," +
		"letterBox:letterBox," +
		"notesOps:notesOps," +
		"notesContact:notesContact," +
		"latitude:latitude," +
		"longitude:longitude," +
		"type:type," +
		"emergency:emergency," +
		"phoneNumber:phoneNumber," +
		"patientId:patientId," +
		"patientLastName:patientLastName," +
		"patientFirstName:patientFirstName," +
		"description:description," +
		"interventionCode:interventionCode" +
	"}"))
}

public fun flowItem_fromJs(obj: FlowItemJs): FlowItem {
	val id = obj.id
	val title = obj.title
	val comment = obj.comment
	val receptionDate = numberToLong(obj.receptionDate, "obj.receptionDate")
	val processingDate = numberToLong(obj.processingDate, "obj.processingDate")
	val processer = obj.processer
	val cancellationDate = numberToLong(obj.cancellationDate, "obj.cancellationDate")
	val canceller = obj.canceller
	val cancellationReason = obj.cancellationReason
	val cancellationNote = obj.cancellationNote
	val status = obj.status
	val homeVisit = obj.homeVisit
	val municipality = obj.municipality
	val town = obj.town
	val zipCode = obj.zipCode
	val street = obj.street
	val building = obj.building
	val buildingNumber = obj.buildingNumber
	val doorbellName = obj.doorbellName
	val floor = obj.floor
	val letterBox = obj.letterBox
	val notesOps = obj.notesOps
	val notesContact = obj.notesContact
	val latitude = obj.latitude
	val longitude = obj.longitude
	val type = obj.type
	val emergency = obj.emergency
	val phoneNumber = obj.phoneNumber
	val patientId = obj.patientId
	val patientLastName = obj.patientLastName
	val patientFirstName = obj.patientFirstName
	val description = obj.description
	val interventionCode = obj.interventionCode
	return FlowItem(
		id = id,
		title = title,
		comment = comment,
		receptionDate = receptionDate,
		processingDate = processingDate,
		processer = processer,
		cancellationDate = cancellationDate,
		canceller = canceller,
		cancellationReason = cancellationReason,
		cancellationNote = cancellationNote,
		status = status,
		homeVisit = homeVisit,
		municipality = municipality,
		town = town,
		zipCode = zipCode,
		street = street,
		building = building,
		buildingNumber = buildingNumber,
		doorbellName = doorbellName,
		floor = floor,
		letterBox = letterBox,
		notesOps = notesOps,
		notesContact = notesContact,
		latitude = latitude,
		longitude = longitude,
		type = type,
		emergency = emergency,
		phoneNumber = phoneNumber,
		patientId = patientId,
		patientLastName = patientLastName,
		patientFirstName = patientFirstName,
		description = description,
		interventionCode = interventionCode,
	)
}
