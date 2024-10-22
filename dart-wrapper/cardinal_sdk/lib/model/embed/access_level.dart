// This file is auto-generated


enum AccessLevel {
	read,
	write;

	static String encode(AccessLevel value) {
		switch (value) {
			case AccessLevel.read:
				return '"READ"';
			case AccessLevel.write:
				return '"WRITE"';
			}
	}


	static AccessLevel fromJSON(String data) {
		switch (data) {
			case "READ":
				return AccessLevel.read;
			case "WRITE":
				return AccessLevel.write;
			default:
				throw ArgumentError('Invalid AccessLevel entry value $data');
			}
	}

}