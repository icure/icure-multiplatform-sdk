// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/time_table_hour.dart';


class TimeTableItem {
	int? rruleStartDate;
	String? rrule;
	int? _notBeforeInMinutes;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get notBeforeInMinutes => _notBeforeInMinutes;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set notBeforeInMinutes(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('notBeforeInMinutes value cannot exceed 2147483647');
		}
		_notBeforeInMinutes = value;
	}
	int? _notAfterInMinutes;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get notAfterInMinutes => _notAfterInMinutes;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set notAfterInMinutes(int? value) {
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
			notBeforeInMinutes: data["notBeforeInMinutes"],
			notAfterInMinutes: data["notAfterInMinutes"],
			rruleStartDate: data["rruleStartDate"],
			rrule: data["rrule"],
			zoneId: data["zoneId"],
			days: data["days"].map((x0) => x0 ),
			recurrenceTypes: data["recurrenceTypes"].map((x0) => x0 ),
			hours: data["hours"].map((x0) => TimeTableHour.fromJSON(x0) ),
			calendarItemTypeId: data["calendarItemTypeId"],
			homeVisit: data["homeVisit"],
			placeId: data["placeId"],
			publicTimeTableItem: data["publicTimeTableItem"],
			acceptsNewPatient: data["acceptsNewPatient"],
			unavailable: data["unavailable"]
		);
	}

	static Map<String, dynamic> encode(TimeTableItem value) {
		Map<String, dynamic> entityAsMap = {
			"rruleStartDate" : value.rruleStartDate,
			"rrule" : value.rrule,
			"notBeforeInMinutes" : value.notBeforeInMinutes,
			"notAfterInMinutes" : value.notAfterInMinutes,
			"zoneId" : value.zoneId,
			"days" : value.days.map((x0) => x0),
			"recurrenceTypes" : value.recurrenceTypes.map((x0) => x0),
			"hours" : value.hours.map((x0) => TimeTableHour.encode(x0)),
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