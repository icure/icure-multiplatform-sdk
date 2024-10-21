// This file is auto-generated


enum AccessLevel {
	read,
	write;

	static String encode(AccessLevel value) {
		switch (value) {
			case AccessLevel.read:
				return '"Read"';
			case AccessLevel.write:
				return '"Write"';
			}
	}

}