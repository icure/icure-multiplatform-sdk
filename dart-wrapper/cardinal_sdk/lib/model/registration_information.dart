// auto-generated file


class RegistrationInformation {
	String firstName;
	String lastName;
	String emailAddress;
	String? userOptions = null;
	Set<String> userRoles = {};
	String? minimumKrakenVersion = null;
	RegistrationInformation(
		this.firstName,
		this.lastName,
		this.emailAddress,
		{
			String? userOptions,
			Set<String>? userRoles,
			String? minimumKrakenVersion
		}) : userOptions = userOptions ?? null,
		userRoles = userRoles ?? {},
		minimumKrakenVersion = minimumKrakenVersion ?? null;

	factory RegistrationInformation.fromJSON(Map<String, dynamic> data) {
		return RegistrationInformation(
			(data["firstName"] as String),
			(data["lastName"] as String),
			(data["emailAddress"] as String),
			userOptions: (data["userOptions"] as String?),
			userRoles: (data["userRoles"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			minimumKrakenVersion: (data["minimumKrakenVersion"] as String?),
		);
	}

	static Map<String, dynamic> encode(RegistrationInformation value) {
		Map<String, dynamic> entityAsMap = {
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"emailAddress" : value.emailAddress,
			"userOptions" : value.userOptions,
			"userRoles" : value.userRoles.map((x0) => x0).toList(),
			"minimumKrakenVersion" : value.minimumKrakenVersion
		};
		return entityAsMap;
	}
}