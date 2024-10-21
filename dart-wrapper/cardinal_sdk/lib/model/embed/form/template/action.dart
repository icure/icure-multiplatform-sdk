// This file is auto-generated
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

	static Map<String, dynamic> encode(Action value) {
		Map<String, dynamic> entityAsMap = {
			"launchers" : value.launchers?.map((x0) => Launcher.encode(x0)),
			"expression" : value.expression,
			"states" : value.states?.map((x0) => State.encode(x0))
		};
		return entityAsMap;
	}
}