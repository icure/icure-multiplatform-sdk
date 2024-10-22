// This file is auto-generated


enum HealthcarePartyStatus {
	trainee,
	withconvention,
	accreditated;

	static String encode(HealthcarePartyStatus value) {
		switch (value) {
			case HealthcarePartyStatus.trainee:
				return '"trainee"';
			case HealthcarePartyStatus.withconvention:
				return '"withconvention"';
			case HealthcarePartyStatus.accreditated:
				return '"accreditated"';
			}
	}


	static HealthcarePartyStatus fromJSON(String data) {
		switch (data) {
			case "trainee":
				return HealthcarePartyStatus.trainee;
			case "withconvention":
				return HealthcarePartyStatus.withconvention;
			case "accreditated":
				return HealthcarePartyStatus.accreditated;
			default:
				throw ArgumentError('Invalid HealthcarePartyStatus entry value $data');
			}
	}

}