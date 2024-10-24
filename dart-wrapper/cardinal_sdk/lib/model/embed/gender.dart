// auto-generated file


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
				return 'male';
			case Gender.female:
				return 'female';
			case Gender.indeterminate:
				return 'indeterminate';
			case Gender.changed:
				return 'changed';
			case Gender.changedToMale:
				return 'changedToMale';
			case Gender.changedToFemale:
				return 'changedToFemale';
			case Gender.unknown:
				return 'unknown';
			}
	}


	static Gender fromJSON(String data) {
		switch (data) {
			case "male":
				return Gender.male;
			case "female":
				return Gender.female;
			case "indeterminate":
				return Gender.indeterminate;
			case "changed":
				return Gender.changed;
			case "changedToMale":
				return Gender.changedToMale;
			case "changedToFemale":
				return Gender.changedToFemale;
			case "unknown":
				return Gender.unknown;
			default:
				throw ArgumentError('Invalid Gender entry value $data');
			}
	}

}