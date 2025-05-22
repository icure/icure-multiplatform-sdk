// auto-generated file
import 'package:cardinal_sdk/model/embed/time_table_hour.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "time_table_item.freezed.dart";


@freezed
abstract class TimeTableItem with _$TimeTableItem {
	const factory TimeTableItem({
		@Default(null) int? rruleStartDate,
		@Default(null) String? rrule,
		@Default(null) int? notBeforeInMinutes,
		@Default(null) int? notAfterInMinutes,
		@Default(null) String? zoneId,
		@Default([]) List<String> days,
		@Default([]) List<String> recurrenceTypes,
		@Default([]) List<TimeTableHour> hours,
		@Default(null) String? calendarItemTypeId,
		@Default(false) bool homeVisit,
		@Default(null) String? placeId,
		@Default(false) bool publicTimeTableItem,
		@Default(true) bool acceptsNewPatient,
		@Default(false) bool unavailable,
		@Default({}) Set<String> reservingRights,
	}) = _TimeTableItem;


	static Map<String, dynamic> encode(TimeTableItem value) {
		Map<String, dynamic> entityAsMap = {
			"rruleStartDate" : value.rruleStartDate,
			"rrule" : value.rrule,
			"notBeforeInMinutes" : value.notBeforeInMinutes,
			"notAfterInMinutes" : value.notAfterInMinutes,
			"zoneId" : value.zoneId,
			"days" : value.days.map((x0) => x0).toList(),
			"recurrenceTypes" : value.recurrenceTypes.map((x0) => x0).toList(),
			"hours" : value.hours.map((x0) => TimeTableHour.encode(x0)).toList(),
			"calendarItemTypeId" : value.calendarItemTypeId,
			"homeVisit" : value.homeVisit,
			"placeId" : value.placeId,
			"publicTimeTableItem" : value.publicTimeTableItem,
			"acceptsNewPatient" : value.acceptsNewPatient,
			"unavailable" : value.unavailable,
			"reservingRights" : value.reservingRights.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static TimeTableItem fromJSON(Map<String, dynamic> data) {
		return TimeTableItem(
			notBeforeInMinutes: (data["notBeforeInMinutes"] as int?),
			notAfterInMinutes: (data["notAfterInMinutes"] as int?),
			rruleStartDate: (data["rruleStartDate"] as int?),
			rrule: (data["rrule"] as String?),
			zoneId: (data["zoneId"] as String?),
			days: (data["days"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			recurrenceTypes: (data["recurrenceTypes"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			hours: (data["hours"] as List<dynamic>).map((x0) => TimeTableHour.fromJSON(x0) ).toList(),
			calendarItemTypeId: (data["calendarItemTypeId"] as String?),
			homeVisit: (data["homeVisit"] as bool),
			placeId: (data["placeId"] as String?),
			publicTimeTableItem: (data["publicTimeTableItem"] as bool),
			acceptsNewPatient: (data["acceptsNewPatient"] as bool),
			unavailable: (data["unavailable"] as bool),
			reservingRights: (data["reservingRights"] as List<dynamic>).map((x0) => (x0 as String) ).toSet()
		);
	}
}