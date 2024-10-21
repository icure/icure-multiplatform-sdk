// This file is auto-generated


enum CareTeamMemberType {
	physician,
	specialist,
	other;

	static String encode(CareTeamMemberType value) {
		switch (value) {
			case CareTeamMemberType.physician:
				return '"Physician"';
			case CareTeamMemberType.specialist:
				return '"Specialist"';
			case CareTeamMemberType.other:
				return '"Other"';
			}
	}

}