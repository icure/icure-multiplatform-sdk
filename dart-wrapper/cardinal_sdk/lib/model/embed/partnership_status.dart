// This file is auto-generated


enum PartnershipStatus {
	active,
	complicated,
	past;

	static String encode(PartnershipStatus value) {
		switch (value) {
			case PartnershipStatus.active:
				return '"active"';
			case PartnershipStatus.complicated:
				return '"complicated"';
			case PartnershipStatus.past:
				return '"past"';
			}
	}


	static PartnershipStatus fromJSON(String data) {
		switch (data) {
			case "active":
				return PartnershipStatus.active;
			case "complicated":
				return PartnershipStatus.complicated;
			case "past":
				return PartnershipStatus.past;
			default:
				throw ArgumentError('Invalid PartnershipStatus entry value $data');
			}
	}

}