// This file is auto-generated


class RegistrationInformation {
	String firstName;
	String lastName;
	String emailAddress;
	String? userOptions;
	Set<String> userRoles = {};
	String? minimumKrakenVersion;

	RegistrationInformation({
		required this.firstName,
		required this.lastName,
		required this.emailAddress,
		this.userOptions,
		this.minimumKrakenVersion,
		Set<String>? userRoles
	}) : userRoles = userRoles ?? {};

	static Map<String, dynamic> encode(RegistrationInformation value) {
		Map<String, dynamic> entityAsMap = {
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"emailAddress" : value.emailAddress,
			"userOptions" : value.userOptions,
			"userRoles" : value.userRoles.map((x0) => x0),
			"minimumKrakenVersion" : value.minimumKrakenVersion
		};
		return entityAsMap;
	}
}