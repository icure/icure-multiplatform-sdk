// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "time_table_hour.freezed.dart";


@freezed
abstract class TimeTableHour with _$TimeTableHour {
	const factory TimeTableHour({
		@Default(null) int? startHour,
		@Default(null) int? endHour,
	}) = _TimeTableHour;


	static Map<String, dynamic> encode(TimeTableHour value) {
		Map<String, dynamic> entityAsMap = {
			"startHour" : value.startHour,
			"endHour" : value.endHour
		};
		return entityAsMap;
	}

	static TimeTableHour fromJSON(Map<String, dynamic> data) {
		return TimeTableHour(
			startHour: (data["startHour"] as int?),
			endHour: (data["endHour"] as int?)
		);
	}
}