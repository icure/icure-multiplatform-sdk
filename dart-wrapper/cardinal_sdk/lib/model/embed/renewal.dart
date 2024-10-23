// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/duration.dart';


class Renewal {
	int? _decimal;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get decimal => _decimal;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set decimal(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('decimal value cannot exceed 2147483647');
		}
		_decimal = value;
	}
	Duration? duration;
	Renewal({
			int? decimal,
			this.duration
		}) : _decimal = decimal;

	factory Renewal.fromJSON(Map<String, dynamic> data) {
		return Renewal(
			decimal: data["decimal"],
			duration: data["duration"] == null ? null : Duration.fromJSON(data["duration"])
		);
	}

	static Map<String, dynamic> encode(Renewal value) {
		Map<String, dynamic> entityAsMap = {
			"decimal" : value.decimal,
			"duration" : value.duration == null ? null : Duration.encode(value.duration!)
		};
		return entityAsMap;
	}
}