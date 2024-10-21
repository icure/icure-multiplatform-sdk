// This file is auto-generated


enum UsersType {
	database,
	ldap,
	token;

	static String encode(UsersType value) {
		switch (value) {
			case UsersType.database:
				return '"Database"';
			case UsersType.ldap:
				return '"Ldap"';
			case UsersType.token:
				return '"Token"';
			}
	}

}