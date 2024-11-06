// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Duration {
	double? value = null;
	CodeStub? unit = null;
	Duration({
			double? value,
			CodeStub? unit
		}) : value = value ?? null,
		unit = unit ?? null;

	factory Duration.fromJSON(Map<String, dynamic> data) {
		return Duration(
			value: (data["value"] as num?)?.toDouble(),
			unit: data["unit"] == null ? null : CodeStub.fromJSON(data["unit"])
		);
	}

	static Map<String, dynamic> encode(Duration value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"unit" : value.unit == null ? null : CodeStub.encode(value.unit!)
		};
		return entityAsMap;
	}
}