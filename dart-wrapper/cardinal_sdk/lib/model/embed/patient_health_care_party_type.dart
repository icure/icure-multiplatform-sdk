// This file is auto-generated


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
				return '"Doctor"';
			case PatientHealthCarePartyType.referral:
				return '"Referral"';
			case PatientHealthCarePartyType.medicalhouse:
				return '"Medicalhouse"';
			case PatientHealthCarePartyType.retirementhome:
				return '"Retirementhome"';
			case PatientHealthCarePartyType.hospital:
				return '"Hospital"';
			case PatientHealthCarePartyType.other:
				return '"Other"';
			case PatientHealthCarePartyType.referringphysician:
				return '"Referringphysician"';
			case PatientHealthCarePartyType.managingorganization:
				return '"Managingorganization"';
			}
	}

}