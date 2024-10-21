// This file is auto-generated


enum AuthenticationClass {
	digitalId,
	twoFactorAuthentication,
	shortLivedToken,
	externalAuthentication,
	password,
	longLivedToken;

	static String encode(AuthenticationClass value) {
		switch (value) {
			case AuthenticationClass.digitalId:
				return '"DigitalId"';
			case AuthenticationClass.twoFactorAuthentication:
				return '"TwoFactorAuthentication"';
			case AuthenticationClass.shortLivedToken:
				return '"ShortLivedToken"';
			case AuthenticationClass.externalAuthentication:
				return '"ExternalAuthentication"';
			case AuthenticationClass.password:
				return '"Password"';
			case AuthenticationClass.longLivedToken:
				return '"LongLivedToken"';
			}
	}

}