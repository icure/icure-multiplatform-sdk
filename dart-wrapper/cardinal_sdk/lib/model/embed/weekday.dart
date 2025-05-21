// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "weekday.freezed.dart";


@freezed
abstract class Weekday with _$Weekday {
	const factory Weekday({
		@Default(null) CodeStub? weekday,
		@Default(null) int? weekNumber,
	}) = _Weekday;


	static Map<String, dynamic> encode(Weekday value) {
		Map<String, dynamic> entityAsMap = {
			"weekday" : value.weekday == null ? null : CodeStub.encode(value.weekday!),
			"weekNumber" : value.weekNumber
		};
		return entityAsMap;
	}

	static Weekday fromJSON(Map<String, dynamic> data) {
		return Weekday(
			weekNumber: (data["weekNumber"] as int?),
			weekday: data["weekday"] == null ? null : CodeStub.fromJSON(data["weekday"])
		);
	}
}