// This file is auto-generated


class AuthenticationToken {
	String? token;
	int creationTime;
	int validity;
	int? deletionDate;
	AuthenticationToken(
		this.creationTime,
		this.validity,
		{
			this.token,
			this.deletionDate
		});

	factory AuthenticationToken.fromJSON(Map<String, dynamic> data) {
		return AuthenticationToken(
			data["creationTime"],
			data["validity"],
			token: data["token"],
			deletionDate: data["deletionDate"],
		);
	}

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