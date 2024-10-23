// auto-generated file


enum GroupType {
	root,
	app,
	database;

	static String encode(GroupType value) {
		switch (value) {
			case GroupType.root:
				return '"root"';
			case GroupType.app:
				return '"app"';
			case GroupType.database:
				return '"database"';
			}
	}


	static GroupType fromJSON(String data) {
		switch (data) {
			case "root":
				return GroupType.root;
			case "app":
				return GroupType.app;
			case "database":
				return GroupType.database;
			default:
				throw ArgumentError('Invalid GroupType entry value $data');
			}
	}

}