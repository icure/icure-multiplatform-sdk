// auto-generated file


class RegistrationInformation {
	String firstName;
	String lastName;
	String emailAddress;
	String? userOptions;
	Set<String> userRoles = {};
	String? minimumKrakenVersion;
	RegistrationInformation(
		this.firstName,
		this.lastName,
		this.emailAddress,
		{
			this.userOptions,
			this.minimumKrakenVersion,
			Set<String>? userRoles
		}) : userRoles = userRoles ?? {};

	factory RegistrationInformation.fromJSON(Map<String, dynamic> data) {
		return RegistrationInformation(
			data["firstName"],
			data["lastName"],
			data["emailAddress"],
			userOptions: data["userOptions"],
			userRoles: data["userRoles"].map((x0) => x0 ).toList(),
			minimumKrakenVersion: data["minimumKrakenVersion"],
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