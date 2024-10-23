// auto-generated file


enum MembershipType {
	doctor,
	mutuality,
	patient,
	specialist,
	other;

	static String encode(MembershipType value) {
		switch (value) {
			case MembershipType.doctor:
				return '"doctor"';
			case MembershipType.mutuality:
				return '"mutuality"';
			case MembershipType.patient:
				return '"patient"';
			case MembershipType.specialist:
				return '"specialist"';
			case MembershipType.other:
				return '"other"';
			}
	}


	static MembershipType fromJSON(String data) {
		switch (data) {
			case "doctor":
				return MembershipType.doctor;
			case "mutuality":
				return MembershipType.mutuality;
			case "patient":
				return MembershipType.patient;
			case "specialist":
				return MembershipType.specialist;
			case "other":
				return MembershipType.other;
			default:
				throw ArgumentError('Invalid MembershipType entry value $data');
			}
	}

}