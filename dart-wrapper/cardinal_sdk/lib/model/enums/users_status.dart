// auto-generated file


enum UsersStatus {
	active,
	disabled,
	registering;

	static String encode(UsersStatus value) {
		switch (value) {
			case UsersStatus.active:
				return 'ACTIVE';
			case UsersStatus.disabled:
				return 'DISABLED';
			case UsersStatus.registering:
				return 'REGISTERING';
			}
	}


	static UsersStatus fromJSON(String data) {
		switch (data) {
			case "ACTIVE":
				return UsersStatus.active;
			case "DISABLED":
				return UsersStatus.disabled;
			case "REGISTERING":
				return UsersStatus.registering;
			default:
				throw ArgumentError('Invalid UsersStatus entry value $data');
			}
	}

}