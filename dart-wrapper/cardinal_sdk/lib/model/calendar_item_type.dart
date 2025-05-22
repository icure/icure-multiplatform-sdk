// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "calendar_item_type.freezed.dart";


@freezed
abstract class CalendarItemType with _$CalendarItemType implements StoredDocument {
	const factory CalendarItemType({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? healthcarePartyId,
		@Default(null) String? agendaId,
		@Default(false) bool defaultCalendarItemType,
		@Default(null) String? name,
		@Default(null) String? color,
		@Default(0) int duration,
		@Default(null) String? externalRef,
		@Default(null) String? mikronoId,
		@Default({}) Set<String> docIds,
		@Default({}) Map<String, String> otherInfos,
		@Default({}) Map<String, String> subjectByLanguage,
	}) = _CalendarItemType;


	static Map<String, dynamic> encode(CalendarItemType value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"healthcarePartyId" : value.healthcarePartyId,
			"agendaId" : value.agendaId,
			"defaultCalendarItemType" : value.defaultCalendarItemType,
			"name" : value.name,
			"color" : value.color,
			"duration" : value.duration,
			"externalRef" : value.externalRef,
			"mikronoId" : value.mikronoId,
			"docIds" : value.docIds.map((x0) => x0).toList(),
			"otherInfos" : value.otherInfos.map((k0, v0) => MapEntry(k0, v0)),
			"subjectByLanguage" : value.subjectByLanguage.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}

	static CalendarItemType fromJSON(Map<String, dynamic> data) {
		return CalendarItemType(
			id: (data["id"] as String),
			duration: (data["duration"] as int),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			agendaId: (data["agendaId"] as String?),
			defaultCalendarItemType: (data["defaultCalendarItemType"] as bool),
			name: (data["name"] as String?),
			color: (data["color"] as String?),
			externalRef: (data["externalRef"] as String?),
			mikronoId: (data["mikronoId"] as String?),
			docIds: (data["docIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			otherInfos: (data["otherInfos"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			subjectByLanguage: (data["subjectByLanguage"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
		);
	}
}