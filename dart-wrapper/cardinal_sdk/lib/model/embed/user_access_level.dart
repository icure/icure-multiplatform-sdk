// auto-generated file


enum UserAccessLevel {
	admin,
	read,
	write;

	static String encode(UserAccessLevel value) {
		switch (value) {
			case UserAccessLevel.admin:
				return 'Admin';
			case UserAccessLevel.read:
				return 'Read';
			case UserAccessLevel.write:
				return 'Write';
			}
	}


	static UserAccessLevel fromJSON(String data) {
		switch (data) {
			case "Admin":
				return UserAccessLevel.admin;
			case "Read":
				return UserAccessLevel.read;
			case "Write":
				return UserAccessLevel.write;
			default:
				throw ArgumentError('Invalid UserAccessLevel entry value $data');
			}
	}

}