// auto-generated file


enum RecoveryDataUseFailureReason {
	missing,
	unauthorized,
	invalidType,
	invalidContent;

	static String encode(RecoveryDataUseFailureReason value) {
		switch (value) {
			case RecoveryDataUseFailureReason.missing:
				return 'Missing';
			case RecoveryDataUseFailureReason.unauthorized:
				return 'Unauthorized';
			case RecoveryDataUseFailureReason.invalidType:
				return 'InvalidType';
			case RecoveryDataUseFailureReason.invalidContent:
				return 'InvalidContent';
			}
	}


	static RecoveryDataUseFailureReason fromJSON(String data) {
		switch (data) {
			case "Missing":
				return RecoveryDataUseFailureReason.missing;
			case "Unauthorized":
				return RecoveryDataUseFailureReason.unauthorized;
			case "InvalidType":
				return RecoveryDataUseFailureReason.invalidType;
			case "InvalidContent":
				return RecoveryDataUseFailureReason.invalidContent;
			default:
				throw ArgumentError('Invalid RecoveryDataUseFailureReason entry value $data');
			}
	}

}