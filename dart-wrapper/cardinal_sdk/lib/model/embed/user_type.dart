// auto-generated file


enum UserType {
	hcp,
	patient,
	device,
	user;

	static String encode(UserType value) {
		switch (value) {
			case UserType.hcp:
				return 'HCP';
			case UserType.patient:
				return 'PATIENT';
			case UserType.device:
				return 'DEVICE';
			case UserType.user:
				return 'USER';
			}
	}


	static UserType fromJSON(String data) {
		switch (data) {
			case "HCP":
				return UserType.hcp;
			case "PATIENT":
				return UserType.patient;
			case "DEVICE":
				return UserType.device;
			case "USER":
				return UserType.user;
			default:
				throw ArgumentError('Invalid UserType entry value $data');
			}
	}

}