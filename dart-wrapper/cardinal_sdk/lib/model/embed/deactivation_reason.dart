// This file is auto-generated


enum DeactivationReason {
	deceased,
	moved,
	otherDoctor,
	retired,
	noContact,
	unknown,
	none;

	static String encode(DeactivationReason value) {
		switch (value) {
			case DeactivationReason.deceased:
				return '"Deceased"';
			case DeactivationReason.moved:
				return '"Moved"';
			case DeactivationReason.otherDoctor:
				return '"OtherDoctor"';
			case DeactivationReason.retired:
				return '"Retired"';
			case DeactivationReason.noContact:
				return '"NoContact"';
			case DeactivationReason.unknown:
				return '"Unknown"';
			case DeactivationReason.none:
				return '"None"';
			}
	}

}