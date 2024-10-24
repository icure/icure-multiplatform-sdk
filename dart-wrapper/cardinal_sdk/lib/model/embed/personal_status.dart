// auto-generated file


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
				return 'single';
			case PersonalStatus.inCouple:
				return 'in_couple';
			case PersonalStatus.married:
				return 'married';
			case PersonalStatus.separated:
				return 'separated';
			case PersonalStatus.divorced:
				return 'divorced';
			case PersonalStatus.divorcing:
				return 'divorcing';
			case PersonalStatus.widowed:
				return 'widowed';
			case PersonalStatus.widower:
				return 'widower';
			case PersonalStatus.complicated:
				return 'complicated';
			case PersonalStatus.unknown:
				return 'unknown';
			case PersonalStatus.contract:
				return 'contract';
			case PersonalStatus.other:
				return 'other';
			case PersonalStatus.annulled:
				return 'annulled';
			case PersonalStatus.polygamous:
				return 'polygamous';
			}
	}


	static PersonalStatus fromJSON(String data) {
		switch (data) {
			case "single":
				return PersonalStatus.single;
			case "in_couple":
				return PersonalStatus.inCouple;
			case "married":
				return PersonalStatus.married;
			case "separated":
				return PersonalStatus.separated;
			case "divorced":
				return PersonalStatus.divorced;
			case "divorcing":
				return PersonalStatus.divorcing;
			case "widowed":
				return PersonalStatus.widowed;
			case "widower":
				return PersonalStatus.widower;
			case "complicated":
				return PersonalStatus.complicated;
			case "unknown":
				return PersonalStatus.unknown;
			case "contract":
				return PersonalStatus.contract;
			case "other":
				return PersonalStatus.other;
			case "annulled":
				return PersonalStatus.annulled;
			case "polygamous":
				return PersonalStatus.polygamous;
			default:
				throw ArgumentError('Invalid PersonalStatus entry value $data');
			}
	}

}