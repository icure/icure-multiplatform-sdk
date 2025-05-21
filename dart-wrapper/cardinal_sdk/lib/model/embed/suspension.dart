// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "suspension.freezed.dart";


@freezed
abstract class Suspension with _$Suspension {
	const factory Suspension({
		@Default(null) int? beginMoment,
		@Default(null) int? endMoment,
		@Default(null) String? suspensionReason,
		@Default(null) String? lifecycle,
	}) = _Suspension;


	static Map<String, dynamic> encode(Suspension value) {
		Map<String, dynamic> entityAsMap = {
			"beginMoment" : value.beginMoment,
			"endMoment" : value.endMoment,
			"suspensionReason" : value.suspensionReason,
			"lifecycle" : value.lifecycle
		};
		return entityAsMap;
	}

	static Suspension fromJSON(Map<String, dynamic> data) {
		return Suspension(
			beginMoment: (data["beginMoment"] as int?),
			endMoment: (data["endMoment"] as int?),
			suspensionReason: (data["suspensionReason"] as String?),
			lifecycle: (data["lifecycle"] as String?)
		);
	}
}