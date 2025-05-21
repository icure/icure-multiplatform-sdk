// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/time_table_item.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "time_table.freezed.dart";


@freezed
abstract class TimeTable with _$TimeTable implements StoredDocument, ICureDocument<String> {
	const factory TimeTable({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? name,
		@Default(null) String? agendaId,
		@Default(null) int? startTime,
		@Default(null) int? endTime,
		@Default([]) List<TimeTableItem> items,
	}) = _TimeTable;


	static Map<String, dynamic> encode(TimeTable value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"agendaId" : value.agendaId,
			"startTime" : value.startTime,
			"endTime" : value.endTime,
			"items" : value.items.map((x0) => TimeTableItem.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static TimeTable fromJSON(Map<String, dynamic> data) {
		return TimeTable(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			agendaId: (data["agendaId"] as String?),
			startTime: (data["startTime"] as int?),
			endTime: (data["endTime"] as int?),
			items: (data["items"] as List<dynamic>).map((x0) => TimeTableItem.fromJSON(x0) ).toList(),
		);
	}
}