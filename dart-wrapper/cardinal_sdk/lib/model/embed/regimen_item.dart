// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/weekday.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/administration_quantity.dart';


class RegimenItem {
	int? date;
	int? _dayNumber;
	@ActualInt32() int? get dayNumber => _dayNumber;
	@ActualInt32() set dayNumber(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('dayNumber value cannot exceed 2147483647');
		}
		_dayNumber = value;
	}
	Weekday? weekday;
	CodeStub? dayPeriod;
	int? timeOfDay;
	AdministrationQuantity? administratedQuantity;
	RegimenItem({
			int? dayNumber,
			this.date,
			this.weekday,
			this.dayPeriod,
			this.timeOfDay,
			this.administratedQuantity
		}) : _dayNumber = dayNumber;

	factory RegimenItem.fromJSON(Map<String, dynamic> data) {
		return RegimenItem(
			dayNumber: data["dayNumber"],
			date: data["date"],
			weekday: data["weekday"] == null ? null : Weekday.fromJSON(data["weekday"]),
			dayPeriod: data["dayPeriod"] == null ? null : CodeStub.fromJSON(data["dayPeriod"]),
			timeOfDay: data["timeOfDay"],
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