// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Duration {
	double? value;
	CodeStub? unit;
	Duration({
			this.value,
			this.unit
		});

	factory Duration.fromJSON(Map<String, dynamic> data) {
		return Duration(
			value: data["value"].toDouble(),
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