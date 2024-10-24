// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/time_table_hour.dart';


class TimeTableItem {
	int? rruleStartDate;
	String? rrule;
	int? _notBeforeInMinutes;
	@ActualInt32() int? get notBeforeInMinutes => _notBeforeInMinutes;
	@ActualInt32() set notBeforeInMinutes(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('notBeforeInMinutes value cannot exceed 2147483647');
		}
		_notBeforeInMinutes = value;
	}
	int? _notAfterInMinutes;
	@ActualInt32() int? get notAfterInMinutes => _notAfterInMinutes;
	@ActualInt32() set notAfterInMinutes(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('notAfterInMinutes value cannot exceed 2147483647');
		}
		_notAfterInMinutes = value;
	}
	String? zoneId;
	@Deprecated('Will be replaced by rrule') List<String> days = [];
	@Deprecated('Will be replaced by rrule') List<String> recurrenceTypes = [];
	List<TimeTableHour> hours = [];
	String? calendarItemTypeId;
	bool homeVisit = false;
	String? placeId;
	bool publicTimeTableItem = false;
	bool acceptsNewPatient = true;
	bool unavailable = false;
	TimeTableItem({
			int? notBeforeInMinutes,
			int? notAfterInMinutes,
			this.rruleStartDate,
			this.rrule,
			this.zoneId,
			this.calendarItemTypeId,
			this.placeId,
			List<String>? days,
			List<String>? recurrenceTypes,
			List<TimeTableHour>? hours,
			bool? homeVisit,
			bool? publicTimeTableItem,
			bool? acceptsNewPatient,
			bool? unavailable
		}) : days = days ?? [],
		recurrenceTypes = recurrenceTypes ?? [],
		hours = hours ?? [],
		homeVisit = homeVisit ?? false,
		publicTimeTableItem = publicTimeTableItem ?? false,
		acceptsNewPatient = acceptsNewPatient ?? true,
		unavailable = unavailable ?? false,
		_notBeforeInMinutes = notBeforeInMinutes,
		_notAfterInMinutes = notAfterInMinutes;

	factory TimeTableItem.fromJSON(Map<String, dynamic> data) {
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
			unavailable: (data["unavailable"] as bool)
		);
	}

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
			"unavailable" : value.unavailable
		};
		return entityAsMap;
	}
}