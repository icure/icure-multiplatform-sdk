// auto-generated file


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
				return 'DIGITAL_ID';
			case AuthenticationClass.twoFactorAuthentication:
				return 'TWO_FACTOR_AUTHENTICATION';
			case AuthenticationClass.shortLivedToken:
				return 'SHORT_LIVED_TOKEN';
			case AuthenticationClass.externalAuthentication:
				return 'EXTERNAL_AUTHENTICATION';
			case AuthenticationClass.password:
				return 'PASSWORD';
			case AuthenticationClass.longLivedToken:
				return 'LONG_LIVED_TOKEN';
			}
	}


	static AuthenticationClass fromJSON(String data) {
		switch (data) {
			case "DIGITAL_ID":
				return AuthenticationClass.digitalId;
			case "TWO_FACTOR_AUTHENTICATION":
				return AuthenticationClass.twoFactorAuthentication;
			case "SHORT_LIVED_TOKEN":
				return AuthenticationClass.shortLivedToken;
			case "EXTERNAL_AUTHENTICATION":
				return AuthenticationClass.externalAuthentication;
			case "PASSWORD":
				return AuthenticationClass.password;
			case "LONG_LIVED_TOKEN":
				return AuthenticationClass.longLivedToken;
			default:
				throw ArgumentError('Invalid AuthenticationClass entry value $data');
			}
	}

}