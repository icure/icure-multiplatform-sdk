// This file is auto-generated


enum Operation {
	transferGroup;

	static String encode(Operation value) {
		switch (value) {
			case Operation.transferGroup:
				return '"TRANSFER_GROUP"';
			}
	}


	static Operation fromJSON(String data) {
		switch (data) {
			case "TRANSFER_GROUP":
				return Operation.transferGroup;
			default:
				throw ArgumentError('Invalid Operation entry value $data');
			}
	}

}