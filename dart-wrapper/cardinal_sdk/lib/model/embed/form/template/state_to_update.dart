// auto-generated file


enum StateToUpdate {
	value,
	visible,
	readonly,
	clazz,
	required;

	static String encode(StateToUpdate value) {
		switch (value) {
			case StateToUpdate.value:
				return '"VALUE"';
			case StateToUpdate.visible:
				return '"VISIBLE"';
			case StateToUpdate.readonly:
				return '"READONLY"';
			case StateToUpdate.clazz:
				return '"CLAZZ"';
			case StateToUpdate.required:
				return '"REQUIRED"';
			}
	}


	static StateToUpdate fromJSON(String data) {
		switch (data) {
			case "VALUE":
				return StateToUpdate.value;
			case "VISIBLE":
				return StateToUpdate.visible;
			case "READONLY":
				return StateToUpdate.readonly;
			case "CLAZZ":
				return StateToUpdate.clazz;
			case "REQUIRED":
				return StateToUpdate.required;
			default:
				throw ArgumentError('Invalid StateToUpdate entry value $data');
			}
	}

}