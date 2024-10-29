// auto-generated file


class FlowItem {
	String? id = null;
	String? title = null;
	String? comment = null;
	int? receptionDate = null;
	int? processingDate = null;
	String? processer = null;
	int? cancellationDate = null;
	String? canceller = null;
	String? cancellationReason = null;
	String? cancellationNote = null;
	String? status = null;
	bool? homeVisit = null;
	String? municipality = null;
	String? town = null;
	String? zipCode = null;
	String? street = null;
	String? building = null;
	String? buildingNumber = null;
	String? doorbellName = null;
	String? floor = null;
	String? letterBox = null;
	String? notesOps = null;
	String? notesContact = null;
	String? latitude = null;
	String? longitude = null;
	String? type = null;
	bool? emergency = null;
	String? phoneNumber = null;
	String? patientId = null;
	String? patientLastName = null;
	String? patientFirstName = null;
	String? description = null;
	String? interventionCode = null;
	FlowItem({
			String? id,
			String? title,
			String? comment,
			int? receptionDate,
			int? processingDate,
			String? processer,
			int? cancellationDate,
			String? canceller,
			String? cancellationReason,
			String? cancellationNote,
			String? status,
			bool? homeVisit,
			String? municipality,
			String? town,
			String? zipCode,
			String? street,
			String? building,
			String? buildingNumber,
			String? doorbellName,
			String? floor,
			String? letterBox,
			String? notesOps,
			String? notesContact,
			String? latitude,
			String? longitude,
			String? type,
			bool? emergency,
			String? phoneNumber,
			String? patientId,
			String? patientLastName,
			String? patientFirstName,
			String? description,
			String? interventionCode
		}) : id = id ?? null,
		title = title ?? null,
		comment = comment ?? null,
		receptionDate = receptionDate ?? null,
		processingDate = processingDate ?? null,
		processer = processer ?? null,
		cancellationDate = cancellationDate ?? null,
		canceller = canceller ?? null,
		cancellationReason = cancellationReason ?? null,
		cancellationNote = cancellationNote ?? null,
		status = status ?? null,
		homeVisit = homeVisit ?? null,
		municipality = municipality ?? null,
		town = town ?? null,
		zipCode = zipCode ?? null,
		street = street ?? null,
		building = building ?? null,
		buildingNumber = buildingNumber ?? null,
		doorbellName = doorbellName ?? null,
		floor = floor ?? null,
		letterBox = letterBox ?? null,
		notesOps = notesOps ?? null,
		notesContact = notesContact ?? null,
		latitude = latitude ?? null,
		longitude = longitude ?? null,
		type = type ?? null,
		emergency = emergency ?? null,
		phoneNumber = phoneNumber ?? null,
		patientId = patientId ?? null,
		patientLastName = patientLastName ?? null,
		patientFirstName = patientFirstName ?? null,
		description = description ?? null,
		interventionCode = interventionCode ?? null;

	factory FlowItem.fromJSON(Map<String, dynamic> data) {
		return FlowItem(
			id: (data["id"] as String?),
			title: (data["title"] as String?),
			comment: (data["comment"] as String?),
			receptionDate: (data["receptionDate"] as int?),
			processingDate: (data["processingDate"] as int?),
			processer: (data["processer"] as String?),
			cancellationDate: (data["cancellationDate"] as int?),
			canceller: (data["canceller"] as String?),
			cancellationReason: (data["cancellationReason"] as String?),
			cancellationNote: (data["cancellationNote"] as String?),
			status: (data["status"] as String?),
			homeVisit: (data["homeVisit"] as bool?),
			municipality: (data["municipality"] as String?),
			town: (data["town"] as String?),
			zipCode: (data["zipCode"] as String?),
			street: (data["street"] as String?),
			building: (data["building"] as String?),
			buildingNumber: (data["buildingNumber"] as String?),
			doorbellName: (data["doorbellName"] as String?),
			floor: (data["floor"] as String?),
			letterBox: (data["letterBox"] as String?),
			notesOps: (data["notesOps"] as String?),
			notesContact: (data["notesContact"] as String?),
			latitude: (data["latitude"] as String?),
			longitude: (data["longitude"] as String?),
			type: (data["type"] as String?),
			emergency: (data["emergency"] as bool?),
			phoneNumber: (data["phoneNumber"] as String?),
			patientId: (data["patientId"] as String?),
			patientLastName: (data["patientLastName"] as String?),
			patientFirstName: (data["patientFirstName"] as String?),
			description: (data["description"] as String?),
			interventionCode: (data["interventionCode"] as String?)
		);
	}

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