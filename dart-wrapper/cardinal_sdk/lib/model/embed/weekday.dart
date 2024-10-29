// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class Weekday {
	CodeStub? weekday = null;
	int? _weekNumber = null;
	@ActualInt32() int? get weekNumber => _weekNumber;
	@ActualInt32() set weekNumber(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('weekNumber value cannot exceed 2147483647');
		}
		_weekNumber = value;
	}
	Weekday({
			int? weekNumber,
			CodeStub? weekday
		}) : weekday = weekday ?? null,
		_weekNumber = weekNumber ?? null;

	factory Weekday.fromJSON(Map<String, dynamic> data) {
		return Weekday(
			weekNumber: (data["weekNumber"] as int?),
			weekday: data["weekday"] == null ? null : CodeStub.fromJSON(data["weekday"])
		);
	}

	static Map<String, dynamic> encode(Weekday value) {
		Map<String, dynamic> entityAsMap = {
			"weekday" : value.weekday == null ? null : CodeStub.encode(value.weekday!),
			"weekNumber" : value.weekNumber
		};
		return entityAsMap;
	}
}