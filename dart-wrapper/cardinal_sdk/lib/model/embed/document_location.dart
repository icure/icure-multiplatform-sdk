// This file is auto-generated


enum DocumentLocation {
	annex,
	body;

	static String encode(DocumentLocation value) {
		switch (value) {
			case DocumentLocation.annex:
				return '"Annex"';
			case DocumentLocation.body:
				return '"Body"';
			}
	}

}