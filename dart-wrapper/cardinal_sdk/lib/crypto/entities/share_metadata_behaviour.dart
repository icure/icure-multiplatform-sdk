// This file is auto-generated


enum ShareMetadataBehaviour {
	required,
	ifAvailable,
	never;

	static String encode(ShareMetadataBehaviour value) {
		switch (value) {
			case ShareMetadataBehaviour.required:
				return '"Required"';
			case ShareMetadataBehaviour.ifAvailable:
				return '"IfAvailable"';
			case ShareMetadataBehaviour.never:
				return '"Never"';
			}
	}

}