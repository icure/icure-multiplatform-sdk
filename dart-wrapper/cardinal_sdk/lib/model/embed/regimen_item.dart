// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/weekday.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/administration_quantity.dart';


class RegimenItem {
	int? date;
	int? _dayNumber;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get dayNumber => _dayNumber;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set dayNumber(int? value) {
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