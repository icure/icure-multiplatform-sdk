// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/trigger.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "launcher.freezed.dart";


@freezed
abstract class Launcher with _$Launcher {
	const factory Launcher({
		required String name,
		required Trigger triggerer,
		@Default(false) bool shouldPassValue,
	}) = _Launcher;


	static Map<String, dynamic> encode(Launcher value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"triggerer" : Trigger.encode(value.triggerer),
			"shouldPassValue" : value.shouldPassValue
		};
		return entityAsMap;
	}

	static Launcher fromJSON(Map<String, dynamic> data) {
		return Launcher(
			name: (data["name"] as String),
			triggerer: Trigger.fromJSON(data["triggerer"]),
			shouldPassValue: (data["shouldPassValue"] as bool),
		);
	}
}