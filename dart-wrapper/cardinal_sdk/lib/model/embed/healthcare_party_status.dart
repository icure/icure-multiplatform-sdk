// This file is auto-generated


enum HealthcarePartyStatus {
	trainee,
	withconvention,
	accreditated;

	static String encode(HealthcarePartyStatus value) {
		switch (value) {
			case HealthcarePartyStatus.trainee:
				return '"Trainee"';
			case HealthcarePartyStatus.withconvention:
				return '"Withconvention"';
			case HealthcarePartyStatus.accreditated:
				return '"Accreditated"';
			}
	}

}