// auto-generated file


enum SuspensionReason {
	notInsured,
	noReasonGiven,
	isHospitalized,
	outsideOfCountry,
	changeOfMutuality;

	static String encode(SuspensionReason value) {
		switch (value) {
			case SuspensionReason.notInsured:
				return 'notInsured';
			case SuspensionReason.noReasonGiven:
				return 'noReasonGiven';
			case SuspensionReason.isHospitalized:
				return 'isHospitalized';
			case SuspensionReason.outsideOfCountry:
				return 'outsideOfCountry';
			case SuspensionReason.changeOfMutuality:
				return 'changeOfMutuality';
			}
	}


	static SuspensionReason fromJSON(String data) {
		switch (data) {
			case "notInsured":
				return SuspensionReason.notInsured;
			case "noReasonGiven":
				return SuspensionReason.noReasonGiven;
			case "isHospitalized":
				return SuspensionReason.isHospitalized;
			case "outsideOfCountry":
				return SuspensionReason.outsideOfCountry;
			case "changeOfMutuality":
				return SuspensionReason.changeOfMutuality;
			default:
				throw ArgumentError('Invalid SuspensionReason entry value $data');
			}
	}

}