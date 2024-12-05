// auto-generated file


enum RecoveryKeySize {
	bytes16,
	bytes32;

	static String encode(RecoveryKeySize value) {
		switch (value) {
			case RecoveryKeySize.bytes16:
				return 'Bytes16';
			case RecoveryKeySize.bytes32:
				return 'Bytes32';
			}
	}


	static RecoveryKeySize fromJSON(String data) {
		switch (data) {
			case "Bytes16":
				return RecoveryKeySize.bytes16;
			case "Bytes32":
				return RecoveryKeySize.bytes32;
			default:
				throw ArgumentError('Invalid RecoveryKeySize entry value $data');
			}
	}

}