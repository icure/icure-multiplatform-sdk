// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "flow_item.freezed.dart";


@freezed
abstract class FlowItem with _$FlowItem {
	const factory FlowItem({
		@Default(null) String? id,
		@Default(null) String? title,
		@Default(null) String? comment,
		@Default(null) int? receptionDate,
		@Default(null) int? processingDate,
		@Default(null) String? processer,
		@Default(null) int? cancellationDate,
		@Default(null) String? canceller,
		@Default(null) String? cancellationReason,
		@Default(null) String? cancellationNote,
		@Default(null) String? status,
		@Default(null) bool? homeVisit,
		@Default(null) String? municipality,
		@Default(null) String? town,
		@Default(null) String? zipCode,
		@Default(null) String? street,
		@Default(null) String? building,
		@Default(null) String? buildingNumber,
		@Default(null) String? doorbellName,
		@Default(null) String? floor,
		@Default(null) String? letterBox,
		@Default(null) String? notesOps,
		@Default(null) String? notesContact,
		@Default(null) String? latitude,
		@Default(null) String? longitude,
		@Default(null) String? type,
		@Default(null) bool? emergency,
		@Default(null) String? phoneNumber,
		@Default(null) String? patientId,
		@Default(null) String? patientLastName,
		@Default(null) String? patientFirstName,
		@Default(null) String? description,
		@Default(null) String? interventionCode,
	}) = _FlowItem;


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

	static FlowItem fromJSON(Map<String, dynamic> data) {
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
}