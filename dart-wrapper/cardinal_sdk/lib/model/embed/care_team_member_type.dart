// auto-generated file


enum CareTeamMemberType {
	physician,
	specialist,
	other;

	static String encode(CareTeamMemberType value) {
		switch (value) {
			case CareTeamMemberType.physician:
				return 'physician';
			case CareTeamMemberType.specialist:
				return 'specialist';
			case CareTeamMemberType.other:
				return 'other';
			}
	}


	static CareTeamMemberType fromJSON(String data) {
		switch (data) {
			case "physician":
				return CareTeamMemberType.physician;
			case "specialist":
				return CareTeamMemberType.specialist;
			case "other":
				return CareTeamMemberType.other;
			default:
				throw ArgumentError('Invalid CareTeamMemberType entry value $data');
			}
	}

}