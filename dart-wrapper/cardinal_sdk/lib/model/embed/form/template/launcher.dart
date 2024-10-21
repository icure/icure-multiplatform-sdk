// This file is auto-generated
import 'package:cardinal_sdk/model/embed/form/template/trigger.dart';


class Launcher {
	String name;
	Trigger triggerer;
	bool shouldPassValue = false;

	Launcher({
		required this.name,
		required this.triggerer,
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
}