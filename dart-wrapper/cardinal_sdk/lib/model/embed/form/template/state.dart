// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/state_to_update.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "state.freezed.dart";


@freezed
abstract class State with _$State {
	const factory State({
		required String name,
		required StateToUpdate stateToUpdate,
		@Default(false) bool canLaunchLauncher,
	}) = _State;


	static Map<String, dynamic> encode(State value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"stateToUpdate" : StateToUpdate.encode(value.stateToUpdate),
			"canLaunchLauncher" : value.canLaunchLauncher
		};
		return entityAsMap;
	}

	static State fromJSON(Map<String, dynamic> data) {
		return State(
			name: (data["name"] as String),
			stateToUpdate: StateToUpdate.fromJSON(data["stateToUpdate"]),
			canLaunchLauncher: (data["canLaunchLauncher"] as bool),
		);
	}
}