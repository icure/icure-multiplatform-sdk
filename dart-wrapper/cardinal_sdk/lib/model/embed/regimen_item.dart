// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/weekday.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/administration_quantity.dart';


class RegimenItem {
	int? date = null;
	int? _dayNumber = null;
	@ActualInt32() int? get dayNumber => _dayNumber;
	@ActualInt32() set dayNumber(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('dayNumber value cannot exceed 2147483647');
		}
		_dayNumber = value;
	}
	Weekday? weekday = null;
	CodeStub? dayPeriod = null;
	int? timeOfDay = null;
	AdministrationQuantity? administratedQuantity = null;
	RegimenItem({
			int? dayNumber,
			int? date,
			Weekday? weekday,
			CodeStub? dayPeriod,
			int? timeOfDay,
			AdministrationQuantity? administratedQuantity
		}) : date = date ?? null,
		weekday = weekday ?? null,
		dayPeriod = dayPeriod ?? null,
		timeOfDay = timeOfDay ?? null,
		administratedQuantity = administratedQuantity ?? null,
		_dayNumber = dayNumber ?? null;

	factory RegimenItem.fromJSON(Map<String, dynamic> data) {
		return RegimenItem(
			dayNumber: (data["dayNumber"] as int?),
			date: (data["date"] as int?),
			weekday: data["weekday"] == null ? null : Weekday.fromJSON(data["weekday"]),
			dayPeriod: data["dayPeriod"] == null ? null : CodeStub.fromJSON(data["dayPeriod"]),
			timeOfDay: (data["timeOfDay"] as int?),
			administratedQuantity: data["administratedQuantity"] == null ? null : AdministrationQuantity.fromJSON(data["administratedQuantity"])
		);
	}

	static Map<String, dynamic> encode(RegimenItem value) {
		Map<String, dynamic> entityAsMap = {
			"date" : value.date,
			"dayNumber" : value.dayNumber,
			"weekday" : value.weekday == null ? null : Weekday.encode(value.weekday!),
			"dayPeriod" : value.dayPeriod == null ? null : CodeStub.encode(value.dayPeriod!),
			"timeOfDay" : value.timeOfDay,
			"administratedQuantity" : value.administratedQuantity == null ? null : AdministrationQuantity.encode(value.administratedQuantity!)
		};
		return entityAsMap;
	}
}