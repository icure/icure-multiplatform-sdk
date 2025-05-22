// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "duration.freezed.dart";


@freezed
abstract class Duration with _$Duration {
	const factory Duration({
		@Default(null) double? value,
		@Default(null) CodeStub? unit,
	}) = _Duration;


	static Map<String, dynamic> encode(Duration value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"unit" : value.unit == null ? null : CodeStub.encode(value.unit!)
		};
		return entityAsMap;
	}

	static Duration fromJSON(Map<String, dynamic> data) {
		return Duration(
			value: (data["value"] as num?)?.toDouble(),
			unit: data["unit"] == null ? null : CodeStub.fromJSON(data["unit"])
		);
	}
}