// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/state_to_update.dart';


class State {
	String name;
	StateToUpdate stateToUpdate;
	bool canLaunchLauncher = false;
	State(
		this.name,
		this.stateToUpdate,
		{
			bool? canLaunchLauncher
		}) : canLaunchLauncher = canLaunchLauncher ?? false;

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
			(data["name"] as String),
			StateToUpdate.fromJSON(data["stateToUpdate"]),
			canLaunchLauncher: (data["canLaunchLauncher"] as bool),
		);
	}
}