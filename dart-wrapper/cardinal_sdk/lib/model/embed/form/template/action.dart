// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/launcher.dart';
import 'package:cardinal_sdk/model/embed/form/template/state.dart';


class Action {
	List<Launcher>? launchers = [];
	String? expression;
	List<State>? states = [];
	Action({
			this.expression,
			List<Launcher>? launchers,
			List<State>? states
		}) : launchers = launchers ?? [],
		states = states ?? [];

	factory Action.fromJSON(Map<String, dynamic> data) {
		return Action(
			launchers: data["launchers"]?.map((x0) => Launcher.fromJSON(x0) ),
			expression: data["expression"],
			states: data["states"]?.map((x0) => State.fromJSON(x0) )
		);
	}

	static Map<String, dynamic> encode(Action value) {
		Map<String, dynamic> entityAsMap = {
			"launchers" : value.launchers?.map((x0) => Launcher.encode(x0)),
			"expression" : value.expression,
			"states" : value.states?.map((x0) => State.encode(x0))
		};
		return entityAsMap;
	}
}