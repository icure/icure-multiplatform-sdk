// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "periodicity.freezed.dart";


@freezed
abstract class Periodicity with _$Periodicity {
	const factory Periodicity({
		@Default(null) CodeStub? relatedCode,
		@Default(null) CodeStub? relatedPeriodicity,
	}) = _Periodicity;


	static Map<String, dynamic> encode(Periodicity value) {
		Map<String, dynamic> entityAsMap = {
			"relatedCode" : value.relatedCode == null ? null : CodeStub.encode(value.relatedCode!),
			"relatedPeriodicity" : value.relatedPeriodicity == null ? null : CodeStub.encode(value.relatedPeriodicity!)
		};
		return entityAsMap;
	}

	static Periodicity fromJSON(Map<String, dynamic> data) {
		return Periodicity(
			relatedCode: data["relatedCode"] == null ? null : CodeStub.fromJSON(data["relatedCode"]),
			relatedPeriodicity: data["relatedPeriodicity"] == null ? null : CodeStub.fromJSON(data["relatedPeriodicity"])
		);
	}
}