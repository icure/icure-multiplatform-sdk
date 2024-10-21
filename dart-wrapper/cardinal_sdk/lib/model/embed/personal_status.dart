// This file is auto-generated


enum PersonalStatus {
	single,
	inCouple,
	married,
	separated,
	divorced,
	divorcing,
	widowed,
	widower,
	complicated,
	unknown,
	contract,
	other,
	annulled,
	polygamous;

	static String encode(PersonalStatus value) {
		switch (value) {
			case PersonalStatus.single:
				return '"Single"';
			case PersonalStatus.inCouple:
				return '"InCouple"';
			case PersonalStatus.married:
				return '"Married"';
			case PersonalStatus.separated:
				return '"Separated"';
			case PersonalStatus.divorced:
				return '"Divorced"';
			case PersonalStatus.divorcing:
				return '"Divorcing"';
			case PersonalStatus.widowed:
				return '"Widowed"';
			case PersonalStatus.widower:
				return '"Widower"';
			case PersonalStatus.complicated:
				return '"Complicated"';
			case PersonalStatus.unknown:
				return '"Unknown"';
			case PersonalStatus.contract:
				return '"Contract"';
			case PersonalStatus.other:
				return '"Other"';
			case PersonalStatus.annulled:
				return '"Annulled"';
			case PersonalStatus.polygamous:
				return '"Polygamous"';
			}
	}

}