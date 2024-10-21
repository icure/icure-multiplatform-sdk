// This file is auto-generated


enum StateToUpdate {
	value,
	visible,
	readonly,
	clazz,
	required;

	static String encode(StateToUpdate value) {
		switch (value) {
			case StateToUpdate.value:
				return '"Value"';
			case StateToUpdate.visible:
				return '"Visible"';
			case StateToUpdate.readonly:
				return '"Readonly"';
			case StateToUpdate.clazz:
				return '"Clazz"';
			case StateToUpdate.required:
				return '"Required"';
			}
	}

}