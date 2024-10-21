// This file is auto-generated


enum MembershipType {
	doctor,
	mutuality,
	patient,
	specialist,
	other;

	static String encode(MembershipType value) {
		switch (value) {
			case MembershipType.doctor:
				return '"Doctor"';
			case MembershipType.mutuality:
				return '"Mutuality"';
			case MembershipType.patient:
				return '"Patient"';
			case MembershipType.specialist:
				return '"Specialist"';
			case MembershipType.other:
				return '"Other"';
			}
	}

}