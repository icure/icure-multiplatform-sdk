// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/time_table_item.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "embedded_time_table.freezed.dart";


@freezed
abstract class EmbeddedTimeTable with _$EmbeddedTimeTable {
	const factory EmbeddedTimeTable({
		required String id,
		@Default({}) Set<CodeStub> codes,
		@Default(null) String? medicalLocationId,
		@Default(null) int? endOfLife,
		@Default(null) String? name,
		@Default(null) int? startTime,
		@Default(null) int? endTime,
		@Default([]) List<TimeTableItem> items,
	}) = _EmbeddedTimeTable;


	static Map<String, dynamic> encode(EmbeddedTimeTable value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"medicalLocationId" : value.medicalLocationId,
			"endOfLife" : value.endOfLife,
			"name" : value.name,
			"startTime" : value.startTime,
			"endTime" : value.endTime,
			"items" : value.items.map((x0) => TimeTableItem.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static EmbeddedTimeTable fromJSON(Map<String, dynamic> data) {
		return EmbeddedTimeTable(
			id: (data["id"] as String),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			medicalLocationId: (data["medicalLocationId"] as String?),
			endOfLife: (data["endOfLife"] as int?),
			name: (data["name"] as String?),
			startTime: (data["startTime"] as int?),
			endTime: (data["endTime"] as int?),
			items: (data["items"] as List<dynamic>).map((x0) => TimeTableItem.fromJSON(x0) ).toList(),
		);
	}
}