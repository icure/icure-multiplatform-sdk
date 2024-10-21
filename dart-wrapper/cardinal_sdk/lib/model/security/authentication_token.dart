// This file is auto-generated


class AuthenticationToken {
	String? token;
	int creationTime;
	int validity;
	int? deletionDate;

	AuthenticationToken({
		required this.creationTime,
		required this.validity,
		this.token,
		this.deletionDate
	});

	static Map<String, dynamic> encode(AuthenticationToken value) {
		Map<String, dynamic> entityAsMap = {
			"token" : value.token,
			"creationTime" : value.creationTime,
			"validity" : value.validity,
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}