// auto-generated file


enum UsersType {
	database,
	ldap,
	token;

	static String encode(UsersType value) {
		switch (value) {
			case UsersType.database:
				return '"database"';
			case UsersType.ldap:
				return '"ldap"';
			case UsersType.token:
				return '"token"';
			}
	}


	static UsersType fromJSON(String data) {
		switch (data) {
			case "database":
				return UsersType.database;
			case "ldap":
				return UsersType.ldap;
			case "token":
				return UsersType.token;
			default:
				throw ArgumentError('Invalid UsersType entry value $data');
			}
	}

}