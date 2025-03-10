// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/trigger.dart';


class Launcher {
	String name;
	Trigger triggerer;
	bool shouldPassValue = false;
	Launcher(
		this.name,
		this.triggerer,
		{
			bool? shouldPassValue
		}) : shouldPassValue = shouldPassValue ?? false;

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
			(data["name"] as String),
			Trigger.fromJSON(data["triggerer"]),
			shouldPassValue: (data["shouldPassValue"] as bool),
		);
	}
}