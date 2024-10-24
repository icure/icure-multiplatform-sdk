// auto-generated file


enum DataOwnerType {
	hcp,
	device,
	patient;

	static String encode(DataOwnerType value) {
		switch (value) {
			case DataOwnerType.hcp:
				return 'hcp';
			case DataOwnerType.device:
				return 'device';
			case DataOwnerType.patient:
				return 'patient';
			}
	}


	static DataOwnerType fromJSON(String data) {
		switch (data) {
			case "hcp":
				return DataOwnerType.hcp;
			case "device":
				return DataOwnerType.device;
			case "patient":
				return DataOwnerType.patient;
			default:
				throw ArgumentError('Invalid DataOwnerType entry value $data');
			}
	}

}