// This file is auto-generated


enum Gender {
	male,
	female,
	indeterminate,
	changed,
	changedToMale,
	changedToFemale,
	unknown;

	static String encode(Gender value) {
		switch (value) {
			case Gender.male:
				return '"Male"';
			case Gender.female:
				return '"Female"';
			case Gender.indeterminate:
				return '"Indeterminate"';
			case Gender.changed:
				return '"Changed"';
			case Gender.changedToMale:
				return '"ChangedToMale"';
			case Gender.changedToFemale:
				return '"ChangedToFemale"';
			case Gender.unknown:
				return '"Unknown"';
			}
	}

}