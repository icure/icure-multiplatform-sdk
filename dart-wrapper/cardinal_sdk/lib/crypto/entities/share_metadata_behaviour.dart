// auto-generated file


enum ShareMetadataBehaviour {
	required,
	ifAvailable,
	never;

	static String encode(ShareMetadataBehaviour value) {
		switch (value) {
			case ShareMetadataBehaviour.required:
				return 'REQUIRED';
			case ShareMetadataBehaviour.ifAvailable:
				return 'IF_AVAILABLE';
			case ShareMetadataBehaviour.never:
				return 'NEVER';
			}
	}


	static ShareMetadataBehaviour fromJSON(String data) {
		switch (data) {
			case "REQUIRED":
				return ShareMetadataBehaviour.required;
			case "IF_AVAILABLE":
				return ShareMetadataBehaviour.ifAvailable;
			case "NEVER":
				return ShareMetadataBehaviour.never;
			default:
				throw ArgumentError('Invalid ShareMetadataBehaviour entry value $data');
			}
	}

}