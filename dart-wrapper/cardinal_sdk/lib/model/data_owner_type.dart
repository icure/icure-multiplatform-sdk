// This file is auto-generated


enum DataOwnerType {
	hcp,
	device,
	patient;

	static String encode(DataOwnerType value) {
		switch (value) {
			case DataOwnerType.hcp:
				return '"Hcp"';
			case DataOwnerType.device:
				return '"Device"';
			case DataOwnerType.patient:
				return '"Patient"';
			}
	}

}