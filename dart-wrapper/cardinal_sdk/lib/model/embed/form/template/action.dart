// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/launcher.dart';
import 'package:cardinal_sdk/model/embed/form/template/state.dart';


class Action {
	List<Launcher>? launchers = [];
	String? expression = null;
	List<State>? states = [];
	Action({
			List<Launcher>? launchers,
			String? expression,
			List<State>? states
		}) : launchers = launchers ?? [],
		expression = expression ?? null,
		states = states ?? [];

	static Map<String, dynamic> encode(Action value) {
		Map<String, dynamic> entityAsMap = {
			"launchers" : value.launchers?.map((x0) => Launcher.encode(x0)).toList(),
			"expression" : value.expression,
			"states" : value.states?.map((x0) => State.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Action fromJSON(Map<String, dynamic> data) {
		return Action(
			launchers: (data["launchers"] as List<dynamic>?)?.map((x0) => Launcher.fromJSON(x0) ).toList(),
			expression: (data["expression"] as String?),
			states: (data["states"] as List<dynamic>?)?.map((x0) => State.fromJSON(x0) ).toList()
		);
	}
}