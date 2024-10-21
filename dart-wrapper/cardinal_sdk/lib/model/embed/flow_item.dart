// This file is auto-generated


class FlowItem {
	String? id;
	String? title;
	String? comment;
	int? receptionDate;
	int? processingDate;
	String? processer;
	int? cancellationDate;
	String? canceller;
	String? cancellationReason;
	String? cancellationNote;
	String? status;
	bool? homeVisit;
	String? municipality;
	String? town;
	String? zipCode;
	String? street;
	String? building;
	String? buildingNumber;
	String? doorbellName;
	String? floor;
	String? letterBox;
	String? notesOps;
	String? notesContact;
	String? latitude;
	String? longitude;
	String? type;
	bool? emergency;
	String? phoneNumber;
	String? patientId;
	String? patientLastName;
	String? patientFirstName;
	String? description;
	String? interventionCode;

	FlowItem({
		this.id,
		this.title,
		this.comment,
		this.receptionDate,
		this.processingDate,
		this.processer,
		this.cancellationDate,
		this.canceller,
		this.cancellationReason,
		this.cancellationNote,
		this.status,
		this.homeVisit,
		this.municipality,
		this.town,
		this.zipCode,
		this.street,
		this.building,
		this.buildingNumber,
		this.doorbellName,
		this.floor,
		this.letterBox,
		this.notesOps,
		this.notesContact,
		this.latitude,
		this.longitude,
		this.type,
		this.emergency,
		this.phoneNumber,
		this.patientId,
		this.patientLastName,
		this.patientFirstName,
		this.description,
		this.interventionCode
	});

	static Map<String, dynamic> encode(FlowItem value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"title" : value.title,
			"comment" : value.comment,
			"receptionDate" : value.receptionDate,
			"processingDate" : value.processingDate,
			"processer" : value.processer,
			"cancellationDate" : value.cancellationDate,
			"canceller" : value.canceller,
			"cancellationReason" : value.cancellationReason,
			"cancellationNote" : value.cancellationNote,
			"status" : value.status,
			"homeVisit" : value.homeVisit,
			"municipality" : value.municipality,
			"town" : value.town,
			"zipCode" : value.zipCode,
			"street" : value.street,
			"building" : value.building,
			"buildingNumber" : value.buildingNumber,
			"doorbellName" : value.doorbellName,
			"floor" : value.floor,
			"letterBox" : value.letterBox,
			"notesOps" : value.notesOps,
			"notesContact" : value.notesContact,
			"latitude" : value.latitude,
			"longitude" : value.longitude,
			"type" : value.type,
			"emergency" : value.emergency,
			"phoneNumber" : value.phoneNumber,
			"patientId" : value.patientId,
			"patientLastName" : value.patientLastName,
			"patientFirstName" : value.patientFirstName,
			"description" : value.description,
			"interventionCode" : value.interventionCode
		};
		return entityAsMap;
	}
}