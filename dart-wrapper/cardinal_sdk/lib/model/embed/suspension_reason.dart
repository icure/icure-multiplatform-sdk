// This file is auto-generated


enum SuspensionReason {
	notInsured,
	noReasonGiven,
	isHospitalized,
	outsideOfCountry,
	changeOfMutuality;

	static String encode(SuspensionReason value) {
		switch (value) {
			case SuspensionReason.notInsured:
				return '"NotInsured"';
			case SuspensionReason.noReasonGiven:
				return '"NoReasonGiven"';
			case SuspensionReason.isHospitalized:
				return '"IsHospitalized"';
			case SuspensionReason.outsideOfCountry:
				return '"OutsideOfCountry"';
			case SuspensionReason.changeOfMutuality:
				return '"ChangeOfMutuality"';
			}
	}

}