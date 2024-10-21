// This file is auto-generated


enum GroupType {
	root,
	app,
	database;

	static String encode(GroupType value) {
		switch (value) {
			case GroupType.root:
				return '"Root"';
			case GroupType.app:
				return '"App"';
			case GroupType.database:
				return '"Database"';
			}
	}

}