// This file is auto-generated


enum UserType {
	hcp,
	patient,
	device,
	user;

	static String encode(UserType value) {
		switch (value) {
			case UserType.hcp:
				return '"Hcp"';
			case UserType.patient:
				return '"Patient"';
			case UserType.device:
				return '"Device"';
			case UserType.user:
				return '"User"';
			}
	}

}