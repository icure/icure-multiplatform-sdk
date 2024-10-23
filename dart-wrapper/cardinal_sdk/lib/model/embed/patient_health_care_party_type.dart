// auto-generated file


enum PatientHealthCarePartyType {
	doctor,
	referral,
	medicalhouse,
	retirementhome,
	hospital,
	other,
	referringphysician,
	managingorganization;

	static String encode(PatientHealthCarePartyType value) {
		switch (value) {
			case PatientHealthCarePartyType.doctor:
				return '"doctor"';
			case PatientHealthCarePartyType.referral:
				return '"referral"';
			case PatientHealthCarePartyType.medicalhouse:
				return '"medicalhouse"';
			case PatientHealthCarePartyType.retirementhome:
				return '"retirementhome"';
			case PatientHealthCarePartyType.hospital:
				return '"hospital"';
			case PatientHealthCarePartyType.other:
				return '"other"';
			case PatientHealthCarePartyType.referringphysician:
				return '"referringphysician"';
			case PatientHealthCarePartyType.managingorganization:
				return '"managingorganization"';
			}
	}


	static PatientHealthCarePartyType fromJSON(String data) {
		switch (data) {
			case "doctor":
				return PatientHealthCarePartyType.doctor;
			case "referral":
				return PatientHealthCarePartyType.referral;
			case "medicalhouse":
				return PatientHealthCarePartyType.medicalhouse;
			case "retirementhome":
				return PatientHealthCarePartyType.retirementhome;
			case "hospital":
				return PatientHealthCarePartyType.hospital;
			case "other":
				return PatientHealthCarePartyType.other;
			case "referringphysician":
				return PatientHealthCarePartyType.referringphysician;
			case "managingorganization":
				return PatientHealthCarePartyType.managingorganization;
			default:
				throw ArgumentError('Invalid PatientHealthCarePartyType entry value $data');
			}
	}

}