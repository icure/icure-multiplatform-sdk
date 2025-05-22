// auto-generated file
import 'package:cardinal_sdk/model/embed/duration.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "renewal.freezed.dart";


@freezed
abstract class Renewal with _$Renewal {
	const factory Renewal({
		@Default(null) int? decimal,
		@Default(null) Duration? duration,
	}) = _Renewal;


	static Map<String, dynamic> encode(Renewal value) {
		Map<String, dynamic> entityAsMap = {
			"decimal" : value.decimal,
			"duration" : value.duration == null ? null : Duration.encode(value.duration!)
		};
		return entityAsMap;
	}

	static Renewal fromJSON(Map<String, dynamic> data) {
		return Renewal(
			decimal: (data["decimal"] as int?),
			duration: data["duration"] == null ? null : Duration.fromJSON(data["duration"])
		);
	}
}