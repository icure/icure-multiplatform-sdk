package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.FlowItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun flowItem_toJs(obj: FlowItem): FlowItemJs {
	val id = obj.id ?: undefined
	val title = obj.title ?: undefined
	val comment = obj.comment ?: undefined
	val receptionDate = longToNumber(obj.receptionDate) ?: undefined
	val processingDate = longToNumber(obj.processingDate) ?: undefined
	val processer = obj.processer ?: undefined
	val cancellationDate = longToNumber(obj.cancellationDate) ?: undefined
	val canceller = obj.canceller ?: undefined
	val cancellationReason = obj.cancellationReason ?: undefined
	val cancellationNote = obj.cancellationNote ?: undefined
	val status = obj.status ?: undefined
	val homeVisit = obj.homeVisit ?: undefined
	val municipality = obj.municipality ?: undefined
	val town = obj.town ?: undefined
	val zipCode = obj.zipCode ?: undefined
	val street = obj.street ?: undefined
	val building = obj.building ?: undefined
	val buildingNumber = obj.buildingNumber ?: undefined
	val doorbellName = obj.doorbellName ?: undefined
	val floor = obj.floor ?: undefined
	val letterBox = obj.letterBox ?: undefined
	val notesOps = obj.notesOps ?: undefined
	val notesContact = obj.notesContact ?: undefined
	val latitude = obj.latitude ?: undefined
	val longitude = obj.longitude ?: undefined
	val type = obj.type ?: undefined
	val emergency = obj.emergency ?: undefined
	val phoneNumber = obj.phoneNumber ?: undefined
	val patientId = obj.patientId ?: undefined
	val patientLastName = obj.patientLastName ?: undefined
	val patientFirstName = obj.patientFirstName ?: undefined
	val description = obj.description ?: undefined
	val interventionCode = obj.interventionCode ?: undefined
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
