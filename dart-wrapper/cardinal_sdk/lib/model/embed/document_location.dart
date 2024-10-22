// This file is auto-generated


enum DocumentLocation {
	annex,
	body;

	static String encode(DocumentLocation value) {
		switch (value) {
			case DocumentLocation.annex:
				return '"annex"';
			case DocumentLocation.body:
				return '"body"';
			}
	}


	static DocumentLocation fromJSON(String data) {
		switch (data) {
			case "annex":
				return DocumentLocation.annex;
			case "body":
				return DocumentLocation.body;
			default:
				throw ArgumentError('Invalid DocumentLocation entry value $data');
			}
	}

}