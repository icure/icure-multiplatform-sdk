// This file is auto-generated


enum PersonNameUse {
	usual,
	official,
	temp,
	nickname,
	anonymous,
	maiden,
	old,
	other;

	static String encode(PersonNameUse value) {
		switch (value) {
			case PersonNameUse.usual:
				return '"usual"';
			case PersonNameUse.official:
				return '"official"';
			case PersonNameUse.temp:
				return '"temp"';
			case PersonNameUse.nickname:
				return '"nickname"';
			case PersonNameUse.anonymous:
				return '"anonymous"';
			case PersonNameUse.maiden:
				return '"maiden"';
			case PersonNameUse.old:
				return '"old"';
			case PersonNameUse.other:
				return '"other"';
			}
	}


	static PersonNameUse fromJSON(String data) {
		switch (data) {
			case "usual":
				return PersonNameUse.usual;
			case "official":
				return PersonNameUse.official;
			case "temp":
				return PersonNameUse.temp;
			case "nickname":
				return PersonNameUse.nickname;
			case "anonymous":
				return PersonNameUse.anonymous;
			case "maiden":
				return PersonNameUse.maiden;
			case "old":
				return PersonNameUse.old;
			case "other":
				return PersonNameUse.other;
			default:
				throw ArgumentError('Invalid PersonNameUse entry value $data');
			}
	}

}