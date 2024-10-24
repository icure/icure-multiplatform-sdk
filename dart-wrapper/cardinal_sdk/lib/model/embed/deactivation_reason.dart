// auto-generated file


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
				return 'deceased';
			case DeactivationReason.moved:
				return 'moved';
			case DeactivationReason.otherDoctor:
				return 'other_doctor';
			case DeactivationReason.retired:
				return 'retired';
			case DeactivationReason.noContact:
				return 'no_contact';
			case DeactivationReason.unknown:
				return 'unknown';
			case DeactivationReason.none:
				return 'none';
			}
	}


	static DeactivationReason fromJSON(String data) {
		switch (data) {
			case "deceased":
				return DeactivationReason.deceased;
			case "moved":
				return DeactivationReason.moved;
			case "other_doctor":
				return DeactivationReason.otherDoctor;
			case "retired":
				return DeactivationReason.retired;
			case "no_contact":
				return DeactivationReason.noContact;
			case "unknown":
				return DeactivationReason.unknown;
			case "none":
				return DeactivationReason.none;
			default:
				throw ArgumentError('Invalid DeactivationReason entry value $data');
			}
	}

}