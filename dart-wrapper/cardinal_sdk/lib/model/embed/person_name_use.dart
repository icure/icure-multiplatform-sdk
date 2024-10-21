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
				return '"Usual"';
			case PersonNameUse.official:
				return '"Official"';
			case PersonNameUse.temp:
				return '"Temp"';
			case PersonNameUse.nickname:
				return '"Nickname"';
			case PersonNameUse.anonymous:
				return '"Anonymous"';
			case PersonNameUse.maiden:
				return '"Maiden"';
			case PersonNameUse.old:
				return '"Old"';
			case PersonNameUse.other:
				return '"Other"';
			}
	}

}