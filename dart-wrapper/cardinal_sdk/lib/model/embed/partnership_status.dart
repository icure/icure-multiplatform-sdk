// This file is auto-generated


enum PartnershipStatus {
	active,
	complicated,
	past;

	static String encode(PartnershipStatus value) {
		switch (value) {
			case PartnershipStatus.active:
				return '"Active"';
			case PartnershipStatus.complicated:
				return '"Complicated"';
			case PartnershipStatus.past:
				return '"Past"';
			}
	}

}