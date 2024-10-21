// This file is auto-generated


enum UsersStatus {
	active,
	disabled,
	registering;

	static String encode(UsersStatus value) {
		switch (value) {
			case UsersStatus.active:
				return '"Active"';
			case UsersStatus.disabled:
				return '"Disabled"';
			case UsersStatus.registering:
				return '"Registering"';
			}
	}

}